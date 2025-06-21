package com.royce.blood_donation.services;

import com.royce.blood_donation.dtos.RequestDonationDTO;
import com.royce.blood_donation.models.User;
import org.springframework.security.core.Authentication;

public interface IDonationRegistration {
    public void createRequestDonation(RequestDonationDTO requestDonationDTO, User user);
}
