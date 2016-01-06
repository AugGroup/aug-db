package com.aug.hrdb.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

@NamedNativeQueries({
  @NamedNativeQuery(
    name = "findEmployeeCode",
    query = "select  e.id,e.EMPLOYEE_CODE "
      + "from employee emp join employee e on e.id = emp.id "
      + "and e.id = (select max(emp.id) "
      + "from employee emp join mas_location l on l.id=emp.location_id and l.id=:location_id "
      + "order by emp.CREATEDTIMESTAMP desc ) ",
    resultClass = EmployeeCodeDto.class)
})

@Entity
public class EmployeeCodeDto {

  @Id
  @Column(name = "ID")
  private Integer id;

  @Column(name = "EMPLOYEE_CODE")
  private String employeeCode;

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

}
