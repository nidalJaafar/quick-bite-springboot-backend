package com.quickbite.backend.module.item.service;

import com.quickbite.backend.common.entity.Item;
import com.quickbite.backend.common.repository.ItemRepository;
import com.quickbite.backend.common.repository.MenuRepository;
import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.common.service.CrudService;
import com.quickbite.backend.common.util.CollectionResponseFactory;
import com.quickbite.backend.module.item.dto.ItemDto;
import com.quickbite.backend.module.item.mapper.ItemMapper;
import com.quickbite.backend.module.item.request.ItemRequest;
import com.quickbite.backend.module.item.response.ItemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService implements CrudService<ItemResponse, Item, ItemDto, ItemRequest> {

  private final ItemRepository itemRepository;
  private final MenuRepository menuRepository;
  private final ItemMapper mapper;
  private final ItemResponse response;

  @Override
  public ItemResponse getEntity(Integer id) {
    response.setItem(mapper.itemToItemDto(itemRepository.getById(id)));
    return response;
  }

  @Override
  public CollectionResponse<ItemDto> getEntities() {
    return CollectionResponseFactory
        .buildResponse(
            itemRepository
                .findAll()
                .parallelStream()
                .map(mapper::itemToItemDto)
                .toList()
        );
  }

  @Override
  public ItemResponse createEntity(ItemRequest request) {
    Item item = init(request, new Item())
        .setAverageRating((double) 0);
    itemRepository.save(item);
    return new ItemResponse().setItem(mapper.itemToItemDto(item));
  }

  @Override
  public ItemResponse updateEntity(ItemRequest request, Integer id) {
    Item item = init(request, itemRepository.getById(id))
        .setAverageRating(itemRepository.averageRating(id));
    itemRepository.save(item);
    return new ItemResponse().setItem(mapper.itemToItemDto(item));
  }

  @Override
  public ItemResponse deleteEntity(Integer id) {
    Item item = itemRepository.getById(id);
    itemRepository.delete(item);
    return new ItemResponse().setItem(mapper.itemToItemDto(item));
  }

  @Override
  public Item init(ItemRequest request, Item entity) {
    return entity
        .setName(request.getName())
        .setDetails(request.getDetails())
        .setBasePrice(request.getBasePrice())
        .setIsTrending(request.getIsTrending())
        .setSale(request.getSale())
        .setType(request.getType())
        .setMenu(menuRepository.getById(request.getMenuId()));
  }
}
