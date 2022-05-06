package com.quickbite.backend.module.visitFeedback.service;

import com.quickbite.backend.common.entity.VisitFeedback;
import com.quickbite.backend.common.repository.VisitFeedbackRepository;
import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.common.service.CrudService;
import com.quickbite.backend.common.util.CollectionResponseFactory;
import com.quickbite.backend.module.visitFeedback.dto.VisitFeedbackDto;
import com.quickbite.backend.module.visitFeedback.mapper.VisitFeedbackMapper;
import com.quickbite.backend.module.visitFeedback.request.VisitFeedbackRequest;
import com.quickbite.backend.module.visitFeedback.response.VisitFeedbackResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VisitFeedbackService implements
    CrudService<VisitFeedbackResponse, VisitFeedback, VisitFeedbackDto, VisitFeedbackRequest> {

  private final VisitFeedbackRepository visitFeedbackRepository;
  private final VisitFeedbackMapper mapper;

  @Override
  public VisitFeedbackResponse getEntity(Integer id) {
    return new VisitFeedbackResponse().setVisitFeedback(
        mapper.visitFeedbackToVisitFeedbackDto(visitFeedbackRepository.getById(id)));
  }

  @Override
  public CollectionResponse<VisitFeedbackDto> getEntities() {
    return CollectionResponseFactory.buildResponse(
        mapper.visitFeedbackListToVisitFeedbackDtoList(visitFeedbackRepository.findAll()));
  }

  @Override
  public VisitFeedbackResponse createEntity(VisitFeedbackRequest request) {
    VisitFeedback visitFeedback = init(request, new VisitFeedback());
    visitFeedbackRepository.save(visitFeedback);
    return new VisitFeedbackResponse().setVisitFeedback(
        mapper.visitFeedbackToVisitFeedbackDto(visitFeedback));
  }

  @Override
  public VisitFeedbackResponse updateEntity(VisitFeedbackRequest request, Integer id) {
    VisitFeedback visitFeedback = init(request, visitFeedbackRepository.getById(id));
    visitFeedbackRepository.save(visitFeedback);
    return new VisitFeedbackResponse().setVisitFeedback(
        mapper.visitFeedbackToVisitFeedbackDto(visitFeedback));
  }

  @Override
  public VisitFeedbackResponse deleteEntity(Integer id) {
    VisitFeedback visitFeedback = visitFeedbackRepository.getById(id);
    visitFeedbackRepository.delete(visitFeedback);
    return new VisitFeedbackResponse().setVisitFeedback(
        mapper.visitFeedbackToVisitFeedbackDto(visitFeedback));
  }

  @Override
  public VisitFeedback init(VisitFeedbackRequest request, VisitFeedback entity) {
    // TODO: set visitFeedback user_id
    return entity
        .setDetails(request.getDetails())
        .setRating(request.getRating());
  }
}
