package com.royce.blood_donation.controllers;

import com.royce.blood_donation.dtos.PostDTO;
import com.royce.blood_donation.models.user.User;
import com.royce.blood_donation.services.post.IPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {
    private final IPostService postService;
    @PostMapping("/add")
    public ResponseEntity<?> addPost(@Validated @RequestBody PostDTO postDTO, @AuthenticationPrincipal User user, BindingResult result){
        if(result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getFieldErrors().toString());
        }
        postService.createPost(postDTO, user);
        return ResponseEntity.ok().build();
    }
}
