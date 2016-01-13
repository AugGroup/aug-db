package com.aug.hrdb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.aug.hrdb.dto.RewardDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "REWARD")
public class Reward extends BaseEntity {

  @Id
  @Column(name = "ID")
  @GeneratedValue
  private Integer id;

  @Column(name = "TYPE_REWARD", nullable = false)
  @NotEmpty
  private String typeReward;

  @Column(name = "YEAR", nullable = false)
  @NotEmpty
  private String year;

  @NotEmpty
  @Column(name = "NAME")
  private String name;

  @Column(name = "REASON", nullable = true)
  private String reason;

  @Column(name = "ISACTIVE", nullable = true)
  private Boolean isActive;

  @ManyToOne()
  @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "id", nullable = false)
  @JsonIgnore
  private Employee employee;

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

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
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

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  public RewardDto toRewardDto() {
    RewardDto rewardDto = new RewardDto();
    rewardDto.setId(this.id);
    rewardDto.setTypeReward(this.typeReward);
    rewardDto.setYear(this.year);
    rewardDto.setReason(this.reason);
    rewardDto.setIsActive(this.isActive);
    rewardDto.setEmployeeId(this.employee.getId());

    return rewardDto;

  }

  public Reward fromRewardDto(Reward reward, RewardDto rewardDto) {
    reward.setId(rewardDto.getId());
    reward.setTypeReward(rewardDto.getTypeReward());
    reward.setYear(rewardDto.getYear());
    reward.setReason(rewardDto.getReason());
    reward.setIsActive(rewardDto.getIsActive());

    Employee employee = new Employee();
    employee.setId(rewardDto.getEmployeeId());
    reward.setEmployee(employee);

    return reward;

  }

}