package com.quickbite.backend.module.visitFeedback.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class VisitFeedbackDto implements Serializable {

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
  }
}
