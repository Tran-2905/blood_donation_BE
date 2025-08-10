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

    @Lob
    @Column(name = "avatar_url")
    private byte[] avatarUrl;
}