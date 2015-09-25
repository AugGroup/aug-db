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
	
	
	private Integer id;
	private String congenitalDisease;
	private String congenitalDiseaseExplain;
	private String congenitalDiseaseExplain2;
	private String congenitalDiseaseExplain3;
	private String geneticDisease;
	private String geneticDiseaseExplain;
	private String geneticDiseaseExplain2;
	private String geneticDiseaseExplain3;
	private String takeMedicine;
	private String takeMedicineExplain;
	private String intolerance;
	private String intoleranceExplain;
	private Integer employeeId;
	private String employeeCode;
	private String congenitalDiseaseSpecified;
	
	@Id
	@Column(name="ID")
	public Integer getId() {
		return id;
	}
	
	
	public void setId(Integer id) {
		this.id = id;
	}

	
	@Column(name="CONGENITAL_DISEASE")
	public String getCongenitalDisease() {
		return congenitalDisease;
	}
	
	
	public void setCongenitalDisease(String congenitalDisease) {
		this.congenitalDisease = congenitalDisease;
	}
	
	@Column(name="CONGENITAL_DISEASE_SPECIFIED1")
	public String getCongenitalDiseaseExplain() {
		return congenitalDiseaseExplain;
	}
	
	
	public void setCongenitalDiseaseExplain(String congenitalDiseaseExplain) {
		this.congenitalDiseaseExplain = congenitalDiseaseExplain;
	}
	
	
	@Column(name="CONGENITAL_DISEASE_SPECIFIED2")
	public String getCongenitalDiseaseExplain2() {
		return congenitalDiseaseExplain2;
	}


	public void setCongenitalDiseaseExplain2(String congenitalDiseaseExplain2) {
		this.congenitalDiseaseExplain2 = congenitalDiseaseExplain2;
	}


	@Column(name="CONGENITAL_DISEASE_SPECIFIED3")
	public String getCongenitalDiseaseExplain3() {
		return congenitalDiseaseExplain3;
	}


	public void setCongenitalDiseaseExplain3(String congenitalDiseaseExplain3) {
		this.congenitalDiseaseExplain3 = congenitalDiseaseExplain3;
	}

	
	@Column(name="GENETIC_DISEASE")
	public String getGeneticDisease() {
		return geneticDisease;
	}


	public void setGeneticDisease(String geneticDisease) {
		this.geneticDisease = geneticDisease;
	}

	
	@Column(name="GENETIC_DISEASE_SPECIFIED1")
	public String getGeneticDiseaseExplain() {
		return geneticDiseaseExplain;
	}


	public void setGeneticDiseaseExplain(String geneticDiseaseExplain) {
		this.geneticDiseaseExplain = geneticDiseaseExplain;
	}

	
	@Column(name="GENETIC_DISEASE_SPECIFIED2")
	public String getGeneticDiseaseExplain2() {
		return geneticDiseaseExplain2;
	}


	public void setGeneticDiseaseExplain2(String geneticDiseaseExplain2) {
		this.geneticDiseaseExplain2 = geneticDiseaseExplain2;
	}

	
	@Column(name="GENETIC_DISEASE_SPECIFIED3")
	public String getGeneticDiseaseExplain3() {
		return geneticDiseaseExplain3;
	}


	public void setGeneticDiseaseExplain3(String geneticDiseaseExplain3) {
		this.geneticDiseaseExplain3 = geneticDiseaseExplain3;
	}


	@Column(name="TAKE_MEDICINE")
	public String getTakeMedicine() {
		return takeMedicine;
	}
	
	
	public void setTakeMedicine(String takeMedicine) {
		this.takeMedicine = takeMedicine;
	}
	
	@Column(name="TAKE_MEDICINE_EXPLAIN")
	public String getTakeMedicineExplain() {
		return takeMedicineExplain;
	}
	
	
	public void setTakeMedicineExplain(String takeMedicineExplain) {
		this.takeMedicineExplain = takeMedicineExplain;
	}
	
	@Column(name="INTOLERANCE")
	public String getIntolerance() {
		return intolerance;
	}
	
	
	public void setIntolerance(String intolerance) {
		this.intolerance = intolerance;
	}
	
	@Column(name="INTOLERANCE_EXPLAIN")
	public String getIntoleranceExplain() {
		return intoleranceExplain;
	}
	
	
	public void setIntoleranceExplain(String intoleranceExplain) {
		this.intoleranceExplain = intoleranceExplain;
	}


	
	@Column(name="EMPLOYEE_ID")
	public Integer getEmployeeId() {
		return employeeId;
	}
	
	
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	
	@Column(name="EMPLOYEE_CODE")
	public String getEmployeeCode() {
		return employeeCode;
	}
	
	
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	
	
	@Column(name="CONGENITAL_DISEASE_SPECIFIED")
	public String getCongenitalDiseaseSpecified() {
		return congenitalDiseaseSpecified;
	}


	public void setCongenitalDiseaseSpecified(String congenitalDiseaseSpecified) {
		this.congenitalDiseaseSpecified = congenitalDiseaseSpecified;
	}
	
	
	

	
	
	

}
