// AppreciatorRepository.java
package com.example.demo.repository;

import com.example.demo.model.Appreciator;
import com.example.demo.model.Post;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface AppreciatorRepository extends JpaRepository<Appreciator, Integer> {
    Optional<Appreciator> findByPostAndAppreciator(Post post, User appreciator);
    List<Appreciator> findByPost(Post post);
    List<Appreciator> findByAppreciator(User appreciator);
}