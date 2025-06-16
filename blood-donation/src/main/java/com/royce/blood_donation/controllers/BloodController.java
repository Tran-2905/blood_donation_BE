package com.royce.blood_donation.Controller;

import com.royce.blood_donation.Model.BloodType;
import com.royce.blood_donation.Response.BloodCapacityResponse;
import com.royce.blood_donation.Response.BloodTypeResponse;
import com.royce.blood_donation.Service.BloodService;
import com.royce.blood_donation.Service.IBloodService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
