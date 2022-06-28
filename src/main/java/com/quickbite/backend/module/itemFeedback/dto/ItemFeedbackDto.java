package com.quickbite.backend.module.itemFeedback.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class ItemFeedbackDto implements Serializable {

  private final Integer id;
  private final UserDto user;
  private final Integer rating;
  private final String details;
  private final ItemDto item;

  @Data
  public static class UserDto implements Serializable {

    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String role;
  }

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
  }
}
