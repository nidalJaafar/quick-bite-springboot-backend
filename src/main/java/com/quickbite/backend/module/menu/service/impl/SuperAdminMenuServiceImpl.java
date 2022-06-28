package com.quickbite.backend.module.menu.service.impl;

import com.quickbite.backend.common.exception.ExceptionSupplier;
import com.quickbite.backend.common.repository.MenuRepository;
import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.common.util.CollectionResponseFactory;
import com.quickbite.backend.module.menu.dto.MenuDto;
import com.quickbite.backend.module.menu.mapper.MenuMapper;
import com.quickbite.backend.module.menu.request.MenuRequest;
import com.quickbite.backend.module.menu.service.SuperAdminMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SuperAdminMenuServiceImpl implements SuperAdminMenuService {

  private final MenuRepository menuRepository;
  private final MenuMapper menuMapper;

  @Override
  public CollectionResponse<MenuDto> getAll() {
    return CollectionResponseFactory.buildResponse(
        menuMapper.menuListToMenuDtoList(menuRepository.findAll()));
  }

  @Override
  public MenuDto get(Integer id) {
    return menuMapper.menuToMenuDto(
        menuRepository.findById(id).orElseThrow(ExceptionSupplier.menuExceptionSupplier()));
  }

  @Override
  public MenuDto post(MenuRequest menuRequest) {
    return menuMapper.menuToMenuDto(menuRepository.save(menuMapper.menuRequestToMenu(menuRequest)));
  }

  @Override
  public MenuDto put(MenuRequest menuRequest, Integer id) {
    return null;
  }

  @Override
  public void delete(Integer id) {
    if (!menuRepository.existsById(id)) {
      throw ExceptionSupplier.menuExceptionSupplier().get();
    }
    menuRepository.deleteById(id);
  }
}
