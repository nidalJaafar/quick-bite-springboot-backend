package com.quickbite.backend.module.menu.service.impl;

import com.quickbite.backend.common.exception.ExceptionSupplier;
import com.quickbite.backend.common.repository.MenuRepository;
import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.common.util.CollectionResponseFactory;
import com.quickbite.backend.module.menu.dto.MenuDto;
import com.quickbite.backend.module.menu.mapper.MenuMapper;
import com.quickbite.backend.module.menu.service.ClientMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientMenuServiceImpl implements ClientMenuService {

  private final MenuRepository menuRepository;
  private final MenuMapper menuMapper;

  @Override
  public CollectionResponse<MenuDto> getAll() {
    return CollectionResponseFactory.buildResponse(
        menuMapper.menuListToMenuDtoList(menuRepository.findAll()));
  }

  @Override
  public MenuDto get(Integer id) {
    return menuMapper.menuToMenuDto(menuRepository.findById(id).orElseThrow(
        ExceptionSupplier.menuExceptionSupplier()));
  }
}
