package com.quickbite.backend.module.order.request;

import com.quickbite.backend.common.type.OrderStatus;
import com.quickbite.backend.module.order.validation.InOrderStatus;
import com.quickbite.backend.common.validation.ItemExists;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class OrderRequest {

  @ItemExists
  private Integer itemId;
  @NotBlank(message = "Status should not be empty")
  @InOrderStatus(anyOf = {OrderStatus.PENDING, OrderStatus.DELIVERED})
  private String status;
}
