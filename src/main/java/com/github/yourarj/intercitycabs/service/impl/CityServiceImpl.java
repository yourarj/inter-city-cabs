package com.github.yourarj.intercitycabs.service.impl;

import com.github.yourarj.intercitycabs.entity.City;
import com.github.yourarj.intercitycabs.repo.CityRepository;
import com.github.yourarj.intercitycabs.service.CityService;

public class CityServiceImpl implements CityService {
  private final CityRepository cityRepository;

  public CityServiceImpl(CityRepository cityRepository) {
    this.cityRepository = cityRepository;
  }

  @Override
  public City create(final String name) {
    final City city = new City(name);
    return cityRepository.save(city);
  }
}
