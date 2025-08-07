package com.royce.blood_donation.repositories;

import com.royce.blood_donation.models.blog.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPostCategoryRepository extends JpaRepository<PostCategory, Integer> {
    PostCategory findPostCategoryById(int id);
    List<PostCategory> findAllByOrderByIdAsc();
}
