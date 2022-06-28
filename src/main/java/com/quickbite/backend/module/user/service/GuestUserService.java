package com.quickbite.backend.module.user.service;

import com.quickbite.backend.module.user.request.LoginRequest;
import com.quickbite.backend.module.user.request.UserRequest;
import com.quickbite.backend.module.user.response.TokenResponse;

public interface GuestUserService {

  TokenResponse post(UserRequest userRequest);

  TokenResponse post(LoginRequest loginRequest);
}
