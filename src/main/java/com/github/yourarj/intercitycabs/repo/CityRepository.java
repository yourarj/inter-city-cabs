/* (C)2022 */
package com.github.yourarj.intercitycabs.repo;

import com.github.yourarj.intercitycabs.entity.City;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CityRepository extends CrudRepository<City, Long> {
    Optional<City> findByCityName(final String cityName);
}
