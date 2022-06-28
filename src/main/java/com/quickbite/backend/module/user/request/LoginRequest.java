package com.quickbite.backend.module.user.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class LoginRequest {
  @Email
  @NotBlank(message = "Email should not be empty")
  private String email;
  @NotBlank(message = "Password should not be empty")
  private String password;
}
