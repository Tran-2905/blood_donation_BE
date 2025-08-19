package com.royce.blood_donation.configuration;

import com.royce.blood_donation.models.blood.BloodComponents;
import com.royce.blood_donation.models.blood.BloodType;
import com.royce.blood_donation.models.donation.Donation;
import com.royce.blood_donation.models.user.User;
import com.royce.blood_donation.responses.DonationResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

public class DonationMapperConfig {
    public static void configureDonationMapping(ModelMapper mapper) {
        // Converter để lấy userId từ User entity
        Converter<User, Long> userToIdConverter = new Converter<User, Long>() {
            @Override
            public Long convert(MappingContext<User, Long> context) {
                return context.getSource() == null ? null : context.getSource().getId();
            }
        };


        // Converter để lấy tên bloodType từ BloodType entity
        Converter<BloodType, String> bloodTypeToNameConverter = new Converter<BloodType, String>() {
            @Override
            public String convert(MappingContext<BloodType, String> context) {
                return context.getSource() == null ? null : context.getSource().getType();
            }
        };

        // Converter để lấy tên component từ BloodComponents entity
        Converter<BloodComponents, String> componentToNameConverter = new Converter<BloodComponents, String>() {
            @Override
            public String convert(MappingContext<BloodComponents, String> context) {
                return context.getSource() == null ? null : context.getSource().getComponentName().name();
            }
        };

        PropertyMap<Donation, DonationResponse> donationMap = new PropertyMap<Donation, DonationResponse>() {
            @Override
            protected void configure() {
                using(userToIdConverter).map(source.getDonorUserId().getId(), destination.getDonorUserId());
                using(userToIdConverter).map(source.getRecipientUserId(), destination.getRecipientUserId());
                using(bloodTypeToNameConverter).map(source.getBloodTypeId().getType(), destination.getBloodType());
                using(componentToNameConverter).map(source.getComponentId().getComponentName().name(), destination.getComponent());
                // Các trường còn lại ModelMapper tự map theo tên mặc định
            }
        };

        mapper.addMappings(donationMap);
    }
}
