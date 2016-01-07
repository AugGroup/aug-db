package com.aug.hrdb.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

@NamedNativeQueries({
  @NamedNativeQuery(
    name = "listFamily",
    query = "select family.ID as ID,family.NAME, "
      + "family.GENDER as GENDER,family.AGE as AGE,family.TELEPHONE as TEL,family.ADDRESS as ADDRESS, "
      + "family.OCCUPATION as OCCUPATION,family.POSITION as POSITION,family.APPLICANT_ID as APPLICANT_ID, "
      + "family.MASRELATION_ID as MASRELATIONTYPE_ID,mas_relation.RELATIONTYPE as MASRELATIONTYPENAME "
      + "from FAMILY as family join MAS_RELATIONTYPE as mas_relation "
      + "on mas_relation.ID = family.MASRELATION_ID "
      + "join APPLICANT as app on app.ID = family.APPLICANT_ID "
      + "where family.APPLICANT_ID=:appId",
    resultClass = FamilyDto.class),
  @NamedNativeQuery(
    name = "SEARCH_FAMILY_ID",
    query = "select family.ID,family.NAME, "
    + "family.GENDER,family.AGE,family.TELEPHONE as TEL,family.ADDRESS, "
    + "family.OCCUPATION,family.POSITION,family.APPLICANT_ID, "
    + "family.MASRELATION_ID as MASRELATIONTYPE_ID,mas_relation.RELATIONTYPE as MASRELATIONTYPENAME "
    + " FROM FAMILY as family join MAS_RELATIONTYPE as mas_relation "
    + "on mas_relation.ID = family.MASRELATION_ID WHERE family.ID = :ID",
    resultClass = FamilyDto.class)
})
@Entity
public class FamilyDto {

  @Id
  @Column(name = "ID")
  private Integer id;

  @Column(name = "NAME")
  private String familyName;

  @Column(name = "GENDER")
  private String gender;

  @Column(name = "AGE")
  private Integer age;

  @Column(name = "TEL")
  private String mobile;

  @Column(name = "ADDRESS")
  private String address;

  @Column(name = "OCCUPATION")
  private String occupation;

  @Column(name = "POSITION")
  private String position;

  @Column(name = "APPLICANT_ID")
  private Integer appId;

  @Column(name = "MASRELATIONTYPE_ID")
  private Integer masRelationTypeId;

  @Column(name = "MASRELATIONTYPENAME")
  private String masRelationTypeName;

  @Transient
  private Integer employeeId;

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

  public Integer getAppId() {
    return appId;
  }

  public void setAppId(Integer appId) {
    this.appId = appId;
  }

  public Integer getMasRelationTypeId() {
    return masRelationTypeId;
  }

  public void setMasRelationTypeId(Integer masRelationTypeId) {
    this.masRelationTypeId = masRelationTypeId;
  }

  public String getMasRelationTypeName() {
    return masRelationTypeName;
  }

  public void setMasRelationTypeName(String masRelationTypeName) {
    this.masRelationTypeName = masRelationTypeName;
  }

  public Integer getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(Integer employeeId) {
    this.employeeId = employeeId;
  }

}