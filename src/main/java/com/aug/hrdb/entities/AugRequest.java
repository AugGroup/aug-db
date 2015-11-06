package com.aug.hrdb.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
*
* @author Supannika Pattanodom
*/

@Entity
@Table(name = "AUG_REQUEST")
public class AugRequest extends BaseEntity {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;

	@Column(name = "REQUEST_DATE")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy",  locale = "en", timezone = "GMT")
	private Date requestDate;
	
	@Column(name = "APPROVE_DATE")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy",  locale = "en", timezone = "GMT")
	private Date approveDate;

	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "JOBCASE_STATUS")
	private String jobcaseStatus;
	
	@Column(name = "NUMBER_APPLICANT")
	private Integer numberApplicant;

	@Column(name = "SPECIFIC_SKILL")
	private String specificSkill;

	@Column(name = "YEAR_EXPERIENCE")
	private Integer yearExperience;

	@Column(name = "JOBCASE_CODE")
	private String jobcaseCode;
	
	@ManyToOne
	@JoinColumn(name = "REQUEST_ID", referencedColumnName = "id", nullable = false)
	private Employee requester;
	
	@ManyToOne
	@JoinColumn(name = "APPROVE_ID", referencedColumnName = "id")	
	private Employee approver;

	@ManyToOne
	@JoinColumn(name = "MASTECHNOLOGY_ID", referencedColumnName = "id", nullable = false)
	private MasTechnology technology;

	@ManyToOne
	@JoinColumn(name = "MASJOBLEVEL_ID", referencedColumnName = "id", nullable = false)
	private MasJoblevel joblevel;

	@JsonIgnore
	@OneToMany(mappedBy ="augRequest",cascade=CascadeType.REMOVE)
	private List<Applicant> applicant;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public MasTechnology getTechnology() {
		return technology;
	}

	public void setTechnology(MasTechnology technology) {
		this.technology = technology;
	}

	public MasJoblevel getJoblevel() {
		return joblevel;
	}

	public void setJoblevel(MasJoblevel joblevel) {
		this.joblevel = joblevel;
	}

	public String getCodeRequest() {
		return jobcaseCode;
	}

	public void setCodeRequest(String jobcaseCode) {
		this.jobcaseCode = jobcaseCode;
	}

	public Date getApproveDate() {
		return approveDate;
	}

	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
	}

	public String getJobcaseCode() {
		return jobcaseCode;
	}

	public void setJobcaseCode(String jobcaseCode) {
		this.jobcaseCode = jobcaseCode;
	}

	public Employee getRequester() {
		return requester;
	}

	public void setRequester(Employee requester) {
		this.requester = requester;
	}

	public Employee getApprover() {
		return approver;
	}

	public void setApprover(Employee approver) {
		this.approver = approver;
	}

	public List<Applicant> getApplicants() {
		return applicant;
	}

	public void setApplicants(List<Applicant> applicant) {
		this.applicant = applicant;
	}

	public List<Applicant> getApplicant() {
		return applicant;
	}

	public void setApplicant(List<Applicant> applicant) {
		this.applicant = applicant;
	}

	public String getJobcaseStatus() {
		return jobcaseStatus;
	}

	public void setJobcaseStatus(String jobcaseStatus) {
		this.jobcaseStatus = jobcaseStatus;
	}
	
}
