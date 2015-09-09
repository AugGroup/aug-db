package com.aug.hrdb.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="LANGUAGE")

public class Language extends BaseEntity{
	
	
	private Integer id;
	private String  nameLanguage;
	private String  speaking;
	private String  reading;
	private String  understanding;
	private String  writing;
	private Applicant applicant;
	
	
	
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="NAMELANGUAGE")
	public String getNameLanguage() {
		return nameLanguage;
	}

	public void setNameLanguage(String nameLanguage) {
		this.nameLanguage = nameLanguage;
	}

	@Column(name="SPEAKING")
	public String getSpeaking() {
		return speaking;
	}

	

	public void setSpeaking(String speaking) {
		this.speaking = speaking;
	}

	@Column(name="READING")
	public String getReading() {
		return reading;
	}

	public void setReading(String reading) {
		this.reading = reading;
	}

	@Column(name="UNDERSTANDING")
	public String getUnderstanding() {
		return understanding;
	}

	public void setUnderstanding(String understanding) {
		this.understanding = understanding;
	}

	@Column(name="WRITING")
	public String getWriting() {
		return writing;
	}

	public void setWriting(String writing) {
		this.writing = writing;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "APPLICANT_ID" ,referencedColumnName="id", nullable=false)
	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}
	
	
		
	



	
	

	
	

}
