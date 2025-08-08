package com.royce.blood_donation.repositories;

import com.royce.blood_donation.dtos.PostDTO;
import com.royce.blood_donation.models.blog.Post;
import com.royce.blood_donation.responses.PostResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IPostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findPostByAuthor_Id(Long authorId);
    Optional<Post> findPostById(Long id);
    List<Post> findAllByOrderByIdDesc();
    @Query("SELECT new com.royce.blood_donation.responses.PostResponse(" +
            "p.id, p.title, a.firstName, p.approvedAt, p.imageUrl, p.summary) " +
            "FROM Post p JOIN p.author a")
    List<PostResponse> findAllPostsWithAuthorAndCategory();

}
