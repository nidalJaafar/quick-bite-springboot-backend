package com.quickbite.backend.module.user.controller;

import com.quickbite.backend.module.user.request.LoginRequest;
import com.quickbite.backend.module.user.request.UserRequest;
import com.quickbite.backend.module.user.response.TokenResponse;
import com.quickbite.backend.module.user.service.GuestUserService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("api/v1/guest")
public class GuestUserController {

  private final GuestUserService service;

  @PostMapping("/signup")
  @ResponseStatus(HttpStatus.CREATED)
  public TokenResponse post(@Valid @RequestBody UserRequest request) {
    return service.post(request);
  }

  @PostMapping("/login")
  @ResponseStatus(HttpStatus.CREATED)
  public TokenResponse post(@Valid @RequestBody LoginRequest request) {
    return service.post(request);
  }

}
