package com.quickbite.backend.module.user.service.impl;

import com.quickbite.backend.common.entity.User;
import com.quickbite.backend.common.repository.UserRepository;
import com.quickbite.backend.common.type.Role;
import com.quickbite.backend.module.user.mapper.UserMapper;
import com.quickbite.backend.module.user.request.LoginRequest;
import com.quickbite.backend.module.user.request.UserRequest;
import com.quickbite.backend.module.user.response.TokenResponse;
import com.quickbite.backend.module.user.service.GuestUserService;
import com.quickbite.backend.security.JwtUserDetailsService;
import com.quickbite.backend.security.JwtUtils;
import com.quickbite.backend.security.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GuestUserServiceImpl implements GuestUserService {

  private final JwtUtils jwtUtils;
  private final AuthenticationManager authenticationManager;
  private final JwtUserDetailsService jwtUserDetailsService;
  private final PasswordEncoder passwordEncoder;
  private final UserRepository userRepository;
  private final UserMapper userMapper;

  @Override
  public TokenResponse post(UserRequest userRequest) {
    User user = userMapper.userRequestToUser(userRequest);
    userRepository.save(user.setRole(
            Role.CLIENT.name())
        .setPassword(passwordEncoder.encoder().encode(userRequest.getPassword())));
    System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
    return new TokenResponse().setToken(jwtUtils.buildToken(userRequest.getEmail()))
        .setUserDto(userMapper.userToUserDto(user));
  }

  @Override
  public TokenResponse post(LoginRequest loginRequest) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
            loginRequest.getPassword()));
    UserDetails userDetails = jwtUserDetailsService
        .loadUserByUsername(loginRequest.getEmail());
    System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
    return new TokenResponse().setToken(jwtUtils.buildToken(userDetails.getUsername()))
        .setUserDto(userMapper.userToUserDto((User) userDetails));
  }
}
