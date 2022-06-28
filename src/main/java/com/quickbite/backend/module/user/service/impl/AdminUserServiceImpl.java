package com.quickbite.backend.module.user.service.impl;

import com.quickbite.backend.common.exception.ExceptionSupplier;
import com.quickbite.backend.common.repository.UserRepository;
import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.common.type.Role;
import com.quickbite.backend.common.util.AuthenticatedUser;
import com.quickbite.backend.common.util.CollectionResponseFactory;
import com.quickbite.backend.module.user.dto.UserDto;
import com.quickbite.backend.module.user.mapper.UserMapper;
import com.quickbite.backend.module.user.request.UserRequest;
import com.quickbite.backend.module.user.service.AdminUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AdminUserServiceImpl implements AdminUserService {

  private final UserMapper userMapper;
  private final UserRepository userRepository;
  private final AuthenticatedUser authenticatedUser;

  @Override
  public CollectionResponse<UserDto> getAllClients() {
    return CollectionResponseFactory.buildResponse(
        userMapper.userListToUserDtoList(userRepository.findUsersByRole(Role.CLIENT.name())));
  }

  @Override
  public UserDto getClient(Integer id) {
    return userMapper.userToUserDto(
        userRepository.findUserByRoleAndId(Role.CLIENT.name(), id).orElseThrow(
            ExceptionSupplier.userExceptionSupplier()));
  }

  @Override
  public UserDto get() {
    return userMapper.userToUserDto(authenticatedUser.getAuthenticatedUser());
  }

  @Override
  public UserDto put(UserRequest userRequest) {
    return null;
  }

  @Override
  public void deleteClient(Integer id) {
    if (!userRepository.existsById(id)) {
      throw ExceptionSupplier.userExceptionSupplier().get();
    }
    userRepository.deleteById(id);
  }
}
