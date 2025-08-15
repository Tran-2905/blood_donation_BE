package com.royce.blood_donation.services.donation;

import com.royce.blood_donation.configuration.DonationMapperConfig;
import com.royce.blood_donation.models.donation.Donation;
import com.royce.blood_donation.repositories.IDonationRepository;
import com.royce.blood_donation.responses.DonationResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DonationService implements IDonationService {
    private final IDonationRepository donationRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<DonationResponse> getAllDonations(Long id) {
        List<Donation> donations = donationRepository.getAllByDonorUserId_Id(id);
        return donations.stream()
                .map(donation -> modelMapper.map(donation, DonationResponse.class))
                .collect(Collectors.toList());
    }
}

