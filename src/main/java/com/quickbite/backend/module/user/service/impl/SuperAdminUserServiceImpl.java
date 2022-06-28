package com.quickbite.backend.module.user.service.impl;

import com.quickbite.backend.common.entity.User;
import com.quickbite.backend.common.exception.ExceptionSupplier;
import com.quickbite.backend.common.repository.UserRepository;
import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.common.type.Role;
import com.quickbite.backend.common.util.AuthenticatedUser;
import com.quickbite.backend.common.util.CollectionResponseFactory;
import com.quickbite.backend.module.user.dto.UserDto;
import com.quickbite.backend.module.user.mapper.UserMapper;
import com.quickbite.backend.module.user.request.UserRequest;
import com.quickbite.backend.module.user.service.SuperAdminUserService;
import com.quickbite.backend.security.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SuperAdminUserServiceImpl implements SuperAdminUserService {

  private final UserMapper userMapper;
  private final UserRepository userRepository;
  private final AuthenticatedUser authenticatedUser;
  private final PasswordEncoder passwordEncoder;

  @Override
  public CollectionResponse<UserDto> getAllClients() {
    return CollectionResponseFactory.buildResponse(
        userMapper.userListToUserDtoList(userRepository.findUsersByRole(Role.CLIENT.name())));
  }

  @Override
  public CollectionResponse<UserDto> getAllAdmins() {
    return CollectionResponseFactory.buildResponse(
        userMapper.userListToUserDtoList(userRepository.findUsersByRole(Role.ADMIN.name())));
  }

  @Override
  public CollectionResponse<UserDto> getAll() {
    return CollectionResponseFactory.buildResponse(
        userMapper.userListToUserDtoList(userRepository.findAll()));
  }

  @Override
  public UserDto getClient(Integer id) {
    return userMapper.userToUserDto(userRepository.findUserByRoleAndId(Role.CLIENT.name(), id)
        .orElseThrow(ExceptionSupplier.userExceptionSupplier()));
  }

  @Override
  public UserDto getAdmin(Integer id) {
    return userMapper.userToUserDto(userRepository.findUserByRoleAndId(Role.ADMIN.name(), id)
        .orElseThrow(ExceptionSupplier.userExceptionSupplier()));
  }

  @Override
  public UserDto get() {
    return userMapper.userToUserDto(authenticatedUser.getAuthenticatedUser());
  }

  @Override
  public UserDto postAdmin(UserRequest userRequest) {
    return userMapper.userToUserDto(userRepository.save(
        userMapper.userRequestToUser(userRequest).setRole(Role.ADMIN.name())
            .setPassword(passwordEncoder.encoder().encode(userRequest.getPassword()))));
  }

  @Override
  public UserDto put(UserRequest userRequest) {
    return null;
  }

  @Override
  public void deleteClient(Integer id) {
    User user = userRepository.findUserByRoleAndId(Role.CLIENT.name(), id)
        .orElseThrow(ExceptionSupplier.userExceptionSupplier());
    userRepository.delete(user);
  }

  @Override
  public void deleteAdmin(Integer id) {
    User user = userRepository.findUserByRoleAndId(Role.ADMIN.name(), id)
        .orElseThrow(ExceptionSupplier.userExceptionSupplier());
    userRepository.delete(user);
  }

}
