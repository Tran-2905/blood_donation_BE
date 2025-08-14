package com.royce.blood_donation.services.user;

import com.nimbusds.openid.connect.sdk.UserInfoResponse;
import com.royce.blood_donation.models.user.User;
import com.royce.blood_donation.repositories.IUserRepository;
import com.royce.blood_donation.responses.UserProfileResponse;
import com.royce.blood_donation.services.jwt.IJWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService{
    private final IUserRepository userRepository;
    private final IJWTService jwtService;

    @Override
    public UserProfileResponse getUserInfo(Long id) {

        return userRepository.findUserWithLatestDonation(id);
    }
}
