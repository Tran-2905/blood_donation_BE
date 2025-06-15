package com.royce.blood_donation;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@OpenAPIDefinition(
		info = @Info(
				title = "Blood Donation System",
				version = "v1.0",
				description = "API phục vụ cho việc quản lý hiến máu trong hệ thống"
		)
)
@SpringBootApplication
public class BloodDonationApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloodDonationApplication.class, args);
	}

}
