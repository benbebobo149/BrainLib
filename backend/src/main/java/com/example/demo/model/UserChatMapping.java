// UserChatMapping.java
package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "UserChatMappings")
public class UserChatMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "from_user_id", nullable = false)
    private Integer from_user_id;

    @Column(name = "to_user_id", nullable = false)
    private Integer to_user_id;

    // getters and setters

    public Integer getId() {
        return id;
    }

    public Integer getFrom_user_id() {
        return from_user_id;
    }

    public Integer getTo_user_id() {
        return to_user_id;
    }

    public void setFrom_user_id(Integer from_user_id) {
        this.from_user_id = from_user_id;
    }

    public void setTo_user_id(Integer to_user_id) {
        this.to_user_id = to_user_id;
    }
}