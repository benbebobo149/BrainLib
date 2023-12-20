// com.example.demo.service.UserService.java
package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public boolean existsById(Integer id) {
        return userRepository.existsById(id);
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public UserResult updateUser(Integer id, User userDetails, HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);
        String userId = jwtService.extractUserId(token);
        User user = userService.findById(userId);
        UserResult result = new UserResult();

        if (!jwtService.validateToken(token, user)) {
            result.setResultCode(1);
            return result;
        }
        
        User user = userRepository.findById(id).orElse(null);

        if (user != null) {
            if (user.getId() == userDetails.getId()) {
                user.setName(userDetails.getName());
                user.setEmail(userDetails.getEmail());
                user.setProfile(userDetails.getProfile());
                userRepository.save(user);
                result.setResultCode(0);
                result.setUser(user);
            } else {
                result.setResultCode(1);
            }
        } else {
            result.setResultCode(2);
        }

        return result;
    }
}