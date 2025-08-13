package com.royce.blood_donation.repositories;

import com.royce.blood_donation.models.user.User;
import com.royce.blood_donation.responses.PostResponse;
import com.royce.blood_donation.responses.UserProfileResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {
    boolean existsByPhoneNumber(String phoneNumber);
    Optional <User> findByPhoneNumber(String phoneNumber);
    User findUserById(Long id);
    Optional<User> findByGoogleAccount(String googleAccount);
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    User getUsersByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.id = :id")
    User getUserById(Long id);

    @Query("""
        SELECT new com.royce.blood_donation.responses.UserProfileResponse(
            u.lastName, u.email, b.type + b.rh, 
        )
        FROM  D
        JOIN 
        JOIN 
        WHERE u.id = :id
""")
    List<UserProfileResponse> findAllUsers();
}
