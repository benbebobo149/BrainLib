// PostController.java
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Post;
import com.example.demo.model.Comment;
import com.example.demo.model.Tag;
import com.example.demo.service.PostService;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        return ResponseEntity.ok(postService.createPost(post));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable Integer id) {
        return ResponseEntity.ok(postService.getPost(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Integer id, @RequestBody Post post) {
        return ResponseEntity.ok(postService.updatePost(id, post));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Integer id) {
        postService.deletePost(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/like")
    public ResponseEntity<Post> likePost(@PathVariable Integer id) {
        return ResponseEntity.ok(postService.likePost(id));
    }

    @PostMapping("/{id}/report/{reporterId}")
    public ResponseEntity<Post> reportPost(@PathVariable Integer id, @PathVariable Integer reporterId) {
        return ResponseEntity.ok(postService.reportPost(id, reporterId));
    }

    @GetMapping("/{id}/comments")
    public ResponseEntity<List<Comment>> getComments(@PathVariable Integer id) {
        return ResponseEntity.ok(postService.getComments(id));
    }

    @PostMapping("/{id}/comments")
    public ResponseEntity<Post> addComment(@PathVariable Integer id, @RequestBody Comment comment) {
        return ResponseEntity.ok(postService.addComment(id, comment));
    }

    @PutMapping("/{id}/comments")
    public ResponseEntity<Post> updateComment(@PathVariable Integer id, @RequestBody Comment oldComment, @RequestBody Comment newComment) {
        return ResponseEntity.ok(postService.updateComment(id, oldComment, newComment));
    }

    @DeleteMapping("/{id}/comments")
    public ResponseEntity<Post> deleteComment(@PathVariable Integer id, @RequestBody Comment comment) {
        return ResponseEntity.ok(postService.deleteComment(id, comment));
    }

    @GetMapping("/{id}/tags")
    public ResponseEntity<List<Tag>> getTags(@PathVariable Integer id) {
        return ResponseEntity.ok(postService.getTags(id));
    }

    @PostMapping("/{id}/tags")
    public ResponseEntity<Post> addTagsToPost(@PathVariable Integer id, @RequestBody List<Tag> tags) {
        return ResponseEntity.ok(postService.addTagsToPost(id, tags));
    }

    @DeleteMapping("/{id}/tags")
    public ResponseEntity<Post> removeTagsFromPost(@PathVariable Integer id, @RequestBody List<Tag> tags) {
        return ResponseEntity.ok(postService.removeTagsFromPost(id, tags));
    }
}