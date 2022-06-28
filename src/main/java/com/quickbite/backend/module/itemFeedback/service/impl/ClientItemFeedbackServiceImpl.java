package com.quickbite.backend.module.itemFeedback.service.impl;

import com.quickbite.backend.common.exception.ExceptionSupplier;
import com.quickbite.backend.common.repository.ItemFeedbackRepository;
import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.common.util.CollectionResponseFactory;
import com.quickbite.backend.module.itemFeedback.dto.ItemFeedbackDto;
import com.quickbite.backend.module.itemFeedback.mapper.ItemFeedbackMapper;
import com.quickbite.backend.module.itemFeedback.request.ItemFeedbackRequest;
import com.quickbite.backend.module.itemFeedback.service.ClientItemFeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClientItemFeedbackServiceImpl implements ClientItemFeedbackService {

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

  @Override
  public ItemFeedbackDto post(ItemFeedbackRequest itemFeedbackRequest) {
    return itemFeedbackMapper.itemFeedbackToItemFeedbackDto(itemFeedbackRepository.save(
        itemFeedbackMapper.itemFeedbackRequestToItemFeedback(itemFeedbackRequest)));
  }

  @Override
  public ItemFeedbackDto put(ItemFeedbackRequest itemFeedbackRequest, Integer id) {
    return null;
  }

  @Override
  public void delete(Integer id) {
    if (!itemFeedbackRepository.existsById(id)) {
      throw ExceptionSupplier.itemFeedbackExceptionSupplier()
          .get();
    }
    itemFeedbackRepository.deleteById(id);
  }
}
