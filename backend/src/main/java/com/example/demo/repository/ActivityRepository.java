// ActivityRepository.java
package com.example.demo.repository;

import com.example.demo.model.Activity;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {
    List<Activity> findAll();
    List<Activity> findByUser(User user);
}