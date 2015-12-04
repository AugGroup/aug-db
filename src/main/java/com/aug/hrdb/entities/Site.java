package com.aug.hrdb.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="SITE")
public class Site extends BaseEntity{
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Integer id;
	
	@Column(name="PROJECTNAME",nullable=false)
	@NotEmpty
	private String projectName;
	
	@Column(name="STARTDATE",nullable=false)
	private Date startDate;
	
	@Column(name="ENDDATE",nullable=false)
	private Date endDate;
	
	@Column(name="PROJECTOWNER",nullable=false)
	@NotEmpty
	private String projectOwner;
	
	@Column(name="PROJECTOWNERCONTACT",nullable=false)
	@NotEmpty
	private String  projectOwnerContact;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEE_ID", nullable = false)
    private Employee employee;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	

	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	
	
	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
	
	public String getProjectOwner() {
		return projectOwner;
	}
	public void setProjectOwner(String projectOwner) {
		this.projectOwner = projectOwner;
	}
	
	

	public String getProjectOwnerContact() {
		return projectOwnerContact;
	}
	
	
	public void setProjectOwnerContact(String projectOwnerContact) {
		this.projectOwnerContact = projectOwnerContact;
	}
	
	
	
	public Employee getEmployee() {
		return employee;
	}
	
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	

}
