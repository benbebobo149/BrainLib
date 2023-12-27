// PostController.java
package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import jakarta.servlet.http.HttpServletRequest;

import com.example.demo.model.Post;
import com.example.demo.model.Comment;
import com.example.demo.model.Tag;

import com.example.demo.service.PostService;
import com.example.demo.service.JwtService;

import com.example.demo.dto.PostResult;
import com.example.demo.dto.CommentListResult;
import com.example.demo.dto.CommentResult;
import com.example.demo.dto.ApproveResult;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private JwtService jwtService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody Post post, HttpServletRequest request) {
        try {
            PostResult result = postService.createPost(post, request);
    
            switch (result.getResultCode()) {
                case 0: // 成功
                    return ResponseEntity.ok(result.getPost());
                case 1: // 沒有權限
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
                default: // 其他錯誤
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } catch (Exception e) {
            // 處理其他可能的錯誤
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/search")
    public ResponseEntity<?> searchPosts(@RequestParam String keyword) {
        try {
            List<Post> allPosts = postService.searchPosts(keyword);
    
            if (allPosts.size() > 0) {
                return ResponseEntity.ok(allPosts);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/{post_id}")
    public ResponseEntity<?> updatePost(@PathVariable Integer post_id, @RequestBody Post post, HttpServletRequest request) {
        try {
            // get tag from request body
            List<Tag> tags = post.getTags();
            PostResult result = postService.updatePost(post_id, post, request);
    
            switch (result.getResultCode()) {
                case 0: // 成功
                    return ResponseEntity.ok(result.getPost());
                case 1: // 沒有權限
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
                case 2: // 找不到
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                default: // 其他錯誤
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } catch (Exception e) {
            // 處理其他可能的錯誤
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/{post_id}")
    public ResponseEntity<?> deletePost(@PathVariable Integer post_id, HttpServletRequest request) {
        try {
            PostResult result = postService.deletePost(post_id, request);
    
            switch (result.getResultCode()) {
                case 0: // 成功
                    return ResponseEntity.ok().build();
                case 1: // 沒有權限
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
                case 2: // 找不到
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                default: // 其他錯誤
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } catch (Exception e) {
            // 處理其他可能的錯誤
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/{post_id}/like")
    public ResponseEntity<?> likePost(@PathVariable Integer post_id, HttpServletRequest request) {
        try {
            PostResult result = postService.likePost(post_id, request);
    
            switch (result.getResultCode()) {
                case 0: // 成功
                    return ResponseEntity.ok(result.getPost());
                case 1: // 沒有權限
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
                case 2: // 找不到
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                default: // 其他錯誤
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } catch (Exception e) {
            // 處理其他可能的錯誤
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/{post_id}/report")
    public ResponseEntity<?> reportPost(@PathVariable Integer post_id, @RequestBody String reason, HttpServletRequest request) {
        try {
            PostResult result = postService.reportPost(post_id, reason, request);
    
            switch (result.getResultCode()) {
                case 0: // 成功
                    return ResponseEntity.ok().build();
                case 1: // 沒有權限
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
                case 2: // 找不到
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                default: // 其他錯誤
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } catch (Exception e) {
            // 處理其他可能的錯誤
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{post_id}/comments")
    public ResponseEntity<?> getComments(@PathVariable Integer post_id, HttpServletRequest request) {
        try {
            CommentListResult result = postService.getComments(post_id, request);
    
            switch (result.getResultCode()) {
                case 0: // 成功
                    return ResponseEntity.ok(result.getComments());
                case 1: // 沒有權限
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
                case 2: // 找不到
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                default: // 其他錯誤
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } catch (Exception e) {
            // 處理其他可能的錯誤
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/{post_id}/comments")
    public ResponseEntity<?> addComment(@PathVariable Integer post_id, @RequestBody Comment comment, HttpServletRequest request) {
        try {
            CommentResult result = postService.addComment(post_id, comment, request);
    
            switch (result.getResultCode()) {
                case 0: // 成功
                    return ResponseEntity.ok().build();
                case 1: // 沒有權限
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
                case 2: // 找不到
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                default: // 其他錯誤
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } catch (Exception e) {
            // 處理其他可能的錯誤
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/comments/{comment_id}")
    public ResponseEntity<?> updateComment(@PathVariable Integer comment_id, @RequestBody Comment newComment, HttpServletRequest request) {
        try {
            CommentResult result = postService.updateComment(comment_id, newComment, request);
    
            switch (result.getResultCode()) {
                case 0: // 成功
                    return ResponseEntity.ok(result.getComment());
                case 1: // 沒有權限
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
                case 2: // 找不到
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                default: // 其他錯誤
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } catch (Exception e) {
            // 處理其他可能的錯誤
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/comments/{comment_id}")
    public ResponseEntity<?> deleteComment(@PathVariable Integer comment_id, HttpServletRequest request) {
        try {
            CommentResult result = postService.deleteComment(comment_id, request);
    
            switch (result.getResultCode()) {
                case 0: // 成功
                    return ResponseEntity.ok().build();
                case 1: // 沒有權限
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
                case 2: // 找不到
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                default: // 其他錯誤
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } catch (Exception e) {
            // 處理其他可能的錯誤
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/all/{tag_id}")
    public ResponseEntity<?> searchTagsPost(@PathVariable Integer tag_id) {
        try {
            List<Post> tagPosts = postService.searchTagsPost(tag_id);
    
            if (tagPosts.size() > 0) {
                return ResponseEntity.ok(tagPosts);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/all")
    public ResponseEntity<?> getAllPosts() {
        try {
            List<Post> posts = postService.getAllPosts();
    
            if (posts.size() > 0) {
                return ResponseEntity.ok(posts);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/my/all")
    public ResponseEntity<List<Post>> getPostsByUser(HttpServletRequest request) {
        try {
            String token = request.getHeader("Authorization").substring(7);
            Integer userId = jwtService.extractUserId(token);

            List<Post> posts = postService.getPostsByUserId(userId);
    
            if (posts.size() > 0) {
                return ResponseEntity.ok(posts);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/{post_id}/approve")
    public ResponseEntity<?> approvePost(@PathVariable Integer post_id, @RequestBody ApproveResult approveResult, HttpServletRequest request) {
        try {
            boolean approve = approveResult.isApprove();
            PostResult result = postService.approvePost(post_id, approve, request);
    
            switch (result.getResultCode()) {
                case 0: // 成功
                    return ResponseEntity.ok().build();
                case 1: // 沒有權限
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
                case 2: // 找不到
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                default: // 其他錯誤
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } catch (Exception e) { 
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/suspend")
    public ResponseEntity<?> getSuspendPosts(HttpServletRequest request) {
        try {
            List<Post> posts = postService.getSuspendPosts(request);
    
            if (posts.size() > 0) {
                return ResponseEntity.ok(posts);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}