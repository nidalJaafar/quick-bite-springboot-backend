package com.quickbite.backend.module.user.service.impl;

import com.quickbite.backend.common.repository.UserRepository;
import com.quickbite.backend.common.util.AuthenticatedUser;
import com.quickbite.backend.module.user.dto.UserDto;
import com.quickbite.backend.module.user.mapper.UserMapper;
import com.quickbite.backend.module.user.request.UserRequest;
import com.quickbite.backend.module.user.service.ClientUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClientUserServiceImpl implements ClientUserService {

  private final UserMapper userMapper;
  private final UserRepository userRepository;
  private final AuthenticatedUser authenticatedUser;

  @Override
  public UserDto get() {
    return userMapper.userToUserDto(authenticatedUser.getAuthenticatedUser());
  }

  @Override
  public UserDto put(UserRequest userRequest) {
    return null;
  }

  @Override
  public void delete() {
    userRepository.delete(authenticatedUser.getAuthenticatedUser());
  }
}
