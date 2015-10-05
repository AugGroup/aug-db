package com.aug.hrdb.entities;

import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.codec.language.bm.Languages;
import org.hibernate.annotations.Index;

import com.aug.hrdb.dto.ApplicantDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "APPLICANT")
public class Applicant extends BaseEntity{
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;

	@Column(name = "APPLICANT_CODE")
	private String code;

	@Column(name = "FIRSTNAME_TH")
	private String firstNameTH;

	@Column(name = "FIRSTNAME_EN")
	private String firstNameEN;

	@Column(name = "LASTNAME_TH")
	private String lastNameTH;

	@Column(name = "LASTNAME_EN")
	private String lastNameEN;

	@Column(name = "NICKNAME_TH")
	private String nickNameTH;

	@Column(name = "NICKNAME_EN")
	private String nickNameEN;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", locale = "en", timezone = "GMT")
	@Column(name = "BIRTHDATE")
	private Date birthDate;

	@Column(name = "PLACE_BIRTH")
	private String placeBirth;

	@Column(name = "AGE")
	private Integer age;

	@Column(name = "HEIGHT")
	private Integer height;

	@Column(name = "WEIGHT")
	private Integer weight;

	@Column(name = "SEX")
	private String sex;

	@Column(name = "RELIGION")
	private String religion;

	@Column(name = "NATIONALITY")
	private String nationality;

	@Column(name = "TEL")
	private String tel;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "APPLICANT_STATUS")
	private String applicantStatus;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", locale = "en", timezone = "GMT")
	@Column(name = "APPLY_DATE")
	private Date applyDate;

	@Column(name = "EMERGENCY_NAME")
	private String emergencyName;

	@Column(name = "EMERGENCY_TEL")
	private String emergencyTel;

	@Column(name = "EMERGENCY_ADDRESS")
	private String emergencyAddress;

	@Column(name = "NOTICE_NEWSPAPER")
	private String noticeNewspaper;

	@Column(name = "NOTICE_MAGAZINE")
	private String noticeMagazine;

	@Column(name = "NOTICE_FRIEND")
	private String noticeFriend;

	@Column(name = "NOTICE_WEBSITE")
	private String noticeWebSite;

	@Column(name = "NOTICE_OTHER")
	private String noticeOther;
	
	@Column(name = "NEWSPAPER_DESCRIPTION")
	private String newspaperDescription;
	
	@Column(name = "MAGAZINE_DESCRIPTION")
	private String magazineDescription;
	
	@Column(name = "FRIEND_DESCRIPTION")
	private String friendDescription;
	
	@Column(name = "WEBSITE_DESCRIPTION")
	private String webSiteDescription;
	
	@Column(name = "OTHER_DESCRIPTION")
	private String otherDescription;
	
	@ManyToOne
	@JoinColumn(name = "MASTECHNOLOGY_ID", referencedColumnName = "id", nullable = false)
	private MasTechnology technology;

	@ManyToOne
	@JoinColumn(name = "MASJOBLEVEL_ID", referencedColumnName = "id", nullable = false)
	private MasJoblevel joblevel;

	@Column(name = "TRACKING_STATUS")
	private String trackingStatus;

	@Column(name = "EXPECTED_SALARY")
	private String expectedSalary;

	@Column(name = "CARD_ID")
	private String cardId;

	@Column(name = "CARD_ISSUED_OFFICE")
	private String cardIssuedOffice;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", locale = "en", timezone = "GMT")
	@Column(name = "CARD_EXPIRY_DATE")
	private Date cardExpiryDate;

	@Column(name = "MILITARY_FROM_YEAR")
	private String militaryFromYear;

	@Column(name = "MILITARY_TO_YEAR")
	private String militarytoYear;

	@Column(name = "MILITARY_PLACE")
	private String militaryPlace;

	@Column(name = "MILITARY_SERVICE_NO")
	private String militaryServiceNo;

	@Column(name = "MILITARY_REASON")
	private String militaryReason;
	
	@Column(name = "MILITARY_STATUS")
	private String militaryStatus;

	@Column(name = "NUMBER_OF_CHILDREN")
	private String numberOfChildren;

	@Column(name = "SPOUSE_NAME")
	private String spouseName;

	@Column(name = "MARRIAGE_CERTIFICATE_NO")
	private String marriageCertificateNo;

	@Column(name = "ISSUE_OFFICE_MARRIAGE")
	private String issueOficeMarriage;

	@Column(name = "OCCUPATION_MARRIAGE")
	private String occupationMarriage;

	@Column(name = "SCORE")
	private String score;

	@Column(name = "TECH_SCORE")
	private String techScore;

	@Column(name = "ATTITUDE_HOME")
	private String attitudeHome;

	@Column(name = "ATTITUDE_OFFICE")
	private String attitudeOffice;

	@Column(name = "NOW_EMPLOYED")
	private String nowEmployed;

	@Column(name = "EMPLOYED_NAME")
	private String employedName;

	@Column(name = "EMPLOYED_POSITION")
	private String employedPosition;

	@Column(name = "EMPLOYED_RELATION")
	private String employedRelation;

	@Column(name = "BRANCH_SERVICE")
	private String branchService;

	@Column(name = "PREVIOUS_EMPLOYERS")
	private String previousEmployers;

	@Column(name = "PREVIOUS_EMPLOYERS_REASON")
	private String previousEmployersReason;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", locale = "en", timezone = "GMT")
	@Column(name = "DATE_TO_BE_DRAFTED")
	private Date dateToBeDrafted;

	@Column(name = "MARRIAGE_ADDRESS")
	private String marriageAddress;
	
	@Column(name = "RESUME")
	private String resume;
	
	@Column(name = "TRANSCRIPT")
	private String transcript;
	
	@Column(name = "IMAGE")
	private String image;

	@JsonIgnore
	@OneToMany(mappedBy = "applicant",cascade=CascadeType.REMOVE)
	private List<Reference> references;

	@JsonIgnore
	@OneToMany(mappedBy = "applicant",cascade=CascadeType.REMOVE)
	private List<Family> families;

	@JsonIgnore
	@OneToMany(mappedBy = "applicant",cascade=CascadeType.REMOVE)
	private Set<Language> languages;

	@JsonIgnore
	@OneToMany(mappedBy = "applicant",cascade=CascadeType.REMOVE)
	private List<Address> address;

	@JsonIgnore
	@OneToMany(mappedBy = "applicant",cascade=CascadeType.REMOVE, fetch=FetchType.EAGER)
	private List<Education> educations;

	@JsonIgnore
	@OneToMany(mappedBy = "applicant",cascade=CascadeType.REMOVE)
	private List<MasCoreSkill> masCoreSkills;

	@JsonIgnore
	@OneToMany(mappedBy = "applicant",cascade=CascadeType.REMOVE)
	private List<Experience> experiences;
	
	@JsonIgnore
	@OneToMany(mappedBy = "applicant",cascade=CascadeType.REMOVE)
	private List<Certification> certifications;
	
	@JsonIgnore
	@OneToMany(mappedBy = "applicant",cascade=CascadeType.REMOVE)
	private List<Ability> abilities;
	
	@JsonIgnore
	@OneToMany(mappedBy ="applicant",cascade=CascadeType.REMOVE)
	private List<Appointment> appointments;
	
	@Transient
	private String reportType;
	
	@JsonIgnore
	@OneToOne(mappedBy="applicant",cascade=CascadeType.REMOVE)
	private Employee employee;
	
	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFirstNameTH() {
		return firstNameTH;
	}

	public void setFirstNameTH(String firstNameTH) {
		this.firstNameTH = firstNameTH;
	}

	public String getFirstNameEN() {
		return firstNameEN;
	}

	public void setFirstNameEN(String firstNameEN) {
		this.firstNameEN = firstNameEN;
	}

	public String getLastNameTH() {
		return lastNameTH;
	}

	public void setLastNameTH(String lastNameTH) {
		this.lastNameTH = lastNameTH;
	}

	public String getLastNameEN() {
		return lastNameEN;
	}

	public void setLastNameEN(String lastNameEN) {
		this.lastNameEN = lastNameEN;
	}

	public String getNickNameTH() {
		return nickNameTH;
	}

	public void setNickNameTH(String nickNameTH) {
		this.nickNameTH = nickNameTH;
	}

	public String getNickNameEN() {
		return nickNameEN;
	}

	public void setNickNameEN(String nickNameEN) {
		this.nickNameEN = nickNameEN;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getEmergencyName() {
		return emergencyName;
	}

	public void setEmergencyName(String emergencyName) {
		this.emergencyName = emergencyName;
	}

	public String getEmergencyTel() {
		return emergencyTel;
	}

	public void setEmergencyTel(String emergencyTel) {
		this.emergencyTel = emergencyTel;
	}

	public String getEmergencyAddress() {
		return emergencyAddress;
	}

	public void setEmergencyAddress(String emergencyAddress) {
		this.emergencyAddress = emergencyAddress;
	}

	public String getNoticeNewspaper() {
		return noticeNewspaper;
	}

	public void setNoticeNewspaper(String noticeNewspaper) {
		this.noticeNewspaper = noticeNewspaper;
	}

	public String getNoticeMagazine() {
		return noticeMagazine;
	}

	public void setNoticeMagazine(String noticeMagazine) {
		this.noticeMagazine = noticeMagazine;
	}

	public String getNoticeFriend() {
		return noticeFriend;
	}

	public void setNoticeFriend(String noticeFriend) {
		this.noticeFriend = noticeFriend;
	}

	public String getNoticeWebSite() {
		return noticeWebSite;
	}

	public void setNoticeWebSite(String noticeWebSite) {
		this.noticeWebSite = noticeWebSite;
	}

	public String getNoticeOther() {
		return noticeOther;
	}

	public void setNoticeOther(String noticeOther) {
		this.noticeOther = noticeOther;
	}

	public String getNewspaperDescription() {
		return newspaperDescription;
	}

	public void setNewspaperDescription(String newspaperDescription) {
		this.newspaperDescription = newspaperDescription;
	}

	public String getMagazineDescription() {
		return magazineDescription;
	}

	public void setMagazineDescription(String magazineDescription) {
		this.magazineDescription = magazineDescription;
	}

	public String getFriendDescription() {
		return friendDescription;
	}

	public void setFriendDescription(String friendDescription) {
		this.friendDescription = friendDescription;
	}

	public String getWebSiteDescription() {
		return webSiteDescription;
	}

	public void setWebSiteDescription(String webSiteDescription) {
		this.webSiteDescription = webSiteDescription;
	}

	public String getOtherDescription() {
		return otherDescription;
	}

	public void setOtherDescription(String otherDescription) {
		this.otherDescription = otherDescription;
	}

//	public Position getPosition1() {
//		return position1;
//	}
//
//	public void setPosition1(Position position1) {
//		this.position1 = position1;
//	}
//
//	public Position getPosition2() {
//		return position2;
//	}
//
//	public void setPosition2(Position position2) {
//		this.position2 = position2;
//	}
//
//	public Position getPosition3() {
//		return position3;
//	}
//
//	public void setPosition3(Position position3) {
//		this.position3 = position3;
//	}

	public String getTrackingStatus() {
		return trackingStatus;
	}

	public void setTrackingStatus(String trackingStatus) {
		this.trackingStatus = trackingStatus;
	}
	
	public String getExpectedSalary() {
		return expectedSalary;
	}

	public void setExpectedSalary(String expectedSalary) {
		this.expectedSalary = expectedSalary;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getCardIssuedOffice() {
		return cardIssuedOffice;
	}

	public void setCardIssuedOffice(String cardIssuedOffice) {
		this.cardIssuedOffice = cardIssuedOffice;
	}

	public Date getCardExpiryDate() {
		return cardExpiryDate;
	}

	public void setCardExpiryDate(Date cardExpiryDate) {
		this.cardExpiryDate = cardExpiryDate;
	}

	public String getMilitaryFromYear() {
		return militaryFromYear;
	}

	public void setMilitaryFromYear(String militaryFromYear) {
		this.militaryFromYear = militaryFromYear;
	}

	public String getMilitarytoYear() {
		return militarytoYear;
	}

	public void setMilitarytoYear(String militarytoYear) {
		this.militarytoYear = militarytoYear;
	}

	public String getMilitaryPlace() {
		return militaryPlace;
	}

	public void setMilitaryPlace(String militaryPlace) {
		this.militaryPlace = militaryPlace;
	}

	public String getMilitaryServiceNo() {
		return militaryServiceNo;
	}

	public void setMilitaryServiceNo(String militaryServiceNo) {
		this.militaryServiceNo = militaryServiceNo;
	}

	public String getMilitaryReason() {
		return militaryReason;
	}

	public void setMilitaryReason(String militaryReason) {
		this.militaryReason = militaryReason;
	}

	public String getNumberOfChildren() {
		return numberOfChildren;
	}

	public void setNumberOfChildren(String numberOfChildren) {
		this.numberOfChildren = numberOfChildren;
	}

	public String getSpouseName() {
		return spouseName;
	}

	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}

	public String getMarriageCertificateNo() {
		return marriageCertificateNo;
	}

	public void setMarriageCertificateNo(String marriageCertificateNo) {
		this.marriageCertificateNo = marriageCertificateNo;
	}

	public String getIssueOficeMarriage() {
		return issueOficeMarriage;
	}

	public void setIssueOficeMarriage(String issueOficeMarriage) {
		this.issueOficeMarriage = issueOficeMarriage;
	}

	public String getOccupationMarriage() {
		return occupationMarriage;
	}

	public void setOccupationMarriage(String occupationMarriage) {
		this.occupationMarriage = occupationMarriage;
	}

	public List<Reference> getReferences() {
		return references;
	}

	public void setReferences(List<Reference> references) {
		this.references = references;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public String getTechScore() {
		return techScore;
	}

	public void setTechScore(String techScore) {
		this.techScore = techScore;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
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

	public String getPlaceBirth() {
		return placeBirth;
	}

	public void setPlaceBirth(String placeBirth) {
		this.placeBirth = placeBirth;
	}

	public String getNowEmployed() {
		return nowEmployed;
	}

	public void setNowEmployed(String nowEmployed) {
		this.nowEmployed = nowEmployed;
	}

	public String getEmployedName() {
		return employedName;
	}

	public void setEmployedName(String employedName) {
		this.employedName = employedName;
	}

	public String getEmployedPosition() {
		return employedPosition;
	}

	public void setEmployedPosition(String employedPosition) {
		this.employedPosition = employedPosition;
	}

	public String getEmployedRelation() {
		return employedRelation;
	}

	public void setEmployedRelation(String employedRelation) {
		this.employedRelation = employedRelation;
	}

	public String getBranchService() {
		return branchService;
	}

	public void setBranchService(String branchService) {
		this.branchService = branchService;
	}

	public String getPreviousEmployers() {
		return previousEmployers;
	}

	public void setPreviousEmployers(String previousEmployers) {
		this.previousEmployers = previousEmployers;
	}

	public String getPreviousEmployersReason() {
		return previousEmployersReason;
	}

	public void setPreviousEmployersReason(String previousEmployersReason) {
		this.previousEmployersReason = previousEmployersReason;
	}

	public Date getDateToBeDrafted() {
		return dateToBeDrafted;
	}

	public void setDateToBeDrafted(Date dateToBeDrafted) {
		this.dateToBeDrafted = dateToBeDrafted;
	}

	public String getMarriageAddress() {
		return marriageAddress;
	}

	public void setMarriageAddress(String marriageAddress) {
		this.marriageAddress = marriageAddress;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getTranscript() {
		return transcript;
	}

	public void setTranscript(String transcript) {
		this.transcript = transcript;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getMilitaryStatus() {
		return militaryStatus;
	}

	public void setMilitaryStatus(String militaryStatus) {
		this.militaryStatus = militaryStatus;
	}
	
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Set<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(Set<Language> languages) {
		this.languages = languages;
	}

	public List<Certification> getCertifications() {
		return certifications;
	}

	public void setCertifications(List<Certification> certifications) {
		this.certifications = certifications;
	}

	public List<Family> getFamilies() {
		return families;
	}

	public void setFamilies(List<Family> families) {
		this.families = families;
	}

	public List<Education> getEducations() {
		return educations;
	}

	public void setEducations(List<Education> educations) {
		this.educations = educations;
	}

	public List<MasCoreSkill> getMasCoreSkills() {
		return masCoreSkills;
	}

	public void setMasCoreSkills(List<MasCoreSkill> masCoreSkills) {
		this.masCoreSkills = masCoreSkills;
	}

	public List<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}


	public MasTechnology getTechnology() {
		return technology;
	}

	public void setTechnology(MasTechnology technology) {
		this.technology = technology;
	}

	public MasJoblevel getJoblevel() {
		return joblevel;
	}

	public void setJoblevel(MasJoblevel joblevel) {
		this.joblevel = joblevel;
	}
	
	
	public List<Ability> getAbilities() {
		return abilities;
	}

	public void setAbilities(List<Ability> abilities) {
		this.abilities = abilities;
	}

	public Applicant fromApplicantDTO(Applicant applicant,ApplicantDto applicantDto) throws ParseException {
		applicant.setId(applicantDto.getId());
		applicant.setFirstNameTH(applicantDto.getFirstNameTH());
		applicant.setFirstNameEN(applicantDto.getFirstNameEN());
		applicant.setLastNameTH(applicantDto.getLastNameTH());
		applicant.setLastNameEN(applicantDto.getLastNameEN());
		applicant.setNickNameTH(applicantDto.getNickNameTH());
		applicant.setNickNameEN(applicantDto.getNickNameEN());
		applicant.setBirthDate(applicantDto.getBirthDate());
		applicant.setPlaceBirth(applicantDto.getPlaceBirth());
		applicant.setAge(applicantDto.getAge());
		applicant.setHeight(applicantDto.getHeight());
		applicant.setWeight(applicantDto.getWeight());
		applicant.setReligion(applicantDto.getReligion());
		applicant.setNationality(applicantDto.getNationality());
		applicant.setTel(applicantDto.getTel());
		applicant.setApplicantStatus(applicantDto.getApplicantStatus());
		applicant.setEmail(applicantDto.getEmail());
		applicant.setApplyDate(applicantDto.getApplyDate());
		applicant.setEmergencyName(applicantDto.getEmergencyName());
		applicant.setEmergencyTel(applicantDto.getEmergencyTel());
		applicant.setEmergencyAddress(applicantDto.getEmergencyAddress());
		applicant.setNoticeNewspaper(applicantDto.getNoticeNewspaper());
		applicant.setNoticeMagazine(applicantDto.getNoticeMagazine());
		applicant.setNoticeFriend(applicantDto.getNoticeFriend());
		applicant.setNoticeWebSite(applicantDto.getNoticeWebSite());
		applicant.setNoticeOther(applicantDto.getNoticeOther());
		applicant.setNewspaperDescription(applicantDto.getNewspaperDescription());
		applicant.setMagazineDescription(applicantDto.getMagazineDescription());
		applicant.setFriendDescription(applicantDto.getFriendDescription());
		applicant.setWebSiteDescription(applicantDto.getWebSiteDescription());
		applicant.setOtherDescription(applicantDto.getOtherDescription());
		applicant.setExpectedSalary(applicantDto.getExpectedSalary());
		applicant.setCardId(applicantDto.getCardId());
		applicant.setCardIssuedOffice(applicantDto.getCardIssuedOffice());
		applicant.setCardExpiryDate(applicantDto.getCardExpiryDate());
		applicant.setMilitaryFromYear(applicantDto.getMilitaryFromYear());
		applicant.setMilitarytoYear(applicantDto.getMilitarytoYear());
		applicant.setMilitaryPlace(applicantDto.getMilitaryPlace());
		applicant.setMilitaryServiceNo(applicantDto.getMilitaryServiceNo());
		applicant.setMilitaryReason(applicantDto.getMilitaryReason());
		applicant.setNumberOfChildren(applicantDto.getNumberOfChildren());
		applicant.setSpouseName(applicantDto.getSpouseName());
		applicant.setMarriageCertificateNo(applicantDto.getMarriageCertificateNo());
		applicant.setIssueOficeMarriage(applicantDto.getIssueOficeMarriage());
		applicant.setOccupationMarriage(applicantDto.getOccupationMarriage());
		applicant.setNowEmployed(applicantDto.getNowEmployed());
		applicant.setEmployedName(applicantDto.getEmployedName());
		applicant.setEmployedPosition(applicantDto.getEmployedPosition());
		applicant.setEmployedRelation(applicantDto.getEmployedRelation());
		applicant.setBranchService(applicantDto.getBranchService());
		applicant.setPreviousEmployers(applicantDto.getPreviousEmployers());
		applicant.setPreviousEmployersReason(applicantDto.getPreviousEmployersReason());
		applicant.setDateToBeDrafted(applicantDto.getDateToBeDrafted());
		applicant.setMarriageAddress(applicantDto.getMarriageAddress());
		applicant.setResume(applicantDto.getResume());
		applicant.setTranscript(applicantDto.getTranscript());
		applicant.setImage(applicantDto.getImage());
		applicant.setJoblevel(applicantDto.getJoblevel());
		applicant.setTechnology(applicantDto.getTechnology());
		applicant.setImage(applicantDto.getImage());
		applicant.setTranscript(applicantDto.getTranscript());
		applicant.setResume(applicantDto.getResume());
		applicant.setSex(applicantDto.getSex());
		applicant.setMilitaryStatus(applicantDto.getMilitaryStatus());
		applicant.setCode(applicantDto.getCode());
		applicant.setScore(applicantDto.getScore());
		applicant.setTechScore(applicantDto.getTechScore());
		applicant.setAttitudeHome(applicantDto.getAttitudeHome());
		applicant.setAttitudeOffice(applicantDto.getAttitudeOffice());
		applicant.setTrackingStatus(applicantDto.getTrackingStatus());
		applicant.setCreatedBy(applicantDto.getCreatedBy());
		applicant.setCreatedTimeStamp(applicantDto.getCreatedTimeStamp());
		return applicant;

	}
	
}
