package com.quickbite.backend.module.user.response;

import com.quickbite.backend.module.user.dto.UserDto;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserResponse {
  private UserDto user;
}
