package com.aug.hrdb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.aug.hrdb.dto.CertificationDto;

@Entity
@Table(name = "CERTIFICATION")
public class Certification extends BaseEntity {
  @Id
  @GeneratedValue
  @Column(name = "ID")
  private Integer id;

  @Column(name = "CERTIFICATION_FORM")
  private String certificationForm;

  @Column(name = "DESCRIPTION")
  private String description;

  @Column(name = "NAME")
  private String name;

  @Column(name = "YEAR")
  private String year;

  @ManyToOne
  @JoinColumn(name = "APPLICANT_ID")
  private Applicant applicant;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCertificationForm() {
    return certificationForm;
  }

  public void setCertificationForm(String certificationForm) {
    this.certificationForm = certificationForm;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public Applicant getApplicant() {
    return applicant;
  }

  public void setApplicant(Applicant applicant) {
    this.applicant = applicant;
  }

  public Certification fromCertificationDto(Certification certification, CertificationDto certificationDto) {
    certification.setId(certificationDto.getId());
    certification.setYear(certificationDto.getYear());
    certification.setName(certificationDto.getName());
    certification.setCertificationForm(certificationDto.getCertificationForm());
    certification.setDescription(certificationDto.getDescription());

    Applicant applicant = new Applicant();
    applicant.setId(certificationDto.getId());
    certification.setApplicant(applicant);

    return certification;

  }

  public CertificationDto toCertificationDto() {
    CertificationDto certificationDto = new CertificationDto();
    certificationDto.setId(this.id);
    certificationDto.setYear(this.year);
    certificationDto.setName(this.name);
    certificationDto.setCertificationForm(this.certificationForm);
    certificationDto.setDescription(this.description);
    certificationDto.setApplicantId(this.applicant.getId());

    return certificationDto;

  }

}
