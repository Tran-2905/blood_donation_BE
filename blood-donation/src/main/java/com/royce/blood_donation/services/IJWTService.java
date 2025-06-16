package com.royce.blood_donation.Service;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;
import java.util.Objects;

public interface IJWTService {
    String extractUsername(String token);
    String generateToken(UserDetails userDetails);
    boolean isTokenExpired(String token);
    boolean validateToken(String token, UserDetails userDetails);
    public String generateRefreshToken(Map<String, Objects> extractClaims, UserDetails userDetails);
}
