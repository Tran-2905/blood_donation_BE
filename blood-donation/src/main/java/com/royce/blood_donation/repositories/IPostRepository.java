package com.royce.blood_donation.repositories;

import com.royce.blood_donation.models.blog.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IPostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findPostByAuthor_Id(Long authorId);
    Optional<Post> findPostById(Long id);
    List<Post> findAllByOrderByIdDesc();

}
