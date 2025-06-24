package com.royce.blood_donation.services.request;

import com.royce.blood_donation.dtos.RequestDonationDTO;
import com.royce.blood_donation.models.user.User;

public interface IDonationRegistration {
    public void createRequestDonation(RequestDonationDTO requestDonationDTO, User user);
}
