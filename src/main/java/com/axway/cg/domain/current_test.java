package com.axway.cg.domain;





import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
public class current_test {
	
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
	private String protocol;
	private String sourceapp;
	private String targetapp;
	private String filename;
	
	
	public String getSendtime() {
		return sendtime;
	}
	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
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
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getFlowidentifier() {
		return flowidentifier;
	}
	public void setFlowidentifier(String flowidentifier) {
		this.flowidentifier = flowidentifier;
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
	@Override
	public String toString() {
		return "current_test [Id=" + Id + ", senddate=" + senddate + ", sendtime=" + sendtime + ", enddate=" + enddate
				+ ", endtime=" + endtime + ", flowidentifier=" + flowidentifier + ", flowname=" + flowname
				+ ", priority=" + priority + ", status=" + status + ", protocol=" + protocol + ", sourceapp="
				+ sourceapp + ", targetapp=" + targetapp + ", filename=" + filename + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
