package com.royce.blood_donation.repositories;

import com.royce.blood_donation.models.blog.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostRepository extends JpaRepository<Post, Long> {

}
