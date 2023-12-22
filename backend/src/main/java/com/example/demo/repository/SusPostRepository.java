package com.example.demo.repository;

import com.example.demo.model.SusPost;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Post;

import java.util.List;

public interface SusPostRepository extends JpaRepository<SusPost, Integer> {
    SusPost findByPost(Post post);
}