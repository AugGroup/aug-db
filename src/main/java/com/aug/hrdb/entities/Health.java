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
@Table(name="HEALTH")
public class Health extends BaseEntity{
	
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
	private Employee employee;
	
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	public Integer getId() {
		return id;
	}
	
	
	public void setId(Integer id) {
		this.id = id;
	}

	
	@Column(name="CONGENITAL_DISEASE",nullable=false)
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

	
	@Column(name="GENETIC_DISEASE",nullable=false)
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


	@Column(name="TAKE_MEDICINE",nullable=false)
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
	
	@Column(name="INTOLERANCE",nullable=false)
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


	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="EMPLOYEE_ID",nullable=false)
	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	
	
	

}
