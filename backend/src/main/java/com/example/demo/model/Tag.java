// Tag.java
package com.example.demo.model;

import com.example.demo.model.TrendTag;
import com.example.demo.model.Post;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tagName", nullable = false)
    private String tagName;

    @Column(name = "tagAbbr", nullable = false)
    private String tagAbbr;

    @OneToOne(mappedBy = "tag", cascade = CascadeType.ALL)
    private TrendTag trendTag;

    @OneToMany(mappedBy = "tag", cascade = CascadeType.ALL)
    private List<PostTag> posts;

    // getters and setters

    public Integer getTag_id() {
        return id;
    }

    public String getTagName() {
        return tagName;
    }

    public String getTagAbbr() {
        return tagAbbr;
    }

    public List<PostTag> getPosts() {
        return posts;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public void setTagAbbr(String tagAbbr) {
        this.tagAbbr = tagAbbr;
    }
}