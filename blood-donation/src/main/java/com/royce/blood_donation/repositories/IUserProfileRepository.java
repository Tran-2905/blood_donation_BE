package com.royce.blood_donation.repositories;

import com.royce.blood_donation.models.user.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserProfileRepository extends JpaRepository <UserProfile, Long>{
    Optional<UserProfile> findByUserId(Long id);
}
