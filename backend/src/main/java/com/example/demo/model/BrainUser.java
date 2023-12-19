// com.example.demo.model.User.java
package com.example.demo.model;

import com.example.demo.model.Activity;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Users")
public class BrainUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "permission", nullable = false)
    private Integer permission;

    @Column(name = "profile", nullable = true)
    private String profile;

    @Column(name = "image", columnDefinition = "VARCHAR(255) DEFAULT 'default_image.jpg'")
    private String image;

    @OneToMany(mappedBy = "brainUser")
    private List<Activity> activities;

    // getters
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getPermission() {
        return permission;
    }

    public String getProfile() {
        return profile;
    }

    public String getImage() {
        return image;
    }

    // setters

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public void setImage(String image) {
        this.image = image;
    }
}