package com.aug.hrdb.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Transient;

import com.aug.hrdb.dto.AugRequestDto;
import com.aug.hrdb.entities.Employee;
import com.aug.hrdb.entities.MasJobLevel;
import com.aug.hrdb.entities.MasTechnology;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@NamedNativeQueries({
		@NamedNativeQuery(name = "SEARCH_ALL_REQUEST", query = "SELECT a.ID, a.REQUEST_DATE, a.STATUS,a.APPROVE_DATE, a.NUMBER_APPLICANT, a.SPECIFIC_SKILL, "
				+ " a.YEAR_EXPERIENCE,j.NAME as MAS_JOB_LEVEL_NAME,t.NAME as MAS_TECHNOLOGY_NAME,a.MASJOBLEVEL_ID,a.MASTECHNOLOGY_ID, "
				+ " a.REQUEST_ID, a.APPROVE_ID, a.JOBCASE_CODE, a.JOBCASE_STATUS, "
				+ " appR.FIRSTNAME_EN AS REQUESTER_NAME, appA.FIRSTNAME_EN AS APPROVAL_NAME "
				+ "FROM AUG_REQUEST a LEFT JOIN MAS_JOBLEVEL j ON a.MASJOBLEVEL_ID = j.ID "
				+ "LEFT JOIN MAS_TECHNOLOGY t ON a.MASTECHNOLOGY_ID = t.ID "
				+ "LEFT JOIN EMPLOYEE er ON a.REQUEST_ID = er.ID "
				+ "LEFT JOIN EMPLOYEE ea ON a.APPROVE_ID = ea.ID "
				+ "LEFT JOIN APPLICANT appR ON er.APPLICANT_ID = appR.ID "
				+ "LEFT JOIN APPLICANT appA ON ea.APPLICANT_ID = appA.ID "
				+ "ORDER BY ID DESC", resultClass = AugRequestDto.class), //REQUEST_ID ASC LIMIT 0,50
		
		@NamedNativeQuery(name = "SEARCH_REQUEST_BY_ID", query = "SELECT a.ID, a.REQUEST_DATE, a.STATUS,a.APPROVE_DATE, a.NUMBER_APPLICANT, a.SPECIFIC_SKILL,"
				+ " a.YEAR_EXPERIENCE,j.NAME as MAS_JOB_LEVEL_NAME,t.NAME as MAS_TECHNOLOGY_NAME,a.MASJOBLEVEL_ID,a.MASTECHNOLOGY_ID, j.ID, t.ID, "
				+ " a.REQUEST_ID, a.APPROVE_ID, a.JOBCASE_CODE, a.JOBCASE_STATUS, "
				+ " appR.FIRSTNAME_EN AS REQUESTER_NAME, appA.FIRSTNAME_EN AS APPROVAL_NAME "
				+ " FROM AUG_REQUEST a LEFT JOIN MAS_JOBLEVEL j ON a.MASJOBLEVEL_ID = j.ID "
				+ "LEFT JOIN EMPLOYEE er ON a.REQUEST_ID = er.ID "
				+ "LEFT JOIN EMPLOYEE ea ON a.APPROVE_ID = ea.ID "
				+ "LEFT JOIN APPLICANT appR ON er.APPLICANT_ID = appR.ID "
				+ "LEFT JOIN APPLICANT appA ON ea.APPLICANT_ID = appA.ID "
				+ "LEFT JOIN MAS_TECHNOLOGY t ON a.MASTECHNOLOGY_ID = t.ID WHERE a.ID = :ID", resultClass = AugRequestDto.class),
		//TEST SQLGrammaException		
		
		@NamedNativeQuery(name = "SEARCH_REQUEST_BY_ID_TEST", query = "SELECT a.ID, a.REQUEST_DATE, a.STATUS,a.APPROVE_DATE, a.NUMBER_APPLICANT, a.SPECIFIC_SKILL,"
				+ " a.YEAR_EXPERIENCE,null as MAS_JOB_LEVEL_NAME,null as MAS_TECHNOLOGY_NAME,a.MASJOBLEVEL_ID,a.MASTECHNOLOGY_ID, j.ID, t.ID, "
				+ " a.REQUEST_ID, a.APPROVE_ID, a.JOBCASE_CODE, a.JOBCASE_STATUS, "
				+ " appR.FIRSTNAME_EN AS REQUESTER_NAME, appA.FIRSTNAME_EN AS APPROVAL_NAME "
				+ " FROM AUG_REQUEST a LEFT JOIN MAS_JOBLEVEL j ON a.MASJOBLEVEL_ID = j.ID "
				+ "LEFT JOIN MAS_TECHNOLOGY t ON a.MASTECHNOLOGY_ID = t.ID "
				+ "LEFT JOIN EMPLOYEE er ON a.REQUEST_ID = er.ID "
				+ "LEFT JOIN EMPLOYEE ea ON a.APPROVE_ID = ea.ID "
				+ "LEFT JOIN APPLICANT appR ON er.APPLICANT_ID = appR.ID "
				+ "LEFT JOIN APPLICANT appA ON ea.APPLICANT_ID = appA.ID "
				+ "WHERE a.ID = :ID", resultClass = AugRequestDto.class),
		
		@NamedNativeQuery(name = "GET_JOBCASE_CODE", query = "SELECT a.ID, a.JOBCASE_CODE, "
				+ "null as REQUEST_DATE, null as STATUS, null as APPROVE_DATE, null as NUMBER_APPLICANT, null as SPECIFIC_SKILL, "
				+ "null as YEAR_EXPERIENCE, null as MAS_JOB_LEVEL_NAME, null as MAS_TECHNOLOGY_NAME, null as MASJOBLEVEL_ID, null as MASTECHNOLOGY_ID, "
				+ "null as REQUEST_ID, null as APPROVE_ID, null as JOBCASE_STATUS, null as APPROVAL_NAME, null as REQUESTER_NAME "
				+ "FROM AUG_REQUEST a", resultClass = AugRequestDto.class)
})
public class AugRequestDto {

	@Id
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "JOBCASE_CODE")
	private String jobcaseCode;

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
	
	@Column(name = "JOBCASE_STATUS")
	private String jobcaseStatus;

	@Column(name = "APPROVAL_NAME")
	private String approvalName;

	@Column(name = "APPROVE_DATE")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", locale = "en", timezone = "GMT")
	private Date approveDate;

	@Column(name = "NUMBER_APPLICANT")
	private Integer numberApplicant;

	@Column(name = "SPECIFIC_SKILL")
	private String specificSkill;

	@Column(name = "YEAR_EXPERIENCE")
	private Integer yearExperience;
	
	@Column(name = "REQUEST_ID")
	private Integer requesterId;
	
	@Column(name = "APPROVE_ID")
	private Integer approverId;
	
	@Column(name = "MASJOBLEVEL_ID")
	private Integer joblevelId;

	@Column(name = "MASTECHNOLOGY_ID")
	private Integer technologyId;
	
	@Transient
	private Employee requester;
	
	@Transient
	private Employee approver;
	
	@Transient
	private MasJobLevel joblevel;

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

	public MasJobLevel getJoblevel() {
		return joblevel;
	}

	public void setJoblevel(MasJobLevel joblevel) {
		this.joblevel = joblevel;
	}

	public MasTechnology getTechnology() {
		return technology;
	}

	public void setTechnology(MasTechnology technology) {
		this.technology = technology;
	}

	public Employee getRequester() {
		return requester;
	}

	public void setRequestId(Employee requester) {
		this.requester = requester;
	}

	public Employee getApprover() {
		return approver;
	}

	public void setApprover(Employee approver) {
		this.approver = approver;
	}

	public Integer getRequesterId() {
		return requesterId;
	}

	public void setRequesterId(Integer requesterId) {
		this.requesterId = requesterId;
	}

	public Integer getApproverId() {
		return approverId;
	}

	public void setApproverId(Integer approverId) {
		this.approverId = approverId;
	}

	public void setRequester(Employee requester) {
		this.requester = requester;
	}

	public String getJobcaseCode() {
		return jobcaseCode;
	}

	public void setJobcaseCode(String jobcaseCode) {
		this.jobcaseCode = jobcaseCode;
	}

	public String getJobcaseStatus() {
		return jobcaseStatus;
	}

	public void setJobcaseStatus(String jobcaseStatus) {
		this.jobcaseStatus = jobcaseStatus;
	}
	
}

