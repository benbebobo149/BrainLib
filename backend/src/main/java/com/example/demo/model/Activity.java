// Activity.java
package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Activities")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer activity_id;

    @Column(name = "user_id", nullable = false)
    private Integer user_id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "visible", nullable = false)
    private Boolean visible;

    @Column(name = "dateTime", nullable = false)
    private Date dateTime;

    @ManyToMany
    @JoinTable(
        name = "activity_tags",
        joinColumns = @JoinColumn(name = "activity_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags;

    // getters and setters

    public Integer getActivity_id() {
        return activity_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getLocation() {
        return location;
    }

    public Boolean getVisible() {
        return visible;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}