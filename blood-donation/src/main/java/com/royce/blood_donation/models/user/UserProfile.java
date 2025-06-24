package com.royce.blood_donation.models.user;

import com.royce.blood_donation.dtos.PostDTO;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user_profiles")
@Data
public class UserProfile {
    @Id
    @Column(name = "user_id")
    private Long userId;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "designation", length = 100)
    private String designation;

    @Column(name = "bio", columnDefinition = "TEXT")
    private String bio;

    @Column(name = "avatar_url", length = 255)
    private String avatarUrl;
}