package com.quickbite.backend.module.itemFeedback.service.impl;

import com.quickbite.backend.common.exception.ExceptionSupplier;
import com.quickbite.backend.common.repository.ItemFeedbackRepository;
import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.common.util.CollectionResponseFactory;
import com.quickbite.backend.module.itemFeedback.dto.ItemFeedbackDto;
import com.quickbite.backend.module.itemFeedback.mapper.ItemFeedbackMapper;
import com.quickbite.backend.module.itemFeedback.service.AdminItemFeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminItemFeedbackServiceImpl implements AdminItemFeedbackService {

  private final ItemFeedbackMapper itemFeedbackMapper;
  private final ItemFeedbackRepository itemFeedbackRepository;

  @Override
  public CollectionResponse<ItemFeedbackDto> getAll() {
    return CollectionResponseFactory.buildResponse(
        itemFeedbackMapper.itemFeedbackListToItemFeedbackDtoList(itemFeedbackRepository.findAll()));
  }

  @Override
  public ItemFeedbackDto get(Integer id) {
    return itemFeedbackMapper.itemFeedbackToItemFeedbackDto(
        itemFeedbackRepository.findById(id).orElseThrow(
            ExceptionSupplier.itemFeedbackExceptionSupplier()));
  }
}
