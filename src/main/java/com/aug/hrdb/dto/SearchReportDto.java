package com.aug.hrdb.dto;

public class SearchReportDto {
	private Integer joblevel;
	private Integer technology;
	private Integer position;
	private String degree;
	private String major;
	private String schoolName;
	private Double gpa;
	private String applyDateStr;

	public String getApplyDateStr() {
		return applyDateStr;
	}
	public void setApplyDateStr(String applyDateStr) {
		this.applyDateStr = applyDateStr;
	}
	private String startDate;
	private String endDate;

	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	private String reportType;
	
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public Double getGpa() {
		return gpa;
	}
	public void setGpa(Double gpa) {
		this.gpa = gpa;
	}
	public String getReportType() {
		return reportType;
	}
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public Integer getJoblevel() {
		return joblevel;
	}
	public void setJoblevel(Integer joblevel) {
		this.joblevel = joblevel;
	}
	public Integer getTechnology() {
		return technology;
	}
	public void setTechnology(Integer technology) {
		this.technology = technology;
	}
	

}

