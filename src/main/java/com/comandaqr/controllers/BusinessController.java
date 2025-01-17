package com.comandaqr.controllers;

import com.comandaqr.infra.security.TokenService;
import com.comandaqr.mapstruct.dto.business.BusinessCreateDTO;
import com.comandaqr.mapstruct.dto.business.BusinessDTO;
import com.comandaqr.mapstruct.mappers.BusinessMapper;
import com.comandaqr.models.Business;
import com.comandaqr.models.User;
import com.comandaqr.services.BusinessService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/business")
@AllArgsConstructor
public class BusinessController {
  private final BusinessService service;
  private final BusinessMapper mapper;
  private final TokenService tokenService;

  @PostMapping("/create")
  public ResponseEntity<BusinessDTO> createBusiness(
      @RequestBody BusinessCreateDTO request,
      @RequestHeader(HttpHeaders.AUTHORIZATION) String bearerToken
  ) {
    User owner = tokenService.extractUser(bearerToken);
    Business business = mapper.businessCreateDtoToBusiness(request);
    business = service.createBusiness(business, owner);

    BusinessDTO response = mapper.businessToBusinessDto(business);
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }
}
