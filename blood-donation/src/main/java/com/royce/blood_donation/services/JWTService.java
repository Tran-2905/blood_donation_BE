package com.royce.blood_donation.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.cglib.core.internal.Function;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class JWTService implements IJWTService {
    @Value("${jwt.secretKey}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private int expiration;


    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSigninKey(), SignatureAlgorithm.HS256)
                .compact();

    }

    public String generateRefreshToken(Map<String, Objects> extractClaims, UserDetails userDetails) {
        return Jwts.builder()
                .setClaims(extractClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 48))
                .signWith(getSigninKey(), SignatureAlgorithm.HS256)
                .compact();

    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaim(token) ;
        return claimsResolver.apply(claims);
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private Key getSigninKey() {
        byte[] key = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(key);
    }

    private Claims extractAllClaim(String token) {
        return Jwts.parserBuilder().setSigningKey(getSigninKey()).build().parseClaimsJws(token).getBody();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = (String) extractClaim(token, Claims::getSubject);
        return username != null && username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    public boolean isTokenExpired(String token) {
        return extractClaim(token, Claims :: getExpiration).before(new Date());
    }
}
