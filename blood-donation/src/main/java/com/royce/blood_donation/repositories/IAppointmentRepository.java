package com.royce.blood_donation.repositories;

import com.royce.blood_donation.models.appointment.Appointment;
import com.royce.blood_donation.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface IAppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> getAppointmentsByUser_Id(Long userId);
}
