package com.aug.hrdb.entities;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;


@Entity
@Table(name="SKILLLANGUAGE")

public class SkillLanguage extends BaseEntity{
	
	private Integer id;
	@Column(name="NAMELANGUAGE")
	private String  nameLanguage;
	@Column(name="SPEAKING")
	private String  speaking;
	@Column(name="READING")
	private String  reading;
	@Column(name="UNDERSTANDING")
	private String  understanding;
	@Column(name="WRITING")
	private String  writing;
	//private Employee employee;
	
	
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}


	public String getNameLanguage() {
		return nameLanguage;
	}

	public void setNameLanguage(String nameLanguage) {
		this.nameLanguage = nameLanguage;
	}

	
	public String getSpeaking() {
		return speaking;
	}

	

	public void setSpeaking(String speaking) {
		this.speaking = speaking;
	}

	
	public String getReading() {
		return reading;
	}

	public void setReading(String reading) {
		this.reading = reading;
	}


	public String getUnderstanding() {
		return understanding;
	}

	public void setUnderstanding(String understanding) {
		this.understanding = understanding;
	}

	
	public String getWriting() {
		return writing;
	}

	public void setWriting(String writing) {
		this.writing = writing;
	}
	
	
		
	

	/*@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="EMPLOYEE_ID",nullable=false)
	public Employee getEmployee() {
		return employee;
	}

	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	*/

	
	

	
	

}
