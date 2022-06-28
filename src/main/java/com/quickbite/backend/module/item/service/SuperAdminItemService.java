package com.quickbite.backend.module.item.service;

import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.module.item.request.ItemRequest;
import com.quickbite.backend.module.item.dto.ItemDto;

public interface SuperAdminItemService {

  CollectionResponse<ItemDto> getAll();

  ItemDto get(Integer id);

  ItemDto put(ItemRequest itemRequest, Integer id);

  ItemDto post(ItemRequest itemRequest);

  void delete(Integer id);
}
