package com.royce.blood_donation.services.post;

import com.royce.blood_donation.dtos.PostDTO;
import com.royce.blood_donation.models.blog.Post;
import com.royce.blood_donation.models.user.User;
import org.springframework.web.multipart.MultipartFile;

public interface IPostService {
    public void createPost(PostDTO postDTO, MultipartFile image_url, MultipartFile avatar_url, User user);
    public Post getPostById(Long id);
}
