package com.royce.blood_donation.controllers;

import com.royce.blood_donation.models.user.User;
import com.royce.blood_donation.responses.UserProfileResponse;
import com.royce.blood_donation.services.user.IUserService;
import com.royce.blood_donation.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/user-profile")
public class UserProfileController {
    private final IUserService userService;
    @GetMapping("/profile")
    public ResponseEntity<UserProfileResponse> getUserProfile(@AuthenticationPrincipal User user) {
        UserProfileResponse profile = userService.getUserInfo(user.getId());
        return ResponseEntity.ok(profile);
    }
}
