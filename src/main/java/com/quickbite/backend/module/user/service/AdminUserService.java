package com.quickbite.backend.module.user.service;

import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.module.user.dto.UserDto;
import com.quickbite.backend.module.user.request.UserRequest;

public interface AdminUserService {

  CollectionResponse<UserDto> getAllClients();

  UserDto getClient(Integer id);

  UserDto get();

  UserDto put(UserRequest userRequest);

  void deleteClient(Integer id);

}