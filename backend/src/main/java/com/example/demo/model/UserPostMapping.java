// UserPostMapping.java
package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "UserPostMappings")
public class UserPostMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "post_id", nullable = false)
    private Integer post_id;

    @Column(name = "user_id", nullable = false)
    private String user_id;

    // getters and setters

    public Integer getId() {
        return id;
    }

    public Integer getPost_id() {
        return post_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPost_id(Integer post_id) {
        this.post_id = post_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}