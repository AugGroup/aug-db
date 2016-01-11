/**
 * @author Preeyaporn
 * @date 12 พ.ค. 2558
 */
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

import com.aug.hrdb.dto.HistoryDto;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "HISTORY")
public class History extends BaseEntity {

  @Id
  @Column(name = "ID")
  @GeneratedValue
  private Integer id;

  @Column(name = "POSITION", nullable = false)
  private String position;

  @Column(name = "SALARY", nullable = false)
  private Double salary;

  @Column(name = "OLD_SALARY")
  private Double oldSalary;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
  @Column(name = "DATE_OF_ADJUSTMENT", nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateOfAdjustment;

  @Column(name = "REASON_OF_ADJUSTMENT")
  private String reasonOfAdjustment;

  @Column(name = "ADJUSTMENT_TIME")
  private Integer adjustmentTime;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "id", nullable = false)
  private Employee employee;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public Double getSalary() {
    return salary;
  }

  public void setSalary(Double salary) {
    this.salary = salary;
  }

  public Double getOldSalary() {
    return oldSalary;
  }

  public void setOldSalary(Double oldSalary) {
    this.oldSalary = oldSalary;
  }

  public Date getDateOfAdjustment() {
    return dateOfAdjustment;
  }

  public void setDateOfAdjustment(Date dateOfAdjustment) {
    this.dateOfAdjustment = dateOfAdjustment;
  }

  public String getReasonOfAdjustment() {
    return reasonOfAdjustment;
  }

  public void setReasonOfAdjustment(String reasonOfAdjustment) {
    this.reasonOfAdjustment = reasonOfAdjustment;
  }

  public Integer getAdjustmentTime() {
    return adjustmentTime;
  }

  public void setAdjustmentTime(Integer adjustmentTime) {
    this.adjustmentTime = adjustmentTime;
  }

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

	/*---------------------- DTO ----------------------*/

  public HistoryDto toHistoryDto() {
    HistoryDto historyDto = new HistoryDto();
    historyDto.setId(this.id);
    historyDto.setPosition(this.position);
    historyDto.setSalary(this.salary);
    historyDto.setOldSalary(this.oldSalary);
    historyDto.setDateOfAdjustment(this.dateOfAdjustment);
    historyDto.setReasonOfAdjustment(this.reasonOfAdjustment);
    historyDto.setAdjustmentTime(this.adjustmentTime);
    historyDto.setCreatedBy(this.getCreatedBy());
    historyDto.setCreatedTimeStamp(this.getCreatedTimeStamp());
    historyDto.setEmployeeId(this.employee.getId());

    return historyDto;

  }

  public History fromHistoryDto(HistoryDto historyDto) {
    History history = new History();
    history.setId(historyDto.getId());
    history.setPosition(historyDto.getPosition());
    history.setSalary(historyDto.getSalary());
    history.setOldSalary(historyDto.getOldSalary());
    history.setDateOfAdjustment(historyDto.getDateOfAdjustment());
    history.setReasonOfAdjustment(historyDto.getReasonOfAdjustment());
    history.setAdjustmentTime(historyDto.getAdjustmentTime());
    history.setCreatedBy(historyDto.getCreatedBy());
    history.setCreatedTimeStamp(historyDto.getCreatedTimeStamp());

    Employee employee = new Employee();
    employee.setId(historyDto.getEmployeeId());
    history.setEmployee(employee);

    return history;

  }

}