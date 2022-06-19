/* (C)2022 */
package com.github.yourarj.intercitycabs.service;

import com.github.yourarj.intercitycabs.entity.Cab;

public interface CabService {
    Cab create(final String registrationCode);
}
