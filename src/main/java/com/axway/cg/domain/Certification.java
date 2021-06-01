package com.axway.cg.domain;



import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
public class Certification {
	
	@Id
	private Long Id_Cert;
	private String state;
	@JsonFormat(pattern = "yyyy-MM-dd", shape =Shape.STRING)
	private String exp_Date;
	private Long time_left;
	
	
	public Long getId_Cert() {
		return Id_Cert;
	}
	public void setId_Cert(Long id_Cert) {
		Id_Cert = id_Cert;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getExp_Date() {
		return exp_Date;
	}
	public void setExp_Date(String exp_Date) {
		this.exp_Date = exp_Date;
	}
	public Long getTime_left() {
		return time_left;
	}
	public void setTime_left(Long time_left) {
		this.time_left = time_left;
	}
	@Override
	public String toString() {
		return "Certification [Id_Cert=" + Id_Cert + ", state=" + state + ", exp_Date=" + exp_Date + ", time_left="
				+ time_left + "]";
	}
	
	
	
	
	
	

}
