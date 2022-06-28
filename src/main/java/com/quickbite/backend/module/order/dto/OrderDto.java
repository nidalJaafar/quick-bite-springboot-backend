package com.quickbite.backend.module.order.dto;

import java.io.Serializable;
import java.util.Set;
import lombok.Data;

@Data
public class OrderDto implements Serializable {

  private final Integer id;
  private final String status;
  private final ItemDto item;
  private final UserDto user;

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

  @Data
  public static class UserDto implements Serializable {

    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
    private final String role;
  }
}
