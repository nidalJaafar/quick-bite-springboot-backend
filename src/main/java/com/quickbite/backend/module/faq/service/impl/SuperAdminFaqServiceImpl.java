package com.quickbite.backend.module.faq.service.impl;

import com.quickbite.backend.common.exception.ExceptionSupplier;
import com.quickbite.backend.common.repository.FaqRepository;
import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.common.util.CollectionResponseFactory;
import com.quickbite.backend.module.faq.dto.FaqDto;
import com.quickbite.backend.module.faq.mapper.FaqMapper;
import com.quickbite.backend.module.faq.request.FaqRequest;
import com.quickbite.backend.module.faq.service.SuperAdminFaqService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SuperAdminFaqServiceImpl implements SuperAdminFaqService {

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

  @Override
  public FaqDto post(FaqRequest faqRequest) {
    return faqMapper.faqToFaqDto(
        faqRepository.save(faqMapper.faqRequestToFaq(faqRequest))
    );
  }

  @Override
  public FaqDto put(FaqRequest faqRequest, Integer id) {
    return null;
  }

  @Override
  public void delete(Integer id) {
    if (!faqRepository.existsById(id))
      throw ExceptionSupplier.faqExceptionSupplier().get();
    faqRepository.deleteById(id);
  }
}
