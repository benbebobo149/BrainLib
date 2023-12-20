package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    boolean existsById(Integer id);
    void deleteById(Integer id);
    User findById(Integer id);
    List<User> findAll();
}