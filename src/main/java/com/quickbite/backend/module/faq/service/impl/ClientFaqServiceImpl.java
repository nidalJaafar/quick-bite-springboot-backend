package com.quickbite.backend.module.faq.service.impl;

import com.quickbite.backend.common.exception.ExceptionSupplier;
import com.quickbite.backend.common.repository.FaqRepository;
import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.common.util.CollectionResponseFactory;
import com.quickbite.backend.module.faq.dto.FaqDto;
import com.quickbite.backend.module.faq.mapper.FaqMapper;
import com.quickbite.backend.module.faq.service.ClientFaqService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientFaqServiceImpl implements ClientFaqService {

  private final FaqMapper faqMapper;
  private final FaqRepository faqRepository;

  @Override
  public CollectionResponse<FaqDto> getAll() {
    return CollectionResponseFactory.buildResponse(
        faqMapper.faqListToFaqDtoList(faqRepository.findAll()));
  }

  @Override
  public FaqDto get(Integer id) {
    return faqMapper.faqToFaqDto(
        faqRepository.findById(id).orElseThrow(ExceptionSupplier.faqExceptionSupplier()));
  }
}
