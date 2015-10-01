package com.aug.hrdb.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

import com.aug.hrdb.entities.Applicant;
import com.fasterxml.jackson.annotation.JsonFormat;

@NamedNativeQueries({
		@NamedNativeQuery(name = "SEARCH_EXPERIENCE", query = "SELECT exp.ID, exp.ADDRESS, exp.TYPE_OF_BUSINESS, exp.APPLICANT_ID, exp.COMPANY_NAME, exp.DATE_FROM, exp.DATE_TO, "
				+ "null as DATE_FORM, null as DATE_TO, exp.POSITION, exp.REASON, exp.REFERENCE, exp.RESPONSIBILITY, exp.SALARY, exp.DATE_WORK "
				+ "FROM EXPERIENCE exp LEFT JOIN APPLICANT a on exp.APPLICANT_ID = a.ID WHERE exp.APPLICANT_ID = :ID", resultClass = ExperienceDto.class),

		@NamedNativeQuery(name = "SEARCH_EXPERIENCE_ID", query = "SELECT exp.ID, exp.ADDRESS, exp.TYPE_OF_BUSINESS, exp.APPLICANT_ID, exp.COMPANY_NAME, exp.DATE_FROM, exp.DATE_TO, "
				+ "null as DATE_FORM, null as DATE_TO, exp.POSITION, exp.REASON, exp.REFERENCE, exp.RESPONSIBILITY, exp.SALARY, exp.DATE_WORK "
				+ "FROM EXPERIENCE exp WHERE exp.id = :ID", resultClass = ExperienceDto.class),

		@NamedNativeQuery(name = "searchExperience", query = "SELECT exp.id, "
				+ "exp.address, "
				+ "exp.type_of_Business, "
				+ "exp.date_from, "
				+ "exp.date_to, "
				+ "exp.position, "
				+ "exp.reason, "
				+ "exp.reference, "
				+ "exp.responsibility, "
				+ "exp.salary, "
				+ "null as DATE_WORK "
				+ "exp.company_name, "
				+ "exp.applicant_id "
				+ "FROM EXPERIENCE as exp "
				+ "inner join employee as emp "
				+ "on emp.id=:ID and exp.applicant_id = emp.applicant_id", resultClass = ExperienceDto.class) })
@Entity
public class ExperienceDto {
	
	@Column(name="APPLICANT_ID")
	private Integer applicantId;
	@Id
	private Integer id;

	private String address;
	@Column(name = "TYPE_OF_BUSINESS")
	private String typeOfBusiness;
	@Column(name = "DATE_FROM")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dateFrom;
	@Column(name = "DATE_TO")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dateTo;

	private String position;

	private String reason;

	private String reference;

	private String responsibility;
	@Column(name = "COMPANY_NAME")
	private String companyName;

	private long salary;
	
	@Column(name= "DATE_WORK")
	private String applyDateStr;

	public Integer getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(Integer applicantId) {
		this.applicantId = applicantId;
	}

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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public long getSalary() {
		return salary;
	}

	public String getApplyDateStr() {
		return applyDateStr;
	}

	public void setApplyDateStr(String applyDateStr) {
		this.applyDateStr = applyDateStr;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}
	
}
