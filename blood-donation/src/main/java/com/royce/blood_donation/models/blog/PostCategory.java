package com.royce.blood_donation.models.blog;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "post_categories")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class PostCategory {
    @EmbeddedId
    private PostCategoryId id;
    @ManyToOne
    @MapsId("postId")
    @JoinColumn(name = "post_id", insertable = false, updatable = false)
    private Post post;
    @ManyToOne
    @MapsId("categoryId")
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private Category category;
}
