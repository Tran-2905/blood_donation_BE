package com.royce.blood_donation.configuration;

import com.royce.blood_donation.dtos.PostCategoryDTO;
import com.royce.blood_donation.dtos.PostDTO;
import com.royce.blood_donation.models.appointment.Appointment;
import com.royce.blood_donation.models.blog.PostCategory;
import com.royce.blood_donation.models.blog.Post;
import com.royce.blood_donation.models.user.UserProfile;
import com.royce.blood_donation.responses.AppointmentResponse;
import com.royce.blood_donation.responses.PostResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        mapper.createTypeMap(PostDTO.class, UserProfile.class)
                .addMappings(m -> {
                    m.map(PostDTO::getDesignation, UserProfile::setDesignation);
                    m.map(PostDTO::getBio,         UserProfile::setBio);
                });
        mapper.createTypeMap(PostDTO.class, Post.class)
                .addMappings(m -> {
                    m.map(PostDTO::getTitle,    Post::setTitle);
                    m.map(PostDTO::getSummary,  Post::setSummary);
                    m.map(PostDTO::getContent,  Post::setContent);
                });
        mapper.createTypeMap(PostCategoryDTO.class, PostCategory.class)
                .addMappings(m -> {
                    m.map(PostCategoryDTO :: getName, PostCategory::setName);
                });
        mapper.createTypeMap(Appointment.class, AppointmentResponse.class)
                .addMappings(m -> {
                    m.map(Appointment::getAvailableDate, AppointmentResponse::setDate);
                    m.map(Appointment::getAvailableTime, AppointmentResponse::setTime);
                    m.map(Appointment::getStatus, AppointmentResponse::setStatus);
                });
        return mapper;


    }

}
