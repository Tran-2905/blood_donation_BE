package com.royce.blood_donation.services.appointment;

import com.royce.blood_donation.dtos.RequestDonationDTO;
import com.royce.blood_donation.models.appointment.Appointment;
import com.royce.blood_donation.models.user.User;
import com.royce.blood_donation.responses.AppointmentResponse;

import java.util.List;

public interface IAppointmentService {
    public void createRequestDonation(RequestDonationDTO requestDonationDTO, User user);

    public List<AppointmentResponse> getAllAppointments(String token);
}
