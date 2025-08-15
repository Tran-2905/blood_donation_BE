package com.royce.blood_donation.services.donation;

import com.royce.blood_donation.models.donation.Donation;
import com.royce.blood_donation.responses.DonationResponse;

import java.util.List;

public interface IDonationService {
    List<DonationResponse> getAllDonations(Long id);
}
