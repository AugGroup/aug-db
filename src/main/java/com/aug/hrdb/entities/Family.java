package com.aug.hrdb.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FAMILY")
public class Family extends BaseEntity implements Serializable {

  @Id
  @GeneratedValue
  @Column(name = "ID", length = 6)
  private Integer id;

  @Column(name = "NAME", nullable = false)
  private String familyName;

  @Column(name = "GENDER", length = 10, nullable = false)
  private String gender;

  @Column(name = "AGE", length = 3, nullable = false)
  private Integer age;

  @Column(name = "TELEPHONE", length = 14, nullable = false)
  private String mobile;

  @Column(name = "ADDRESS", nullable = false)
  private String address;

  @Column(name = "OCCUPATION")
  private String occupation;

  @Column(name = "POSITION")
  private String position;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "MASRELATION_ID", nullable = false)
  private MasRelationType masRelationType;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "APPLICANT_ID", nullable = false)
  private Applicant applicant;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFamilyName() {
    return familyName;
  }

  public void setFamilyName(String familyName) {
    this.familyName = familyName;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getOccupation() {
    return occupation;
  }

  public void setOccupation(String occupation) {
    this.occupation = occupation;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public MasRelationType getMasRelationType() {
    return masRelationType;
  }

  public void setMasRelationType(MasRelationType masRelationType) {
    this.masRelationType = masRelationType;
  }

  public Applicant getApplicant() {
    return applicant;
  }

  public void setApplicant(Applicant applicant) {
    this.applicant = applicant;
  }

}