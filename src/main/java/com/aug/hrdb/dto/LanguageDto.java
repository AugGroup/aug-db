package com.aug.hrdb.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

 @NamedNativeQueries({
	@NamedNativeQuery(
            name = "listLanguage",
            		 query = "select language.ID as ID,"
            		 		+ "language.NAMELANGUAGE,language.SPEAKING as SPEAKKING, "
                      		+ "language.READING as READING, "
                      		+ "language.UNDERSTANDING as UNDERSTANDDING, "
                      		+ "language.WRITING as WRITING "
                      		+ "from LANGUAGE as language,APPLICANT as app, EMPLOYEE as emp  "
                      		+ "where app.applicant_id =:appId and emp.applicant_id = language.applicant_id", 
               resultClass = LanguageDto.class),
    @NamedNativeQuery(name = "SEARCH_LANGUAGES_ID", query = "select language.ID,"
            		 		+ "language.NAMELANGUAGE,language.SPEAKING, "
                      		+ "language.READING, "
                      		+ "language.UNDERSTANDING, "
                      		+ "language.WRITING "
                      		+ " FROM LANGUAGE language WHERE language.ID = :ID", resultClass = LanguageDto.class)
    })


@Entity
public class LanguageDto {
	
	@Column(name="ID")
	@Id
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
	@Column(name = "APPLICANT_ID")
	private Integer applicantId;
	
	@Column(name ="EMPLOYEE_ID")
	private Integer employeeId;
	
	
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


	public Integer getApplicantId() {
		return applicantId;
	}


	public void setApplicantId(Integer applicantId) {
		this.applicantId = applicantId;
	}


	public Integer getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	
	
	
	
	
	
}
