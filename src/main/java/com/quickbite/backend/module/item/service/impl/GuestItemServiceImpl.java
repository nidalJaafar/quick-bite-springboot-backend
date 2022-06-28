package com.quickbite.backend.module.item.service.impl;

import com.quickbite.backend.common.exception.ExceptionSupplier;
import com.quickbite.backend.common.repository.ItemRepository;
import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.common.util.CollectionResponseFactory;
import com.quickbite.backend.module.item.dto.ItemDto;
import com.quickbite.backend.module.item.mapper.ItemMapper;
import com.quickbite.backend.module.item.service.GuestItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GuestItemServiceImpl implements GuestItemService {

  private final ItemMapper itemMapper;
  private final ItemRepository itemRepository;

  @Override
  public CollectionResponse<ItemDto> getAll() {
    return CollectionResponseFactory.buildResponse(
        itemMapper.itemListToItemDtoList(itemRepository.findAll()));
  }

  @Override
  public ItemDto get(Integer id) {
    return itemMapper.itemToItemDto(
        itemRepository.findById(id).orElseThrow(ExceptionSupplier.itemExceptionSupplier()));
  }
}
