package com.axway.cg.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.axway.cg.ResourceNotFoundException;
import com.axway.cg.domain.Flow;
import com.axway.cg.repository.FlowRepository;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/flows")
public class flowController {

	@Autowired
	private FlowRepository flowRepository;

	@GetMapping("flow")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<Flow> listAll(
			@RequestParam("flowidentifier") String flowidentifier,
			@RequestParam("flowname") String flowname,
			@RequestParam("sourceapp") String sourceapp,
			@RequestParam("targetapp") String targetapp)
			 {
		if (flowidentifier != null ) {
			if (flowname != null) {
				if(sourceapp != null) {
					if (targetapp != null) { {
								return flowRepository.search(flowidentifier, flowname, sourceapp, targetapp);
							}
						}
				}		}
			
		}
		return (List<Flow>) flowRepository.findAll();
		
		
	}

	@GetMapping("flow/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<Flow> getFlowById(@PathVariable(value = "Id") Long flowId) throws ResourceNotFoundException {
		Flow flow = flowRepository.findById(flowId)
				.orElseThrow(() -> new ResourceNotFoundException("Flow not found for this id :: " + flowId));
		return ResponseEntity.ok().body(flow);
	}

	@GetMapping
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Iterable<Flow> findByFlowidentifierAndFlownameAndSourceappAndTargetapp(
			@RequestParam("flowidentifier") String flowidentifier,
			@RequestParam("flowname") String flowname,
			@RequestParam("sourceapp") String sourceapp,
			@RequestParam("targetapp") String targetapp) {
		if (flowidentifier != null) {
			if (flowname != null) {
				if (sourceapp != null) {
					if (targetapp != null) {
								return flowRepository
										.findByFlowidentifierAndFlownameAndSourceappAndTargetapp(
												flowidentifier, flowname, sourceapp, targetapp);
					}
				}
			}

		}
		return flowRepository.findAll();

	}
	
	@GetMapping("search")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Iterable<Flow> findByFlowidentifierAndFlownameAndSourceappAndTargetappAndSenddateAndEnddate(
			@RequestParam("flowidentifier") String flowidentifier,
			@RequestParam("flowname") String flowname,
			@RequestParam("sourceapp") String sourceapp,
			@RequestParam("targetapp") String targetapp,
			@RequestParam("senddate") String senddate,
			@RequestParam("enddate") String enddate) {
		if (flowidentifier != null) {
			if (flowname != null) {
				if (sourceapp != null) {
					if (targetapp != null) {
						if (senddate != null) {
							if (enddate != null) {
								return flowRepository
										.findByFlowidentifierAndFlownameAndSourceappAndTargetappAndSenddateAndEnddate(
												flowidentifier, flowname, sourceapp, targetapp, senddate, enddate);
					}}}
				}
			}

		}
		return flowRepository.findAll();

	}
	
	
	
	
}
