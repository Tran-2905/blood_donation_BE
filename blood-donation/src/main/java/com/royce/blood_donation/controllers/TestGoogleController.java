package com.royce.blood_donation.controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class TestGoogleController {
    @GetMapping("/authorize/{provider}")
    public void redirectToProvider(@PathVariable String provider, HttpServletResponse response) throws IOException {
        String redirectUrl = "http://localhost:8080/oauth2/authorization/" + provider;
        response.sendRedirect(redirectUrl);
    }
}
