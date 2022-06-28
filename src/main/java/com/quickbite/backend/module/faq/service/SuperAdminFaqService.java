package com.quickbite.backend.module.faq.service;

import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.module.faq.dto.FaqDto;
import com.quickbite.backend.module.faq.request.FaqRequest;

public interface SuperAdminFaqService {

  CollectionResponse<FaqDto> getAll();

  FaqDto get(Integer id);

  FaqDto post(FaqRequest faqRequest);

  FaqDto put(FaqRequest faqRequest, Integer id);

  void delete(Integer id);
}
