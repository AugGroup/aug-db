package com.aug.hrdb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import com.aug.db.entities.Applicant;
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

	/*@ManyToOne
	@JoinColumn(name = "APPLICANT_ID")
	private Applicant applicant;
	*/
	
	/*@ManyToOne
	@JoinColumn(name = "EMPLOYEE_ID")
	private Applicant employee;
	*/
	
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
	


}
