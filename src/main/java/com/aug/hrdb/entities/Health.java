package com.aug.hrdb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "HEALTH")
public class Health extends BaseEntity {

  @Id
  @GeneratedValue
  @Column(name = "ID")
  private Integer id;

  @Column(name = "CONGENITAL_DISEASE", nullable = false)
  private String congenitalDisease;

  @Column(name = "CONGENITAL_DISEASE_SPECIFIED1")
  private String congenitalDiseaseExplain;

  @Column(name = "CONGENITAL_DISEASE_SPECIFIED2")
  private String congenitalDiseaseExplain2;

  @Column(name = "CONGENITAL_DISEASE_SPECIFIED3")
  private String congenitalDiseaseExplain3;

  @Column(name = "GENETIC_DISEASE", nullable = false)
  private String geneticDisease;

  @Column(name = "GENETIC_DISEASE_SPECIFIED1")
  private String geneticDiseaseExplain;

  @Column(name = "GENETIC_DISEASE_SPECIFIED2")
  private String geneticDiseaseExplain2;

  @Column(name = "GENETIC_DISEASE_SPECIFIED3")
  private String geneticDiseaseExplain3;

  @Column(name = "TAKE_MEDICINE", nullable = false)
  private String takeMedicine;

  @Column(name = "TAKE_MEDICINE_EXPLAIN")
  private String takeMedicineExplain;

  @Column(name = "INTOLERANCE", nullable = false)
  private String intolerance;

  @Column(name = "INTOLERANCE_EXPLAIN")
  private String intoleranceExplain;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "EMPLOYEE_ID", nullable = false)
  private Employee employee;

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

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

}