package com.royce.blood_donation.controllers;

import com.royce.blood_donation.responses.BloodCapacityResponse;
import com.royce.blood_donation.responses.BloodTypeResponse;
import com.royce.blood_donation.services.IBloodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v1/blood")
@RequiredArgsConstructor
public class BloodController {
    private final IBloodService bloodService;
    @GetMapping("/types")
    public ResponseEntity<?> getAllBlood() {
        List<BloodTypeResponse> bloodTypeResponse = bloodService.getAllBloodTypes();
        return new ResponseEntity<>(bloodTypeResponse, HttpStatus.OK);
    }

    @GetMapping("/all-type")
    public ResponseEntity<?> getAllBloodType() {
        List<BloodCapacityResponse> bloodTypeResponse = bloodService.getAllBloodCapacity();
        return new ResponseEntity<>(bloodTypeResponse, HttpStatus.OK);
    }

}
