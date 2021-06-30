package com.axway.cg.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axway.cg.domain.Certification;

@Repository
public interface CertificationRepository extends CrudRepository<Certification, Long> {

}
