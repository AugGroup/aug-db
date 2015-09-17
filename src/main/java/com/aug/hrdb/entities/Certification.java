package com.aug.hrdb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.aug.hrdb.entities.Certification;
import com.aug.hrdb.entities.Employee;
import com.aug.hrdb.dto.CertificationDto;

@Entity
@Table(name = "CERTIFICATION")
public class Certification extends BaseEntity {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "CERTIFICATION_FORM")
	private String certificationForm;
	
	@Column(name = "DESCRICPION")
	private String descricption;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "YEAR")
	private String year;

	@ManyToOne
	@JoinColumn(name = "APPLICANT_ID")
	private Applicant applicant;
	
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

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}
	
public Certification fromCertificationDto(Certification certification, CertificationDto certificationDto) {
		
//		Certification certification = new Certification();
		
//		certification.setId(certificationDto.getId());
		certification.setYear(certificationDto.getYear());
		certification.setName(certificationDto.getName());
		/*certification.setCertificationFrom(certificationDto.getCertificationFrom());
		certification.setDescription(certificationDto.getDescription());*/

		Applicant applicant = new Applicant();
		applicant.setId(certificationDto.getId());
		certification.setApplicant(applicant);
		
		return certification;
	}

	public CertificationDto toCertificationDto() {

		CertificationDto certificationDto = new CertificationDto();
		
		certificationDto.setId(this.id);
		certificationDto.setYear(this.year);
		certificationDto.setName(this.name);
		/*certificationDto.setCertificationFrom(this.certificationFrom);
		certificationDto.setDescription(this.description);
		certificationDto.setEmployeeId(this.employee.getId());*/
		
		return certificationDto;
	}


}
