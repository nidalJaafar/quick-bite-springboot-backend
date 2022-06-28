package com.quickbite.backend.module.user.service;

import com.quickbite.backend.module.user.dto.UserDto;
import com.quickbite.backend.module.user.request.UserRequest;

public interface ClientUserService {

  UserDto get();

  UserDto put(UserRequest userRequest);

  void delete();
}
