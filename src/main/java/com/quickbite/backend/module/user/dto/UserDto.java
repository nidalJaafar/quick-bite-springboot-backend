package com.quickbite.backend.module.user.dto;

import java.io.Serializable;
import java.util.Set;
import lombok.Data;

@Data
public class UserDto implements Serializable {

  private final Integer id;
  private final String firstName;
  private final String lastName;
  private final String email;
  private final String role;
  private final VisitFeedbackDto visitFeedback;
  private final Set<ItemFeedbackDto> itemFeedbacks;

  @Data
  public static class VisitFeedbackDto implements Serializable {

    private final Integer id;
    private final Integer rating;
    private final String details;
  }

  @Data
  public static class ItemFeedbackDto implements Serializable {

    private final Integer id;
    private final Integer rating;
    private final String details;
    private final ItemDto item;

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
}
