// TagRepository.java
package com.example.demo.repository;

import com.example.demo.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Integer> {
    Tag save(Tag tag);
    List<Tag> findAll();
    void delete(Tag tag);
}