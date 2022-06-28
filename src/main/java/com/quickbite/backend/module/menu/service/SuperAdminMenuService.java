package com.quickbite.backend.module.menu.service;

import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.module.menu.dto.MenuDto;
import com.quickbite.backend.module.menu.request.MenuRequest;

public interface SuperAdminMenuService {

  CollectionResponse<MenuDto> getAll();

  MenuDto get(Integer id);

  MenuDto post(MenuRequest menuRequest);

  MenuDto put(MenuRequest menuRequest, Integer id);

  void delete(Integer id);
}
