package com.github.yourarj.intercitycabs.repo;

import com.github.yourarj.intercitycabs.entity.Booking;
import com.github.yourarj.intercitycabs.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface BookingRepository extends CrudRepository<Booking, Long> {
}
