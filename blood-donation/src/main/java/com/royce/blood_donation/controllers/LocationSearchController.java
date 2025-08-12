package com.royce.blood_donation.controllers;

import com.royce.blood_donation.services.distance.IDistanceService;
import com.royce.blood_donation.services.geocode.IGeocodingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/search")
public class LocationSearchController {
    private final IDistanceService distanceService;
    private final IGeocodingService geocodingService;

    /**
     * API: GET /api/v1/distance/calculate?origin=...&destination=...
     */
    @GetMapping("/calculate")
    public ResponseEntity<Map<String, Object>> getDistance(
            @RequestParam String origin,
            @RequestParam String destination
    ) {
        // Lấy lat/lng cho địa chỉ origin
        double[] originLatLng = geocodingService.getLatLngFromAddress(origin);
        // Lấy lat/lng cho địa chỉ destination
        double[] destinationLatLng = geocodingService.getLatLngFromAddress(destination);

        // Gọi Distance Matrix API để tính quãng đường thực tế
        double distanceKm = distanceService.getDrivingDistance(
                originLatLng[0], originLatLng[1],
                destinationLatLng[0], destinationLatLng[1]
        );

        // Trả kết quả JSON
        Map<String, Object> response = new HashMap<>();
        response.put("origin", origin);
        response.put("destination", destination);
        response.put("distance_km", distanceKm);

        return ResponseEntity.ok(response);
    }
}