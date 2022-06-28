package com.quickbite.backend.security;

import com.quickbite.backend.common.entity.User;
import com.quickbite.backend.common.exception.ExceptionSupplier;
import com.quickbite.backend.common.repository.UserRepository;
import java.util.function.Supplier;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    return userRepository.findUserByEmail(email)
        .orElseThrow(ExceptionSupplier.usernameNotFoundExceptionSupplier());
  }
}
