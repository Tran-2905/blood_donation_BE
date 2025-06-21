package com.royce.blood_donation.services;

import com.royce.blood_donation.models.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;
import java.util.Objects;

public interface IJWTService {
    String extractUsername(String token);
    String generateToken(User user);
    boolean isTokenExpired(String token);
    boolean validateToken(String token, UserDetails userDetails);
    public String generateRefreshToken(Map<String, Objects> extractClaims, User userDetails);
}
