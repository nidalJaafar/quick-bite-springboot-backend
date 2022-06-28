package com.quickbite.backend.module.visitFeedback.service;

import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.module.visitFeedback.dto.VisitFeedbackDto;
import com.quickbite.backend.module.visitFeedback.request.VisitFeedbackRequest;

public interface ClientVisitFeedbackService {

  CollectionResponse<VisitFeedbackDto> getAll();

  VisitFeedbackDto get(Integer id);

  VisitFeedbackDto post(VisitFeedbackRequest visitFeedbackRequest);

  VisitFeedbackDto put(VisitFeedbackRequest visitFeedbackRequest, Integer id);

  void delete(Integer id);
}
