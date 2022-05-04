package com.quickbite.backend.common.util;

import com.quickbite.backend.common.response.CollectionResponse;
import java.util.List;


public class CollectionResponseFactory {
  /** Builds the CollectionResponse
   * @param list the list to be added <br/>
   * @return CollectionResponse<T> the CollectionResponse instance <br/><br/>
   * Sets the count to the value of the list size <br/>
   * Sets the data to the value of the list <br/>
   * @see CollectionResponse
   * */
  public static <T> CollectionResponse<T> buildResponse(List<T> list) {
    return new CollectionResponse<T>().setCount(list.size()).setData(list);
  }
}

