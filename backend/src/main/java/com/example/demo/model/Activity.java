// Activity.java
package com.example.demo.model;

import com.example.demo.model.BrainUser;
import com.example.demo.model.UserActivityMapping;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Activities")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "brainUser", nullable = false, referencedColumnName = "id")
    private BrainUser brainUser;

    @OneToMany(mappedBy = "activity")
    private Set<UserActivityMapping> participants;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "visible", columnDefinition = "boolean default false")
    private Boolean visible;

    @Column(name = "dateTime", nullable = false)
    private Date dateTime;

    // getters and setters

    public Integer getActivityId() {
        return id;
    }

    public BrainUser getBrainUser() {
        return brainUser;
    }

    public Set<UserActivityMapping> getParticipants() {
        return participants;
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

    public void setBrainUser(BrainUser brainUser) {
        this.brainUser = brainUser;
    }

    public void setParticipants(Set<UserActivityMapping> participants) {
        this.participants = participants;
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
}