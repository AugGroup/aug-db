package com.aug.hrdb.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
*
* @author Supannika Pattanodom
*/
@Entity
@Table(name = "AUG_REQUEST")
public class AugRequest extends BaseEntity{

	@Id
	@GeneratedValue
	@Column(name = "REQUEST_ID")
	private Integer id;

	@Column(name = "REQUEST_DATE")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date requestDate;

	@Column(name = "REQUESTER_NAME")
	private String requesterName;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "APPROVAL_NAME")
	private String approvalName;

	@Column(name = "APPROVE_DATE")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date approveDate;

//	@ManyToOne
//	@JoinColumn(name = "REQUEST_POSITION", referencedColumnName = "id")
//	private Position positionRequest;

	@Column(name = "NUMBER_APPLICANT")
	private Integer numberApplicant;

	@Column(name = "SPECIFIC_SKILL")
	private String specificSkill;

	@Column(name = "YEAR_EXPERIENCE")
	private Integer yearExperience;
	
	@Transient
	private String positionStr;

/*	public String getPositionStr() {
		return positionStr;
	}

	public void setPositionStr(String positionStr) {
		this.positionStr = positionStr;
	}*/

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

//	public Position getPositionRequest() {
//		return positionRequest;
//	}
//
//	public void setPositionRequest(Position positionRequest) {
//		this.positionRequest = positionRequest;
//	}

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
	
	

}
