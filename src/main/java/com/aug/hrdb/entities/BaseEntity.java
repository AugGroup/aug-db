package com.aug.hrdb.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;


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
	
	
	@Column(name = "AUDITFLAG", nullable = false, length = 1)
	private String auditFlag;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATEDTIMESTAMP", nullable = false)
	private Date createdTimeStamp;
	@Column(name = "CREATEDBY", nullable = false, length = 10)
	private Integer createdBy;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Column(name="UPDATEDTIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedTimeStamp;
	@Column(name = "UPDATEDBY", nullable = true, length = 10)
	private Integer updatedBy;

	
	public String getAuditFlag() {
		return auditFlag;
	}

	public void setAuditFlag(String auditFlag) {
		this.auditFlag = auditFlag;
	}


	public Date getCreatedTimeStamp() {
		return createdTimeStamp;
	}

	public void setCreatedTimeStamp(Date createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	

	public Date getUpdatedTimeStamp() {
		return updatedTimeStamp;
	}

	public void setUpdatedTimeStamp(Date updatedTimeStamp) {
		this.updatedTimeStamp = updatedTimeStamp;
	}

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
