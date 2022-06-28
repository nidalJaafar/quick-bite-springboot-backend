package com.quickbite.backend.module.user.controller;

import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.module.user.dto.UserDto;
import com.quickbite.backend.module.user.request.UserRequest;
import com.quickbite.backend.module.user.service.SuperAdminUserService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Validated
@PreAuthorize(value = "hasRole('SUPER_ADMIN')")
@RequestMapping("api/v1/super-admin")
public class SuperAdminUserController {

  private final SuperAdminUserService service;

  @GetMapping("/users")
  @ResponseStatus(HttpStatus.OK)
  public CollectionResponse<UserDto> getAll() {
    return service.getAll();
  }

  @GetMapping("/client-user")
  @ResponseStatus(HttpStatus.OK)
  public CollectionResponse<UserDto> getClients() {
    return service.getAllClients();
  }

  @GetMapping("/admin-user")
  @ResponseStatus(HttpStatus.OK)
  public CollectionResponse<UserDto> getAdmins() {
    return service.getAllAdmins();
  }

  @GetMapping("/admin-user/{id}")
  @ResponseStatus(HttpStatus.OK)
  public UserDto getAdmin(@PathVariable Integer id) {
    return service.getAdmin(id);
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

  @PostMapping("/admin-user")
  @ResponseStatus(HttpStatus.CREATED)
  public UserDto postAdmin(@Valid @RequestBody UserRequest request) {
    return service.postAdmin(request);
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

  @DeleteMapping("/admin-user/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteAdmin(@PathVariable Integer id) {
    service.deleteAdmin(id);
  }

}
