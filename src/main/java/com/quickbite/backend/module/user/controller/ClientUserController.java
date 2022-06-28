package com.quickbite.backend.module.user.controller;

import com.quickbite.backend.module.user.dto.UserDto;
import com.quickbite.backend.module.user.request.UserRequest;
import com.quickbite.backend.module.user.service.ClientUserService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Validated
@PreAuthorize(value = "hasRole('CLIENT')")
@RequestMapping("api/v1/client")
public class ClientUserController {

  private final ClientUserService service;

  @GetMapping("/user")
  @ResponseStatus(HttpStatus.OK)
  public UserDto get() {
    return service.get();
  }

  @PutMapping("/user")
  @ResponseStatus(HttpStatus.CREATED)
  public UserDto put(@Valid @RequestBody UserRequest request) {
    return service.put(request);
  }

  @DeleteMapping("/user")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete() {
    service.delete();
  }

}