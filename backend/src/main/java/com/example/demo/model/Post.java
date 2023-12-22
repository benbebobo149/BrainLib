// Post.java
package com.example.demo.model;

import com.example.demo.model.User;
import com.example.demo.model.PostTag;
import com.example.demo.model.SusPost;
import com.example.demo.model.Appreciator;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "users", nullable = false)
    private User user;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "thumb_up", nullable = false)
    private Integer thumbUp;

    @Column(name = "visible", nullable = false)
    private Boolean visible;

    @Column(name = "is_suspend", nullable = false)
    private Boolean isSuspend;

    @OneToMany(mappedBy = "post")
    private Set<PostTag> tags;

    @OneToMany(mappedBy = "post")
    private Set<Comment> comments;

    @OneToMany(mappedBy = "post")
    private Set<SusPost> suspendInfo;

    @OneToMany(mappedBy = "post")
    private Set<Appreciator> appreciators;

    // getters and setters
    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getImage() {
        return image;
    }

    public Integer getThumbUp() {
        return thumbUp;
    }

    public Boolean getVisible() {
        return visible;
    }

    public Boolean getIsSuspend() {
        return isSuspend;
    }

    public Set<PostTag> getTags() {
        return tags;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public Set<SusPost> getSuspendInfo() {
        return suspendInfo;
    }

    public Set<Appreciator> getAppreciators() {
        return appreciators;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setTags(Set<PostTag> tags) {
        this.tags = tags;
    }

    public void setThumbUp(Integer thumbUp) {
        this.thumbUp = thumbUp;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    } 

    public void setIsSuspend(Boolean isSuspend) {
        this.isSuspend = isSuspend;
    }
}