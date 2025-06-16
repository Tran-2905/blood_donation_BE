package com.royce.blood_donation.repositories;

import com.royce.blood_donation.models.RequestDonation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDonationRegistrationRepository extends JpaRepository<RequestDonation, Long> {

}
