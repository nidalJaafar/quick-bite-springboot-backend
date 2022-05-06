package com.quickbite.backend.module.faq.mapper;

import com.quickbite.backend.common.entity.Faq;
import com.quickbite.backend.module.faq.dto.FaqDto;
import java.util.List;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface FaqMapper {

  Faq faqDtoToFaq(FaqDto faqDto);

  FaqDto faqToFaqDto(Faq faq);

  List<FaqDto> faqListToFaqDtoList(List<Faq> faqList);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateFaqFromFaqDto(
      FaqDto faqDto, @MappingTarget Faq faq);
}
