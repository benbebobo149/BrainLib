// PostService.java
package com.example.demo.service;

import com.example.demo.dto.CommentListResult;
import com.example.demo.dto.CommentResult;
import com.example.demo.dto.JwtResult;
import com.example.demo.dto.NewPostResult;
import com.example.demo.dto.PostListResult;
import com.example.demo.dto.PostResult;
import com.example.demo.dto.SusPostResult;
import com.example.demo.dto.TagPostResult;
import com.example.demo.dto.TagRequest;
import com.example.demo.model.Appreciator;
import com.example.demo.model.Comment;
import com.example.demo.model.Post;
import com.example.demo.model.PostTag;
import com.example.demo.model.SusPost;
import com.example.demo.model.Tag;
import com.example.demo.model.User;
import com.example.demo.repository.AppreciatorRepository;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.PostTagRepository;
import com.example.demo.repository.SusPostRepository;
import com.example.demo.repository.TagRepository;
import com.example.demo.service.JwtService;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private AppreciatorRepository appreciatorRepository;

  @Autowired
  private PostTagRepository postTagRepository;

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

  public TagPostResult createPost(
    NewPostResult post,
    HttpServletRequest request
  ) {
    JwtResult jwtResult = jwtService.parseRequest(request);
    TagPostResult result = new TagPostResult();
    if (jwtResult == null) {
      result.setResultCode(1);
      return result;
    }

    if (!jwtResult.getPassed()) {
      result.setResultCode(1);
      return result;
    }
    Post newPost = new Post();
    User user = jwtResult.getUser();
    newPost.setUser(user);
    newPost.setTitle(post.getTitle());
    newPost.setContent(post.getContent());
    newPost.setImage(post.getImage());
    newPost.setThumbUp(0);
    newPost.setIsSuspend(false);
    Post savedPost = postRepository.save(newPost);
    post.setId(savedPost.getId());
    post.setUser(user.getId());
    post.setUsername(user.getName());

    result.setPost(post);
    result.setResultCode(0);

    List<TagRequest> tagr = post.getTags();

    if (tagr.size() == 0) {
      return result;
    }
    for (TagRequest tag : tagr) {
      PostTag postTag = new PostTag();
      postTag.setPost(savedPost);
      postTag.setTag(tagRepository.findById(tag.getId()).orElse(null));
      postTagRepository.save(postTag);
    }
    return result;
  }

  public List<NewPostResult> searchPosts(String keyword) {
    List<Post> posts = postRepository.findByTitleContaining(keyword);
    List<NewPostResult> newPosts = new ArrayList<>();

    for (Post post : posts) {
      NewPostResult newPost = new NewPostResult();
      newPost.setId(post.getId());
      newPost.setUser(post.getUser().getId());
      newPost.setUsername(post.getUser().getName());
      newPost.setThumbUp(post.getThumbUp());
      newPost.setComments(commentRepository.findByPost(post).size());
      newPost.setVisible(post.getVisible());
      newPost.setTitle(post.getTitle());
      newPost.setContent(post.getContent());
      newPost.setImage(post.getImage());

      List<TagRequest> tags = new ArrayList<>();
      List<PostTag> postTags = postTagRepository.findByPost(post);

      for (PostTag postTag : postTags) {
        TagRequest newTag = new TagRequest();
        newTag.setId(postTag.getTag().getId());
        newTag.setTagName(postTag.getTag().getTagName());
        tags.add(newTag);
      }

      newPost.setTags(tags);

      newPosts.add(newPost);
    }

    return newPosts;
  }

  public List<NewPostResult> getAllPosts() {
    List<Post> posts = postRepository.findAll();
    List<NewPostResult> newPosts = new ArrayList<>();

    for (Post post : posts) {
      NewPostResult newPost = new NewPostResult();
      newPost.setId(post.getId());
      newPost.setUser(post.getUser().getId());
      newPost.setUsername(post.getUser().getName());
      newPost.setThumbUp(post.getThumbUp());
      newPost.setComments(commentRepository.findByPost(post).size());
      newPost.setVisible(post.getVisible());
      newPost.setTitle(post.getTitle());
      newPost.setContent(post.getContent());
      newPost.setImage(post.getImage());

      List<TagRequest> tags = new ArrayList<>();
      List<PostTag> postTags = postTagRepository.findByPost(post);

      for (PostTag postTag : postTags) {
        TagRequest newTag = new TagRequest();
        newTag.setId(postTag.getTag().getId());
        newTag.setTagName(postTag.getTag().getTagName());
        tags.add(newTag);
      }

      newPost.setTags(tags);

      newPosts.add(newPost);
    }

    return newPosts;
  }

  public List<NewPostResult> getPostsByUserId(Integer id) {
    User user = userService.getUserById(id);
    List<Post> posts = postRepository.findByUser(user);

    List<NewPostResult> newPosts = new ArrayList<>();

    for (Post post : posts) {
      NewPostResult newPost = new NewPostResult();
      newPost.setId(post.getId());
      newPost.setUser(post.getUser().getId());
      newPost.setUsername(post.getUser().getName());
      newPost.setThumbUp(post.getThumbUp());
      newPost.setComments(commentRepository.findByPost(post).size());
      newPost.setVisible(post.getVisible());
      newPost.setTitle(post.getTitle());
      newPost.setContent(post.getContent());
      newPost.setImage(post.getImage());

      List<TagRequest> tags = new ArrayList<>();
      List<PostTag> postTags = postTagRepository.findByPost(post);

      for (PostTag postTag : postTags) {
        TagRequest newTag = new TagRequest();
        newTag.setId(postTag.getTag().getId());
        newTag.setTagName(postTag.getTag().getTagName());
        tags.add(newTag);
      }

      newPost.setTags(tags);

      newPosts.add(newPost);
    }
    return newPosts;
  }

  public PostResult approvePost(
    Integer id,
    boolean approve,
    HttpServletRequest request
  ) {
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
      List<PostTag> postTags = postTagRepository.findByPost(post);
      for (PostTag postTag : postTags) {
        postTagRepository.delete(postTag);
      }
      susPostRepository.delete(susPost);
      postRepository.delete(post);
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

  public TagPostResult updatePost(
    Integer id,
    NewPostResult postDetails,
    HttpServletRequest request
  ) {
    JwtResult jwtResult = jwtService.parseRequest(request);
    TagPostResult result = new TagPostResult();

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

    List<PostTag> originalPostTags = postTagRepository.findByPost(post);

        List<Tag> originalTags = new ArrayList<>();
        for (PostTag postTag : originalPostTags) {
            originalTags.add(postTag.getTag());
        }
        List<TagRequest> tagr = postDetails.getTags();
        List<Tag> tags = new ArrayList<>();
        for (TagRequest tag : tagr) {
            tags.add(tagRepository.findById(tag.getId()).orElse(null));
        }

    for (Tag tag : originalTags) {
      PostTag postTag = postTagRepository.findByPostAndTag(post, tag);
      postTagRepository.delete(postTag);
    }

    for (Tag tag : tags) {
      PostTag postTag = new PostTag();
      postTag.setPost(post);
      postTag.setTag(tag);
      postTagRepository.save(postTag);
    }

    if (
      post.getUser().getId() != jwtResult.getUser().getId() &&
      jwtResult.getUser().getPermission() == 0
    ) {
      result.setResultCode(1);
      return result;
    }

        post.setTitle(postDetails.getTitle());
        post.setContent(postDetails.getContent());
        post.setImage(postDetails.getImage());
        postRepository.save(post);

    postDetails.setId(post.getId());
    postDetails.setUser(post.getUser().getId());
    postDetails.setUsername(post.getUser().getName());
    postDetails.setThumbUp(post.getThumbUp());
    postDetails.setComments(commentRepository.findByPost(post).size());
    postDetails.setVisible(post.getVisible());

    result.setPost(postDetails);
    result.setResultCode(0);

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

        List<PostTag> postTags = postTagRepository.findByPost(post);
        for (PostTag postTag : postTags) {
            postTagRepository.delete(postTag);
        }

        List<Comment> comments = commentRepository.findByPost(post);
        for (Comment comment : comments) {
            commentRepository.delete(comment);
        }

    if (post == null) {
      result.setResultCode(2);
    } else if (
      user.getId() == post.getUser().getId() || user.getPermission() > 0
    ) {
      postRepository.delete(post);
      result.setResultCode(0);
    } else {
      result.setResultCode(1);
    }

    return result;
  }

  public TagPostResult likePost(Integer id, HttpServletRequest request) {
    JwtResult jwtResult = jwtService.parseRequest(request);

    TagPostResult result = new TagPostResult();

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

    List<Appreciator> appreciators = appreciatorRepository.findByPost(post);
    List<User> users = appreciators
      .stream()
      .map(Appreciator::getAppreciator)
      .toList();
    Appreciator appreciator = null;

    if (users.contains(user)) {
      post.setThumbUp(post.getThumbUp() - 1);
      Optional<Appreciator> OptionalAppreciator = appreciatorRepository.findByPostAndAppreciator(
        post,
        user
      );

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

    NewPostResult newPost = new NewPostResult();
    newPost.setId(post.getId());
    newPost.setUser(post.getUser().getId());
    newPost.setUsername(post.getUser().getName());
    newPost.setThumbUp(post.getThumbUp());
    newPost.setComments(commentRepository.findByPost(post).size());
    newPost.setVisible(post.getVisible());
    newPost.setTitle(post.getTitle());
    newPost.setContent(post.getContent());
    newPost.setImage(post.getImage());

    List<TagRequest> tags = new ArrayList<>();
    List<PostTag> postTags = postTagRepository.findByPost(post);

    for (PostTag postTag : postTags) {
      TagRequest newTag = new TagRequest();
      newTag.setId(postTag.getTag().getId());
      newTag.setTagName(postTag.getTag().getTagName());
      tags.add(newTag);
    }

    newPost.setTags(tags);

    result.setResultCode(0);
    result.setPost(newPost);

    return result;
  }

  public PostResult reportPost(
    Integer id,
    String reason,
    HttpServletRequest request
  ) {
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
    CommentListResult result = new CommentListResult();

    Post post = postRepository.findById(id).orElse(null);
    List<Comment> comments = commentRepository.findByPost(post);

    if (post == null || comments.size() == 0) {
      result.setResultCode(2);
      return result;
    } else {
      result.setResultCode(0);
      result.setComments(comments);
    }
    return result;
  }

  public CommentResult addComment(
    Integer id,
    Comment comment,
    HttpServletRequest request
  ) {
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
      User user = jwtResult.getUser();
      comment.setUser(user);
      comment.setPost(post);
      comment.setCreatedAt(new Date().toString());
      commentRepository.save(comment);

      result.setComment(comment);
      result.setResultCode(0);
    }
    return result;
  }

  public CommentResult updateComment(
    Integer id,
    Comment newComment,
    HttpServletRequest request
  ) {
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

  public List<NewPostResult> searchTagsPost(Integer id) {
    Tag tag = tagRepository.findById(id).orElse(null);

    if (tag == null) {
      return new ArrayList<>();
    }

    List<PostTag> postTags = postTagRepository.findByTag(tag);
    List<Post> posts = new ArrayList<>();

    for (PostTag postTag : postTags) {
      posts.add(postTag.getPost());
    }

    List<NewPostResult> tagPosts = new ArrayList<>();

    for (Post post : posts) {
      NewPostResult tagPost = new NewPostResult();
      tagPost.setId(post.getId());
      tagPost.setUser(post.getUser().getId());
      tagPost.setUsername(post.getUser().getName());
      tagPost.setThumbUp(post.getThumbUp());
      tagPost.setComments(commentRepository.findByPost(post).size());
      tagPost.setVisible(post.getVisible());
      tagPost.setTitle(post.getTitle());
      tagPost.setContent(post.getContent());
      tagPost.setImage(post.getImage());

      List<TagRequest> tags = new ArrayList<>();
      List<PostTag> postTags2 = postTagRepository.findByPost(post);

      for (PostTag postTag : postTags2) {
        TagRequest newTag = new TagRequest();
        newTag.setId(postTag.getTag().getId());
        newTag.setTagName(postTag.getTag().getTagName());
        tags.add(newTag);
      }

      tagPost.setTags(tags);

      tagPosts.add(tagPost);
    }

    return tagPosts;
  }

  public List<SusPostResult> getSuspendPosts(HttpServletRequest request) {
    JwtResult jwtResult = jwtService.parseRequest(request);

    if (jwtResult == null) {
      return new ArrayList<>();
    }

    if (!jwtResult.getPassed()) {
      return new ArrayList<>();
    }

    List<Post> posts = postRepository.findByIsSuspend(true);
    List<SusPostResult> newPosts = new ArrayList<>();

    for (Post post : posts) {
      SusPostResult newPost = new SusPostResult();
      newPost.setId(post.getId());
      newPost.setUser(post.getUser().getId());
      newPost.setUsername(post.getUser().getName());
      newPost.setThumbUp(post.getThumbUp());
      newPost.setComments(commentRepository.findByPost(post).size());
      newPost.setVisible(post.getVisible());
      newPost.setTitle(post.getTitle());
      newPost.setContent(post.getContent());
      newPost.setImage(post.getImage());

      List<TagRequest> tags = new ArrayList<>();
      List<PostTag> postTags = postTagRepository.findByPost(post);

      for (PostTag postTag : postTags) {
        TagRequest newTag = new TagRequest();
        newTag.setId(postTag.getTag().getId());
        newTag.setTagName(postTag.getTag().getTagName());
        tags.add(newTag);
      }

      newPost.setTags(tags);

      Optional<SusPost> OptionalSusPost = susPostRepository.findByPost(post);

      SusPost susPost = new SusPost();

      if (OptionalSusPost.isPresent()) {
        susPost = OptionalSusPost.get();
      }

      newPost.setReason(susPost.getReason());

      newPosts.add(newPost);
    }

    return newPosts;
  }

  public NewPostResult getPostById(Integer id) {
    NewPostResult result = new NewPostResult();
    Optional<Post> post = postRepository.findById(id);
    if (post.isPresent()) {
      result.setResultCode(0);
      result.setId(post.get().getId());
      result.setUser(post.get().getUser().getId());
      result.setUsername(post.get().getUser().getName());
      result.setThumbUp(post.get().getThumbUp());
      result.setComments(commentRepository.findByPost(post.get()).size());
      result.setVisible(post.get().getVisible());
      result.setTitle(post.get().getTitle());
      result.setContent(post.get().getContent());
      result.setImage(post.get().getImage());
      List<TagRequest> tags = new ArrayList<>();
      List<PostTag> postTags = postTagRepository.findByPost(post.get());
      for (PostTag postTag : postTags) {
        TagRequest newTag = new TagRequest();
        newTag.setId(postTag.getTag().getId());
        newTag.setTagName(postTag.getTag().getTagName());
        tags.add(newTag);
      }
      result.setTags(tags);
    } else {
      result.setResultCode(1);
    }
    return result;
  }
}
