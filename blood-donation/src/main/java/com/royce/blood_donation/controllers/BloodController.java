package com.royce.blood_donation.controllers;

import com.royce.blood_donation.responses.BloodCapacityResponse;
import com.royce.blood_donation.responses.BloodTypeResponse;
import com.royce.blood_donation.services.blood.IBloodService;
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

    @GetMapping("/blood-types/{id}/components")
    public ResponseEntity<?> getCapacityBlood(@PathVariable("id") int id, @RequestParam(required = false) int bloodComponentId) {
        BloodCapacityResponse bloodTypeResponse = bloodService.getAllBloodCapacityByBloodTypeAndBloodComponent(id,bloodComponentId);
        return new ResponseEntity<>(bloodTypeResponse, HttpStatus.OK);
    }


    @GetMapping("/blood-type/{id}")
    public ResponseEntity<?> getBloodType(@PathVariable("id") int id){
        return new ResponseEntity<>(bloodService.getBloodTypeById(id), HttpStatus.OK);
    }

    @GetMapping("/component/{id}")
    public ResponseEntity<?> getAllComponent(@PathVariable("id") int id){
        return new ResponseEntity<>( bloodService.getBloodComponentById(id), HttpStatus.OK);
    }

    @GetMapping("/component-type")
    public ResponseEntity<?> getAllComponents(){
        return new ResponseEntity<>(bloodService.getBloodComponents(), HttpStatus.OK);
    }

}
