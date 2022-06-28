package com.quickbite.backend.common.util;

import static com.quickbite.backend.common.exception.ExceptionSupplier.userExceptionSupplier;

import com.quickbite.backend.common.entity.User;
import com.quickbite.backend.common.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthenticatedUser {

  private final UserRepository userRepository;

  public User getAuthenticatedUser() {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth == null) {
      return null;
    }
    UserDetails userDetails = (UserDetails) auth.getPrincipal();
    return userRepository
        .findUserByEmail(userDetails.getUsername())
        .orElseThrow(userExceptionSupplier());
  }
}
