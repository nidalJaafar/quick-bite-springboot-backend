package com.quickbite.backend.module.user.dto;

import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserDto implements Serializable {

  private final Integer id;
  private final String firstName;
  private final String lastName;
  private final String email;
  private final String role;
}
