package com.royce.blood_donation.controllers;

import com.royce.blood_donation.dtos.LoginUserDTO;
import com.royce.blood_donation.dtos.UserDTO;
import com.royce.blood_donation.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {
    private final IUserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDTO userDTO, BindingResult result) {
        try{
            if(result.hasErrors()) {
                List<String> errors = result.getFieldErrors().stream().map(FieldError::getDefaultMessage).toList();
                return ResponseEntity.badRequest().body(errors.toString());
            }
            userService.createUser(userDTO);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginUserDTO loginUserDTO, BindingResult result) {
        try{
            if(result.hasErrors()) {
                List<String> errors = result.getFieldErrors().stream().map(FieldError::getDefaultMessage).toList();
            }
            return ResponseEntity.ok(userService.login(loginUserDTO));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
//    @PostMapping("/refesh-token")
//    public ResponseEntity<?> refeshToken(@RequestBody UserDTO userDTO, BindingResult result) {
//        if(result.hasErrors()) {
//            List<String> errors = result.getFieldErrors().stream().map(FieldError::getDefaultMessage).toList();
//        }
//
//        return ResponseEntity.ok().build();
//    }
}
