package com.quickbite.backend.module.user.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quickbite.backend.module.user.dto.UserDto;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TokenResponse {

  String token;
  @JsonProperty("user")
  UserDto userDto;
}
