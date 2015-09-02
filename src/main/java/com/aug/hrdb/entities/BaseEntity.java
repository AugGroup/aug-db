package com.aug.hrdb.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@MappedSuperclass
public abstract class BaseEntity {


	@Transient	
	private String sortingBy;
	@Transient
	private String cmd;
	@Transient
	private String name;
	@Transient
	private String tmpImage;
	@Transient
	private String reportType;
	
	
	private String auditFlag;
	private Date createdTimeStamp;
	private Integer createdBy;
	private Date updatedTimeStamp;
	private Integer updatedBy;

	
	@Column(name = "AUDITFLAG", nullable = false, length = 1)
	public String getAuditFlag() {
		return auditFlag;
	}

	public void setAuditFlag(String auditFlag) {
		this.auditFlag = auditFlag;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATEDTIMESTAMP", nullable = false)
	public Date getCreatedTimeStamp() {
		return createdTimeStamp;
	}

	public void setCreatedTimeStamp(Date createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}

	@Column(name = "CREATEDBY", nullable = false, length = 10)
	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	
	@Column(name="UPDATEDTIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdatedTimeStamp() {
		return updatedTimeStamp;
	}

	public void setUpdatedTimeStamp(Date updatedTimeStamp) {
		this.updatedTimeStamp = updatedTimeStamp;
	}

	@Column(name = "UPDATEDBY", nullable = true, length = 10)
	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	
	public BaseEntity() {

	}
	
	
	@Transient
	public String getSortingBy() {
		return sortingBy;
	}

	public void setSortingBy(String sortingBy) {
		this.sortingBy = sortingBy;
	}
	
	
	@Transient
	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	
	@Transient
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	@Transient
	public String getTmpImage() {
		return tmpImage;
	}

	public void setTmpImage(String tmpImage) {
		this.tmpImage = tmpImage;
	}

	
	@Transient
	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	

  
}
