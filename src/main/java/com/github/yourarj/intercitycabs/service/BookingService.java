/* (C)2022 */
package com.github.yourarj.intercitycabs.service;

import com.github.yourarj.intercitycabs.exception.InvalidCabException;
import com.github.yourarj.intercitycabs.exception.InvalidCityException;

public interface BookingService {
void bookRide(final long cabId, final long destinationCityId)
	throws InvalidCabException, InvalidCityException;
}
