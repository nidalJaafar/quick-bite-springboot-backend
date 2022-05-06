package com.quickbite.backend.module.menu.request;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MenuRequest {
  private String name;
}
