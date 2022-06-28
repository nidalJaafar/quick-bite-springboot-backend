package com.quickbite.backend.module.item.request;

import com.quickbite.backend.common.type.ItemType;
import com.quickbite.backend.module.item.validation.InItemType;
import com.quickbite.backend.module.item.validation.MenuExists;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ItemRequest {

  @NotBlank(message = "Name should not be empty")
  private String name;
  @NotBlank(message = "Description should not be empty")
  private String details;
  @InItemType(anyOf = {ItemType.DESSERT, ItemType.DRINK, ItemType.PLATE, ItemType.SANDWICH})
  private ItemType type;
  @Min(value = 1, message = "Base price should be greater than 1")
  private Double basePrice;
  @Min(value = 0, message = "Sale should be greater than 0")
  private Integer sale;
  @Min(value = 0, message = "isTrending should be 0 or 1")
  @Max(value = 1, message = "isTrending should be 0 or 1")
  private Integer isTrending;
  @MenuExists
  private Integer menuId;
}
