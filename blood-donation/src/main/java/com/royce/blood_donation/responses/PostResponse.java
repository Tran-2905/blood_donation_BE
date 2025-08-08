package com.royce.blood_donation.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
public class PostResponse {
    private Long id;
    private String title;
    @JsonProperty("author_name")
    private String authorName;
    @JsonProperty("approved_at")
    private LocalDateTime approvedAt;
    @JsonProperty("image_url")
    private String imageUrl;
    private String summary;
    public PostResponse(Long id, String title, String authorName, LocalDateTime approvedAt, String imageUrl, String summary) {
        this.id = id;
        this.title = title;
        this.authorName = authorName;
        this.approvedAt = approvedAt;
        this.imageUrl = imageUrl;
        this.summary = summary;
    }
}
