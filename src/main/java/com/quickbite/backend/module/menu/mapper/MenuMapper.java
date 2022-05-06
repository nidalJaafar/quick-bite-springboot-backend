package com.quickbite.backend.module.menu.mapper;

import com.quickbite.backend.common.entity.Menu;
import com.quickbite.backend.module.menu.dto.MenuDto;
import java.util.List;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface MenuMapper {

  Menu menuDtoToMenu(MenuDto menuDto);

  MenuDto menuToMenuDto(Menu menu);

  List<MenuDto> menuListToMenuDtoList(List<Menu> menuList);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateMenuFromMenuDto(
      MenuDto menuDto, @MappingTarget Menu menu);

  @AfterMapping
  default void linkItems(@MappingTarget Menu menu) {
    menu.getItems().forEach(item -> item.setMenu(menu));
  }
}
