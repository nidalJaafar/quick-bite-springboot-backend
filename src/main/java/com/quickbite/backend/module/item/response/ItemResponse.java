package com.quickbite.backend.module.item.response;

import com.quickbite.backend.module.item.dto.ItemDto;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ItemResponse {
  private ItemDto item;
}
