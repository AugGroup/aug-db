package com.aug.hrdb.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

@NamedNativeQueries({
  @NamedNativeQuery(
    name = "reportStatusEmployee",
    query = "Select emp.id, "
      + "emp.EMPLOYEE_CODE as employeeCode, "
//      + "DATE_FORMAT(official.START_WORK_DATE,'%d-%m-%Y') as startWorkDate, "
      + "app.LASTNAME_EN  as lastEng, "
      + "app.FIRSTNAME_EN  as nameEng, "
      + "DATE_FORMAT(app.BIRTHDATE,'%d-%m-%Y') as dateOfBirth, "
      + "app.AGE as age, "
      + "staff.STAFFTYPENAME as statusStaff, "
//      + "site.PROJECTOWNER as projectOwner, "
//      + "DATE_FORMAT(site.STARTDATE,'%d-%m-%Y') as startDate, "
//      + "DATE_FORMAT(site.ENDDATE,'%d-%m-%Y') as endDate, "
      + "TIMESTAMPDIFF(YEAR, app.BIRTHDATE, now() ) as year, "
      + "TIMESTAMPDIFF(MONTH, app.BIRTHDATE, now() ) % 12 as month, "
      + "FLOOR(TIMESTAMPDIFF( DAY, app.BIRTHDATE, now() ) % 30.4375 ) as day "
//      + "TIMESTAMPDIFF(YEAR, official.start_work_date, now() ) as yearwork, "
//      + "TIMESTAMPDIFF(MONTH, official.start_work_date, now() ) % 12 as monthwork, "
//      + "FLOOR(TIMESTAMPDIFF( DAY,official.start_work_date, now() ) % 30.4375 ) as daywork  "
      + "from EMPLOYEE as emp  "
      + "join applicant as app on emp.applicant_id = app.id "
//      + "join SITE as site on site.employee_ID = emp.ID "
//      + "join OFFICIAL as official on app.OFFICIAL_ID = OFFICIAL.ID "
      + "join MAS_STAFFTYPE as staff on staff.ID = emp.STAFFTYPE_ID "
      + "where staff.STAFFTYPENAME like :statusStaff",
    resultClass = ReportStatusEmployeeDto.class)
})

@Entity
public class ReportStatusEmployeeDto {

  @Id
  @Column(name = "ID")
  private Integer id;

  @Column(name = "employeeCode")
  private String employeeCode;

  @Column(name = "lastEng")
  private String lastEng;

  @Column(name = "nameEng")
  private String nameEng;

  @Column(name = "dateOfBirth")
  private String dateOfBirth;

  @Column(name = "age")
  private Integer age;

//  @Column(name = "projectOwner")
//  private String projectOwner;

//  @Column(name = "startWorkDate")
//  private String startWorkDate;

//  @Column(name = "startDate")
//  private String startDate;

//  @Column(name = "endDate")
//  private String endDate;

  @Column(name = "year")
  private Integer year;

  @Column(name = "month")
  private Integer month;

  @Column(name = "day")
  private Integer day;

//  @Column(name = "yearwork")
//  private Integer yearwork;
//
//  @Column(name = "monthwork")
//  private Integer monthwork;
//
//  @Column(name = "daywork")
//  private Integer daywork;

  @Column(name = "statusStaff")
  private String statusStaff;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getEmployeeCode() {
    return employeeCode;
  }

  public void setEmployeeCode(String employeeCode) {
    this.employeeCode = employeeCode;
  }

  public String getLastEng() {
    return lastEng;
  }

  public void setLastEng(String lastEng) {
    this.lastEng = lastEng;
  }

  public String getNameEng() {
    return nameEng;
  }

  public void setNameEng(String nameEng) {
    this.nameEng = nameEng;
  }

  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

//  public String getProjectOwner() {
//    return projectOwner;
//  }
//
//  public void setProjectOwner(String projectOwner) {
//    this.projectOwner = projectOwner;
//  }

//  public String getStartWorkDate() {
//    return startWorkDate;
//  }
//
//  public void setStartWorkDate(String startWorkDate) {
//    this.startWorkDate = startWorkDate;
//  }

//  public String getStartDate() {
//    return startDate;
//  }
//
//  public void setStartDate(String startDate) {
//    this.startDate = startDate;
//  }
//
//  public String getEndDate() {
//    return endDate;
//  }
//
//  public void setEndDate(String endDate) {
//    this.endDate = endDate;
//  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public Integer getMonth() {
    return month;
  }

  public void setMonth(Integer month) {
    this.month = month;
  }

  public Integer getDay() {
    return day;
  }

  public void setDay(Integer day) {
    this.day = day;
  }

//  public Integer getYearwork() {
//    return yearwork;
//  }
//
//  public void setYearwork(Integer yearwork) {
//    this.yearwork = yearwork;
//  }
//
//  public Integer getMonthwork() {
//    return monthwork;
//  }
//
//  public void setMonthwork(Integer monthwork) {
//    this.monthwork = monthwork;
//  }
//
//  public Integer getDaywork() {
//    return daywork;
//  }
//
//  public void setDaywork(Integer daywork) {
//    this.daywork = daywork;
//  }

  public String getStatusStaff() {
    return statusStaff;
  }

  public void setStatusStaff(String statusStaff) {
    this.statusStaff = statusStaff;
  }

}
