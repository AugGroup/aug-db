/**
 * @author natechanok
 * @date Apr 30, 2015
 */
package com.aug.hrdb.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

import com.fasterxml.jackson.annotation.JsonFormat;

@NamedNativeQueries({
  @NamedNativeQuery(
    name = "insertOfficial",
    query = "insert into OFFICIAL(OFFICIAL_DATE, START_WORK_DATE, END_WORK_DATE, POSITION_APPLIED_FOR, "
      + "SALARY_EXPECTED, PROBATION_DATE, createdTimeStamp, createdBy, auditFlag) values (:OFFICIAL_DATE, "
      + ":START_WORK_DATE, :END_WORK_DATE, :POSITION_APPLIED_FOR,"
      + ":SALARY_EXPECTED, :PROBATION_DATE, NOW(), 0, 'C')",
    resultClass = Official.class),

  @NamedNativeQuery(
    name = "searchIdEmpToOfficial",
    query = "select * from OFFICIAL ORDER BY ID desc LIMIT 1;",
    resultClass = Official.class),

  @NamedNativeQuery(
    name = "updateOfficial",
    query = "update OFFICIAL set OFFICIAL_DATE =:OFFICIAL_DATE, START_WORK_DATE =:START_WORK_DATE, "
      + "END_WORK_DATE =:END_WORK_DATE, POSITION_APPLIED_FOR =:POSITION_APPLIED_FOR, "
      + "SALARY_EXPECTED =:SALARY_EXPECTED, PROBATION_DATE =:PROBATION_DATE, updatedTimeStamp = NOW(), "
      + "updatedBy =:updatedBy, auditFlag ='U' where ID =:ID",
    resultClass = Official.class),
})
@Entity
@Table(name = "OFFICIAL", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class Official extends BaseEntity {

  @Id
  @GeneratedValue
  @Column(name = "ID")
  private Integer id;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yyyy")
  @Column(name = "START_WORK_DATE")
  private Date startWorkDate;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yyyy")
  @Column(name = "END_WORK_DATE")
  private Date endWorkDate;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yyyy")
  @Column(name = "PROBATION_DATE")
  private Date probationDate;

  @OneToOne(fetch = FetchType.LAZY, mappedBy = "official")
  private Applicant applicant;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Date getStartWorkDate() {
    return startWorkDate;
  }

  public void setStartWorkDate(Date startWorkDate) {
    this.startWorkDate = startWorkDate;
  }

  public Date getEndWorkDate() {
    return endWorkDate;
  }

  public void setEndWorkDate(Date endWorkDate) {
    this.endWorkDate = endWorkDate;
  }

  public Date getProbationDate() {
    return probationDate;
  }

  public void setProbationDate(Date probationDate) {
    this.probationDate = probationDate;
  }

  public Applicant getApplicant() {
    return applicant;
  }

  public void setApplicant(Applicant applicant) {
    this.applicant = applicant;
  }

}