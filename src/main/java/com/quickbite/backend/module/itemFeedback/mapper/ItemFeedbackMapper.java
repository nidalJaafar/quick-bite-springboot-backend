package com.quickbite.backend.module.itemFeedback.mapper;

import com.quickbite.backend.common.entity.ItemFeedback;
import com.quickbite.backend.module.itemFeedback.dto.ItemFeedbackDto;
import com.quickbite.backend.module.itemFeedback.request.ItemFeedbackRequest;
import java.util.List;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ItemFeedbackMapper {

  ItemFeedback itemFeedbackDtoToItemFeedback(ItemFeedbackDto itemFeedbackDto);

  ItemFeedbackDto itemFeedbackToItemFeedbackDto(ItemFeedback itemFeedback);

  List<ItemFeedbackDto> itemFeedbackListToItemFeedbackDtoList(List<ItemFeedback> itemFeedbackList);

  ItemFeedback itemFeedbackRequestToItemFeedback(ItemFeedbackRequest itemFeedbackRequest);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateItemFeedbackFromItemFeedbackDto(
      ItemFeedbackDto itemFeedbackDto, @MappingTarget ItemFeedback itemFeedback);
}
