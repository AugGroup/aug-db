package com.aug.hrdb.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

@NamedNativeQueries({
  @NamedNativeQuery(
    name = "searchEmployee",
    query = "select emp.ID as ID,emp.employee_code as EMPLOYEE_CODE,app.FIRSTNAME_EN as NAME_ENG,app.LASTNAME_EN as SURNAME_ENG, "
      + "app.CARD_ID as CARD_ID  "
      + "from employee as emp, applicant as app "
      + "where emp.applicant_id = app.id "
      + "order by emp.id asc",
    resultClass = EmployeeListDto.class),

  @NamedNativeQuery(
    name = "searchEmpForUniqueIdCard",
    query = "select emp.ID as ID,emp.employee_code as EMPLOYEE_CODE,app.FIRSTNAME_EN as NAME_ENG,app.LASTNAME_EN as SURNAME_ENG, "
      + "app.CARD_ID as CARD_ID  "
      + "from employee as emp join applicant as app on emp.applicant_id = app.id "
      + "where emp.id !=:empId and app.CARD_ID =:idcard",
    resultClass = EmployeeListDto.class)
})

@Entity
public class EmployeeListDto {

  @Id
  @Column(name = "ID")
  private Integer id;

  @Column(name = "EMPLOYEE_CODE")
  private String employeeCode;

  @Column(name = "NAME_ENG")
  private String nameEng;

  @Column(name = "SURNAME_ENG")
  private String surnameEng;

  @Column(name = "CARD_ID")
  private String cardId;

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

  public String getNameEng() {
    return nameEng;
  }

  public void setNameEng(String nameEng) {
    this.nameEng = nameEng;
  }

  public String getSurnameEng() {
    return surnameEng;
  }

  public void setSurnameEng(String surnameEng) {
    this.surnameEng = surnameEng;
  }

  public String getCardId() {
    return cardId;
  }

  public void setCardId(String cardId) {
    this.cardId = cardId;
  }

}
