package com.example.demo.repository;

import com.example.demo.model.SusPost;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Post;
import com.example.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface SusPostRepository extends JpaRepository<SusPost, Integer> {
    Optional<SusPost> findByPost(Post post);
    List<SusPost> findBySuspender(User suspender);
}