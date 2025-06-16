package com.royce.blood_donation.controllers;

import com.royce.blood_donation.dtos.RequestDonationDTO;
import com.royce.blood_donation.services.DonationRegistration;
import com.royce.blood_donation.services.IDonationRegistration;
import lombok.RequiredArgsConstructor;
import org.springdoc.webmvc.core.service.RequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/request")
public class RequestController {
    private final IDonationRegistration donationRegistration;
    @PostMapping("/add")
    public ResponseEntity<?> addRequest(@RequestBody RequestDonationDTO requestDonationDTO, BindingResult result) {

        try{
            if(result.hasErrors()) {
                List<String> errors = result.getFieldErrors().stream().map(FieldError::getDefaultMessage).toList();
                return ResponseEntity.badRequest().body(errors.toString());
            }
            donationRegistration.createRequestDonation(requestDonationDTO);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
