    package com.royce.blood_donation.controllers;

    import com.royce.blood_donation.models.otp.OtpDetails;
    import com.royce.blood_donation.services.otps.IEmailService;
    import com.royce.blood_donation.services.otps.IOtpStorageService;
    import lombok.RequiredArgsConstructor;
    import org.springframework.web.bind.annotation.*;

    import java.time.LocalDateTime;

    @RequiredArgsConstructor
    @RestController
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("api/v1/otp")
    public class OtpController {
        private final IEmailService emailOtpService;
        private final IOtpStorageService otpStorageService;

        @PostMapping("/send")
        public String sendOtp(@RequestParam String email) {
            emailOtpService.sendOtp(email);
            return "OTP sent to " + email;
        }

        @PostMapping("/verify")
        public String verifyOtp(@RequestParam String email, @RequestParam String otp) {
            OtpDetails otpDetails = otpStorageService.getOtpDetails(email);

            if (otpDetails == null) {
                return "No OTP found for this email.";
            }

            if (otpDetails.getExpirationTime().isBefore(LocalDateTime.now())) {
                otpStorageService.removeOtp(email);
                return "OTP has expired.";
            }

            if (!otpDetails.getOtp().equals(otp)) {
                return "Invalid OTP.";
            }

            otpStorageService.removeOtp(email);
            return "OTP verified successfully!";
        }
    }
