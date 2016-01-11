package com.aug.hrdb.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

@NamedNativeQueries({
  @NamedNativeQuery(
    name = "searchPasswordByEmail",
    query = "SELECT emp.id, app.email , log.password , log.username FROM login as log,applicant as app," +
      "employee as emp WHERE emp.id = log.EMPLOYEE_ID AND app.id=emp.APPLICANT_ID AND app.email = :EMAIL",
    resultClass = LoginForgotDto.class),
})

@Entity
public class LoginForgotDto {

  @Id
  @Column(name = "ID")
  private Integer id;

  @Column(name = "email")
  private String email;

  @Column(name = "password")
  private String password;

  @Column(name = "username")
  private String username;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

}