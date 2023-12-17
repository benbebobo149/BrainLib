// SusPostMapping.java
package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "SusPostsMappings")
public class SusPostMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "post_id", nullable = false)
    private Integer post_id;

    @Column(name = "user_id", nullable = false)
    private Integer user_id;

    @Column(name = "is_reviewed", nullable = false)
    private Boolean is_reviewed;

    @Column(name = "reason", nullable = false)
    private String reason;

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

    public Boolean getIs_reviewed() {
        return is_reviewed;
    }

    public String getReason() {
        return reason;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPost_id(Integer post_id) {
        this.post_id = post_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public void setIs_reviewed(Boolean is_reviewed) {
        this.is_reviewed = is_reviewed;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}