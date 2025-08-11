package com.royce.blood_donation.services.geocode;


import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class GeocodingService implements IGeocodingService{
    @Value("${api.key}")
    private String apiKey;

    @Override
    public double[] getLatLngFromAddress(String address) {
        String url = String.format(
                "https://maps.googleapis.com/maps/api/geocode/json?address=%s&key=%s",
                address.replace(" ", "+"), apiKey
        );
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        JSONObject json = new JSONObject(result);
        JSONArray results = (JSONArray) json.get("results");
        JSONObject location = results.getJSONObject(0)
                .getJSONObject("geometry")
                .getJSONObject("location");
        double lat = location.getDouble("lat");
        double lng = location.getDouble("lng");
        return new double[]{lat, lng};

    }
}
