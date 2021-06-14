package com.axway.cg.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;


@Entity
@Table(name = "CURRENT_TABLE")
public class Flow {

	
	@Id
	private Long Id;
	
	@JsonFormat(pattern = "yyyy-MM-dd", shape =Shape.STRING)
	private String senddate;
	
	@JsonFormat(pattern = "HH:mm:ss", shape =Shape.STRING)
	private String sendtime;
	
	@JsonFormat(pattern = "yyyy-MM-dd", shape =Shape.STRING)
	private String enddate;
	
	
	@JsonFormat(pattern = "HH:mm:ss", shape =Shape.STRING)
	private String endtime;
	
	private String flowidentifier;
	private String flowname;
	private String priority;
	private String status;
	private String sourceapp;
	private String targetapp;
	private String filename;
	private String protocol;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getSenddate() {
		return senddate;
	}
	public void setSenddate(String senddate) {
		this.senddate = senddate;
	}
	public String getSendtime() {
		return sendtime;
	}
	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	
	public String getFlowname() {
		return flowname;
	}
	public void setFlowname(String flowname) {
		this.flowname = flowname;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public String getSourceapp() {
		return sourceapp;
	}
	public void setSourceapp(String sourceapp) {
		this.sourceapp = sourceapp;
	}
	public String getTargetapp() {
		return targetapp;
	}
	public void setTargetapp(String targetapp) {
		this.targetapp = targetapp;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFlowidentifier() {
		return flowidentifier;
	}
	public void setFlowidentifier(String flowidentifier) {
		this.flowidentifier = flowidentifier;
	}
	
	
	
	
	
}
