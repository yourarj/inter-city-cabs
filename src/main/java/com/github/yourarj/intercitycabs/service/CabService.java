/* (C)2022 */
package com.github.yourarj.intercitycabs.service;

import com.github.yourarj.intercitycabs.entity.Cab;
import com.github.yourarj.intercitycabs.exception.InvalidCityException;

public interface CabService {
    Cab create(final String registrationCode, String externalCityId) throws InvalidCityException;
}
