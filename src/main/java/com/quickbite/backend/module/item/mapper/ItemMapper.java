package com.quickbite.backend.module.item.mapper;

import com.quickbite.backend.common.entity.Item;
import com.quickbite.backend.module.item.dto.ItemDto;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ItemMapper {

  Item itemDtoToItem(ItemDto itemDto);

  ItemDto itemToItemDto(Item item);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateItemFromItemDto(
      ItemDto itemDto, @MappingTarget Item item);

  @AfterMapping
  default void linkImages(@MappingTarget Item item) {
    item.getImages().forEach(image -> image.setItem(item));
  }

  @AfterMapping
  default void linkItemFeedbacks(@MappingTarget Item item) {
    item.getItemFeedbacks().forEach(itemFeedback -> itemFeedback.setItem(item));
  }
}
