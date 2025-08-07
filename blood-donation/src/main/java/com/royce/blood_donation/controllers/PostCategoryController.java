package com.royce.blood_donation.controllers;

import com.royce.blood_donation.dtos.PostCategoryDTO;
import com.royce.blood_donation.models.blog.PostCategory;
import com.royce.blood_donation.responses.BloodCapacityResponse;
import com.royce.blood_donation.services.post.IPostCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/post-category")
@RequiredArgsConstructor
public class PostCategoryController {
    private final IPostCategoryService postCategoryService;
    @GetMapping("/all")
    public ResponseEntity<?> getAllPostCategory(){
        postCategoryService.getAllCategories();
        return new ResponseEntity<>(postCategoryService.getAllCategories(), HttpStatus.OK);
    }

    @GetMapping("/category-type/{id}")
    public ResponseEntity<?> getPostCategoryById(@PathVariable("id") int id){
        return new ResponseEntity<>(postCategoryService.getPostCategoryById(id), HttpStatus.OK);
    }
    @GetMapping("create")
    public ResponseEntity<?> createPostCategory(@RequestBody PostCategoryDTO postCategoryDTO){
        postCategoryService.createPostCategory(postCategoryDTO);
        return ResponseEntity.ok().build();
    }
}
