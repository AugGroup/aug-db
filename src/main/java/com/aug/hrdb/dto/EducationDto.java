package com.aug.hrdb.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@NamedNativeQueries({
  @NamedNativeQuery(
    name = "SEARCH_EDUCATION",
    query = "SELECT ed.ID, ed.UNIVERSITY, mas_degreetype.NAME, ed.FACULTY, ed.MAJOR, "
      + "ed.START_DATE, ed.GPA, ed.GRADUATED_DATE,ed.CERTIFICATION, ed.APPLICANT_ID,ed.MAS_DEGREETYPE_ID "
      + "FROM EDUCATION ed LEFT JOIN MAS_DEGREETYPE as mas_degreetype on mas_degreetype.ID = ed.MAS_DEGREETYPE_ID "
      + "LEFT JOIN APPLICANT a on ed.APPLICANT_ID = a.ID WHERE ed.APPLICANT_ID =:ID",
    resultClass = EducationDto.class),

  @NamedNativeQuery(
    name = "SEARCH_EDUCATION_ID",
    query = "SELECT ed.ID, ed.UNIVERSITY, ed.MAS_DEGREETYPE_ID, ed.FACULTY, ed.MAJOR, "
      + "ed.START_DATE, ed.GPA, ed.GRADUATED_DATE,ed.CERTIFICATION, ed.APPLICANT_ID , mas_degreetype.NAME"
      + " FROM EDUCATION ed JOIN MAS_DEGREETYPE mas_degreetype on mas_degreetype.ID = ed.MAS_DEGREETYPE_ID WHERE ed.ID =:ID",
    resultClass = EducationDto.class)
})
public class EducationDto {

  @Id
  @Column(name = "ID")
  private Integer id;

  @Column(name = "UNIVERSITY")
  private String university;

  @Column(name = "MAS_DEGREETYPE_ID")
  private Integer masDegreeTypeId;

  @Column(name = "NAME")
  private String masDegreeType;

  @Column(name = "FACULTY")
  private String faculty;

  @Column(name = "MAJOR")
  private String major;

  @Column(name = "GPA")
  private String gpa;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", locale = "en", timezone = "GMT")
  @Column(name = "START_DATE")
  private Date start_date;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", locale = "en", timezone = "GMT")
  @Column(name = "GRADUATED_DATE")
  private Date graduated_date;

  @Column(name = "CERTIFICATION")
  private String certification;

  @Column(name = "APPLICANT_ID")
  private Integer applicantId;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUniversity() {
    return university;
  }

  public void setUniversity(String university) {
    this.university = university;
  }

  public Integer getMasDegreeTypeId() {
    return masDegreeTypeId;
  }

  public void setMasDegreeTypeId(Integer masDegreeTypeId) {
    this.masDegreeTypeId = masDegreeTypeId;
  }

  public String getMasDegreeType() {
    return masDegreeType;
  }

  public void setMasDegreeType(String masDegreeType) {
    this.masDegreeType = masDegreeType;
  }

  public String getFaculty() {
    return faculty;
  }

  public void setFaculty(String faculty) {
    this.faculty = faculty;
  }

  public String getMajor() {
    return major;
  }

  public void setMajor(String major) {
    this.major = major;
  }

  public String getGpa() {
    return gpa;
  }

  public void setGpa(String gpa) {
    this.gpa = gpa;
  }

  public Date getStart_date() {
    return start_date;
  }

  public void setStart_date(Date start_date) {
    this.start_date = start_date;
  }

  public Date getGraduated_date() {
    return graduated_date;
  }

  public void setGraduated_date(Date graduated_date) {
    this.graduated_date = graduated_date;
  }

  public String getCertification() {
    return certification;
  }

  public void setCertification(String certification) {
    this.certification = certification;
  }

  public Integer getApplicantId() {
    return applicantId;
  }

  public void setApplicantId(Integer applicantId) {
    this.applicantId = applicantId;
  }

}