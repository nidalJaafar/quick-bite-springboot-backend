package com.quickbite.backend.module.user.request;

import com.quickbite.backend.module.user.validation.UniqueUserEmail;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserRequest {

  @NotBlank(message = "First name should not be empty")
  private String firstName;
  @NotBlank(message = "Last name should not be empty")
  private String lastName;
  @Email
  @UniqueUserEmail
  @NotBlank(message = "Email should not be empty")
  private String email;
  @NotBlank(message = "Password should not be empty")
  private String password;
}
