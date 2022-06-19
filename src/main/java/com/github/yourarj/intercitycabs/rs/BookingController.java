/* (C)2022 */
package com.github.yourarj.intercitycabs.rs;

import com.github.yourarj.intercitycabs.entity.Booking;
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
  protected Booking bookRide(
      @RequestParam("sourceCityId") final String sourceCityId, @RequestParam("destinationCityId") final String destinationCityId)
      throws InvalidCabException, InvalidCityException {
    return bookingService.bookRideWithExternalCityId(sourceCityId, destinationCityId);
  }
}
