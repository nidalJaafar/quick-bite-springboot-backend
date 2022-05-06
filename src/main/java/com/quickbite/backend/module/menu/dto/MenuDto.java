package com.quickbite.backend.module.menu.dto;

import java.io.Serializable;
import java.util.Set;
import lombok.Data;

@Data
public class MenuDto implements Serializable {

  private final Integer id;
  private final String name;
  private final Set<ItemDto> items;

  @Data
  public static class ItemDto implements Serializable {

    private final Integer id;
    private final String name;
    private final String details;
    private final String type;
    private final Double basePrice;
    private final Integer sale;
    private final Double averageRating;
    private final Integer isTrending;
    private final Set<ImageDto> images;

    @Data
    public static class ImageDto implements Serializable {

      private final Integer id;
      private final String path;
    }
  }
}
