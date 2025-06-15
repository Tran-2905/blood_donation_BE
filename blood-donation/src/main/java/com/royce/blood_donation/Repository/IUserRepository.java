package com.royce.blood_donation.Repository;

import com.royce.blood_donation.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {
    boolean existsByPhoneNumber(String phoneNumber);
    Optional <User> findByPhoneNumber(String phoneNumber);
}
