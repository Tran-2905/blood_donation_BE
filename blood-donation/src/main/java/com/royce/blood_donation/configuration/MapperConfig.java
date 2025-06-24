package com.royce.blood_donation.configuration;

import com.royce.blood_donation.dtos.PostDTO;
import com.royce.blood_donation.models.blog.Post;
import com.royce.blood_donation.models.user.UserProfile;
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
                    m.map(PostDTO::getAvatarUrl,   UserProfile::setAvatarUrl);
                });

        // --- mapping từ PostDTO → Post ---
        mapper.createTypeMap(PostDTO.class, Post.class)
                .addMappings(m -> {
                    m.map(PostDTO::getTitle,    Post::setTitle);
                    m.map(PostDTO::getSummary,  Post::setSummary);
                    m.map(PostDTO::getContent,  Post::setContent);
                    m.map(PostDTO::getImageUrl, Post::setImageUrl);
                });

        return mapper;
    }

}
