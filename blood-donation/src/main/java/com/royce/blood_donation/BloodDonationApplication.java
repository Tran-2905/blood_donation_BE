package com.royce.blood_donation;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@OpenAPIDefinition(
		info = @Info(
				title = "Blood Donation System",
				version = "v1.0",
				description = "API phục vụ cho việc quản lý hiến máu trong hệ thống"
		)
)
@EnableWebSecurity
@SpringBootApplication
public class BloodDonationApplication {
	public static void main(String[] args) {
		SpringApplication.run(BloodDonationApplication.class, args);
	}
}
