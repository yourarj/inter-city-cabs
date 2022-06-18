package com.github.yourarj.intercitycabs.repo;

import com.github.yourarj.intercitycabs.entity.Cab;
import com.github.yourarj.intercitycabs.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface CabRepository extends CrudRepository<Cab, Long> {
}
