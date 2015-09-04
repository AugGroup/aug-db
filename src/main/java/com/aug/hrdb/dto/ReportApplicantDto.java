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
		+ "applicant.APPLICANT_ID AS id ,"
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
		+ "applicant.POSITION1_ID AS position1,"
		+ "applicant.POSITION2_ID AS position2,"
		+ "applicant.POSITION3_ID AS position3,"
		+ "education.DEGREE AS degree,"
		+ "education.FACULTY AS faculty,"
		+ "education.GPA AS gpa,"
		+ "education.MAJOR AS major,"
		+ "education.SCHOOL_NAME AS schoolName,"
		+ "education.APPLICANT_ID AS applicantId,"
		+ "position1.ID AS pos1Id,"
		+ "position1.POSITION_CODE AS positionCode1,"
		+ "position1.POSITION_NAME AS positionName1,"
		+ "position2.ID AS pos2Id,"
		+ "position2.POSITION_CODE AS positionCode2,"
		+ "position2.POSITION_NAME AS positionName2,"
		+ "position3.ID AS pos3Id,"
		+ "position3.POSITION_CODE AS positionCode3,"
		+ "position3.POSITION_NAME AS positionName3 "
		+ "FROM APPLICANT applicant "
		+ "LEFT JOIN EDUCATION education ON applicant.APPLICANT_ID = education.APPLICANT_ID "
		+ "LEFT JOIN POSITION position1 ON applicant.POSITION1_ID = position1.ID "
		+ "LEFT JOIN POSITION position2 ON applicant.POSITION2_ID = position2.ID "
		+ "LEFT JOIN POSITION position3 ON applicant.POSITION3_ID = position3.ID ", resultClass = ReportApplicantDto.class),
		
		@NamedNativeQuery(name = "REPORT_SEARCH_BY_CRITERIA", query = "SELECT "
		+ "applicant.APPLICANT_ID AS id, "
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
		+ "applicant.POSITION1_ID AS position1,"
		+ "applicant.POSITION2_ID AS position2,"
		+ "applicant.POSITION3_ID AS position3,"
		+ "education.DEGREE AS degree,"
		+ "education.FACULTY AS faculty,"
		+ "education.GPA AS gpa,"
		+ "education.MAJOR AS major,"
		+ "education.SCHOOL_NAME AS schoolName,"
		+ "education.APPLICANT_ID AS applicantId,"
		+ "position1.ID AS pos1Id,"
		+ "position1.POSITION_CODE AS positionCode1,"
		+ "position1.POSITION_NAME AS positionName1,"
		+ "position2.ID AS pos2Id,"
		+ "position2.POSITION_CODE AS positionCode2,"
		+ "position2.POSITION_NAME AS positionName2,"
		+ "position3.ID AS pos3Id,"
		+ "position3.POSITION_CODE AS positionCode3,"
		+ "position3.POSITION_NAME AS positionName3 "
		+ "FROM APPLICANT applicant "
		+ "LEFT JOIN EDUCATION education ON applicant.APPLICANT_ID = education.APPLICANT_ID "
		+ "LEFT JOIN POSITION position1 ON applicant.POSITION1_ID = position1.ID "
		+ "LEFT JOIN POSITION position2 ON applicant.POSITION2_ID = position2.ID " //WHERE education.DEGREE= :DEGREE AND education.MAJOR =:MAJOR
		+ "LEFT JOIN POSITION position3 ON applicant.POSITION3_ID = position3.ID "
		+ "WHERE education.DEGREE like :DEGREE AND education.MAJOR like :MAJOR AND "
		+ "education.SCHOOL_NAME like :SCHOOL_NAME", resultClass = ReportApplicantDto.class),
		
		@NamedNativeQuery(name = "REPORT_SEARCH_BY_MONTH", query = "SELECT "
		+ "applicant.APPLICANT_ID AS id, "
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
		+ "applicant.POSITION1_ID AS position1,"
		+ "applicant.POSITION2_ID AS position2,"
		+ "applicant.POSITION3_ID AS position3,"
		+ "education.DEGREE AS degree,"
		+ "education.FACULTY AS faculty,"
		+ "education.GPA AS gpa,"
		+ "education.MAJOR AS major,"
		+ "education.SCHOOL_NAME AS schoolName,"
		+ "education.APPLICANT_ID AS applicantId,"
		+ "position1.ID AS pos1Id,"
		+ "position1.POSITION_CODE AS positionCode1,"
		+ "position1.POSITION_NAME AS positionName1,"
		+ "position2.ID AS pos2Id,"
		+ "position2.POSITION_CODE AS positionCode2,"
		+ "position2.POSITION_NAME AS positionName2,"
		+ "position3.ID AS pos3Id,"
		+ "position3.POSITION_CODE AS positionCode3,"
		+ "position3.POSITION_NAME AS positionName3 "
		+ "FROM APPLICANT applicant "
		+ "LEFT JOIN EDUCATION education ON applicant.APPLICANT_ID = education.APPLICANT_ID "
		+ "LEFT JOIN POSITION position1 ON applicant.POSITION1_ID = position1.ID "
		+ "LEFT JOIN POSITION position2 ON applicant.POSITION2_ID = position2.ID " 
		+ "LEFT JOIN POSITION position3 ON applicant.POSITION3_ID = position3.ID "
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

	@Column(name = "position1")
	private Integer position1;
	
	@Column(name = "position2")
	private Integer position2;
	
	@Column(name = "position3")
	private Integer position3;

	@Column(name = "degree")
	private String degree;

	@Column(name = "faculty")
	private String faculty;

	@Column(name = "gpa")
	private Double gpa;

	@Column(name = "major")
	private String major;

	@Column(name = "schoolName")
	private String schoolName;

	/*@Column(name = "yearOfGraduate")
	private String yearOfGraduate;*/
	
	@Column(name = "ApplicantId")
	private String ApplicantId;
		
	@Column(name = "pos1Id")
	private Integer pos1Id;
	@Column(name = "pos2Id")
	private Integer pos2Id;
	@Column(name = "pos3Id")
	private Integer pos3Id;
	
	@Column(name = "positionCode1")
	private String positionCode1;
	@Column(name = "positionCode2")
	private String positionCode2;
	@Column(name = "positionCode3")
	private String positionCode3;
	
	@Column(name = "positionName1")
	private String positionName1;
	@Column(name = "positionName2")
	private String positionName2;
	@Column(name = "positionName3")
	private String positionName3;
	
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
	public Integer getPosition1() {
		return position1;
	}
	public void setPosition1(Integer position1) {
		this.position1 = position1;
	}
	public Integer getPosition2() {
		return position2;
	}
	public void setPosition2(Integer position2) {
		this.position2 = position2;
	}
	public Integer getPosition3() {
		return position3;
	}
	public void setPosition3(Integer position3) {
		this.position3 = position3;
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
	
	public Integer getPos1Id() {
		return pos1Id;
	}
	public void setPos1Id(Integer pos1Id) {
		this.pos1Id = pos1Id;
	}
	public Integer getPos2Id() {
		return pos2Id;
	}
	public void setPos2Id(Integer pos2Id) {
		this.pos2Id = pos2Id;
	}
	public Integer getPos3Id() {
		return pos3Id;
	}
	public void setPos3Id(Integer pos3Id) {
		this.pos3Id = pos3Id;
	}
	public String getPositionCode1() {
		return positionCode1;
	}
	public void setPositionCode1(String positionCode1) {
		this.positionCode1 = positionCode1;
	}
	public String getPositionCode2() {
		return positionCode2;
	}
	public void setPositionCode2(String positionCode2) {
		this.positionCode2 = positionCode2;
	}
	public String getPositionCode3() {
		return positionCode3;
	}
	public void setPositionCode3(String positionCode3) {
		this.positionCode3 = positionCode3;
	}
	public String getPositionName1() {
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
	}
	public String getReportType() {
		return reportType;
	}
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

}
