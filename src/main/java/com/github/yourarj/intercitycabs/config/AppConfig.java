package com.github.yourarj.intercitycabs.config;

import com.github.yourarj.intercitycabs.repo.BookingRepository;
import com.github.yourarj.intercitycabs.repo.CabRepository;
import com.github.yourarj.intercitycabs.repo.CityRepository;
import com.github.yourarj.intercitycabs.service.ApplicationService;
import com.github.yourarj.intercitycabs.service.BookingService;
import com.github.yourarj.intercitycabs.service.CabService;
import com.github.yourarj.intercitycabs.service.CityService;
import com.github.yourarj.intercitycabs.service.impl.ApplicationServiceImpl;
import com.github.yourarj.intercitycabs.service.impl.BookingServiceImpl;
import com.github.yourarj.intercitycabs.service.impl.CabServiceImpl;
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

  @Bean
  protected CabService cabService(CabRepository cabRepository, CityRepository cityRepository) {
    return new CabServiceImpl(cabRepository, cityRepository);
  }

  @Bean
  protected ApplicationService applicationService(CityRepository cityRepository, CabRepository cabRepository) {
    return new ApplicationServiceImpl(cityRepository, cabRepository);
  }
}
