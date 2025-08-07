package com.royce.blood_donation.services.post;

import com.royce.blood_donation.dtos.PostCategoryDTO;
import com.royce.blood_donation.models.blog.PostCategory;
import com.royce.blood_donation.repositories.IPostCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostCategoryService implements IPostCategoryService {
    private final IPostCategoryRepository postCategoryRepository;
    private final ModelMapper mapper;
    @Override
    public void createPostCategory(PostCategoryDTO postCategoryDTO) {
        PostCategory postCategory = new PostCategory();
        mapper.map(postCategoryDTO, postCategory);
        postCategory.setSlug(postCategory.getName().toLowerCase().replaceAll(" ", "-"));
        postCategoryRepository.save(postCategory);
        System.out.println("Saved Post Category: " + postCategory.getName());
    }

    @Override
    public PostCategory getPostCategoryById(int id) {
        return postCategoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Post Category not found"));
    }

    @Override
    public List<PostCategory> getAllCategories() {
        return postCategoryRepository.findAllByOrderByIdAsc();
    }
}
