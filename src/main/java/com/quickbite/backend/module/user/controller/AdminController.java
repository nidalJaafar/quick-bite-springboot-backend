package com.quickbite.backend.module.user.controller;

import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.module.user.dto.UserDto;
import com.quickbite.backend.module.user.request.UserRequest;
import com.quickbite.backend.module.user.response.UserResponse;
import com.quickbite.backend.module.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin")
public class AdminController {
  private final UserService userService;

  @GetMapping("/user")
  public ResponseEntity<CollectionResponse<UserDto>> getUsers() {
    return ResponseEntity.ok(userService.getEntities());
  }

  @GetMapping("/user/{id}")
  public ResponseEntity<UserResponse> getUser(@PathVariable Integer id) {
    return ResponseEntity.ok(userService.getEntity(id));
  }

  @PostMapping("/user")
  public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request) {
    return ResponseEntity.status(HttpStatus.CREATED).body(userService.createEntity(request));
  }

  @PutMapping("/user/{id}")
  public ResponseEntity<UserResponse> updateUser(@RequestBody UserRequest request, @PathVariable Integer id) {
    return ResponseEntity.status(HttpStatus.CREATED).body(userService.updateEntity(request, id));
  }

  @DeleteMapping("/user/{id}")
  public ResponseEntity<UserResponse> deleteUser(@PathVariable Integer id) {
    return ResponseEntity.ok(userService.deleteEntity(id));
  }
}
