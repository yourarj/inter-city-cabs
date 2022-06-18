/* (C)2022 */
package com.github.yourarj.intercitycabs.service.impl;

import com.github.yourarj.intercitycabs.entity.Booking;
import com.github.yourarj.intercitycabs.entity.Cab;
import com.github.yourarj.intercitycabs.entity.City;
import com.github.yourarj.intercitycabs.exception.InvalidCabException;
import com.github.yourarj.intercitycabs.exception.InvalidCityException;
import com.github.yourarj.intercitycabs.repo.BookingRepository;
import com.github.yourarj.intercitycabs.repo.CabRepository;
import com.github.yourarj.intercitycabs.repo.CityRepository;
import com.github.yourarj.intercitycabs.service.BookingService;
import com.github.yourarj.intercitycabs.util.CabState;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

public class BookingServiceImpl implements BookingService {
  private final BookingRepository bookingRepository;
  private final CabRepository cabRepository;
  private final CityRepository cityRepository;

  public BookingServiceImpl(
      BookingRepository bookingRepository,
      CabRepository cabRepository,
      CityRepository cityRepository) {
    this.bookingRepository = bookingRepository;
    this.cabRepository = cabRepository;
    this.cityRepository = cityRepository;
  }

  @Override
  @Transactional
  public Booking bookRide(long sourceCityId, long destinationCityId)
      throws InvalidCabException, InvalidCityException {
    final List<Cab> cabs = cabRepository.findByCityIdAndState(sourceCityId, CabState.IDLE);
    if (cabs.isEmpty()) {
      throw new InvalidCabException("No cab found for specified city");
    }

    Cab cab =
        cabs.stream().min((o1, o2) -> {
                  if (o1.getCurrentRideStart().isBefore(o2.getCurrentRideStart())) {
                    return 1;
                  } else if (o1.getCurrentRideStart().isAfter(o2.getCurrentRideStart())) {
                    return -1;
                  }
                  return 0;
                })
            .orElseThrow(() -> new InvalidCabException("No cab found for specified city"));

    if (cab.getState().equals(CabState.ON_TRIP)) {
      throw new InvalidCabException("The specified cab can't be booked!");
    }
    final City sourceCity = cab.getCity();
    final City destinationCity =
        cityRepository
            .findById(destinationCityId)
            .orElseThrow(
                () ->
                    new InvalidCityException(
                        String.format("City with id `%d` doesn't exist", destinationCityId)));
    cab.setState(CabState.ON_TRIP);
    cab.setCity(null);
    cabRepository.save(cab);
    final Booking booking = new Booking(cab, sourceCity, destinationCity);
    return bookingRepository.save(booking);
  }
}
