// Post.java
package com.example.demo.model;

import javax.persistence.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

@Entity
@Table(name = "posts")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "title", nullable = false)
    private String title;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb", name = "content", nullable = false)
    private String content;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "thumb_up", nullable = true)
    private Integer thumbUp;

    @Column(name = "visible", nullable = false)
    private Boolean visible;

    @Column(name = "is_suspend", nullable = false)
    private Boolean isSuspend;

    @Column(name = "suspender_id", nullable = true)
    private Integer suspenderId;

    // getters and setters
    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
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

    public Integer getSuspenderId() {
        return suspenderId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public void setThumbUp(Integer thumbUp) {
        this.thumbUp = thumbUp;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    } 

    public void setIsSuspend(Boolean isSuspend) {
        this.isSuspend = isSuspend;
    }

    public void setSuspenderId(Integer suspenderId) {
        this.suspenderId = suspenderId;
    }
}