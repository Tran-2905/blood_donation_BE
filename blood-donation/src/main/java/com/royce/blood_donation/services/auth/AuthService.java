package com.royce.blood_donation.services.auth;

import com.royce.blood_donation.dtos.UserLoginDTO;
import com.royce.blood_donation.dtos.RefreshToken;
import com.royce.blood_donation.dtos.UserDTO;
import com.royce.blood_donation.models.user.User;
import com.royce.blood_donation.models.enums.Role;
import com.royce.blood_donation.repositories.IUserRepository;
import com.royce.blood_donation.responses.AuthenticationResponse;
import com.royce.blood_donation.services.jwt.JWTService;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor

public class AuthService implements IAuthService {
    private final IUserRepository userRepository;
    private final JWTService jwtService;


    private PasswordEncoder passwordEncoder (){
        return new BCryptPasswordEncoder();
    }
    @Override
    public void createUser(UserDTO userDTO) {
        if(userRepository.existsByPhoneNumber(userDTO.getPhoneNumber())) {
            throw new RuntimeException("Phone number already exists");
        }
        if(userDTO.getRole()==null){
            userDTO.setRole(Role.User);
        }
        if(userDTO.getFacebookAccountId()==null || userDTO.getGoogleAccountId()==null){
            userDTO.setPassword(passwordEncoder().encode(userDTO.getPassword()));
        }
         User user = User.builder()
                .phoneNumber(userDTO.getPhoneNumber())
                .email(userDTO.getEmail())
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .passwordHash(userDTO.getPassword())
                .role(userDTO.getRole())
                .country(userDTO.getCountry())
                .city(userDTO.getCity())
                .address(userDTO.getAddress())
                .bloodTypeId(userDTO.getBloodType())
                .facebookAccount(userDTO.getFacebookAccountId())
                .googleAccount(userDTO.getGoogleAccountId())
                .dateOfBirth(userDTO.getDateOfBirth())
                .build();
        userRepository.save(user);
    }

    @Override
    public AuthenticationResponse login(UserLoginDTO userLoginDTO) {
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        if(userRepository.existsByEmail(userLoginDTO.getEmail())) {
            User user = userRepository.findByEmail(userLoginDTO.getEmail()).orElseThrow(()->new RuntimeException("User not found"));
            if(passwordEncoder().matches(userLoginDTO.getPassword(), user.getPassword())) {
//                authenticationResponse.setUser(user);
                authenticationResponse.setToken(jwtService.generateToken(user));
                authenticationResponse.setRefreshToken(jwtService.generateRefreshToken(new HashMap<>(),user));
            }
        }
        return authenticationResponse;
    }


    public AuthenticationResponse refreshToken(RefreshToken refreshToken) {
        String phoneNumber = jwtService.extractUsername(refreshToken.getToken());
        User user = userRepository.getUsersByEmail(phoneNumber);
        if (jwtService.validateToken(refreshToken.getToken(), user)) {
            String jwt = jwtService.generateToken(user);
            AuthenticationResponse authenticationResponse = new AuthenticationResponse();
            authenticationResponse.setToken(jwt);
            authenticationResponse.setRefreshToken(jwtService.generateRefreshToken(new HashMap<>(), user));
            return authenticationResponse;
        }
        return null;
    }

    public User findOrCreateUserFromOAuth(String email, String googleId, String firstName, String lastName) {

        User user = userRepository.findByEmail(email)
                .orElseGet(() -> {
                    User newUser = new User();
                    newUser.setEmail(email);
                    newUser.setGoogleAccount(googleId);
                    newUser.setFirstName(firstName);
                    newUser.setLastName(lastName);
                    newUser.setRole(Role.User);
                    newUser.setBloodTypeId(10);
                    return newUser;
                });
        user.setGoogleAccount(googleId);
        return userRepository.save(user);
    }



}
