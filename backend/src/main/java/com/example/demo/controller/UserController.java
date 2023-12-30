package com.example.demo.controller;

import com.example.demo.dto.UserListResult;
import com.example.demo.dto.UserResult;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/all")
  public ResponseEntity<?> getAllUsers() {
    try {
      List<User> users = userService.findAll();

      if (users.size() > 0) {
        return ResponseEntity.ok(users);
      } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
      }
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getUserById(@PathVariable Integer id) {
    try {
      User user = userService.getUserById(id);

      if (user != null) {
        return ResponseEntity.ok(user);
      } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
      }
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateUser(
    @PathVariable Integer id,
    @RequestBody User userDetails,
    HttpServletRequest request
  ) {
    try {
      UserResult result = userService.updateUser(id, userDetails, request);
      switch (result.getResultCode()) {
        case 0: // 成功
          return ResponseEntity.ok(result.getUser());
        case 1: // 沒有權限
          return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        case 2: // 找不到
          return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        case 3: // 姓名已被使用
          return ResponseEntity.status(HttpStatus.CONFLICT).build();
        default: // 其他錯誤
          return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .build();
      }
    } catch (Exception e) {
      System.out.println(e);
      // 處理其他可能的錯誤
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteUser(
    @PathVariable Integer id,
    HttpServletRequest request
  ) {
    try {
      UserResult result = userService.deleteById(id, request);

      switch (result.getResultCode()) {
        case 0: // 成功
          return ResponseEntity.ok().build();
        case 1: // 沒有權限
          return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        case 2: // 找不到
          return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        default: // 其他錯誤
          return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .build();
      }
    } catch (Exception e) {
      // 處理其他可能的錯誤
      System.out.println(e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @GetMapping("/all/{permission}")
  public ResponseEntity<?> getUserByPermission(
    @PathVariable Integer permission
  ) {
    try {
      List<User> users = userService.getByPermission(permission);

      if (users.size() > 0) {
        return ResponseEntity.ok(users);
      } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
      }
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @GetMapping("/by-username/{username}")
  public ResponseEntity<?> getUserByUsername(@PathVariable String username) {
    try {
      User user = userService.getByName(username);

      if (user != null) {
        return ResponseEntity.ok(user);
      } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
      }
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }
}
