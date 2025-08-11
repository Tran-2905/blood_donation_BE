package com.royce.blood_donation.services.geocode;

public interface IGeocodingService {
    public double[] getLatLngFromAddress(String address);
}
