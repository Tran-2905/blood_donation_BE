package com.royce.blood_donation.services.user;

import com.nimbusds.openid.connect.sdk.UserInfoResponse;
import com.royce.blood_donation.models.user.User;
import com.royce.blood_donation.responses.UserProfileResponse;

public interface IUserService {
    public UserProfileResponse getUserInfo(Long id);
}
