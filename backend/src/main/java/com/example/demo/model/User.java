// com.example.demo.model.User.java
package com.example.demo.model;

import com.example.demo.model.Activity;
import com.example.demo.model.Comment;
// import com.example.demo.model.Chat;
import com.example.demo.model.Post;
import com.example.demo.model.Attender;
import com.example.demo.model.Appreciator;
import com.example.demo.model.SusPost;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
@Table(name = "Users")
public class User {
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

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Activity> activities;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    @OneToMany(mappedBy = "user")
    private List<Attender> joinActivity;

    @OneToMany(mappedBy = "appreciator")
    private List<Appreciator> appreciatedPosts;

    @OneToMany(mappedBy = "suspender")
    private List<SusPost> suspendedPosts;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

    // @OneToMany(mappedBy = "sender")
    // private List<Chat> sentChat;

    // @OneToMany(mappedBy = "receiver")
    // private List<Chat> receivedChat;


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

    public List<Activity> getActivities() {
        return activities;
    }

    public List<Attender> getJoinActivity() {
        return joinActivity;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public List<SusPost> getSusPost() {
        return suspendedPosts;
    }

    public List<Comment> getComments() {
        return comments;
    }

    // public List<Chat> getSentChat() {
    //     return sentChat;
    // }

    // public List<Chat> getReceivedChat() {
    //     return receivedChat;
    // }

    // public Set<Chat> getConversation() {
    //     Set<Chat> conversation = Stream.concat(sentChat.stream(), receivedChat.stream())
    //                                    .distinct()
    //                                    .collect(Collectors.toSet());
    //     return conversation;
    // }

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