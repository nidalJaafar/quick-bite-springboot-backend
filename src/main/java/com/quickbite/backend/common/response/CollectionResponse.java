package com.quickbite.backend.common.response;

import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CollectionResponse<T> {
  private int count;
  private List<T> data;
}
