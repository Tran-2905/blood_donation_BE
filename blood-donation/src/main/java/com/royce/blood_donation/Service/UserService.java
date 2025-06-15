package com.royce.blood_donation.Service;

import com.royce.blood_donation.DTO.LoginUserDTO;
import com.royce.blood_donation.DTO.RefreshToken;
import com.royce.blood_donation.DTO.UserDTO;
import com.royce.blood_donation.Model.User;
import com.royce.blood_donation.Model.enums.Role;
import com.royce.blood_donation.Repository.IUserRepository;
import com.royce.blood_donation.Response.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;

@Service
@RequiredArgsConstructor

public class UserService implements IUserService {
    private final IUserRepository userRepository;
    private final JWTService jwtService;

    private PasswordEncoder passwordEncoder (){
        return new BCryptPasswordEncoder();
    }
    @Override
    public User createUser(UserDTO userDTO) {
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
         return userRepository.save(user);
    }

    @Override
    public AuthenticationResponse login(LoginUserDTO loginUserDTO) {
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        if(userRepository.existsByPhoneNumber(loginUserDTO.getPhoneNumber())) {
            User user = userRepository.findByPhoneNumber(loginUserDTO.getPhoneNumber()).orElseThrow(()->new RuntimeException("User not found"));
            if(passwordEncoder().matches(loginUserDTO.getPassword(), user.getPassword())) {
//                authenticationResponse.setUser(user);
                authenticationResponse.setToken(jwtService.generateToken(user));
                authenticationResponse.setRefreshToken(jwtService.generateRefreshToken(new HashMap<>(),user));
            }
        }
        return authenticationResponse;
    }

    public User getUserByPhoneNumber(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber).orElseThrow(()->new RuntimeException("User not found"));
    }

    public AuthenticationResponse refreshToken(RefreshToken refreshToken) {
        String phoneNumber = jwtService.extractUsername(refreshToken.getToken());
        User user = getUserByPhoneNumber(phoneNumber);
        if(jwtService.validateToken(refreshToken.getToken(), user)) {
            String jwt = jwtService.generateToken(user);
            AuthenticationResponse authenticationResponse = new AuthenticationResponse();
            authenticationResponse.setToken(jwt);
            authenticationResponse.setRefreshToken(jwtService.generateRefreshToken(new HashMap<>(),user));
            return authenticationResponse;
        }
        return null;
    }
}
