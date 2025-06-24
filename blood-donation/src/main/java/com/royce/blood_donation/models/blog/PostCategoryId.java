package com.royce.blood_donation.models.blog;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class PostCategoryId implements Serializable {
    @Column(name = "post_id")
    private Long postId;

    @Column(name = "category_id")
    private Integer categoryId;

}
