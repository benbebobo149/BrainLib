// Comment.java
package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "post_id", nullable = false)
    private Integer post_id;

    @Column(name = "user_id", nullable = false)
    private Integer user_id;

    @Column(name = "content", columnDefinition = "json", nullable = false)
    private String content;

    // getters and setters

    public Integer getId() {
        return id;
    }

    public Integer getPost_id() {
        return post_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public String getContent() {
        return content;
    }

    public void setPost_id(Integer post_id) {
        this.post_id = post_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public void setContent(String content) {
        this.content = content;
    }
}