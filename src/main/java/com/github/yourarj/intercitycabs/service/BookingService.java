/* (C)2022 */
package com.github.yourarj.intercitycabs.service;

import com.github.yourarj.intercitycabs.entity.Booking;
import com.github.yourarj.intercitycabs.exception.InvalidBookingException;
import com.github.yourarj.intercitycabs.exception.InvalidCabException;
import com.github.yourarj.intercitycabs.exception.InvalidCityException;

public interface BookingService {
    Booking bookRide(final long sourceCityId, final long destinationCityId)
            throws InvalidCabException, InvalidCityException;

    Booking bookRideWithExternalCityId(final String sourceCityExternalId, final String destinationCityExternalId)
            throws InvalidCabException, InvalidCityException;

    void endRide(final long bookingId) throws InvalidBookingException;

    Iterable<Booking> getAll();
}
