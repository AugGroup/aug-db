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
	
	private Integer id;
	private String name;
	private Boolean isActive;
	private String code;
	//private Set<Employee> employee = new HashSet<Employee>();
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	public Integer getId() {
		return id;
	}
	
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="STAFFTYPENAME",nullable=false)
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Column(name="ISACTIVE",nullable=false)
	public Boolean getIsActive() {
		return isActive;
	}
	
	
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	@Column(name="CODE")
	public String getCode() {
		return code;
	}
	
	
	public void setCode(String code) {
		this.code = code;
	}
	

    /*@OneToMany(fetch = FetchType.LAZY, mappedBy = "masStaffType")
	public Set<Employee> getEmployee() {
		return employee;
	}


	public void setEmployee(Set<Employee> employee) {
		this.employee = employee;
	}*/
	
	

}
