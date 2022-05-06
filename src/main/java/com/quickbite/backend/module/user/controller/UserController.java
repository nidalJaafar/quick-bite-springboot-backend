package com.quickbite.backend.module.user.controller;

import com.quickbite.backend.module.user.request.UserRequest;
import com.quickbite.backend.module.user.response.UserResponse;
import com.quickbite.backend.module.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// TODO: implement the methods

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping("/profile")
  public ResponseEntity<UserResponse> getUser() {
    return null;
  }

  @PutMapping("/profile")
  public ResponseEntity<UserResponse> updateUser(UserRequest request) {
    return null;
  }

  @DeleteMapping("/profile")
  public ResponseEntity<UserResponse> deleteUser() {
    return null;
  }
}
