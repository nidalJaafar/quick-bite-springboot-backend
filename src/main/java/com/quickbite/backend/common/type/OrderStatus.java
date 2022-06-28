package com.quickbite.backend.common.type;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum OrderStatus {
  PENDING("pending"),
  DELIVERED("delivered");

  private final String status;
}
