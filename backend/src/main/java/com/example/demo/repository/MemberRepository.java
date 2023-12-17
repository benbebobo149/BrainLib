// com.example.demo.repository.MemberRepository.java
package com.example.demo.repository;

import com.example.demo.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    List<Member> findByName(String name);
    List<Member> findByEmail(String email);

}