// PostController.java
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import com.example.demo.model.Post;
import com.example.demo.model.Comment;
import com.example.demo.model.Tag;

import com.example.demo.service.PostService;

import com.example.demo.dto.PostResult;
import com.example.demo.dto.PostListResult;
import com.example.demo.dto.CommentListResult;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody Post post) {
        try {
            PostListResult result = postService.createPost(post);
    
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

    @GetMapping("/search")
    public ResponseEntity<?> searchPost(@RequestParam String keywords) {
        try {
            List<Post> allPosts = postService.searchPost(keywords);
    
            if (allPosts != null) {
                return ResponseEntity.ok(allPosts);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{post_id}")
    public ResponseEntity<?> updatePost(@PathVariable Integer post_id, @RequestBody Post post) {
        try {
            PostResult result = postService.updatePost(post_id, post);
    
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

    @DeleteMapping("/{post_id}")
    public ResponseEntity<?> deletePost(@PathVariable Integer post_id) {
        try {
            PostResult result = postService.deletePost(post_id);
    
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

    @PutMapping("/{post_id}/like")
    public ResponseEntity<?> likePost(@PathVariable Integer post_id) {
        try {
            PostResult result = postService.likePost(post_id);
    
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

    @PutMapping("/{post_id}/report")
    public ResponseEntity<?> reportPost(@PathVariable Integer id, @RequestBody String reason) {
        try {
            PostResult result = postService.reportPost(id, reason);
    
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

    @GetMapping("/{post_id}/comments")
    public ResponseEntity<?> getComments(@PathVariable Integer post_id) {
        try {
            CommentListResult result = postService.getComments(post_id);
    
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

    @PostMapping("/{post_id}/comments")
    public ResponseEntity<?> addComment(@PathVariable Integer post_id, @RequestBody Comment comment) {
        try {
            CommentResult result = postService.addComment(post_id, comment);
    
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

    @PutMapping("/comments/{comment_id}")
    public ResponseEntity<?> updateComment(@PathVariable Integer comment_id, @RequestBody Comment newComment) {
        try {
            CommentResult result = postService.updateComment(id, newComment);
    
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

    @DeleteMapping("/comments/{comment_id}")
    public ResponseEntity<?> deleteComment(@PathVariable Integer comment_id) {
        try {
            CommentResult result = postService.deleteComment(comment_id);
    
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

    @GetMapping("/all/{tag_id}")
    public ResponseEntity<?> searchTagsPost(@PathVariable Integer tag_id) {
        try {
            PostListResult tagPosts = postService.searchTagsPost(id);
    
            if (tagPosts != null) {
                return ResponseEntity.ok(tagPosts);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/all")
    public ResponseEntity<?> getAllPosts() {
        try {
            PostListResult Posts = postService.getAllPosts();
    
            if (Posts != null) {
                return ResponseEntity.ok(Posts);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/my/all")
    public ResponseEntity<Post> getMyAllPosts() {
        try {
            PostListResult Posts = postService.getMyAllPosts();
    
            if (Posts != null) {
                return ResponseEntity.ok(Posts);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/posts/{post_od/approve}")
    public ResponseEntity<?> approvePost(@PathVariable Integer post_id, @RequestBody boolean approve) {
        try {
            PostResult result = postService.approvePost(post_id, approve);
    
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
}