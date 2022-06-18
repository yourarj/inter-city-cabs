/* (C)2022 */
package com.github.yourarj.intercitycabs.service.impl;

import com.github.yourarj.intercitycabs.entity.Cab;
import com.github.yourarj.intercitycabs.entity.City;
import com.github.yourarj.intercitycabs.exception.InvalidCabException;
import com.github.yourarj.intercitycabs.exception.InvalidCityException;
import com.github.yourarj.intercitycabs.repo.BookingRepository;
import com.github.yourarj.intercitycabs.repo.CabRepository;
import com.github.yourarj.intercitycabs.repo.CityRepository;
import com.github.yourarj.intercitycabs.service.BookingService;
import com.github.yourarj.intercitycabs.util.CabState;

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
public void bookRide(long cabId, long destinationCityId)
	throws InvalidCabException, InvalidCityException {
	final Cab cab = cabRepository.findById(cabId).orElseThrow(() -> new InvalidCabException(cabId));
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
}
}
