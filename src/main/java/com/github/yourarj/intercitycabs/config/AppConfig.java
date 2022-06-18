package com.github.yourarj.intercitycabs.config;

import com.github.yourarj.intercitycabs.repo.BookingRepository;
import com.github.yourarj.intercitycabs.repo.CabRepository;
import com.github.yourarj.intercitycabs.repo.CityRepository;
import com.github.yourarj.intercitycabs.service.BookingService;
import com.github.yourarj.intercitycabs.service.CityService;
import com.github.yourarj.intercitycabs.service.impl.BookingServiceImpl;
import com.github.yourarj.intercitycabs.service.impl.CityServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Bean
  protected BookingService bookingService(
      BookingRepository bookingRepository,
      CabRepository cabRepository,
      CityRepository cityRepository) {
    return new BookingServiceImpl(bookingRepository, cabRepository, cityRepository);
  }

  @Bean
  protected CityService cityService(CityRepository cityRepository) {
    return new CityServiceImpl(cityRepository);
  }
}
