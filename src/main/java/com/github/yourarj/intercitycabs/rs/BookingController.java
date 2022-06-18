/* (C)2022 */
package com.github.yourarj.intercitycabs.rs;

import com.github.yourarj.intercitycabs.exception.InvalidCabException;
import com.github.yourarj.intercitycabs.exception.InvalidCityException;
import com.github.yourarj.intercitycabs.service.BookingService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/booking")
public class BookingController {
private final BookingService bookingService;

public BookingController(BookingService bookingService) {
	this.bookingService = bookingService;
}

@PutMapping(path = "/create")
protected void bookRide(
	@RequestParam final long cabId, @RequestParam final long destinationCityId)
	throws InvalidCabException, InvalidCityException {
	bookingService.bookRide(cabId, destinationCityId);
}
}
