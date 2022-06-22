/* (C)2022 */
package com.github.yourarj.intercitycabs.rs;

import com.github.yourarj.intercitycabs.entity.Cab;
import com.github.yourarj.intercitycabs.exception.InvalidCityException;
import com.github.yourarj.intercitycabs.service.CabService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cab")
public class CabController {
    private final CabService cabService;

    public CabController(CabService cabService) {
        this.cabService = cabService;
    }

    @PutMapping("/create")
    protected Cab createCab(@RequestParam("registrationCode") final String registrationCode, @RequestParam("initialCity") final String externalCityId) throws InvalidCityException {
        return cabService.create(registrationCode, externalCityId);
    }
}
