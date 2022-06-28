package com.quickbite.backend.common.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ItemType {
  SANDWICH("sandwich"),
  DESSERT("dessert"),
  PLATE("plate"),
  DRINK("drink");

  private final String type;
}
