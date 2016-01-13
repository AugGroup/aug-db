package com.aug.hrdb.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

@NamedNativeQueries({
  @NamedNativeQuery(
    name = "searchReward",
    query = "select reward.id, reward.type_reward, reward.year, reward.reason, reward.isActive, reward.employee_id ,"
      + "reward.name from reward as reward,employee as emp where reward.employee_id =:empId and reward.employee_id=emp.id",
    resultClass = RewardDto.class)
})
@Entity
public class RewardDto {

  @Id
  @Column(name = "ID")
  private Integer id;

  @Column(name = "TYPE_REWARD")
  private String typeReward;

  @Column(name = "YEAR")
  private String year;

  @Column(name = "REASON")
  private String reason;

  @Column(name = "ISACTIVE")
  private Boolean isActive;

  @Column(name = "EMPLOYEE_ID")
  private Integer employeeId;

  @Column(name = "NAME")
  private String name;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTypeReward() {
    return typeReward;
  }

  public void setTypeReward(String typeReward) {
    this.typeReward = typeReward;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public Boolean getIsActive() {
    return isActive;
  }

  public void setIsActive(Boolean active) {
    isActive = active;
  }

  public Integer getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(Integer employeeId) {
    this.employeeId = employeeId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}