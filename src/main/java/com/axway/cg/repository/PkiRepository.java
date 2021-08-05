package com.axway.cg.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axway.cg.domain.Pki;

@Repository
public interface PkiRepository extends CrudRepository<Pki, String>{

}
