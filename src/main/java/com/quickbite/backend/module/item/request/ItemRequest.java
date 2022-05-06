package com.quickbite.backend.module.item.request;

import lombok.Data;

@Data
public class ItemRequest {
  private String name;
  private String details;
  private String type;
  private Double basePrice;
  private Integer sale;
  private Double averageRating;
  private Integer isTrending;
  private Integer menuId;
}
