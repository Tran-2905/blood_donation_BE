package com.royce.blood_donation.repositories;

import com.royce.blood_donation.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {
    boolean existsByPhoneNumber(String phoneNumber);
    Optional <User> findByPhoneNumber(String phoneNumber);
    User findUserById(Long id);
    Optional<User> findByGoogleAccount(String googleAccount);
    Optional<User> findByEmail(String email);
}
