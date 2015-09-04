package com.aug.hrdb.dto;

import java.util.Date;

import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

import com.fasterxml.jackson.annotation.JsonFormat;

@NamedNativeQueries({
		@NamedNativeQuery(name = "SEARCH_EXPERIENCE", query = "SELECT e.id, e.address, e.typeOfBusiness, e.dateFrom, e.dateTo, e.position, e.reason, e.reference, e.responsibility, e.salary"
				+ " FROM EXPERIENCE e LEFT JOIN APPLICANT a on e.APPLICANT_ID = a.APPLICANT_ID WHERE e.APPLICANT_ID = :ID", resultClass = ExperienceDto.class),

		@NamedNativeQuery(name = "SEARCH_EXPERIENCE_ID", query = "SELECT e.id, e.address, e.typeOfBusiness, e.dateFrom, e.dateTo, e.position, e.reason, e.reference, e.responsibility, e.salary"
				+ " FROM EXPERIENCE e WHERE e.id = :ID", resultClass = ExperienceDto.class) })
public class ExperienceDto {
	/*@JoinColumn(name="APPLICANT_ID") private Applicant applicant;
	  @JoinColumn(name="EMPLOYEE_ID") private Employee employee;*/

	private Integer id;

	private String address;

	private String typeOfBusiness;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "en", timezone = "GMT")
	private Date dateFrom;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "en", timezone = "GMT")
	private Date dateTo;

	private String position;

	private String reason;

	private String reference;

	private String responsibility;

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
