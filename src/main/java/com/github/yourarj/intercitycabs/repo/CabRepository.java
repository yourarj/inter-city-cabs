/* (C)2022 */
package com.github.yourarj.intercitycabs.repo;

import com.github.yourarj.intercitycabs.entity.Cab;
import com.github.yourarj.intercitycabs.entity.City;
import com.github.yourarj.intercitycabs.util.CabState;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CabRepository extends CrudRepository<Cab, Long> {
    List<Cab> findByCityIdAndState(final long cityId, final CabState cabState);
}
