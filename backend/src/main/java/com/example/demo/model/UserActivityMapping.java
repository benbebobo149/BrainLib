// UserActivityMapping.java
package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "UserActivityMapping")
public class UserActivityMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id", nullable = false)
    private Integer user_id;

    @Column(name = "activity_id", nullable = false)
    private Integer activity_id;

    // getters and setters

    public Integer getId() {
        return id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public Integer getActivity_id() {
        return activity_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public void setActivity_id(Integer activity_id) {
        this.activity_id = activity_id;
    }
}