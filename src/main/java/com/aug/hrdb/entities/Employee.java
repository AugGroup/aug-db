/**
 * @author natechanok
 * @date May 2, 2015
 */

package com.aug.hrdb.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@NamedNativeQueries({
  @NamedNativeQuery(
    name = "searchIdEmptoAddress",
    query = "select * from EMPLOYEE ORDER BY ID desc LIMIT 1;",
    resultClass = Employee.class)
})

@Entity
@Table(name = "EMPLOYEE")
public class Employee extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Integer id;

  @Column(name = "EMPLOYEE_CODE", nullable = false, unique = true)
  private String employeeCode;

  @Column(name = "TEL_HOME", nullable = false)
  private String telHome;

  @Column(name = "TEL_FAX", nullable = true)
  private String telFax;

  @Column(name = "CONGENITAL_DISEASE", nullable = true)
  private String congenitalDisease;

  @Column(name = "HOSPITAL", nullable = true)
  private String hospital;

  @Column(name = "RELATIONSHIP_WITH_EMERGENCY_CONTACT", nullable = true)
  private String relationshipWithEmergencyContact;

  @Column(name = "PREVIOUS_EMPLOYER", nullable = true)
  private String previousEmployer;

  @Column(name = "PREVIOUSEMP_REASONS_NO", nullable = true)
  private String previousEmpReasonsNo;

  @Column(name = "STATUSEMP", nullable = false)
  @NotEmpty
  private String statusEmp;

  @Column(name = "ISMANAGER", nullable = true)
  private Integer isManager;

  //------------------self relation-------------------
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "AIM_EMP_ID", referencedColumnName = "id", nullable = true, insertable = true, updatable = true)
  private Employee aimEmpId;

  @OneToMany(mappedBy = "aimEmpId", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
  private Set<Employee> staffs = new HashSet<Employee>();

  @OneToMany(mappedBy = "requester", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
  @JsonIgnore
  private Set<AugRequest> requester = new HashSet<AugRequest>();

  @OneToMany(mappedBy = "approver", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
  @JsonIgnore
  private Set<AugRequest> approver = new HashSet<AugRequest>();

  @OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE)
  private Set<Allowance> allowances = new HashSet<Allowance>();

  @OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE)
  private Set<History> histories = new HashSet<History>();

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "MAS_CORE_SKILL_ID")
  private MasCoreSkill masCoreSkill;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "EMPLOYMENT_ID")
  private MasEmployment masEmployment;

  @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
  private Set<Leave> leaves = new HashSet<Leave>();

  @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
  private Set<Punish> punishs = new HashSet<Punish>();

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "DIVISION_ID", referencedColumnName = "id", nullable = false)
  private MasDivision masDivision;

  @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
  @JsonIgnore
  private Set<Reward> rewards = new HashSet<Reward>();

  @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
  @JsonIgnore
  private Set<Card> cards = new HashSet<Card>();

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "STAFFTYPE_ID")
  private MasStaffType masStaffType;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "LOCATION_ID")
  private MasLocation masLocation;

  @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
  @JsonIgnore
  private Set<Probation> probations = new HashSet<Probation>();

  @OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE)
  private Set<Site> site = new HashSet<Site>();

  @OneToOne(fetch = FetchType.LAZY, mappedBy = "employee", cascade = CascadeType.REMOVE)
  private Login login;

  @OneToOne(mappedBy = "employee", cascade = CascadeType.REMOVE)
  private Health health;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "APPLICANT_ID", nullable = false)
  private Applicant applicant;

  @OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE)
  @JsonIgnore
  private Set<Reservation> reservation = new HashSet<Reservation>();

  @Transient
  private String status;

  @Transient
  private Integer masCoreSkillId;

  @Transient
  private Integer technologyId;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getEmployeeCode() {
    return employeeCode;
  }

  public void setEmployeeCode(String employeeCode) {
    this.employeeCode = employeeCode;
  }

  public String getTelHome() {
    return telHome;
  }

  public void setTelHome(String telHome) {
    this.telHome = telHome;
  }

  public String getTelFax() {
    return telFax;
  }

  public void setTelFax(String telFax) {
    this.telFax = telFax;
  }

  public String getCongenitalDisease() {
    return congenitalDisease;
  }

  public void setCongenitalDisease(String congenitalDisease) {
    this.congenitalDisease = congenitalDisease;
  }

  public String getHospital() {
    return hospital;
  }

  public void setHospital(String hospital) {
    this.hospital = hospital;
  }

  public String getRelationshipWithEmergencyContact() {
    return relationshipWithEmergencyContact;
  }

  public void setRelationshipWithEmergencyContact(String relationshipWithEmergencyContact) {
    this.relationshipWithEmergencyContact = relationshipWithEmergencyContact;
  }

  public String getPreviousEmployer() {
    return previousEmployer;
  }

  public void setPreviousEmployer(String previousEmployer) {
    this.previousEmployer = previousEmployer;
  }

  public String getPreviousEmpReasonsNo() {
    return previousEmpReasonsNo;
  }

  public void setPreviousEmpReasonsNo(String previousEmpReasonsNo) {
    this.previousEmpReasonsNo = previousEmpReasonsNo;
  }

  public String getStatusEmp() {
    return statusEmp;
  }

  public void setStatusEmp(String statusEmp) {
    this.statusEmp = statusEmp;
  }

  public Integer getIsManager() {
    return isManager;
  }

  public void setIsManager(Integer isManager) {
    this.isManager = isManager;
  }

  public Employee getAimEmpId() {
    return aimEmpId;
  }

  public void setAimEmpId(Employee aimEmpId) {
    this.aimEmpId = aimEmpId;
  }

  public Set<Employee> getStaffs() {
    return staffs;
  }

  public void setStaffs(Set<Employee> staffs) {
    this.staffs = staffs;
  }

  public Set<AugRequest> getRequester() {
    return requester;
  }

  public void setRequester(Set<AugRequest> requester) {
    this.requester = requester;
  }

  public Set<AugRequest> getApprover() {
    return approver;
  }

  public void setApprover(Set<AugRequest> approver) {
    this.approver = approver;
  }

  public Set<Allowance> getAllowances() {
    return allowances;
  }

  public void setAllowances(Set<Allowance> allowances) {
    this.allowances = allowances;
  }

  public Set<History> getHistories() {
    return histories;
  }

  public void setHistories(Set<History> histories) {
    this.histories = histories;
  }

  public MasCoreSkill getMasCoreSkill() {
    return masCoreSkill;
  }

  public void setMasCoreSkill(MasCoreSkill masCoreSkill) {
    this.masCoreSkill = masCoreSkill;
  }

  public MasEmployment getMasEmployment() {
    return masEmployment;
  }

  public void setMasEmployment(MasEmployment masEmployment) {
    this.masEmployment = masEmployment;
  }

  public Set<Leave> getLeaves() {
    return leaves;
  }

  public void setLeaves(Set<Leave> leaves) {
    this.leaves = leaves;
  }

  public Set<Punish> getPunishs() {
    return punishs;
  }

  public void setPunishs(Set<Punish> punishs) {
    this.punishs = punishs;
  }

  public MasDivision getMasDivision() {
    return masDivision;
  }

  public void setMasDivision(MasDivision masDivision) {
    this.masDivision = masDivision;
  }

  public Set<Reward> getRewards() {
    return rewards;
  }

  public void setRewards(Set<Reward> rewards) {
    this.rewards = rewards;
  }

  public Set<Card> getCards() {
    return cards;
  }

  public void setCards(Set<Card> cards) {
    this.cards = cards;
  }

  public MasStaffType getMasStaffType() {
    return masStaffType;
  }

  public void setMasStaffType(MasStaffType masStaffType) {
    this.masStaffType = masStaffType;
  }

  public MasLocation getMasLocation() {
    return masLocation;
  }

  public void setMasLocation(MasLocation masLocation) {
    this.masLocation = masLocation;
  }

  public Set<Probation> getProbations() {
    return probations;
  }

  public void setProbations(Set<Probation> probations) {
    this.probations = probations;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Integer getMasCoreSkillId() {
    return masCoreSkillId;
  }

  public void setMasCoreSkillId(Integer masCoreSkillId) {
    this.masCoreSkillId = masCoreSkillId;
  }

  public Integer getTechnologyId() {
    return technologyId;
  }

  public void setTechnologyId(Integer technologyId) {
    this.technologyId = technologyId;
  }

  public Set<Site> getSite() {
    return site;
  }

  public void setSite(Set<Site> site) {
    this.site = site;
  }

  public Login getLogin() {
    return login;
  }

  public void setLogin(Login login) {
    this.login = login;
  }

  public Health getHealth() {
    return health;
  }

  public void setHealth(Health health) {
    this.health = health;
  }

  public Applicant getApplicant() {
    return applicant;
  }

  public void setApplicant(Applicant applicant) {
    this.applicant = applicant;
  }

  public Set<Reservation> getReservation() {
    return reservation;
  }

  public void setReservation(Set<Reservation> reservation) {
    this.reservation = reservation;
  }

}