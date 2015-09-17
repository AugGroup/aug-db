package com.aug.hrdb.dto;

import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

@NamedNativeQueries({
	@NamedNativeQuery(name = "SEARCH_CERTIFICATE", query = "SELECT c.ID, c.CERTIFICATION_FORM, c.DESCRICPION, c.NAME, c.YEAR, c.APPLICANT_ID"
		+ " FROM CERTIFICATE c LEFT JOIN APPLICANT a on c.APPLICANT_ID = a.APPLICANT_ID WHERE c.APPLICANT_ID = :ID", resultClass = CertificationDto.class),
		
	@NamedNativeQuery(name = "SEARCH_CERTIFICATE_ID", query = "SELECT c.ID, c.CERTIFICATION_FORM, c.DESCRICPION, c.NAME, c.YEAR, c.APPLICANT_ID"
		+ " FROM CERTIFICATE c WHERE c.CERTIFICATE_ID = :ID", resultClass = CertificationDto.class)
	})
public class CertificationDto {
	
	private Integer id;
	
	private String certificationForm;
	
	private String descricption;
	
	private String name;
	
	private String year;
	
	private Integer applicantId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCertificationForm() {
		return certificationForm;
	}

	public void setCertificationForm(String certificationForm) {
		this.certificationForm = certificationForm;
	}

	public String getDescricption() {
		return descricption;
	}

	public void setDescricption(String descricption) {
		this.descricption = descricption;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Integer getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(Integer applicantId) {
		this.applicantId = applicantId;
	}

	

}
