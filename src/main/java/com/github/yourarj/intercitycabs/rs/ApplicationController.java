/* (C)2022 */
package com.github.yourarj.intercitycabs.rs;

import com.github.yourarj.intercitycabs.exception.InvalidCabException;
import com.github.yourarj.intercitycabs.exception.InvalidCityException;
import com.github.yourarj.intercitycabs.service.ApplicationService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/app")
public class ApplicationController {
  private final ApplicationService applicationService;

  public ApplicationController(ApplicationService applicationService) {
    this.applicationService = applicationService;
  }

  @PutMapping(path = "/initialize")
  protected void bookRide(@RequestParam("initialState") final String initialState) {
    applicationService.initializeApplicationState(initialState);
  }
}
