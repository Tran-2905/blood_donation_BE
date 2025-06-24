package com.royce.blood_donation.services.post;

import com.royce.blood_donation.configuration.MapperConfig;
import com.royce.blood_donation.dtos.PostDTO;
import com.royce.blood_donation.models.blog.Post;
import com.royce.blood_donation.models.enums.Status;
import com.royce.blood_donation.models.user.User;
import com.royce.blood_donation.models.user.UserProfile;
import com.royce.blood_donation.repositories.IPostRepository;
import com.royce.blood_donation.repositories.IUserProfileRepository;
import com.royce.blood_donation.repositories.IUserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService implements IPostService {
    private final IPostRepository postRepository;
    private final IUserProfileRepository userProfileRepository;
    private final IUserRepository userRepository;
    private final ModelMapper mapper;
    @Transactional
    public void createPost(PostDTO postDTO, User user){
        User managedUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        UserProfile userProfile = mapper.map(postDTO, UserProfile.class);
        userProfile.setUser(managedUser);
        userProfileRepository.save(userProfile);
        Post post = mapper.map(postDTO, Post.class);
        post.setAuthor(managedUser);
        post.setSlug(post.getTitle().toLowerCase().replaceAll(" ", "-"));
        post.setStatus(Status.Pending);

        postRepository.save(post);
    }
}
