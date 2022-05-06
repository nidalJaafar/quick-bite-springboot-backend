package com.quickbite.backend.module.item.dto;

import java.io.Serializable;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ItemDto implements Serializable {

  private final Integer id;
  private final String name;
  private final String details;
  private final String type;
  private final Double basePrice;
  private final Integer sale;
  private final Double averageRating;
  private final Integer isTrending;
  private final Set<ImageDto> images;
  private final Set<ItemFeedbackDto> itemFeedbacks;


  @AllArgsConstructor
  @Getter
  public static class ImageDto implements Serializable {

    private final Integer id;
    private final String path;
  }

  @AllArgsConstructor
  @Getter
  public static class ItemFeedbackDto implements Serializable {

    private final Integer id;
    private final UserDto user;
    private final Integer rating;
    private final String details;

    @AllArgsConstructor
    @Getter
    public static class UserDto implements Serializable {

      private final Integer id;
    }
  }
}
