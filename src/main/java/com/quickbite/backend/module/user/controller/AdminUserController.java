package com.quickbite.backend.module.user.controller;

import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.module.user.dto.UserDto;
import com.quickbite.backend.module.user.request.UserRequest;
import com.quickbite.backend.module.user.service.AdminUserService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Validated
@PreAuthorize(value = "hasRole('ADMIN')")
@RequestMapping("api/v1/admin")
public class AdminUserController {

  private final AdminUserService service;

  @GetMapping("/client-user")
  @ResponseStatus(HttpStatus.OK)
  public CollectionResponse<UserDto> getClients() {
    return service.getAllClients();
  }

  @GetMapping("/client-user/{id}")
  @ResponseStatus(HttpStatus.OK)
  public UserDto getClient(@PathVariable Integer id) {
    return service.getClient(id);
  }

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

  @DeleteMapping("/client-user/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteClient(@PathVariable Integer id) {
    service.deleteClient(id);
  }

  @DeleteMapping("/user")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete() {
    service.delete();
  }

}