package com.quickbite.backend.module.visitFeedback.mapper;

import com.quickbite.backend.common.entity.VisitFeedback;
import com.quickbite.backend.module.visitFeedback.dto.VisitFeedbackDto;
import com.quickbite.backend.module.visitFeedback.request.VisitFeedbackRequest;
import java.util.List;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface VisitFeedbackMapper {

  VisitFeedback visitFeedbackDtoToVisitFeedback(VisitFeedbackDto visitFeedbackDto);

  VisitFeedbackDto visitFeedbackToVisitFeedbackDto(VisitFeedback visitFeedback);

  List<VisitFeedbackDto> visitFeedbackListToVisitFeedbackDtoList(List<VisitFeedback> visitFeedbackList);

  VisitFeedback visitFeedbackRequestToVisitFeedback(VisitFeedbackRequest visitFeedbackRequest);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateVisitFeedbackFromVisitFeedbackDto(
      VisitFeedbackDto visitFeedbackDto, @MappingTarget VisitFeedback visitFeedback);
}
