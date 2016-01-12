package com.aug.hrdb.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

import com.aug.hrdb.dto.PunishDto;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "PUNISH")
public class Punish extends BaseEntity {

  @Id
  @GeneratedValue
  @Column(name = "ID")
  private Integer id;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
  @Column(name = "DATEPUNISH", nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date datePunish;

  @Column(name = "DESCRIPTION", nullable = false)
  @NotEmpty
  private String description;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "id", nullable = true)
  private Employee employee;

  @Column(name = "PENALTY", nullable = false)
  @NotEmpty
  private String penalty;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Date getDatePunish() {
    return datePunish;
  }

  public void setDatePunish(Date datePunish) {
    this.datePunish = datePunish;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  public String getPenalty() {
    return penalty;
  }

  public void setPenalty(String penalty) {
    this.penalty = penalty;
  }

  public PunishDto toPunishDto() {
    PunishDto punishDto = new PunishDto();
    punishDto.setId(this.id);
    punishDto.setDatePunish(this.datePunish);
    punishDto.setDescription(this.description);
    punishDto.setPenalty(this.penalty);
    punishDto.setEmployeeId(this.getId());
    return punishDto;
  }

  public Punish fromPunishDto(Punish punish, PunishDto punishDto) {
    punish.setId(punishDto.getId());
    punish.setDatePunish(punishDto.getDatePunish());
    punish.setDescription(punishDto.getDescription());
    punish.setPenalty(punishDto.getPenalty());

    Employee employee = new Employee();
    employee.setId(punishDto.getEmployeeId());
    punish.setEmployee(employee);
    return punish;

  }
	
}