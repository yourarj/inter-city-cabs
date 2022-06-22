package com.github.yourarj.intercitycabs.service.impl;

import com.github.yourarj.intercitycabs.entity.Cab;
import com.github.yourarj.intercitycabs.entity.City;
import com.github.yourarj.intercitycabs.repo.CabRepository;
import com.github.yourarj.intercitycabs.repo.CityRepository;
import com.github.yourarj.intercitycabs.service.ApplicationService;
import com.github.yourarj.intercitycabs.util.CabState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;

public class ApplicationServiceImpl implements ApplicationService {
  private final CityRepository cityRepository;
  private final CabRepository cabRepository;

  private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationServiceImpl.class);

  public ApplicationServiceImpl(CityRepository cityRepository, CabRepository cabRepository) {
    this.cityRepository = cityRepository;
    this.cabRepository = cabRepository;
  }

  @Override
  public void initializeApplicationState(String applicationStateString) {
    applicationStateString
        .lines()
        .forEach(
            entry -> {
              LOGGER.info("Processing entry '{}", entry);
              final String[] entryParts = entry.split(",");
              if (entryParts.length != 3) {
                LOGGER.error("Skipping invalid entry: '{}'", entry);
                throw new InputMismatchException("Input doesn't match expected format");
              }

              final String cabId = entryParts[0].trim();
              final CabState cabState = CabState.valueOf(entryParts[1].trim());
              final String cityId = entryParts[2].trim();

              final City city =
                  cityRepository
                      .findByCityName(cityId)
                      .orElseGet(
                          () -> {
                            City newCity = new City(cityId);
                            return cityRepository.save(newCity);
                          });

              final Cab cab =
                  cabRepository
                      .findByRegistrationCode(cabId)
                      .orElseGet(
                          () -> {
                            Cab newCab = new Cab(cabId, city);
                            return cabRepository.save(newCab);
                          });

              cab.setCity(city);
              cab.setState(cabState);

              cabRepository.save(cab);
            });
  }
}
