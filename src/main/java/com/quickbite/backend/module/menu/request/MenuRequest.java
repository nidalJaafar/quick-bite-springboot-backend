package com.quickbite.backend.module.menu.request;

import com.quickbite.backend.module.menu.validation.UniqueMenuName;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MenuRequest {

  @NotBlank(message = "Name should not be empty")
  @UniqueMenuName
  private String name;
}
