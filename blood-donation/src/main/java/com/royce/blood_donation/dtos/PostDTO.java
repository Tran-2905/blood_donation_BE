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
    @JsonProperty("author_name")
    private String authorName;
    private String designation;
    private String bio;
    @JsonProperty("category_id")
    private int categoryId;
}
