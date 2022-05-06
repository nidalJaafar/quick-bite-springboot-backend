package com.quickbite.backend.module.user.service;

import com.quickbite.backend.common.entity.User;
import com.quickbite.backend.common.repository.UserRepository;
import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.common.service.CrudService;
import com.quickbite.backend.common.util.CollectionResponseFactory;
import com.quickbite.backend.module.user.dto.UserDto;
import com.quickbite.backend.module.user.mapper.UserMapper;
import com.quickbite.backend.module.user.request.UserRequest;
import com.quickbite.backend.module.user.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements CrudService<UserResponse, User, UserDto, UserRequest> {

  private final UserRepository userRepository;
  private final UserMapper mapper;

  @Override
  public UserResponse getEntity(Integer id) {
    return new UserResponse().setUser(mapper.userToUserDto(userRepository.getById(id)));
  }

  @Override
  public CollectionResponse<UserDto> getEntities() {
    return CollectionResponseFactory.buildResponse(mapper.userListToUserDtoList(userRepository.findAll()));
  }

  @Override
  public UserResponse createEntity(UserRequest request) {
    User user = init(request, new User());
    userRepository.save(user);
    return new UserResponse().setUser(mapper.userToUserDto(user));
  }

  @Override
  public UserResponse updateEntity(UserRequest request, Integer id) {
    User user = init(request, userRepository.getById(id));
    userRepository.save(user);
    return new UserResponse().setUser(mapper.userToUserDto(user));
  }

  @Override
  public UserResponse deleteEntity(Integer id) {
    User user = userRepository.getById(id);
    userRepository.delete(user);
    return new UserResponse().setUser(mapper.userToUserDto(user));
  }

  @Override
  public User init(UserRequest request, User entity) {
    return entity
        .setEmail(request.getEmail())
        .setFirstName(request.getFirstName())
        .setLastName(request.getLastName())
        .setPassword(request.getPassword());
  }
}
