package com.aug.hrdb.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="MAS_TECHNOLOGY")
public class MasTechnology extends BaseEntity {
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Integer id;
	
	@Column(name="NAME" ,nullable=false)
	private String name;
	
	@Column(name = "CODE" ,nullable = false)
	private String code;
	
	@Column(name = "ISACTIVE" ,nullable = false)
	private Boolean isActive;

	@JsonIgnore
	@OneToMany(mappedBy="technology",fetch=FetchType.LAZY)
	private Set<Applicant> applicants = new HashSet<Applicant>();
	
	@JsonIgnore
	@OneToMany(mappedBy="masTechnology")
	private List<CareerCase> careerCases;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Set<Applicant> getApplicants() {
		return applicants;
	}

	public void setApplicants(Set<Applicant> applicants) {
		this.applicants = applicants;
	}

	public List<CareerCase> getCareerCases() {
		return careerCases;
	}

	public void setCareerCases(List<CareerCase> careerCases) {
		this.careerCases = careerCases;
	}
	
}
