package com.aug.hrdb.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Transient;

import com.aug.hrdb.dto.AugRequestDto;
import com.aug.hrdb.entities.MasJoblevel;
import com.aug.hrdb.entities.MasTechnology;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@NamedNativeQueries({
		@NamedNativeQuery(name = "SEARCH_ALL_REQUEST", query = "SELECT a.ID, a.REQUEST_DATE, a.REQUESTER_NAME, a.STATUS, a.APPROVAL_NAME,a.APPROVE_DATE, a.REQUEST_MASJOBLEVEL, a.NUMBER_APPLICANT, a.SPECIFIC_SKILL,"
				+ " a.YEAR_EXPERIENCE,null as MAS_JOB_LEVEL_NAME,null as MAS_TECHNOLOGY_NAME,a.MASJOBLEVEL_ID,a.MASTECHNOLOGY_ID, j.ID, t.ID "
				+ "FROM AUG_REQUEST a LEFT JOIN MAS_JOBLEVEL j ON a.REQUEST_MASJOBLEVEL = j.ID LEFT JOIN MAS_TECHNOLOGY t ON a.REQUEST_MASTECHNOLOGY = t.ID ORDER BY REQUEST_DATE DESC", resultClass = AugRequestDto.class), //REQUEST_ID ASC LIMIT 0,50
		
		@NamedNativeQuery(name = "SEARCH_REQUEST_BY_ID", query = "SELECT a.ID, a.REQUEST_DATE, a.REQUESTER_NAME, a.STATUS, a.APPROVAL_NAME,a.APPROVE_DATE, a.REQUEST_MASTECHNOLOGY, a.REQUEST_MASJOBLEVEL, a.NUMBER_APPLICANT, a.SPECIFIC_SKILL,"
				+ " a.YEAR_EXPERIENCE,null as MAS_JOB_LEVEL_NAME,null as MAS_TECHNOLOGY_NAME,a.MASJOBLEVEL_ID,a.MASTECHNOLOGY_ID, j.ID, t.ID"
				+ " FROM AUG_REQUEST a LEFT JOIN MAS_JOBLEVEL j ON a.REQUEST_MASJOBLEVEL = j.ID LEFT JOIN MAS_TECHNOLOGY t ON a.REQUEST_MASTECHNOLOGY = t.ID WHERE REQUEST_ID = :ID", resultClass = AugRequestDto.class),
		//TEST SQLGrammaException		
		
		@NamedNativeQuery(name = "SEARCH_REQUEST_BY_ID_TEST", query = "SELECT a.ID, a.REQUEST_DATE, a.REQUESTER_NAME, a.STATUS, a.APPROVAL_NAME,a.APPROVE_DATE, a.REQUEST_MASTECHNOLOGY, a.REQUEST_MASJOBLEVEL, a.NUMBER_APPLICANT, a.SPECIFIC_SKILL,"
						+ " a.YEAR_EXPERIENCE,null as MAS_JOB_LEVEL_NAME,null as MAS_TECHNOLOGY_NAME,a.MASJOBLEVEL_ID,a.MASTECHNOLOGY_ID, j.ID, t.ID"
						+ " FROM AUG_REQUEST a LEFT JOIN MAS_JOBLEVEL j ON a.REQUEST_MASJOBLEVEL = j.ID LEFT JOIN MAS_TECHNOLOGY t ON a.REQUEST_MASTECHNOLOGY = t.ID WHERE REQUEST_ID = :ID", resultClass = AugRequestDto.class)})
public class AugRequestDto {

	@Id
	@Column(name = "ID")
	private Integer id;  

	@Column(name = "MAS_JOB_LEVEL_NAME")
	private String masJobLevelName;
	
	@Column(name = "MAS_TECHNOLOGY_NAME")
	private String masTechnologyName;
	
	@Column(name = "REQUEST_DATE")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", locale = "en", timezone = "GMT")
	private Date requestDate;

	@Column(name = "REQUESTER_NAME")
	private String requesterName;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "APPROVAL_NAME")
	private String approvalName;

	@Column(name = "APPROVE_DATE")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", locale = "en", timezone = "GMT")
	private Date approveDate;

	@Column(name = "REQUEST_MASTECHNOLOGY")
	private Integer requestTechnology;

	@Column(name = "REQUEST_MASJOBLEVEL")
	private Integer requestJoblevel;

	@Column(name = "NUMBER_APPLICANT")
	private Integer numberApplicant;

	@Column(name = "SPECIFIC_SKILL")
	private String specificSkill;

	@Column(name = "YEAR_EXPERIENCE")
	private Integer yearExperience;
	
	@Column(name = "MASJOBLEVEL_ID")
	private Integer joblevelId;

	@Column(name = "MASTECHNOLOGY_ID")
	private Integer technologyId;
	
	@Transient
	private MasJoblevel joblevel;

	@Transient
	private MasTechnology technology;

	@Transient
	private String jobLevelStr;
	
	@Transient
	private String technologyStr;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public String getRequesterName() {
		return requesterName;
	}

	public void setRequesterName(String requesterName) {
		this.requesterName = requesterName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getApprovalName() {
		return approvalName;
	}

	public void setApprovalName(String approvalName) {
		this.approvalName = approvalName;
	}

	public Date getApproveDate() {
		return approveDate;
	}

	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
	}

	public Integer getNumberApplicant() {
		return numberApplicant;
	}

	public void setNumberApplicant(Integer numberApplicant) {
		this.numberApplicant = numberApplicant;
	}

	public String getSpecificSkill() {
		return specificSkill;
	}

	public void setSpecificSkill(String specificSkill) {
		this.specificSkill = specificSkill;
	}

	public Integer getYearExperience() {
		return yearExperience;
	}

	public void setYearExperience(Integer yearExperience) {
		this.yearExperience = yearExperience;
	}

	public String getMasJobLevelName() {
		return masJobLevelName;
	}

	public void setMasJobLevelName(String masJobLevelName) {
		this.masJobLevelName = masJobLevelName;
	}

	public String getMasTechnologyName() {
		return masTechnologyName;
	}

	public void setMasTechnologyName(String masTechnologyName) {
		this.masTechnologyName = masTechnologyName;
	}

	public String getJobLevelStr() {
		return jobLevelStr;
	}

	public void setJobLevelStr(String jobLevelStr) {
		this.jobLevelStr = jobLevelStr;
	}

	public String getTechnologyStr() {
		return technologyStr;
	}

	public void setTechnologyStr(String technologyStr) {
		this.technologyStr = technologyStr;
	}

	public Integer getRequestTechnology() {
		return requestTechnology;
	}

	public void setRequestTechnology(Integer requestTechnology) {
		this.requestTechnology = requestTechnology;
	}

	public Integer getRequestJoblevel() {
		return requestJoblevel;
	}

	public void setRequestJoblevel(Integer requestJoblevel) {
		this.requestJoblevel = requestJoblevel;
	}

	public Integer getJoblevelId() {
		return joblevelId;
	}

	public void setJoblevelId(Integer joblevelId) {
		this.joblevelId = joblevelId;
	}

	public Integer getTechnologyId() {
		return technologyId;
	}

	public void setTechnologyId(Integer technologyId) {
		this.technologyId = technologyId;
	}

	public MasJoblevel getJoblevel() {
		return joblevel;
	}

	public void setJoblevel(MasJoblevel joblevel) {
		this.joblevel = joblevel;
	}

	public MasTechnology getTechnology() {
		return technology;
	}

	public void setTechnology(MasTechnology technology) {
		this.technology = technology;
	}
	
	


}

