package com.quickbite.backend.module.user.service;

import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.module.user.dto.UserDto;
import com.quickbite.backend.module.user.request.UserRequest;

public interface SuperAdminUserService {

  CollectionResponse<UserDto> getAllClients();

  CollectionResponse<UserDto> getAllAdmins();

  CollectionResponse<UserDto> getAll();

  UserDto getClient(Integer id);

  UserDto getAdmin(Integer id);

  UserDto get();

  UserDto postAdmin(UserRequest userRequest);

  UserDto put(UserRequest userRequest);

  void deleteClient(Integer id);

  void deleteAdmin(Integer id);

}
