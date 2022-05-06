package com.quickbite.backend.module.faq.service;

import com.quickbite.backend.common.entity.Faq;
import com.quickbite.backend.common.repository.FaqRepository;
import com.quickbite.backend.common.response.CollectionResponse;
import com.quickbite.backend.common.service.CrudService;
import com.quickbite.backend.common.util.CollectionResponseFactory;
import com.quickbite.backend.module.faq.dto.FaqDto;
import com.quickbite.backend.module.faq.mapper.FaqMapper;
import com.quickbite.backend.module.faq.request.FaqRequest;
import com.quickbite.backend.module.faq.response.FaqResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FaqService implements CrudService<FaqResponse, Faq, FaqDto, FaqRequest> {

  private final FaqRepository faqRepository;
  private final FaqMapper mapper;

  @Override
  public FaqResponse getEntity(Integer id) {
    return new FaqResponse()
        .setFaq(mapper.faqToFaqDto(faqRepository.getById(id)));
  }

  @Override
  public CollectionResponse<FaqDto> getEntities() {
    return CollectionResponseFactory.buildResponse(
        mapper.faqListToFaqDtoList(faqRepository.findAll())
    );
  }

  @Override
  public FaqResponse createEntity(FaqRequest request) {
    Faq faq = init(request, new Faq());
    faqRepository.save(faq);
    return new FaqResponse().setFaq(mapper.faqToFaqDto(faq));
  }

  @Override
  public FaqResponse updateEntity(FaqRequest request, Integer id) {
    Faq faq = init(request, faqRepository.getById(id));
    faqRepository.save(faq);
    return new FaqResponse().setFaq(mapper.faqToFaqDto(faq));
  }

  @Override
  public FaqResponse deleteEntity(Integer id) {
    Faq faq = faqRepository.getById(id);
    faqRepository.delete(faq);
    return new FaqResponse().setFaq(mapper.faqToFaqDto(faq));
  }

  @Override
  public Faq init(FaqRequest request, Faq entity) {
    return entity
        .setAnswer(request.getAnswer())
        .setQuestion(request.getQuestion());
  }
}
