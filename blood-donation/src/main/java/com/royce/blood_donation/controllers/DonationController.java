package com.royce.blood_donation.controllers;

import com.royce.blood_donation.models.donation.Donation;
import com.royce.blood_donation.models.user.User;
import com.royce.blood_donation.responses.DonationResponse;
import com.royce.blood_donation.services.donation.IDonationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/donation")
public class DonationController {
    private final IDonationService donationService;
    @GetMapping("/all")
    public ResponseEntity<?> getDonation(@AuthenticationPrincipal User user){
        List<DonationResponse> donations = donationService.getAllDonations(user.getId());
        return  ResponseEntity.ok(donations);
    }
}
