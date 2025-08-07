package com.royce.blood_donation.services.post;

import com.royce.blood_donation.dtos.PostCategoryDTO;
import com.royce.blood_donation.models.blog.PostCategory;

import java.util.List;

public interface IPostCategoryService {
    public void createPostCategory(PostCategoryDTO postCategory);
    public PostCategory getPostCategoryById(int id);
    public List<PostCategory> getAllCategories();
}
