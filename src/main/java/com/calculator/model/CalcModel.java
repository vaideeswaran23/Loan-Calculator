package com.calculator.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LoanCalulator")
public class CalcModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String ssn;
	private String dob;
	private int principal;
	private int rate;
	private int term;
	private String type;
	private double arp;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public int getPrincipal() {
		return principal;
	}
	public void setPrincipal(int principal) {
		this.principal = principal;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getArp() {
		return arp;
	}
	public void setArp(double arp) {
		this.arp = arp;
	}
	@Override
	public String toString() {
		return "CalcModel [id=" + id + ", name=" + name + ", ssn=" + ssn + ", dob=" + dob + ", principal=" + principal
				+ ", rate=" + rate + ", term=" + term + ", type=" + type + ", arp=" + arp + "]";
	}
	
}
