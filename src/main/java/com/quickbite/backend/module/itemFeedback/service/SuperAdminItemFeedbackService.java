package com.quickbite.backend.module.itemFeedback.service;

import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.module.itemFeedback.dto.ItemFeedbackDto;

public interface SuperAdminItemFeedbackService {

  CollectionResponse<ItemFeedbackDto> getAll();

  ItemFeedbackDto get(Integer id);
}
