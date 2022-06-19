package com.github.yourarj.intercitycabs.service.impl;

import com.github.yourarj.intercitycabs.entity.Cab;
import com.github.yourarj.intercitycabs.repo.CabRepository;
import com.github.yourarj.intercitycabs.service.CabService;

public class CabServiceImpl implements CabService {
  private final CabRepository cabRepository;

  public CabServiceImpl(CabRepository cabRepository) {
    this.cabRepository = cabRepository;
  }

  @Override
  public Cab create(final String registrationCode) {
    final Cab cab = new Cab(registrationCode);
    return cabRepository.save(cab);
  }
}
