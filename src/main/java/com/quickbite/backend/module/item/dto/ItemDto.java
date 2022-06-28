package com.quickbite.backend.module.item.dto;

import java.io.Serializable;
import java.util.Set;
import lombok.Data;

@Data
public class ItemDto implements Serializable {

  private final Integer id;
  private final String name;
  private final String details;
  private final String type;
  private final Double basePrice;
  private final Integer sale;
  private final Double averageRating;
  private final MenuDto menu;
  private final Set<ImageDto> images;
  private final Set<ItemFeedbackDto> itemFeedbacks;

  @Data
  public static class MenuDto implements Serializable {

    private final Integer id;
    private final String name;
  }

  @Data
  public static class ImageDto implements Serializable {

    private final Integer id;
    private final String path;
  }

  @Data
  public static class ItemFeedbackDto implements Serializable {

    private final Integer id;
    private final UserDto user;
    private final Integer rating;
    private final String details;

    @Data
    public static class UserDto implements Serializable {

      private final Integer id;
      private final String firstName;
      private final String lastName;
      private final String email;
      private final String role;
    }
  }
}
