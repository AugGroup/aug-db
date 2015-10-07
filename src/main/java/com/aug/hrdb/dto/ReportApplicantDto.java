package com.aug.hrdb.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Transient;

import com.aug.hrdb.dto.ReportApplicantDto;
import com.fasterxml.jackson.annotation.JsonFormat;

@NamedNativeQueries({ @NamedNativeQuery(name = "REPORT_APPLICANT", query = "SELECT "
		+ "applicant.ID AS id ,"
		+ "applicant.AGE AS age,"
		+ "applicant.APPLICANT_STATUS AS applicantStatus,"
		+ "applicant.APPLY_DATE AS applyDate,"
		+ "applicant.ATTITUDE_HOME AS attitudeHome,"
		+ "applicant.ATTITUDE_OFFICE AS attitudeOffice,"
		+ "applicant.APPLICANT_CODE AS code,"
		+ "applicant.EMAIL AS email,"
		+ "applicant.FIRSTNAME_EN AS firstNameEN,"
		+ "applicant.LASTNAME_EN AS lastNameEn,"
		+ "applicant.SCORE AS score,"
		+ "applicant.SEX AS sex,"
		+ "applicant.TECH_SCORE AS techScore,"
		+ "applicant.TEL AS tel,"
		+ "applicant.TRACKING_STATUS AS trackingStatus,"
		+ "applicant.MASTECHNOLOGY_ID AS technologyId,"
		+ "applicant.MASJOBLEVEL_ID AS joblevelId,"
		+ "education.DEGREETYPE_ID AS degreeId,"
		+ "degreeType.ID,"
		+ "degreeType.NAME AS degreeName,"
		+ "education.FACULTY AS faculty,"
		+ "education.GPA AS gpa,"
		+ "education.MAJOR AS major,"
		+ "education.UNIVERSITY AS university,"
		+ "education.APPLICANT_ID AS ApplicantId,"
		+ "joblevel.ID AS joblevelId,"
		+ "joblevel.CODE AS joblevelCode,"
		+ "joblevel.NAME AS joblevelName,"
		+ "technology.ID AS technologyId,"
		+ "technology.CODE AS technologyCode,"
		+ "technology.NAME AS technologyName "
		+ "FROM APPLICANT applicant "
		+ "LEFT JOIN EDUCATION education ON applicant.ID = education.APPLICANT_ID "
		+ "LEFT JOIN MAS_DEGREETYPE degreeType ON degreeType.ID = education.DEGREETYPE_ID "
		+ "LEFT JOIN MAS_JOBLEVEL joblevel ON applicant.MASJOBLEVEL_ID = joblevel.ID "
		+ "LEFT JOIN MAS_TECHNOLOGY technology ON applicant.MASTECHNOLOGY_ID = technology.ID ", resultClass = ReportApplicantDto.class),
		
		@NamedNativeQuery(name = "REPORT_SEARCH_BY_CRITERIA", query = "SELECT "
		+ "applicant.ID AS id, "
		+ "applicant.AGE AS age, "
		+ "applicant.APPLICANT_STATUS AS applicantStatus, "
		+ "applicant.APPLY_DATE AS applyDate,"
		+ "applicant.ATTITUDE_HOME AS attitudeHome,"
		+ "applicant.ATTITUDE_OFFICE AS attitudeOffice,"
		+ "applicant.APPLICANT_CODE AS code,"
		+ "applicant.EMAIL AS email,"
		+ "applicant.FIRSTNAME_EN AS firstNameEN,"
		+ "applicant.LASTNAME_EN AS lastNameEn,"
		+ "applicant.SCORE AS score,"
		+ "applicant.SEX AS sex,"
		+ "applicant.TECH_SCORE AS techScore,"
		+ "applicant.TEL AS tel,"
		+ "applicant.TRACKING_STATUS AS trackingStatus,"
		+ "applicant.MASTECHNOLOGY_ID AS technologyId,"
		+ "applicant.MASJOBLEVEL_ID AS joblevelId,"
		+ "education.DEGREETYPE_ID AS degreeId,"
		+ "degreeType.ID,"
		+ "degreeType.NAME AS degreeName,"
		+ "education.FACULTY AS faculty,"
		+ "education.GPA AS gpa,"
		+ "education.MAJOR AS major,"
		+ "education.UNIVERSITY AS university,"
		+ "education.APPLICANT_ID AS ApplicantId,"
		+ "joblevel.ID AS joblevelId,"
		+ "joblevel.CODE AS joblevelCode,"
		+ "joblevel.NAME AS joblevelName,"
		+ "technology.ID AS technologyId,"
		+ "technology.CODE AS technologyCode,"
		+ "technology.NAME AS technologyName "
		+ "FROM APPLICANT applicant "
		+ "LEFT JOIN EDUCATION education ON applicant.ID = education.APPLICANT_ID "
		+ "LEFT JOIN MAS_DEGREETYPE degreeType ON degreeType.ID = education.DEGREETYPE_ID "
		+ "LEFT JOIN MAS_JOBLEVEL joblevel ON applicant.MASJOBLEVEL_ID = joblevel.ID "
		+ "LEFT JOIN MAS_TECHNOLOGY technology ON applicant.MASTECHNOLOGY_ID = technology.ID "
		+ "WHERE "
		+ "education.MAJOR like :MAJOR AND "
		+ "education.UNIVERSITY like :UNIVERSITY ", resultClass = ReportApplicantDto.class),
		
		@NamedNativeQuery(name = "REPORT_SEARCH_BY_MONTH", query = "SELECT "
		+ "applicant.ID AS id, "
		+ "applicant.AGE AS age, "
		+ "applicant.APPLICANT_STATUS AS applicantStatus, "
		+ "applicant.APPLY_DATE AS applyDate,"
		+ "applicant.ATTITUDE_HOME AS attitudeHome,"
		+ "applicant.ATTITUDE_OFFICE AS attitudeOffice,"
		+ "applicant.APPLICANT_CODE AS code,"
		+ "applicant.EMAIL AS email,"
		+ "applicant.FIRSTNAME_EN AS firstNameEN,"
		+ "applicant.LASTNAME_EN AS lastNameEN,"
		+ "applicant.SCORE AS score,"
		+ "applicant.SEX AS sex,"
		+ "applicant.TECH_SCORE AS techScore,"
		+ "applicant.TEL AS tel,"
		+ "applicant.TRACKING_STATUS AS trackingStatus,"
		+ "applicant.MASTECHNOLOGY_ID AS technologyId,"
		+ "applicant.MASJOBLEVEL_ID AS joblevelId,"
		+ "education.DEGREETYPE_ID AS degreeId,"
		+ "degreeType.ID,"
		+ "degreeType.NAME AS degreeName,"
//		+ "education.DEGREE AS degree,"
		+ "education.FACULTY AS faculty,"
		+ "education.GPA AS gpa,"
		+ "education.MAJOR AS major,"
		+ "education.UNIVERSITY AS university,"
		+ "education.APPLICANT_ID AS ApplicantId,"
		+ "joblevel.ID AS joblevelId,"
		+ "joblevel.CODE AS joblevelCode,"
		+ "joblevel.NAME AS joblevelName,"
		+ "technology.ID AS technologyId,"
		+ "technology.CODE AS technologyCode,"
		+ "technology.NAME AS technologyName "
		+ "FROM APPLICANT applicant "
		+ "LEFT JOIN EDUCATION education ON applicant.ID = education.APPLICANT_ID "
		+ "LEFT JOIN MAS_DEGREETYPE degreeType ON degreeType.ID = education.DEGREETYPE_ID "
		+ "LEFT JOIN MAS_JOBLEVEL joblevel ON applicant.MASJOBLEVEL_ID = joblevel.ID "
		+ "LEFT JOIN MAS_TECHNOLOGY technology ON applicant.MASTECHNOLOGY_ID = technology.ID "
		+ "WHERE applicant.APPLY_DATE BETWEEN STR_TO_DATE( :STARTDATE,'%d/%m/%Y') AND STR_TO_DATE( :ENDDATE,'%d/%m/%Y') ", resultClass = ReportApplicantDto.class)
		
})
 
@Entity
public class ReportApplicantDto {

	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "age")
	private Integer age;

	@Column(name = "applicantStatus")
	private String applicantStatus;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "en", timezone = "GMT")
	@Column(name = "applyDate")
	private Date applyDate;

	@Column(name = "attitudeHome")
	private String attitudeHome;

	@Column(name = "attitudeOffice")
	private String attitudeOffice;  

	@Column(name = "code")
	private String code;

	@Column(name = "email")
	private String email;

	@Column(name = "firstNameEN")
	private String firstNameEN;

	@Column(name = "lastNameEN")
	private String lastNameEN;
	
	@Transient
	private String fullNameEN;

	@Column(name = "sex")
	private String sex;

	@Column(name = "tel")
	private String tel;

	@Column(name = "score")
	private String score;

	@Column(name = "techScore")
	private String techScore;

	@Column(name = "trackingStatus")
	private String trackingStatus;

	@Column(name = "joblevelId")
	private Integer joblevelId;
	
	@Column(name = "technologyId")
	private Integer technologyId;

	@Column(name = "degreeId")
	private Integer degreeId;
	
	@Column(name = "degreeName")
	private String degree;

	@Column(name = "faculty")
	private String faculty;

	@Column(name = "gpa")
	private Double gpa;

	@Column(name = "major")
	private String major;

	@Column(name = "university")
	private String schoolName;

	/*@Column(name = "yearOfGraduate")
	private String yearOfGraduate;*/
	
	@Column(name = "ApplicantId")
	private String ApplicantId;
	
	@Column(name = "joblevelCode")
	private String joblevelCode;
	@Column(name = "technologyCode")
	private String technologyCode;
	
	@Column(name = "joblevelName")
	private String masJoblevelName;
	@Column(name = "technologyName")
	private String masTechnologyName;
	
/*	@Column(name = "positionName1")
	private String positionName1;
	@Column(name = "positionName2")
	private String positionName2;
	@Column(name = "positionName3")
	private String positionName3;*/
	
	@Transient
	private String reportType;
	
	@Transient
	private String applyDateStr;
	
	@Transient
	private String startDate;
	
	@Transient
	private String endDate;

	public String getApplyDateStr() {
		return applyDateStr;
	}
	public void setApplyDateStr(String applyDateStr) {
		this.applyDateStr = applyDateStr;
	}
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getApplicantStatus() {
		return applicantStatus;
	}
	public void setApplicantStatus(String applicantStatus) {
		this.applicantStatus = applicantStatus;
	}
	public Date getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	public String getAttitudeHome() {
		return attitudeHome;
	}
	public void setAttitudeHome(String attitudeHome) {
		this.attitudeHome = attitudeHome;
	}
	public String getAttitudeOffice() {
		return attitudeOffice;
	}
	public void setAttitudeOffice(String attitudeOffice) {
		this.attitudeOffice = attitudeOffice;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstNameEN() {
		return firstNameEN;
	}
	public void setFirstNameEN(String firstNameEN) {
		this.firstNameEN = firstNameEN;
	}
	public String getLastNameEN() {
		return lastNameEN;
	}
	public void setLastNameEN(String lastNameEN) {
		this.lastNameEN = lastNameEN;
	}
	
	public String getFullNameEN() {
		return firstNameEN+"  "+lastNameEN;
	}
	public void setFullNameEN(String fullNameEN) {
		this.fullNameEN = fullNameEN;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getTechScore() {
		return techScore;
	}
	public void setTechScore(String techScore) {
		this.techScore = techScore;
	}
	public String getTrackingStatus() {
		return trackingStatus;
	}
	public void setTrackingStatus(String trackingStatus) {
		this.trackingStatus = trackingStatus;
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
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public String getGpa() {
		return gpa.toString();
	}
	public void setGpa(Double gpa) {
		this.gpa = gpa;
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
	public String getApplicantId() {
		return ApplicantId;
	}
	public void setApplicantId(String applicantId) {
		ApplicantId = applicantId;
	}
	
/*	public String getPositionName1() {
		return positionName1;
	}
	public void setPositionName1(String positionName1) {
		this.positionName1 = positionName1;
	}
	public String getPositionName2() {
		return positionName2;
	}
	public void setPositionName2(String positionName2) {
		this.positionName2 = positionName2;
	}
	public String getPositionName3() {
		return positionName3;
	}
	public void setPositionName3(String positionName3) {
		this.positionName3 = positionName3;
	}*/
	public String getReportType() {
		return reportType;
	}
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	public Integer getDegreeId() {
		return degreeId;
	}
	public void setDegreeId(Integer degreeId) {
		this.degreeId = degreeId;
	}
	public String getMasJoblevelName() {
		return masJoblevelName;
	}
	public void setMasJoblevelName(String masJoblevelName) {
		this.masJoblevelName = masJoblevelName;
	}
	public String getMasTechnologyName() {
		return masTechnologyName;
	}
	public void setMasTechnologyName(String masTechnologyName) {
		this.masTechnologyName = masTechnologyName;
	}
	public String getJoblevelCode() {
		return joblevelCode;
	}
	public void setJoblevelCode(String joblevelCode) {
		this.joblevelCode = joblevelCode;
	}
	public String getTechnologyCode() {
		return technologyCode;
	}
	public void setTechnologyCode(String technologyCode) {
		this.technologyCode = technologyCode;
	}

}
