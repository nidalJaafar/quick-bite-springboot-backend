package com.quickbite.backend.common.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Role {
  CLIENT("client"),
  ADMIN("admin"),
  SUPER_ADMIN("super_admin");

  private final String role;

}
