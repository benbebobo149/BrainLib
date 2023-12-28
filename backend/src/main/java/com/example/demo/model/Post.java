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
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JsonIdentityReference(alwaysAsId = true)
    @JoinColumn(name = "users", nullable = false, referencedColumnName = "id")
    private User user;

    @Column(name = "title", nullable = false)
    private String title;
    
    
    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(name = "image", columnDefinition = "VARCHAR(255) DEFAULT 'default_post_image.jpg'")
    private String image;

    @Column(name = "thumb_up", columnDefinition = "int default 0")
    private Integer thumbUp;

    @Column(name = "visible", columnDefinition = "boolean default false")
    private Boolean visible;

    @Column(name = "is_suspend", columnDefinition = "boolean default false")
    private Boolean isSuspend;

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

    public void setThumbUp(Integer thumbUp) {
        this.thumbUp = thumbUp;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    } 

    public void setIsSuspend(Boolean isSuspend) {
        this.isSuspend = isSuspend;
    }
}