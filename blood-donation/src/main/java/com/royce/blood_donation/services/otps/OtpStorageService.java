package com.royce.blood_donation.services.otps;

import com.royce.blood_donation.models.otp.OtpDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
@Service
public class OtpStorageService implements IOtpStorageService {
    private Map<String, OtpDetails> otpStore = new HashMap<>();

    @Override
    public void storeOtp(String email, String otp) {
        OtpDetails otpDetails = new OtpDetails(email, otp, LocalDateTime.now().plusMinutes(5));
        otpStore.put(email, otpDetails);
    }

    @Override
    public OtpDetails getOtpDetails(String email) {
        return otpStore.get(email);
    }

    @Override
    public void removeOtp(String email) {
        otpStore.remove(email);
    }
}
