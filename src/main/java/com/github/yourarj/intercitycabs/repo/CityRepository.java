package com.github.yourarj.intercitycabs.repo;

import com.github.yourarj.intercitycabs.entity.City;
import com.github.yourarj.intercitycabs.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Long> {
}
