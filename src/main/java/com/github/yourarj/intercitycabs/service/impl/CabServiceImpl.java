package com.github.yourarj.intercitycabs.service.impl;

import com.github.yourarj.intercitycabs.entity.Cab;
import com.github.yourarj.intercitycabs.entity.City;
import com.github.yourarj.intercitycabs.exception.InvalidCityException;
import com.github.yourarj.intercitycabs.repo.CabRepository;
import com.github.yourarj.intercitycabs.repo.CityRepository;
import com.github.yourarj.intercitycabs.service.CabService;

public class CabServiceImpl implements CabService {
  private final CabRepository cabRepository;
  private final CityRepository cityRepository;

  public CabServiceImpl(CabRepository cabRepository, CityRepository cityRepository) {
    this.cabRepository = cabRepository;
    this.cityRepository = cityRepository;
  }

  @Override
  public Cab create(final String registrationCode, String externalCityId) throws InvalidCityException {
    final City initialCity = cityRepository.findByCityName(externalCityId).orElseThrow(() -> new InvalidCityException(
            String.format("City with external id `%s` doesn't exist", externalCityId)));
    final Cab cab = new Cab(registrationCode, initialCity);
    return cabRepository.save(cab);
  }
}
