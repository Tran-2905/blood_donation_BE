package com.royce.blood_donation.repositories;

import com.royce.blood_donation.models.donation.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDonationRepository extends JpaRepository<Donation, Long> {
    List<Donation> getAllByDonorUserId_Id(Long userId);
}
