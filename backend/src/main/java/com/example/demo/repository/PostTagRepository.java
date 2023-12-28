package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Post;
import com.example.demo.model.PostTag;
import com.example.demo.model.Tag;

import java.util.List;

public interface PostTagRepository extends JpaRepository<PostTag, Integer> {
    PostTag findByPostAndTag(Post post, Tag tag);
    List<PostTag> findByTag(Tag tag);
    List<PostTag> findByPost(Post post);
}