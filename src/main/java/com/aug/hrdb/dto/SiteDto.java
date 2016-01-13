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
    query = "select site.ID,site.PROJECTNAME,site.STARTDATE,site.ENDDATE,site.PROJECTOWNER, site.PROJECTOWNERCONTACT,"
      + "site.EMPLOYEE_ID,emp.EMPLOYEE_CODE from SITE site join EMPLOYEE emp on emp.ID=site.EMPLOYEE_ID "
      + "where site.EMPLOYEE_ID=:empId",
    resultClass = SiteDto.class)
})
@Entity
public class SiteDto {

  @Id
  @Column(name = "ID")
  private Integer id;

  @Column(name = "PROJECTNAME")
  private String projectName;

  @Column(name = "STARTDATE")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
  private Date startDate;

  @Column(name = "ENDDATE")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
  private Date endDate;

  @Column(name = "PROJECTOWNER")
  private String projectOwner;

  @Column(name = "PROJECTOWNERCONTACT")
  private String projectOwnerContact;

  @Column(name = "EMPLOYEE_ID")
  private Integer employeeId;

  @Column(name = "EMPLOYEE_CODE")
  private String employeeCode;

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

  public Integer getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(Integer employeeId) {
    this.employeeId = employeeId;
  }

  public String getEmployeeCode() {
    return employeeCode;
  }

  public void setEmployeeCode(String employeeCode) {
    this.employeeCode = employeeCode;
  }

}