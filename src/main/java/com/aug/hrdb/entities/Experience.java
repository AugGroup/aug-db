package com.aug.hrdb.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "EXPERIENCE")
public class Experience extends BaseEntity {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;
	
/*	@ManyToOne
	@JoinColumn(name="APPLICANT_ID")
	private Applicant applicant;
	
	@ManyToOne
	@JoinColumn(name="EMPLOYEE_ID")
	private Employee employee;*/

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "TYPE_OF_BUSINESS")
	private String typeOfBusiness;
	
	@Column(name ="COMPANY_NAME")
	private String companyName;

	@Column(name = "DATE_FROM")
	private Date dateFrom;

	@Column(name = "DATE_TO")
	private Date dateTo;

	@Column(name = "POSITION")
	private String position;

	@Column(name = "REASON")
	private String reason;

	@Column(name = "REFERENCE")
	private String reference;

	@Column(name = "RESPONSIBILITY")
	private String responsibility;

	@Column(name = "SALARY")
	private long salary;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTypeOfBusiness() {
		return typeOfBusiness;
	}

	public void setTypeOfBusiness(String typeOfBusiness) {
		this.typeOfBusiness = typeOfBusiness;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getResponsibility() {
		return responsibility;
	}

	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}
	
}
