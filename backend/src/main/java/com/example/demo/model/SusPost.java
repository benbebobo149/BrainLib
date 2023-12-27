// SusPostMapping.java
package com.example.demo.model;

import com.example.demo.model.Post;
import com.example.demo.model.User;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "SusPosts")
public class SusPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "post", nullable = false)
    private Post post;
    
    @ManyToOne
    @JoinColumn(name = "suspender", nullable = false)
    private User suspender;

    @Column(name = "isReviewed", nullable = false)
    private Boolean isReviewed;

    @Column(name = "reason", nullable = false)
    private String reason;

    // getters and setters

    public Integer getId() {
        return id;
    }

    public Post getPost() {
        return post;
    }

    public User getUser() {
        return suspender;
    }

    public Boolean getIs_reviewed() {
        return isReviewed;
    }

    public String getReason() {
        return reason;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public void setUser(User suspender) {
        this.suspender = suspender;
    }

    public void setIsReviewed(Boolean isReviewed) {
        this.isReviewed = isReviewed;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}