package com.royce.blood_donation.services.appointment;


import com.royce.blood_donation.dtos.RequestDonationDTO;
import com.royce.blood_donation.models.appointment.Appointment;
import com.royce.blood_donation.models.user.User;
import com.royce.blood_donation.models.enums.Status;
import com.royce.blood_donation.repositories.IBloodTypeRepository;
import com.royce.blood_donation.repositories.IAppointmentRepository;
import com.royce.blood_donation.repositories.IUserRepository;
import com.royce.blood_donation.responses.AppointmentResponse;
import com.royce.blood_donation.services.auth.IAuthService;
import com.royce.blood_donation.services.jwt.IJWTService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService implements IAppointmentService {
    private final IAppointmentRepository appointmentRepository;
    private final IUserRepository userRepository;
    private final IBloodTypeRepository bloodTypeRepository;
    private final IJWTService jwtService;
    private final ModelMapper mapper;
    public void createRequestDonation(RequestDonationDTO requestDonationDTO, User user) {

        Appointment requestDonation = Appointment.builder()
                .user(userRepository.findUserById(user.getId()))
                .fullName(requestDonationDTO.getFullName())
                .phoneNumber(requestDonationDTO.getPhoneNumber())
                .email(requestDonationDTO.getEmail())
                .dateOfBirth(requestDonationDTO.getDateOfBirth())
                .gender(requestDonationDTO.getGender())
                .bloodTypeId(bloodTypeRepository.findById(requestDonationDTO.getBloodTypeId()))
                .weight(requestDonationDTO.getWeight())
                .height(requestDonationDTO.getHeight())
                .lastDonation(requestDonationDTO.getLastDonation())
                .availableDate(requestDonationDTO.getAvailableDate())
                .availableTime(requestDonationDTO.getAvailableTime())
                .notes(requestDonationDTO.getNotes())
                .acceptGeneralTerm(requestDonationDTO.isAcceptGeneralTerm())
                .acceptContactTerm(requestDonationDTO.isAcceptContactTerm())
                .status(Status.pending)
                .build();
        appointmentRepository.save(requestDonation);
    }

    @Override
    public AppointmentResponse getAllAppointments(Long id) {
        AppointmentResponse appointmentResponses = new AppointmentResponse();
        Appointment appointments = appointmentRepository.getAppointmentsByUser_Id(id);
        if(appointments == null) {
            appointmentResponses.setStatus("No appointments found");
            return appointmentResponses;
        }
        mapper.map(appointments, appointmentResponses);
        appointmentResponses.setType(appointments.getBloodComponent().getComponentName().name());
        return appointmentResponses;
    }



}
