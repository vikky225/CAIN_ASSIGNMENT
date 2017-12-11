package com.unico.gcdrswebservice.repository;

import com.unico.gcdrswebservice.domain.GCD;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface GCDRepository extends CrudRepository<GCD, Long> {
}
