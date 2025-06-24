package com.royce.blood_donation.services.post;

import com.royce.blood_donation.dtos.PostDTO;
import com.royce.blood_donation.models.user.User;

public interface IPostService {
    public void createPost(PostDTO postDTO, User user);
}
