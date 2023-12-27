// PostTagMapping.java
package com.example.demo.model;

import com.example.demo.model.Post;
import com.example.demo.model.Tag;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "PostTagLinks")
public class PostTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonBackReference(value = "post-posttag")
    @ManyToOne
    @JoinColumn(name = "post", nullable = false)
    private Post post;

    @JsonBackReference(value = "tag-posttag")
    @ManyToOne
    @JoinColumn(name = "tag", nullable = false)
    private Tag tag;

    // getters and setters

    public Integer getId() {
        return id;
    }

    public Post getPost() {
        return post;
    }

    public Tag getTag() {
        return tag;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public void setTag(Tag tag) {
        this.tag = tag;   
    }
}