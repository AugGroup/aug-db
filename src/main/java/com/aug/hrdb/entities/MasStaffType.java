package com.aug.hrdb.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="MAS_STAFFTYPE")
public class MasStaffType extends BaseEntity{
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Integer id;
	@Column(name="STAFFTYPENAME",nullable=false)
	private String name;
	@Column(name="ISACTIVE",nullable=false)
	private Boolean isActive;
	@Column(name="CODE")
	private String code;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "masStaffType")
	private Set<Employee> employee = new HashSet<Employee>();
	
	
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
	

    
	public Set<Employee> getEmployee() {
		return employee;
	}


	public void setEmployee(Set<Employee> employee) {
		this.employee = employee;
	}
	
	

}
