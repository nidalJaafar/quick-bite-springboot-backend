package com.quickbite.backend.module.menu.service;

import com.quickbite.backend.common.entity.Menu;
import com.quickbite.backend.common.repository.MenuRepository;
import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.common.service.CrudService;
import com.quickbite.backend.common.util.CollectionResponseFactory;
import com.quickbite.backend.module.menu.dto.MenuDto;
import com.quickbite.backend.module.menu.mapper.MenuMapper;
import com.quickbite.backend.module.menu.request.MenuRequest;
import com.quickbite.backend.module.menu.response.MenuResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MenuService implements CrudService<MenuResponse, Menu, MenuDto, MenuRequest> {

  private final MenuRepository menuRepository;
  private final MenuMapper mapper;

  @Override
  public MenuResponse getEntity(Integer id) {
    return new MenuResponse().setMenu(mapper.menuToMenuDto(menuRepository.getById(id)));
  }

  @Override
  public CollectionResponse<MenuDto> getEntities() {
    return CollectionResponseFactory.buildResponse(mapper.menuListToMenuDtoList(menuRepository.findAll()));
  }

  @Override
  public MenuResponse createEntity(MenuRequest request) {
    Menu menu = init(request, new Menu());
    menuRepository.save(menu);
    return new MenuResponse().setMenu(mapper.menuToMenuDto(menu));
  }

  @Override
  public MenuResponse updateEntity(MenuRequest request, Integer id) {
    Menu menu = init(request, menuRepository.getById(id));
    menuRepository.save(menu);
    return new MenuResponse().setMenu(mapper.menuToMenuDto(menu));
  }

  @Override
  public MenuResponse deleteEntity(Integer id) {
    Menu menu = menuRepository.getById(id);
    menuRepository.delete(menu);
    return new MenuResponse().setMenu(mapper.menuToMenuDto(menu));
  }

  @Override
  public Menu init(MenuRequest request, Menu entity) {
    return entity
        .setName(request.getName());
  }
}
