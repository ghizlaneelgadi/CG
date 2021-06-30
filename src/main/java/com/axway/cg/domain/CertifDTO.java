package com.axway.cg.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import javax.persistence.Id;

public class CertifDTO {
 
	
	@Id
	private String Id;
	private String Root;
	private String iNum;
	private String T;
	private String S;
	private String C;
	private String K;
	private String E;
	
	@JsonFormat(pattern = "yyyy-MM-dd", shape =Shape.STRING)
	private String Exp_Date;
	
	private String Delivered_to;
	private String Delivered_by;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getRoot() {
		return Root;
	}
	public void setRoot(String root) {
		Root = root;
	}
	public String getiNum() {
		return iNum;
	}
	public void setiNum(String iNum) {
		this.iNum = iNum;
	}
	public String getT() {
		return T;
	}
	public void setT(String t) {
		T = t;
	}
	public String getS() {
		return S;
	}
	public void setS(String s) {
		S = s;
	}
	public String getC() {
		return C;
	}
	public void setC(String c) {
		C = c;
	}
	public String getK() {
		return K;
	}
	public void setK(String k) {
		K = k;
	}
	public String getE() {
		return E;
	}
	public void setE(String e) {
		E = e;
	}
	public String getExp_Date() {
		return Exp_Date;
	}
	public void setExp_Date(String exp_Date) {
		Exp_Date = exp_Date;
	}
	public String getDelivered_to() {
		return Delivered_to;
	}
	public void setDelivered_to(String delivered_to) {
		Delivered_to = delivered_to;
	}
	public String getDelivered_by() {
		return Delivered_by;
	}
	public void setDelivered_by(String delivered_by) {
		Delivered_by = delivered_by;
	}
	
	
	
}
