package com.aug.hrdb.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

@Entity
@NamedNativeQueries({

	@NamedNativeQuery(name = "CHECK_TAG", query = "SELECT job.ID, job.NAME, job.CODE, job.TAG "
			+ "FROM MAS_JOBLEVEL job "
			+ "WHERE job.TAG =:TAG", resultClass = JoblevelDto.class),


	})
public class JoblevelDto {

	@Id
	@Column(name = "ID")
	private Integer jobId;
	
	@Column(name = "NAME")
	private String jobName;
	
	@Column(name = "TAG")
	private String tag;
	
	@Column(name = "CODE")
	private String code;

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}
