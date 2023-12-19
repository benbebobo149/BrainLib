// PostTagMapping.java
package com.example.demo.model;

import com.example.demo.model.Post;
import com.example.demo.model.Tag;

import jakarta.persistence.*;

@Entity
@Table(name = "PostTagLinks")
public class PostTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "post", nullable = false)
    private Post post;

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