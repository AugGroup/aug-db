package com.aug.hrdb.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="MAS_STAFFTYPE")
public class MasStaffType extends BaseEntity{
	
	@Id @GeneratedValue @Column(name="ID")
	private Integer id;
	
	@Column(name="STAFFTYPENAME",nullable=false)
	private String name;
	
	@Column(name="ISACTIVE",nullable=false)
	private Boolean isActive;
	
	@Column(name="CODE")
	private String code;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "masStaffType")
	private List<Employee> employees;

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

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
}