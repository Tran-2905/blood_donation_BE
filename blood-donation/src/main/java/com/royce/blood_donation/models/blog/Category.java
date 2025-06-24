package com.royce.blood_donation.models.blog;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer id;

    @Column(name = "name", nullable = false, unique = true, length = 50)
    private String name;

    @Column(name = "slug", nullable = false, unique = true, length = 50)
    private String slug;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}
