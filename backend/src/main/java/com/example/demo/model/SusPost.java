// SusPostMapping.java
package com.example.demo.model;

import com.example.demo.model.Post;
import com.example.demo.model.User;

import jakarta.persistence.*;

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

    @Column(name = "is_reviewed", nullable = false)
    private Boolean is_reviewed;

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
        return is_reviewed;
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

    public void setIs_reviewed(Boolean is_reviewed) {
        this.is_reviewed = is_reviewed;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}