package com.royce.blood_donation.services.otps;

import com.royce.blood_donation.models.otp.OtpDetails;

public interface IOtpStorageService {
    public void storeOtp(String email, String otp);
    public OtpDetails getOtpDetails(String email);
    public void removeOtp(String email);
}
