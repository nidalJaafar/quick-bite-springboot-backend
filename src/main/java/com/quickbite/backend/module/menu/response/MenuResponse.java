package com.quickbite.backend.module.menu.response;

import com.quickbite.backend.module.menu.dto.MenuDto;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MenuResponse {
  private MenuDto menu;
}
