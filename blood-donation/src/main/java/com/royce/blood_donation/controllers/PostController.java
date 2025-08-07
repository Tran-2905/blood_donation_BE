package com.royce.blood_donation.controllers;

import com.royce.blood_donation.dtos.PostDTO;
import com.royce.blood_donation.models.blog.Post;
import com.royce.blood_donation.models.user.User;
import com.royce.blood_donation.services.post.IPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/posts")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class PostController {
    private final IPostService postService;
    @PostMapping(value="/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE )
    public ResponseEntity<?> addPost(@RequestPart("post") @Validated PostDTO postDTO,
                                     @RequestPart(value = "image_url", required = false) MultipartFile image_url,
                                     @RequestPart(value = "avatar_url", required = false) MultipartFile avatar_url
                                    ,@AuthenticationPrincipal User user, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getFieldErrors().toString());
        }
        postService.createPost(postDTO, image_url, avatar_url, user);
        return ResponseEntity.ok().build();
    }


}
