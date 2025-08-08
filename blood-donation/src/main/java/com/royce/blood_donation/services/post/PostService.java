package com.royce.blood_donation.services.post;

import com.royce.blood_donation.dtos.PostDTO;
import com.royce.blood_donation.models.blog.Post;
import com.royce.blood_donation.models.blog.PostCategory;
import com.royce.blood_donation.models.enums.Status;
import com.royce.blood_donation.models.user.User;
import com.royce.blood_donation.models.user.UserProfile;
import com.royce.blood_donation.repositories.IPostRepository;
import com.royce.blood_donation.repositories.IUserProfileRepository;
import com.royce.blood_donation.repositories.IUserRepository;
import com.royce.blood_donation.responses.PostResponse;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostService implements IPostService {
    private final IPostRepository postRepository;
    private final IUserProfileRepository userProfileRepository;
    private final IUserRepository userRepository;
    private final ModelMapper mapper;
    @Transactional
    public void createPost(PostDTO postDTO,MultipartFile image_url, MultipartFile avatar_url, User user){
        User managedUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        UserProfile userProfile = userProfileRepository.findByUserId(user.getId()).orElse(new UserProfile());
        mapper.map(postDTO, userProfile);
        if(avatar_url!=null){
            userProfile.setAvatarUrl(uploadImages(avatar_url));
        }
        userProfile.setUser(managedUser);
        userProfileRepository.save(userProfile);
        Post post = new Post();
        mapper.map(postDTO, post);
        post.setAuthor(managedUser);
        post.setImageUrl(uploadImages(image_url));
        post.setSlug(post.getTitle().toLowerCase().replaceAll(" ", "-"));
        post.setStatus(Status.pending);
        postRepository.save(post);
    }
    @Override
    public Post getPostById(Long id){
        return postRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Post not found"));
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public List<PostResponse> getAllPosts() {
        return postRepository.findAllPostsWithAuthorAndCategory();
    }

    public String uploadImages( MultipartFile file ){
        try {
            String fileName = "";
            if (file.isEmpty()) {
                throw new IOException("File is empty");
            }
            if (file.getSize() > 10 * 1024 * 1024) {
                throw new IOException("File size should be less than 10MB");
            }
            String contentType = file.getContentType();
            if (contentType == null || !contentType.startsWith("image/")) {
                throw new IOException("Image must be a jpeg or png file");
            }
            return fileName = storeFile(file);

        }catch (Exception e) {
            return e.getMessage();
        }
    }
    private boolean isImageFile(MultipartFile file) {
        String contentType = file.getContentType();
        return contentType != null && contentType.startsWith("image/");
    }


    public String storeFile(MultipartFile file) throws IOException {
        if(!isImageFile(file)||(file.getOriginalFilename() == null)){
            throw new IOException("Invalid file type");
        }
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//        them UUID vao file name de dam bao ten file la duy nhat
        String uniqueFileName = UUID.randomUUID().toString() + "_" + fileName;
        // duong dan den thu muc ma ban muon luu file
        java.nio.file.Path upLoadDir = Paths.get("uploads");
        //kiem tra xem thu muc ma ban muon luu file da ton tai hay chua
        if(!Files.exists(upLoadDir)){
            Files.createDirectories(upLoadDir);
        }
        // duong dan den file
        java.nio.file.Path destination = Paths.get(upLoadDir.toString(), uniqueFileName);
//        sao chep file vao thu muc
        Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);
        return fileName;
    }


}
