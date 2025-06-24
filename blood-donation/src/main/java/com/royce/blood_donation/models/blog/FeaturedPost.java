package com.royce.blood_donation.models.blog;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "featured_posts")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class FeaturedPost {
    @Id
    @Column(name = "post_id")
    private Long postId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "post_id")
    private Post post;

    @Column(name = "priority")
    private Short priority;

    @Column(name = "added_at", nullable = false, updatable = false)
    private LocalDateTime addedAt;
}
