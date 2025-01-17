package com.comandaqr.mapstruct.mappers;

import com.comandaqr.mapstruct.dto.business.BusinessCreateDTO;
import com.comandaqr.mapstruct.dto.business.BusinessDTO;
import com.comandaqr.models.Business;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BusinessMapper {
  Business businessDtoToBusiness(BusinessDTO businessDTO);
  BusinessDTO businessToBusinessDto(Business business);
  Business businessCreateDtoToBusiness(BusinessCreateDTO businessCreateDTO);
}
