/* (C)2022 */
package com.github.yourarj.intercitycabs.repo;

import com.github.yourarj.intercitycabs.entity.Booking;
import com.github.yourarj.intercitycabs.util.CabState;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends CrudRepository<Booking, Long> {
  List<Booking> findByCabId(final long cabId);
}
