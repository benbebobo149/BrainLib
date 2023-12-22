// AppreciatorRepository.java
package com.example.demo.repository;

import com.example.demo.model.Appreciator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;
import java.util.Optional;

public interface AppreciatorRepository extends JpaRepository<Appreciator, Integer> {
    Optional<Appreciator> findByPostAndAppreciator(Post post, User appreciator);
}