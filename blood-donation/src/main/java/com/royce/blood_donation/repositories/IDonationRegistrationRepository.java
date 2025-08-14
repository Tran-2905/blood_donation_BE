package com.royce.blood_donation.repositories;

import com.royce.blood_donation.models.appointment.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDonationRegistrationRepository extends JpaRepository<Appointment, Long> {

}
