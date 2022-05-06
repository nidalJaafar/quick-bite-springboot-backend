package com.quickbite.backend.module.user.request;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserRequest {
  private String firstName;
  private String lastName;
  private String email;
  private String password;
}
