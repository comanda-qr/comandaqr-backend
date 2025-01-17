package com.comandaqr.services;

import com.comandaqr.models.Business;
import com.comandaqr.models.User;
import com.comandaqr.repositories.BusinessRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
@AllArgsConstructor
public class BusinessService {
  private final BusinessRepository repository;

  public Business createBusiness(Business business, User owner) {
    business.setOwner(owner);
    return repository.save(business);
  }

  public Page<Business> findAllBusinesses(Pageable pageable) {
    return repository.findAll(pageable);
  }

  public Business findBusiness(UUID id) throws ResponseStatusException {
    return repository.findById(id).orElseThrow(
        () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
    );
  }

  public void deleteBusiness(UUID id) throws ResponseStatusException {
    Business business = findBusiness(id);
    repository.delete(business);
  }
}
