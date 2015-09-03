package com.aug.hrdb.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;



 @NamedNativeQueries({
	@NamedNativeQuery(
            name = "listSkillLanguage",
              query = "select language.ID as ID,employee.ID as EMPLOYEE_ID,employee.EMPLOYEE_CODE as EMPLOYEE_CODE,maslanguage.ID as MAS_SKILLLANGUAGEID,maslanguage.SKILL_LANGUAGE as MAS_SKILLLANGUAGENAME,language.SPEAKINGSKILL as SPEAKKING,"
            		+ "language.READINGSKILL as READING,language.UNDERSTANDINDSKILL as UNDERSTANDDING,language.WRITINGSKILL as WRITING  from EMP_SKILLLANGUAGE as language join EMP_EMPLOYEE as employee"
            		+ " on employee.ID=language.EMPLOYEE_ID"
            		+ " join MAS_SKILLLANGUAGE as maslanguage on maslanguage.ID=language.MASSKILLLANGUAGE_ID"
            		+ " where employee.ID=:empId", 
            resultClass = SkillLanguageDto.class)
  })


@Entity
public class SkillLanguageDto {
	
	@Id
	@Column(name="ID")
	private Integer id;
	@Column(name="EMPLOYEE_ID")
	private Integer employeeId;
	@Column(name="EMPLOYEE_CODE")
	private String  employeeCode;
	@Column(name="NAMELANGUAGE")
    private String nameLanguage;
	@Column(name="SPEAKING")
	private String  speaking;
	@Column(name="READING")
	private String  reading;
	@Column(name="UNDERSTANDING")
	private String  understanding;
	@Column(name="WRITING")
	private String  writing;
	
	
	
	public Integer getId() {
		return id;
	}
	
	
	public void setId(Integer id) {
		this.id = id;
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
	
	
	
}
