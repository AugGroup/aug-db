package com.aug.hrdb.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

@NamedNativeQueries({
  @NamedNativeQuery(
    name = "listHealth",
    query = "select health.ID,health.CONGENITAL_DISEASE,health.CONGENITAL_DISEASE_SPECIFIED1,health.CONGENITAL_DISEASE_SPECIFIED2,health.CONGENITAL_DISEASE_SPECIFIED3,"
      + "health.GENETIC_DISEASE,health.GENETIC_DISEASE_SPECIFIED1,health.GENETIC_DISEASE_SPECIFIED2,health.GENETIC_DISEASE_SPECIFIED3,"
      + "health.TAKE_MEDICINE,health.TAKE_MEDICINE_EXPLAIN,health.INTOLERANCE,health.INTOLERANCE_EXPLAIN,health.EMPLOYEE_ID,emp.EMPLOYEE_CODE,"
      + "( CASE "
      + "WHEN CONGENITAL_DISEASE_SPECIFIED1!=''&&CONGENITAL_DISEASE_SPECIFIED2=''&&CONGENITAL_DISEASE_SPECIFIED3='' THEN CONGENITAL_DISEASE_SPECIFIED1 "
      + "WHEN CONGENITAL_DISEASE_SPECIFIED1!=''&&CONGENITAL_DISEASE_SPECIFIED2!=''&&CONGENITAL_DISEASE_SPECIFIED3=''  THEN CONCAT(CONGENITAL_DISEASE_SPECIFIED1,', ',CONGENITAL_DISEASE_SPECIFIED2) "
      + "WHEN CONGENITAL_DISEASE_SPECIFIED1!=''&&CONGENITAL_DISEASE_SPECIFIED2!=''&&CONGENITAL_DISEASE_SPECIFIED3!=''  THEN CONCAT(CONGENITAL_DISEASE_SPECIFIED1,', ',CONGENITAL_DISEASE_SPECIFIED2,', ',CONGENITAL_DISEASE_SPECIFIED3) "
      + "WHEN CONGENITAL_DISEASE_SPECIFIED1=''&&CONGENITAL_DISEASE_SPECIFIED2!=''&&CONGENITAL_DISEASE_SPECIFIED3=''  THEN CONGENITAL_DISEASE_SPECIFIED2 "
      + "WHEN CONGENITAL_DISEASE_SPECIFIED1=''&&CONGENITAL_DISEASE_SPECIFIED2!=''&&CONGENITAL_DISEASE_SPECIFIED3!=''  THEN CONCAT(CONGENITAL_DISEASE_SPECIFIED2,', ',CONGENITAL_DISEASE_SPECIFIED3) "
      + "WHEN CONGENITAL_DISEASE_SPECIFIED1!=''&&CONGENITAL_DISEASE_SPECIFIED2=''&&CONGENITAL_DISEASE_SPECIFIED3!=''  THEN CONCAT(CONGENITAL_DISEASE_SPECIFIED1,', ',CONGENITAL_DISEASE_SPECIFIED3) "
      + "WHEN CONGENITAL_DISEASE_SPECIFIED1=''&&CONGENITAL_DISEASE_SPECIFIED2=''&&CONGENITAL_DISEASE_SPECIFIED3!=''  THEN CONGENITAL_DISEASE_SPECIFIED3 "
      + "ELSE '' "
      + "END ) AS CONGENITAL_DISEASE_SPECIFIED "
      + "from  HEALTH  health join EMPLOYEE emp on health.EMPLOYEE_ID=emp.ID "
      + "where health.EMPLOYEE_ID=:empId",
    resultClass = HealthDto.class)
})

@Entity
public class HealthDto {

  @Id
  @Column(name = "ID")
  private Integer id;

  @Column(name = "CONGENITAL_DISEASE")
  private String congenitalDisease;

  @Column(name = "CONGENITAL_DISEASE_SPECIFIED1")
  private String congenitalDiseaseExplain;

  @Column(name = "CONGENITAL_DISEASE_SPECIFIED2")
  private String congenitalDiseaseExplain2;

  @Column(name = "CONGENITAL_DISEASE_SPECIFIED3")
  private String congenitalDiseaseExplain3;

  @Column(name = "GENETIC_DISEASE")
  private String geneticDisease;

  @Column(name = "GENETIC_DISEASE_SPECIFIED1")
  private String geneticDiseaseExplain;

  @Column(name = "GENETIC_DISEASE_SPECIFIED2")
  private String geneticDiseaseExplain2;

  @Column(name = "GENETIC_DISEASE_SPECIFIED3")
  private String geneticDiseaseExplain3;

  @Column(name = "TAKE_MEDICINE")
  private String takeMedicine;

  @Column(name = "TAKE_MEDICINE_EXPLAIN")
  private String takeMedicineExplain;

  @Column(name = "INTOLERANCE")
  private String intolerance;

  @Column(name = "INTOLERANCE_EXPLAIN")
  private String intoleranceExplain;

  @Column(name = "EMPLOYEE_ID")
  private Integer employeeId;

  @Column(name = "EMPLOYEE_CODE")
  private String employeeCode;

  @Column(name = "CONGENITAL_DISEASE_SPECIFIED")
  private String congenitalDiseaseSpecified;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCongenitalDisease() {
    return congenitalDisease;
  }

  public void setCongenitalDisease(String congenitalDisease) {
    this.congenitalDisease = congenitalDisease;
  }

  public String getCongenitalDiseaseExplain() {
    return congenitalDiseaseExplain;
  }

  public void setCongenitalDiseaseExplain(String congenitalDiseaseExplain) {
    this.congenitalDiseaseExplain = congenitalDiseaseExplain;
  }

  public String getCongenitalDiseaseExplain2() {
    return congenitalDiseaseExplain2;
  }

  public void setCongenitalDiseaseExplain2(String congenitalDiseaseExplain2) {
    this.congenitalDiseaseExplain2 = congenitalDiseaseExplain2;
  }

  public String getCongenitalDiseaseExplain3() {
    return congenitalDiseaseExplain3;
  }

  public void setCongenitalDiseaseExplain3(String congenitalDiseaseExplain3) {
    this.congenitalDiseaseExplain3 = congenitalDiseaseExplain3;
  }

  public String getGeneticDisease() {
    return geneticDisease;
  }

  public void setGeneticDisease(String geneticDisease) {
    this.geneticDisease = geneticDisease;
  }

  public String getGeneticDiseaseExplain() {
    return geneticDiseaseExplain;
  }

  public void setGeneticDiseaseExplain(String geneticDiseaseExplain) {
    this.geneticDiseaseExplain = geneticDiseaseExplain;
  }

  public String getGeneticDiseaseExplain2() {
    return geneticDiseaseExplain2;
  }

  public void setGeneticDiseaseExplain2(String geneticDiseaseExplain2) {
    this.geneticDiseaseExplain2 = geneticDiseaseExplain2;
  }

  public String getGeneticDiseaseExplain3() {
    return geneticDiseaseExplain3;
  }

  public void setGeneticDiseaseExplain3(String geneticDiseaseExplain3) {
    this.geneticDiseaseExplain3 = geneticDiseaseExplain3;
  }

  public String getTakeMedicine() {
    return takeMedicine;
  }

  public void setTakeMedicine(String takeMedicine) {
    this.takeMedicine = takeMedicine;
  }

  public String getTakeMedicineExplain() {
    return takeMedicineExplain;
  }

  public void setTakeMedicineExplain(String takeMedicineExplain) {
    this.takeMedicineExplain = takeMedicineExplain;
  }

  public String getIntolerance() {
    return intolerance;
  }

  public void setIntolerance(String intolerance) {
    this.intolerance = intolerance;
  }

  public String getIntoleranceExplain() {
    return intoleranceExplain;
  }

  public void setIntoleranceExplain(String intoleranceExplain) {
    this.intoleranceExplain = intoleranceExplain;
  }

  public Integer getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(Integer employeeId) {
    this.employeeId = employeeId;
  }

  public String getEmployeeCode() {
    return employeeCode;
  }

  public void setEmployeeCode(String employeeCode) {
    this.employeeCode = employeeCode;
  }

  public String getCongenitalDiseaseSpecified() {
    return congenitalDiseaseSpecified;
  }

  public void setCongenitalDiseaseSpecified(String congenitalDiseaseSpecified) {
    this.congenitalDiseaseSpecified = congenitalDiseaseSpecified;
  }

}