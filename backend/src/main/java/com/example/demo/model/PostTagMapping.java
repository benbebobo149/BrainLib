// PostTagMapping.java
package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "PostTagLinks")
public class PostTagMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "post_id", nullable = false)
    private Integer post_id;

    @Column(name = "topic_id", nullable = false)
    private String topic_id;

    // getters and setters

    public Integer getId() {
        return id;
    }

    public Integer getPost_id() {
        return post_id;
    }

    public String getTopic_id() {
        return topic_id;
    }

    public void setPost_id(Integer post_id) {
        this.post_id = post_id;
    }

    public void setTopic_id(String topic_id) {
        this.topic_id = topic_id;   
    }
}