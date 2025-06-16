package com.royce.blood_donation.services;


import com.royce.blood_donation.dtos.RequestDonationDTO;
import com.royce.blood_donation.models.RequestDonation;
import com.royce.blood_donation.models.enums.Status;
import com.royce.blood_donation.repositories.IBloodTypeRepository;
import com.royce.blood_donation.repositories.IDonationRegistrationRepository;
import com.royce.blood_donation.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DonationRegistration implements IDonationRegistration {
    private final IDonationRegistrationRepository donationRegistrationRepository;
    private final IUserRepository userRepository;
    private final IBloodTypeRepository bloodTypeRepository;
    public void createRequestDonation(RequestDonationDTO requestDonationDTO) {
        RequestDonation requestDonation = RequestDonation.builder()
                .user(userRepository.findUserById(requestDonationDTO.getUserId()))
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
                .status(Status.Pending)
                .build();
        donationRegistrationRepository.save(requestDonation);
    }
}
