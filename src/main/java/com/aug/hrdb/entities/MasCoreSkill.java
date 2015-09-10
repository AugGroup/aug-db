package com.aug.hrdb.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


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
	
	/*@ManyToOne(fetch=FetchType.EAGER)
	 @JoinColumn(name="OFFICIAL_ID" , referencedColumnName="id")
	 private Official official;*/
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "masCoreSkill", cascade=CascadeType.ALL, orphanRemoval=true)
	private Set<Employee> employees = new HashSet<Employee>();
	
	@ManyToOne
	@JoinColumn(name="APPLICANT_ID")
	private Applicant applicant;
	
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
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	public Applicant getApplicant() {
		return applicant;
	}
	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}


	
	
}
