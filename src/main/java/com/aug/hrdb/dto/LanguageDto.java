package com.aug.hrdb.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;



 @NamedNativeQueries({
	@NamedNativeQuery(
            name = "listSkillLanguage",
            		 query = "select language.ID as ID,"
            		 		+ "language.NAMELANGUAGE,language.SPEAKING as SPEAKKING, "
                      		+ "language.READING as READING, "
                      		+ "language.UNDERSTANDING as UNDERSTANDDING, "
                      		+ "language.WRITING as WRITING "
                      		+ "from LANGUAGE as language,APPLICANT as app, EMPLOYEE as emp  "
                      		+ "where emp.id =:empId and emp.applicant_id = language.applicant_id", 
               resultClass = LanguageDto.class)
  })


@Entity
public class LanguageDto {
	
	@Id
	private Integer id;
    private String nameLanguage;
	private String  speaking;
	private String  reading;
	private String  understanding;
	private String  writing;
	private Integer applicantId;
	
	
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
	
	
	
}
