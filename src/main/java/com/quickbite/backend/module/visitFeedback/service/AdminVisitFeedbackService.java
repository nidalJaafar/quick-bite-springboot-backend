package com.quickbite.backend.module.visitFeedback.service;

import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.module.visitFeedback.dto.VisitFeedbackDto;

public interface AdminVisitFeedbackService {

  CollectionResponse<VisitFeedbackDto> getAll();

  VisitFeedbackDto get(Integer id);
}
