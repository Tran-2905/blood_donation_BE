package com.royce.blood_donation.controllers;

import com.royce.blood_donation.dtos.UserLoginDTO;
import com.royce.blood_donation.dtos.UserDTO;
import com.royce.blood_donation.services.jwt.IJWTService;
import com.royce.blood_donation.services.user.IUserService;
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
    private final IJWTService jwtService;

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
    public ResponseEntity<?> login(@RequestBody UserLoginDTO userLoginDTO, BindingResult result) {
        try{
            if(result.hasErrors()) {
                List<String> errors = result.getFieldErrors().stream().map(FieldError::getDefaultMessage).toList();
            }
            return ResponseEntity.ok(userService.login(userLoginDTO));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }


}
