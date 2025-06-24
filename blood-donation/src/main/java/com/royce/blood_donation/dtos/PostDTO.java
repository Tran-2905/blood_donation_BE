package com.royce.blood_donation.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.royce.blood_donation.models.user.User;
import jakarta.persistence.Column;
import lombok.*;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDTO {
    @JsonProperty("tittle")
    private String title;
    private String summary;
    private String content;
    @JsonProperty("image_url")
    private String imageUrl;
    @JsonProperty("author_name")
    private String authorName;
    private String designation;
    private String bio;
    @JsonProperty("avatar_url")
    private String avatarUrl;

}
