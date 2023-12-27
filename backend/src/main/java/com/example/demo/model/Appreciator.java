// UserPostMapping.java
package com.example.demo.model;

import com.example.demo.model.Post;
import com.example.demo.model.User;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "Appreciators")
public class Appreciator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonBackReference(value = "post-appreciator")
    @ManyToOne
    @JoinColumn(name = "post", nullable = false, referencedColumnName = "id")
    private Post post;

    @JsonBackReference(value = "user-appreciator")
    @ManyToOne
    @JoinColumn(name = "appreciator", nullable = false, referencedColumnName = "id")
    private User appreciator;

    // getters and setters

    public Integer getId() {
        return id;
    }

    public Post getPost() {
        return post;
    }

    public User getAppreciator() {
        return appreciator;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public void setAppreciator(User appreciator) {
        this.appreciator = appreciator;
    }
}