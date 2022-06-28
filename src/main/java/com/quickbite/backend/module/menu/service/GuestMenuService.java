package com.quickbite.backend.module.menu.service;

import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.module.menu.dto.MenuDto;

public interface GuestMenuService {
  CollectionResponse<MenuDto> getAll();

  MenuDto get(Integer id);
}
