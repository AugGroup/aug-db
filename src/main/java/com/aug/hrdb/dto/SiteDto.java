package com.aug.hrdb.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

import com.fasterxml.jackson.annotation.JsonFormat;


@NamedNativeQueries({
	@NamedNativeQuery(
            name = "listSite",
              query = "select site.ID,site.PROJECTNAME,site.STARTDATE,site.ENDDATE,site.PROJECTOWNER, "
              		+ "site.PROJECTOWNERCONTACT,site.EMPLOYEE_ID,emp.EMPLOYEE_CODE "
              		+ "from EMP_SITE site join EMP_EMPLOYEE emp on emp.ID=site.EMPLOYEE_ID "
              		+ "where site.EMPLOYEE_ID=:empId",
            resultClass = SiteDto.class)
  })


@Entity
public class SiteDto {
	
	
	private Integer id;
	private String projectName;
	private Date startDate;
	private Date endDate;
	private String projectOwner;
	private String  projectOwnerContact; 
    private Integer employeeId;
    private String  employeeCode;
    
    @Id
    @Column(name="ID")
	public Integer getId() {
		return id;
	}
	
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="PROJECTNAME")
	public String getProjectName() {
		return projectName;
	}
		
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	
	@Column(name="STARTDATE")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	public Date getStartDate() {
		return startDate;
	}
	
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	@Column(name="ENDDATE")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	public Date getEndDate() {
		return endDate;
	}
	
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	@Column(name="PROJECTOWNER")
	public String getProjectOwner() {
		return projectOwner;
	}
	
	
	public void setProjectOwner(String projectOwner) {
		this.projectOwner = projectOwner;
	}
	
	@Column(name="PROJECTOWNERCONTACT")
	public String getProjectOwnerContact() {
		return projectOwnerContact;
	}
	
	
	public void setProjectOwnerContact(String projectOwnerContact) {
		this.projectOwnerContact = projectOwnerContact;
	}

	@Column(name="EMPLOYEE_ID")
	public Integer getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	@Column(name="EMPLOYEE_CODE")
	public String getEmployeeCode() {
		return employeeCode;
	}


	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	
	
	

}
