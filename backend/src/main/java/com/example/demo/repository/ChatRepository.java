// ChatMessageRepository.java
package com.example.demo.repository;

import com.example.demo.model.Chat;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatMessageRepository extends JpaRepository<Chat, Integer> {
    List<Chat> findBySender(User sender);
    List<Chat> findByReceiver(User receiver);
}