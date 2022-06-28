package com.quickbite.backend.module.faq.service;

import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.module.faq.dto.FaqDto;

public interface ClientFaqService {

  CollectionResponse<FaqDto> getAll();

  FaqDto get(Integer id);
}
