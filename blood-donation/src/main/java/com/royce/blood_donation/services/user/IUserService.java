package com.royce.blood_donation.services.user;

import com.nimbusds.openid.connect.sdk.UserInfoResponse;

public interface IUserService {
    public UserInfoResponse getUserInfo(String accessToken);
}
