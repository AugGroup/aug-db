package com.aug.hrdb.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="CAREER_CASE")
public class CareerCase extends BaseEntity {
	
	@Id @GeneratedValue @Column(name="ID")
	private Integer id;
	
	@Column(name="CODE", nullable=false)
	private String code;
	
	@ManyToOne
	@JoinColumn(name="MAS_CAREER_CASE_STATUS_ID")
	private MasCareerCaseStatus masCareerCaseStatus;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_REQUEST", nullable=false)
	private Date dateRequest;
	
	@ManyToOne
	@JoinColumn(name="CLIENT_ID", nullable=false)
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="MAS_DIVISION_ID", nullable=false)
	private MasDivision masDivision;
	
	@ManyToOne
	@JoinColumn(name="MAS_JOBLEVEL_ID", nullable=false)
	private MasJobLevel masJobLevel;
	
	@ManyToOne
	@JoinColumn(name="MAS_CORESKILL_ID", nullable=false)
	private MasCoreSkill masCoreSkill;
	
	@ManyToOne
	@JoinColumn(name="MAS_TECHNOLOGY_ID")
	private MasTechnology masTechnology;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "CAREER_CASE_SPECIALTY", 
		joinColumns = { 
			@JoinColumn(name = "CAREER_CASE_ID", nullable = false, updatable = false) 
		}, 
		inverseJoinColumns = { 
			@JoinColumn(name = "SPECIALTY_ID", nullable = false, updatable = false) 
	})
	private List<MasSpecialty> masSpecialties;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "START_DATE")
	private Date startDate;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "END_DATE")
	private Date endDate;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "EXPECTED_DATE")
	private Date expectedDate;
	
	@Column(name="JOB_DESCRIPTION")
	private String jobDescription;
	
	@Column(name="SPECIAL_REQUEST")
	private String specialRequest;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public MasCareerCaseStatus getCareerCaseStatus() {
		return masCareerCaseStatus;
	}

	public void setCareerCaseStatus(MasCareerCaseStatus masCareerCaseStatus) {
		this.masCareerCaseStatus = masCareerCaseStatus;
	}

	public Date getDateRequest() {
		return dateRequest;
	}

	public void setDateRequest(Date dateRequest) {
		this.dateRequest = dateRequest;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public MasDivision getMasDivision() {
		return masDivision;
	}

	public void setMasDivision(MasDivision masDivision) {
		this.masDivision = masDivision;
	}

	public MasJobLevel getMasJobLevel() {
		return masJobLevel;
	}

	public void setMasJobLevel(MasJobLevel masJobLevel) {
		this.masJobLevel = masJobLevel;
	}

	public MasCoreSkill getMasCoreSkill() {
		return masCoreSkill;
	}

	public void setMasCoreSkill(MasCoreSkill masCoreSkill) {
		this.masCoreSkill = masCoreSkill;
	}

	public MasTechnology getMasTechnology() {
		return masTechnology;
	}

	public void setMasTechnology(MasTechnology masTechnology) {
		this.masTechnology = masTechnology;
	}

	public List<MasSpecialty> getMasSpecialties() {
		return masSpecialties;
	}

	public void setMasSpecialties(List<MasSpecialty> masSpecialties) {
		this.masSpecialties = masSpecialties;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getExpectedDate() {
		return expectedDate;
	}

	public void setExpectedDate(Date expectedDate) {
		this.expectedDate = expectedDate;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getSpecialRequest() {
		return specialRequest;
	}

	public void setSpecialRequest(String specialRequest) {
		this.specialRequest = specialRequest;
	}
	
}