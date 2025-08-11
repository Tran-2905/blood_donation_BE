package com.royce.blood_donation.services.distance;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DistanceService implements IDistanceService{
    @Value("${api.key}")
    private String API_KEY;
    @Override
    public double getDrivingDistance(double lat1, double lng1, double lat2, double lng2){
        String url = String.format(
                "https://maps.googleapis.com/maps/api/distancematrix/json?origins=%f,%f&destinations=%f,%f&key=%s",
                lat1, lng1, lat2, lng2, API_KEY
        );

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);

        JSONObject json = new JSONObject(result);
        return json.getJSONArray("rows")
                .getJSONObject(0)
                .getJSONArray("elements")
                .getJSONObject(0)
                .getJSONObject("distance")
                .getDouble("value") / 1000.0; // km
    }
}
