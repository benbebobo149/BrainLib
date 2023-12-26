// PostService.java
package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;

import com.example.demo.model.Post;
import com.example.demo.model.Comment;
import com.example.demo.model.Appreciator;
import com.example.demo.model.SusPost;
import com.example.demo.model.Tag;
import com.example.demo.model.User;
import com.example.demo.model.PostTag;

import com.example.demo.service.JwtService;
import com.example.demo.service.UserService;

import com.example.demo.dto.PostResult;
import com.example.demo.dto.PostListResult;
import com.example.demo.dto.JwtResult;
import com.example.demo.dto.CommentListResult;
import com.example.demo.dto.CommentResult;

import com.example.demo.repository.PostRepository;
import com.example.demo.repository.AppreciatorRepository;
import com.example.demo.repository.SusPostRepository;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.TagRepository;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private AppreciatorRepository appreciatorRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private SusPostRepository susPostRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;

    public PostResult createPost(Post post, HttpServletRequest request) {
        JwtResult jwtResult = jwtService.parseRequest(request);

        PostResult result = new PostResult();
        
        if (jwtResult == null) {
            result.setResultCode(1);
            return result;
        }
        
        if (!jwtResult.getPassed()) {
            result.setResultCode(1);
            return result;
        }

        post = postRepository.save(post);
        result.setPost(post);
        result.setResultCode(0);

        return result;
    }

    public List<Post> searchPosts(String keyword) {
        return postRepository.findByTitleContaining(keyword);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public List<Post> getPostsByUserId(Integer id) {
        User user = userService.getUserById(id);
        return postRepository.findByUser(user);
    }

    public PostResult approvePost(Integer id, boolean approve, HttpServletRequest request) {
        JwtResult jwtResult = jwtService.parseRequest(request);

        PostResult result = new PostResult();
        
        if (jwtResult == null) {
            result.setResultCode(1);
            return result;
        }
        
        if (!jwtResult.getPassed()) {
            result.setResultCode(1);
            return result;
        }
        
        Post post = null;
        SusPost susPost = null;
        Optional<Post> OptionalPost = postRepository.findById(id);
        
        if (OptionalPost.isPresent()) {
            post = OptionalPost.get();
        }

        if (post == null) {
            result.setResultCode(2);
            return result;
        }

        Optional<SusPost> OptionalSusPost = susPostRepository.findByPost(post);

        if (OptionalSusPost.isPresent()) {
            susPost = OptionalSusPost.get();
        }

        if (post != null && susPost != null && !approve) {
            postRepository.delete(post);
            susPostRepository.delete(susPost);
            result.setResultCode(0);
            return result;
        }

        if (post == null || susPost == null) {
            result.setResultCode(2);
            return result;
        } else {
            post.setIsSuspend(false);
            postRepository.save(post);
            susPostRepository.delete(susPost);
            
            result.setPost(post);
            result.setResultCode(0);
        }

        return result;
    }

    public PostResult updatePost(Integer id, Post postDetails, HttpServletRequest request) {

        JwtResult jwtResult = jwtService.parseRequest(request);

        PostResult result = new PostResult();
        
        if (jwtResult == null) {
            result.setResultCode(1);
            return result;
        }
        
        if (!jwtResult.getPassed()) {
            result.setResultCode(1);
            return result;
        }

        Post post = postRepository.findById(id).orElse(null);

        if (post != null) {
            if (post.getId() == postDetails.getId()) {
                post.setTitle(postDetails.getTitle());
                post.setContent(postDetails.getContent());
                post.setImage(postDetails.getImage());
                post.setVisible(postDetails.getVisible());
                post.setTags(postDetails.getTags());
                result.setPost(postRepository.save(post));
                result.setResultCode(0);
            } else {
                result.setResultCode(1);
            }
        } else {
            result.setResultCode(2);
        }

        return result;
    }

    public PostResult deletePost(Integer id, HttpServletRequest request) {

        JwtResult jwtResult = jwtService.parseRequest(request);

        PostResult result = new PostResult();
        
        if (jwtResult == null) {
            result.setResultCode(1);
            return result;
        }
        
        if (!jwtResult.getPassed()) {
            result.setResultCode(1);
            return result;
        }

        Post post = postRepository.findById(id).orElse(null);
        User user = jwtResult.getUser();

        if (post == null) {
            result.setResultCode(2);
        } else if (user.getId() == post.getUser().getId() || user.getPermission() > 0) {
            postRepository.delete(post);
            result.setResultCode(0);
        } else {
            result.setResultCode(1);
        }

        return result;
    }

    public PostResult likePost(Integer id, HttpServletRequest request) {
        JwtResult jwtResult = jwtService.parseRequest(request);

        PostResult result = new PostResult();
        
        if (jwtResult == null) {
            result.setResultCode(1);
            return result;
        }
        
        if (!jwtResult.getPassed()) {
            result.setResultCode(1);
            return result;
        }

        Post post = postRepository.findById(id).orElse(null);

        if (post == null) {
            result.setResultCode(2);
            return result;
        }

        User user = jwtResult.getUser();

        List<Appreciator> appreciators = post.getAppreciators();
        List<User> users = appreciators.stream().map(Appreciator::getAppreciator).toList();
        Appreciator appreciator = null;

        if (users.contains(user)) {
            post.setThumbUp(post.getThumbUp() - 1);
            Optional<Appreciator> OptionalAppreciator = appreciatorRepository.findByPostAndAppreciator(post, user);
            
            if (OptionalAppreciator.isPresent()) {
                appreciator = OptionalAppreciator.get();
            }

            if (appreciator == null) {
                result.setResultCode(2);
                return result;
            }

            appreciatorRepository.delete(appreciator);
        } else {
            post.setThumbUp(post.getThumbUp() + 1);
            Appreciator newAppreciator = new Appreciator();
            newAppreciator.setPost(post);
            newAppreciator.setAppreciator(user);
            appreciatorRepository.save(newAppreciator);
        }

        result.setResultCode(0);

        return result;
    }

    public PostResult reportPost(Integer id, String reason, HttpServletRequest request) {
        JwtResult jwtResult = jwtService.parseRequest(request);

        PostResult result = new PostResult();
        
        if (jwtResult == null) {
            result.setResultCode(1);
            return result;
        }
        
        if (!jwtResult.getPassed()) {
            result.setResultCode(1);
            return result;
        }

        Post post = postRepository.findById(id).orElse(null);

        SusPost susPost = new SusPost();

        if (post == null) {
            result.setResultCode(2);
            return result;
        } else {
            post.setIsSuspend(true);
            postRepository.save(post);

            susPost.setPost(post);
            susPost.setUser(jwtResult.getUser());
            susPost.setIsReviewed(false);
            susPost.setReason(reason);
            susPostRepository.save(susPost);

            result.setPost(post);
            result.setResultCode(0);
        }

        return result;
    }

    public CommentListResult getComments(Integer id, HttpServletRequest request) {
        JwtResult jwtResult = jwtService.parseRequest(request);

        CommentListResult result = new CommentListResult();
        
        if (jwtResult == null) {
            result.setResultCode(1);
            return result;
        }
        
        if (!jwtResult.getPassed()) {
            result.setResultCode(1);
            return result;
        }

        Post post = postRepository.findById(id).orElse(null);

        if (post == null) {
            result.setResultCode(2);
            return result;
        } else {
            result.setComments(post.getComments());
            result.setResultCode(0);
        }
        return result;
    }

    public CommentResult addComment(Integer id, Comment comment, HttpServletRequest request) {
        JwtResult jwtResult = jwtService.parseRequest(request);

        CommentResult result = new CommentResult();
        
        if (jwtResult == null) {
            result.setResultCode(1);
            return result;
        }
        
        if (!jwtResult.getPassed()) {
            result.setResultCode(1);
            return result;
        }

        Post post = postRepository.findById(id).orElse(null);

        if (post == null) {
            result.setResultCode(2);
            return result;
        } else {
            commentRepository.save(comment);

            result.setComment(comment);
            result.setResultCode(0);
        }
        return result;
    }

    public CommentResult updateComment(Integer id, Comment newComment, HttpServletRequest request) {
        JwtResult jwtResult = jwtService.parseRequest(request);

        CommentResult result = new CommentResult();
        
        if (jwtResult == null) {
            result.setResultCode(1);
            return result;
        }
        
        if (!jwtResult.getPassed()) {
            result.setResultCode(1);
            return result;
        }

        Comment oldComment = commentRepository.findById(id).orElse(null);

        if (oldComment == null) {
            result.setResultCode(2);
            return result;
        } else {
            oldComment.setContent(newComment.getContent());
            commentRepository.save(oldComment);

            result.setComment(oldComment);
            result.setResultCode(0);
        }

        return result;
    }

    public CommentResult deleteComment(Integer id, HttpServletRequest request) {
        JwtResult jwtResult = jwtService.parseRequest(request);

        CommentResult result = new CommentResult();
        
        if (jwtResult == null) {
            result.setResultCode(1);
            return result;
        }
        
        if (!jwtResult.getPassed()) {
            result.setResultCode(1);
            return result;
        }

        Comment comment = commentRepository.findById(id).orElse(null);

        if (comment == null) {
            result.setResultCode(2);
            return result;
        } else {
            commentRepository.delete(comment);

            result.setComment(comment);
            result.setResultCode(0);
        }

        return result;
    }

    public List<Post> searchTagsPost(Integer id) {
        Tag tag = tagRepository.findById(id).orElse(null);

        if (tag == null) {
            return new ArrayList<>();
        }

        List<PostTag> postTags = tag.getPosts();
        List<Post> posts = postTags.stream().map(PostTag::getPost).toList();

        return posts;
    }
}