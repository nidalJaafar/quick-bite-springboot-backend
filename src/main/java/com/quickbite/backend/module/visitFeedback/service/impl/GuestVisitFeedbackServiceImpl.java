package com.quickbite.backend.module.visitFeedback.service.impl;

import com.quickbite.backend.common.exception.ExceptionSupplier;
import com.quickbite.backend.common.repository.VisitFeedbackRepository;
import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.common.util.CollectionResponseFactory;
import com.quickbite.backend.module.visitFeedback.dto.VisitFeedbackDto;
import com.quickbite.backend.module.visitFeedback.mapper.VisitFeedbackMapper;
import com.quickbite.backend.module.visitFeedback.service.GuestVisitFeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GuestVisitFeedbackServiceImpl implements GuestVisitFeedbackService {

  private final VisitFeedbackRepository visitFeedbackRepository;
  private final VisitFeedbackMapper visitFeedbackMapper;

  @Override
  public CollectionResponse<VisitFeedbackDto> getAll() {
    return CollectionResponseFactory.buildResponse(
        visitFeedbackMapper.visitFeedbackListToVisitFeedbackDtoList(
            visitFeedbackRepository.findAll()));
  }

  @Override
  public VisitFeedbackDto get(Integer id) {
    return visitFeedbackMapper.visitFeedbackToVisitFeedbackDto(
        visitFeedbackRepository.findById(id).orElseThrow(
            ExceptionSupplier.visitFeedbackExceptionSupplier()));
  }
}
