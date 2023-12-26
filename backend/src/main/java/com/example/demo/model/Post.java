// Post.java
package com.example.demo.model;

import com.example.demo.model.User;
import com.example.demo.model.Comment;
import com.example.demo.model.Tag;
import com.example.demo.model.SusPost;
import com.example.demo.model.Appreciator;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "users", nullable = false, referencedColumnName = "id")
    private User user;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "image", columnDefinition = "VARCHAR(255) DEFAULT 'default_post_image.jpg'")
    private String image;

    @Column(name = "thumb_up", columnDefinition = "int default 0")
    private Integer thumbUp;

    @Column(name = "visible", columnDefinition = "boolean default false")
    private Boolean visible;

    @Column(name = "is_suspend", columnDefinition = "boolean default false")
    private Boolean isSuspend;

    @OneToMany(mappedBy = "post")
    private List<PostTag> tags;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    @OneToMany(mappedBy = "post")
    private List<SusPost> suspendInfo;

    @OneToMany(mappedBy = "post")
    private List<Appreciator> appreciators;


    public Post() {
        this.thumbUp = 0;
        this.visible = false;
        this.isSuspend = false;
    }

    // getters and setters
    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getImage() {
        return image;
    }

    public Integer getThumbUp() {
        return thumbUp;
    }

    public Boolean getVisible() {
        return visible;
    }

    public Boolean getIsSuspend() {
        return isSuspend;
    }

    public List<PostTag> getTags() {
        return tags;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<SusPost> getSuspendInfo() {
        return suspendInfo;
    }

    public List<Appreciator> getAppreciators() {
        return appreciators;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setTags(List<PostTag> tags) {
        this.tags = tags;
    }

    public void setThumbUp(Integer thumbUp) {
        this.thumbUp = thumbUp;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    } 

    public void setIsSuspend(Boolean isSuspend) {
        this.isSuspend = isSuspend;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setSuspendInfo(List<SusPost> suspendInfo) {
        this.suspendInfo = suspendInfo;
    }

    public void setAppreciators(List<Appreciator> appreciators) {
        this.appreciators = appreciators;
    }
}