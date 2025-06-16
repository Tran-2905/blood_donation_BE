package com.royce.blood_donation.services;

import com.royce.blood_donation.dtos.RequestDonationDTO;

public interface IDonationRegistration {
    public void createRequestDonation(RequestDonationDTO requestDonationDTO);
}
