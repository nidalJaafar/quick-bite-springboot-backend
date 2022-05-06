package com.quickbite.backend.module.itemFeedback.service;

import com.quickbite.backend.common.entity.ItemFeedback;
import com.quickbite.backend.common.repository.ItemFeedbackRepository;
import com.quickbite.backend.common.repository.ItemRepository;
import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.common.service.CrudService;
import com.quickbite.backend.common.util.CollectionResponseFactory;
import com.quickbite.backend.module.itemFeedback.dto.ItemFeedbackDto;
import com.quickbite.backend.module.itemFeedback.mapper.ItemFeedbackMapper;
import com.quickbite.backend.module.itemFeedback.request.ItemFeedbackRequest;
import com.quickbite.backend.module.itemFeedback.response.ItemFeedbackResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemFeedbackService implements
    CrudService<ItemFeedbackResponse, ItemFeedback, ItemFeedbackDto, ItemFeedbackRequest> {

  private final ItemFeedbackRepository itemFeedbackRepository;
  private final ItemFeedbackMapper mapper;
  private final ItemRepository itemRepository;

  @Override
  public ItemFeedbackResponse getEntity(Integer id) {
    return new ItemFeedbackResponse().setItemFeedback(
        mapper.itemFeedbackToItemFeedbackDto(itemFeedbackRepository.getById(id)));
  }

  @Override
  public CollectionResponse<ItemFeedbackDto> getEntities() {
    return CollectionResponseFactory.buildResponse(
        mapper.itemFeedbackListToItemFeedbackDtoList(itemFeedbackRepository.findAll()));
  }

  @Override
  public ItemFeedbackResponse createEntity(ItemFeedbackRequest request) {
    ItemFeedback itemFeedback = init(request, new ItemFeedback());
    itemFeedbackRepository.save(itemFeedback);
    return new ItemFeedbackResponse().setItemFeedback(mapper.itemFeedbackToItemFeedbackDto(itemFeedback));
  }

  @Override
  public ItemFeedbackResponse updateEntity(ItemFeedbackRequest request, Integer id) {
    ItemFeedback itemFeedback = init(request, itemFeedbackRepository.getById(id));
    itemFeedbackRepository.save(itemFeedback);
    return new ItemFeedbackResponse().setItemFeedback(mapper.itemFeedbackToItemFeedbackDto(itemFeedback));
  }

  @Override
  public ItemFeedbackResponse deleteEntity(Integer id) {
    ItemFeedback itemFeedback = itemFeedbackRepository.getById(id);
    itemFeedbackRepository.delete(itemFeedback);
    return new ItemFeedbackResponse().setItemFeedback(mapper.itemFeedbackToItemFeedbackDto(itemFeedback));
  }

  @Override
  public ItemFeedback init(ItemFeedbackRequest request, ItemFeedback entity) {
    return entity
        .setItem(itemRepository.getById(request.getItemId()))
        .setDetails(request.getDetails())
        .setRating(request.getRating());
    // TODO: set user_id
  }
}
