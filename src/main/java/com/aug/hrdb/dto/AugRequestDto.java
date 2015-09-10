package com.aug.hrdb.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Transient;

import com.aug.hrdb.dto.AugRequestDto;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@NamedNativeQueries({
		@NamedNativeQuery(name = "SEARCH_ALL_REQUEST", query = "SELECT a.REQUEST_ID, a.REQUEST_DATE, a.REQUESTER_NAME, a.STATUS, a.APPROVAL_NAME,a.APPROVE_DATE, a.REQUEST_POSITION, a.NUMBER_APPLICANT, a.SPECIFIC_SKILL,"
				+ " a.YEAR_EXPERIENCE, p.POSITION_NAME, p.ID FROM AUG_REQUEST a JOIN POSITION p ON a.REQUEST_POSITION = p.ID ORDER BY REQUEST_DATE DESC", resultClass = AugRequestDto.class), //REQUEST_ID ASC LIMIT 0,50
		@NamedNativeQuery(name = "SEARCH_REQUEST_BY_ID", query = "SELECT a.REQUEST_ID, a.REQUEST_DATE, a.REQUESTER_NAME, a.STATUS, a.APPROVAL_NAME,a.APPROVE_DATE, a.REQUEST_POSITION, a.NUMBER_APPLICANT, a.SPECIFIC_SKILL,"
				+ " a.YEAR_EXPERIENCE, p.POSITION_NAME, p.ID FROM AUG_REQUEST a JOIN POSITION p ON a.REQUEST_POSITION = p.ID WHERE REQUEST_ID = :ID", resultClass = AugRequestDto.class),
		//TEST SQLGrammaException		
		@NamedNativeQuery(name = "SEARCH_REQUEST_BY_ID_TEST", query = "SELECT a.REQUEST_ID, a.REQUEST_DATE, a.REQUESTER_NAME, a.STATUS, a.APPROVAL_NAME,a.APPROVE_DATE, a.REQUEST_POSITION, a.NUMBER_APPLICANT, a.SPECIFIC_SKILL,"
						+ " a.YEAR_EXPERIENCE, p.POSITION_NAME, p.IDFROMAUG_REQUEST a JOIN POSITION p ON a.REQUEST_POSITION = p.ID WHERE REQUEST_ID = :ID", resultClass = AugRequestDto.class)})
public class AugRequestDto {

	@Column(name = "POSITION_NAME")
	private String positionName;

	@Id
	@Column(name = "REQUEST_ID")
	private Integer id;

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

	@Column(name = "REQUEST_POSITION")
	private Integer positionRequest;

	@Column(name = "NUMBER_APPLICANT")
	private Integer numberApplicant;

	@Column(name = "SPECIFIC_SKILL")
	private String specificSkill;

	@Column(name = "YEAR_EXPERIENCE")
	private Integer yearExperience;

	@Transient
	private String positionStr;

	public String getPositionStr() {
		return positionStr;
	}

	public void setPositionStr(String positionStr) {
		this.positionStr = positionStr;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

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

	public Integer getPositionRequest() {
		return positionRequest;
	}

	public void setPositionRequest(Integer positionRequest) {
		this.positionRequest = positionRequest;
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

}

