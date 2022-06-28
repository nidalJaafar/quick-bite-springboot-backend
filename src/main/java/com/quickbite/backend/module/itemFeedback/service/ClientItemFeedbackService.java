package com.quickbite.backend.module.itemFeedback.service;

import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.module.itemFeedback.dto.ItemFeedbackDto;
import com.quickbite.backend.module.itemFeedback.request.ItemFeedbackRequest;

public interface ClientItemFeedbackService {

  CollectionResponse<ItemFeedbackDto> getAll();

  ItemFeedbackDto get(Integer id);

  ItemFeedbackDto post(ItemFeedbackRequest itemFeedbackRequest);

  ItemFeedbackDto put(ItemFeedbackRequest itemFeedbackRequest, Integer id);

  void delete(Integer id);
}
