// com.example.demo.service.UserService.java
package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import com.example.demo.dto.UserResult;
import com.example.demo.dto.UserListResult;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public User getByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    public User getByName(String name) {
        return userRepository.findByName(name).orElse(null);
    }

    public List<User> getByPermission(Integer permission) {
        return userRepository.findByPermission(permission);
    }

    public UserResult deleteById(Integer id, HttpServletRequest request) {

        JwtResult jwtResult = jwtService.parseRequest(request);
        UserResult result = new UserResult();
        
        if (!(jwtResult != null) && (!jwtResult.getPassed())) {
            result.setResultCode(1);
            return result;
        }
        
        User user = userRepository.findById(id).orElse(null);

        if (user != null) {
            if (user.getId() == id || user.getPermission() == 2) {
            userRepository.deleteById(id);
            result.setResultCode(0);
            } else {
                result.setResultCode(1);
            }
        } else {
            result.setResultCode(2);
        }

        return result;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public UserResult updateUser(Integer id, User userDetails, HttpServletRequest request) {

        JwtResult jwtResult = jwtService.parseRequest(request);

        UserResult result = new UserResult();

        if (!(jwtResult != null) && (!jwtResult.getPassed())) {
            result.setResultCode(1);
            return result;
        }
        
        User user = userRepository.findById(id).orElse(null);

        if (user != null) {
            if (user.getId() == userDetails.getId()) {
                user.setName(userDetails.getName());
                user.setEmail(userDetails.getEmail());
                user.setProfile(userDetails.getProfile());
                user.setPermission(userDetails.getPermission());
                user.setImage(userDetails.getImage());
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