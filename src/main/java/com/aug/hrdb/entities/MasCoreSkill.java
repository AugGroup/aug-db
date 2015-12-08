package com.aug.hrdb.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "MAS_CORESKILL")
public class MasCoreSkill extends BaseEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "NAME",nullable=false)
	private String name;
	
	@Column(name = "CODE")
	private String code;
	
	@Column(name = "ISACTIVE",nullable=true)
	private Boolean isActive;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "masCoreSkill", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Employee> employees;
	
	@JsonIgnore
	@OneToMany(mappedBy="coreSkill",fetch=FetchType.LAZY)
	private List<Applicant> applicants;
	
	@JsonIgnore
	@OneToMany(mappedBy="masCoreSkill")
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

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Applicant> getApplicants() {
		return applicants;
	}

	public void setApplicants(List<Applicant> applicants) {
		this.applicants = applicants;
	}

	public List<CareerCase> getCareerCases() {
		return careerCases;
	}

	public void setCareerCases(List<CareerCase> careerCases) {
		this.careerCases = careerCases;
	}
	
}
