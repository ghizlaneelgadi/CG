package com.axway.cg.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.axway.cg.domain.Flow;



public interface FlowRepository extends CrudRepository<Flow, Serializable>{
	List<Flow> findByFlowidentifier(String flowidentifier);
	List<Flow> findByFlowname(String flowname);
	List<Flow> findBySourceapp(String sourceapp);
	List<Flow> findByTargetapp(String targetapp);
	List<Flow> findByFlowidentifierAndFlowname(String flowidentifier, String flowname);
	List<Flow> findByFlowidentifierAndFlownameAndSourceappAndTargetapp(String flowidentifier, String flowname, String sourceapp, String targetapp);
	List<Flow> findByFlowidentifierAndFlownameAndSourceappAndTargetappAndSenddateAndEnddate(String flowidentifier, String flowname, String senddate, String enddate, String sourceapp, String targetapp);

	
	@Query("SELECT f FROM Flow f WHERE lower(f.flowidentifier) LIKE lower(concat('%',?1,'%'))"
			+ "AND lower(f.flowname) LIKE lower(concat('%',?2,'%'))"
			+ "AND lower(f.sourceapp) LIKE lower(concat('%',?3,'%'))"
			+ "AND lower(f.targetapp) LIKE lower(concat('%',?4,'%'))"
			+ "AND f.senddate LIKE %?5%"
			+ "AND f.enddate LIKE %?6%")
	public List<Flow> search(String flowidentifier, String flowname, String sourceapp, String targetapp, String senddate, String enddate);
	
	
}
