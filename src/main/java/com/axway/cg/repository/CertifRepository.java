package com.axway.cg.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.axway.cg.domain.Certification;

@Repository
public interface CertifRepository extends PagingAndSortingRepository<Certification, Long> {

}
