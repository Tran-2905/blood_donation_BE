package com.royce.blood_donation.Service.OTP;

import com.royce.blood_donation.Model.OtpDetails;

public interface IOtpStorageService {
    public void storeOtp(String email, String otp);
    public OtpDetails getOtpDetails(String email);
    public void removeOtp(String email);
}
