// PostService.java
package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import com.example.demo.model.ResourceNotFoundException;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Post getPost(Integer id) {
        return postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
    }

    public Post updatePost(Integer id, Post postDetails) {
        Post post = getPost(id);
        post.setTitle(postDetails.getTitle());
        post.setContent(postDetails.getContent());
        return postRepository.save(post);
    }

    public void deletePost(Integer id) {
        Post post = getPost(id);
        postRepository.delete(post);
    }

    public Post likePost(Integer id) {
        Post post = getPost(id);
        post.setThumbUp(post.getThumbUp() + 1);
        return postRepository.save(post);
    }

    public Post reportPost(Integer id, Integer reporterId) {
        Post post = getPost(id);
        post.setIsSuspend(true);
        post.setSuspenderId(reporterId);
        return postRepository.save(post);
    }

    public List<Comment> getComments(Integer id) {
        Post post = getPost(id);
        return post.getComments();
    }

    public Post addComment(Integer id, Comment comment) {
        Post post = getPost(id);
        post.getComments().add(comment);
        return postRepository.save(post);
    }

    public Post updateComment(Integer id, Comment oldComment, Comment newComment) {
        Post post = getPost(id);
        post.getComments().remove(oldComment);
        post.getComments().add(newComment);
        return postRepository.save(post);
    }

    public Post deleteComment(Integer id, Comment comment) {
        Post post = getPost(id);
        post.getComments().remove(comment);
        return postRepository.save(post);
    }

    public List<Tag> getTags(Integer id) {
        Post post = getPost(id);
        return post.getTags();
    }

    public Post addTagsToPost(Integer id, List<Tag> tags) {
        Post post = getPost(id);
        post.getTags().addAll(tags);
        return postRepository.save(post);
    }

    public Post removeTagsFromPost(Integer id, List<Tag> tags) {
        Post post = getPost(id);
        post.getTags().removeAll(tags);
        return postRepository.save(post);
    }
}