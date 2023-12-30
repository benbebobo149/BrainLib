// PostController.java
package com.example.demo.controller;

import com.example.demo.dto.ApproveResult;
import com.example.demo.dto.CommentListResult;
import com.example.demo.dto.CommentResult;
import com.example.demo.dto.NewPostResult;
import com.example.demo.dto.PostResult;
import com.example.demo.dto.ReasonRequest;
import com.example.demo.dto.SusPostResult;
import com.example.demo.dto.TagPostResult;
import com.example.demo.model.Comment;
import com.example.demo.model.Post;
import com.example.demo.model.Tag;
import com.example.demo.service.JwtService;
import com.example.demo.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/post")
public class PostController {

  @Autowired
  private PostService postService;

  @Autowired
  private JwtService jwtService;

  @PostMapping
  public ResponseEntity<?> createPost(
    @RequestBody NewPostResult post,
    HttpServletRequest request
  ) {
    try {
      TagPostResult result = postService.createPost(post, request);

      switch (result.getResultCode()) {
        case 0: // 成功
          return ResponseEntity.ok(result.getPost());
        case 1: // 沒有權限
          return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        default: // 其他錯誤
          return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .build();
      }
    } catch (Exception e) {
      // 處理其他可能的錯誤
      System.out.println(e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @GetMapping("/search")
  public ResponseEntity<?> searchPosts(@RequestParam String keyword) {
    try {
      List<NewPostResult> allPosts = postService.searchPosts(keyword);

      if (allPosts.size() > 0) {
        return ResponseEntity.ok(allPosts);
      } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
      }
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @PutMapping("/{post_id}")
  public ResponseEntity<?> updatePost(
    @PathVariable Integer post_id,
    @RequestBody NewPostResult post,
    HttpServletRequest request
  ) {
    try {
      TagPostResult result = postService.updatePost(post_id, post, request);

      switch (result.getResultCode()) {
        case 0: // 成功
          return ResponseEntity.ok(result.getPost());
        case 1: // 沒有權限
          return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        case 2: // 找不到
          return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        default: // 其他錯誤
          return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .build();
      }
    } catch (Exception e) {
      // 處理其他可能的錯誤
      return ResponseEntity.ok(e);
    }
  }

  @DeleteMapping("/{post_id}")
  public ResponseEntity<?> deletePost(
    @PathVariable Integer post_id,
    HttpServletRequest request
  ) {
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
          return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .build();
      }
    } catch (Exception e) {
      // 處理其他可能的錯誤
      return ResponseEntity.ok(e);
    }
  }

  @PutMapping("/{post_id}/like")
  public ResponseEntity<?> likePost(
    @PathVariable Integer post_id,
    HttpServletRequest request
  ) {
    try {
      TagPostResult result = postService.likePost(post_id, request);

      switch (result.getResultCode()) {
        case 0: // 成功
          return ResponseEntity.ok(result.getPost());
        case 1: // 沒有權限
          return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        case 2: // 找不到
          return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        default: // 其他錯誤
          return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .build();
      }
    } catch (Exception e) {
      // 處理其他可能的錯誤
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @PutMapping("/{post_id}/report")
  public ResponseEntity<?> reportPost(
    @PathVariable Integer post_id,
    @RequestBody ReasonRequest reason,
    HttpServletRequest request
  ) {
    try {
      String reasonStr = reason.getReason();
      PostResult result = postService.reportPost(post_id, reasonStr, request);

      switch (result.getResultCode()) {
        case 0: // 成功
          return ResponseEntity.ok().build();
        case 1: // 沒有權限
          return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        case 2: // 找不到
          return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        default: // 其他錯誤
          return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .build();
      }
    } catch (Exception e) {
      // 處理其他可能的錯誤
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @GetMapping("/{post_id}/comments")
  public ResponseEntity<?> getComments(
    @PathVariable Integer post_id,
    HttpServletRequest request
  ) {
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
          return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .build();
      }
    } catch (Exception e) {
      // 處理其他可能的錯誤
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @PostMapping("/{post_id}/comments")
  public ResponseEntity<?> addComment(
    @PathVariable Integer post_id,
    @RequestBody Comment comment,
    HttpServletRequest request
  ) {
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
          return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .build();
      }
    } catch (Exception e) {
      // 處理其他可能的錯誤
      return ResponseEntity.ok(e);
    }
  }

  @PutMapping("/comments/{comment_id}")
  public ResponseEntity<?> updateComment(
    @PathVariable Integer comment_id,
    @RequestBody Comment newComment,
    HttpServletRequest request
  ) {
    try {
      CommentResult result = postService.updateComment(
        comment_id,
        newComment,
        request
      );

      switch (result.getResultCode()) {
        case 0: // 成功
          return ResponseEntity.ok(result.getComment());
        case 1: // 沒有權限
          return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        case 2: // 找不到
          return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        default: // 其他錯誤
          return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .build();
      }
    } catch (Exception e) {
      // 處理其他可能的錯誤
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @DeleteMapping("/comments/{comment_id}")
  public ResponseEntity<?> deleteComment(
    @PathVariable Integer comment_id,
    HttpServletRequest request
  ) {
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
          return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .build();
      }
    } catch (Exception e) {
      // 處理其他可能的錯誤
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @GetMapping("/all/{tag_id}")
  public ResponseEntity<?> searchTagsPost(@PathVariable Integer tag_id) {
    try {
      List<NewPostResult> tagPosts = postService.searchTagsPost(tag_id);

      if (tagPosts.size() > 0) {
        return ResponseEntity.ok(tagPosts);
      } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
      }
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @GetMapping("/all")
  public ResponseEntity<?> getAllPosts() {
    try {
      List<NewPostResult> posts = postService.getAllPosts();

      if (posts.size() > 0) {
        return ResponseEntity.ok(posts);
      } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
      }
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @GetMapping("/my/all")
  public ResponseEntity<?> getPostsByUser(HttpServletRequest request) {
    try {
      String token = request.getHeader("Authorization").substring(7);
      Integer userId = jwtService.extractUserId(token);

      List<NewPostResult> posts = postService.getPostsByUserId(userId);

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

  @PostMapping("/{post_id}/approve")
  public ResponseEntity<?> approvePost(
    @PathVariable Integer post_id,
    @RequestBody ApproveResult approveResult,
    HttpServletRequest request
  ) {
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
          return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .build();
      }
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @GetMapping("/suspend")
  public ResponseEntity<?> getSuspendPosts(HttpServletRequest request) {
    try {
      List<SusPostResult> posts = postService.getSuspendPosts(request);

      if (posts.size() > 0) {
        return ResponseEntity.ok(posts);
      } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
      }
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @GetMapping("/{post_id}")
  public ResponseEntity<?> getPostById(@PathVariable Integer post_id) {
    try {
      NewPostResult result = postService.getPostById(post_id);

      switch (result.getResultCode()) {
        case 0: // 成功
          return ResponseEntity.ok(result);
        case 1: // 找不到
          return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        default: // 其他錯誤
          return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .build();
      }
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }
}
