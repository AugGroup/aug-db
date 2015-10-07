package com.aug.hrdb.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

@NamedNativeQueries({
	@NamedNativeQuery(name = "SEARCH_CERTIFICATE", query = "SELECT c.ID, c.CERTIFICATION_FORM, c.DESCRIPTION, c.NAME, c.YEAR, c.APPLICANT_ID"
		+ " FROM CERTIFICATION c LEFT JOIN APPLICANT a on c.APPLICANT_ID = a.ID WHERE c.APPLICANT_ID = :ID", resultClass = CertificationDto.class),
		
	@NamedNativeQuery(name = "SEARCH_CERTIFICATE_ID", query = "SELECT c.ID, c.CERTIFICATION_FORM, c.DESCRIPTION, c.NAME, c.YEAR, c.APPLICANT_ID"
		+ " FROM CERTIFICATION c WHERE c.ID = :ID", resultClass = CertificationDto.class),
		
	@NamedNativeQuery(name = "searchCertification",
					  query = "SELECT c.id, c.CERTIFICATION_FORM, c.DESCRIPTION, c.NAME, c.YEAR, c.APPLICANT_ID "
					  			+ "FROM CERTIFICATION c "	
							    + "WHERE c.applicant_id =:ID", resultClass = CertificationDto.class)	
	})


@Entity
public class CertificationDto {
	
	@Id
	@Column(name="ID")
	private Integer id;

	
	@Column(name="CERTIFICATION_FORM")
	private String certificationForm;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="YEAR")
	private String year;
	
	@Column(name="APPLICANT_ID")
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


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
