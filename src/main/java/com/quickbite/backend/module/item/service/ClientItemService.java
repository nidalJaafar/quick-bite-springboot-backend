package com.quickbite.backend.module.item.service;

import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.module.item.dto.ItemDto;

public interface ClientItemService {

  CollectionResponse<ItemDto> getAll();

  ItemDto get(Integer id);
}
