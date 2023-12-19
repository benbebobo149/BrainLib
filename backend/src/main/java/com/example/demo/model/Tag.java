// Tag.java
package com.example.demo.model;

import com.example.demo.model.TrendTag;
import com.example.demo.model.PostTag;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tag_name", nullable = false)
    private String tag_name;

    @Column(name = "tag_abbr", nullable = false)
    private String tag_abbr;

    @OneToOne(mappedBy = "tag", cascade = CascadeType.ALL)
    private TrendTag trendTag;

    @OneToMany(mappedBy = "tag", cascade = CascadeType.ALL)
    private Set<PostTag> posts;

    // getters and setters

    public Integer getTag_id() {
        return id;
    }

    public String getTag_name() {
        return tag_name;
    }

    public String getTag_abbr() {
        return tag_abbr;
    }

    public Set<PostTag> getPosts() {
        return posts;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }

    public void setTag_abbr(String tag_abbr) {
        this.tag_abbr = tag_abbr;
    }
}