package com.royce.blood_donation.controllers;

import com.royce.blood_donation.dtos.RequestDonationDTO;
import com.royce.blood_donation.models.user.User;
import com.royce.blood_donation.services.request.IDonationRegistration;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/request-donation")
public class RequestController {
    private final IDonationRegistration donationRegistration;
    @PostMapping("/add")
    public ResponseEntity<?> addRequest(@RequestBody @Valid RequestDonationDTO requestDonationDTO, BindingResult result, @AuthenticationPrincipal User user) {
        try{
            if(result.hasErrors()) {
                List<String> errors = result.getFieldErrors().stream().map(FieldError::getDefaultMessage).toList();
                return ResponseEntity.badRequest().body(errors.toString());
            }
            donationRegistration.createRequestDonation(requestDonationDTO, user);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
