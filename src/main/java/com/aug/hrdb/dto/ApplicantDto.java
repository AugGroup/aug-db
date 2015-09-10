package com.aug.hrdb.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.annotation.JsonFormat;



@NamedNativeQueries({
	
	@NamedNativeQuery(name = "SEARCH_BY_ID_APPLICATION", query = "SELECT a.APPLICANT_ID, a.APPLICANT_CODE, a.FIRSTNAME_TH, a.FIRSTNAME_EN, a.LASTNAME_TH, a.LASTNAME_EN, a.NICKNAME_TH, a.NICKNAME_EN,"
		+ "a.BIRTHDATE, a.PLACE_BIRTH, a.AGE, a.HEIGHT, a.WEIGHT, a.RELIGION, a.NATIONALITY, a.TEL, a.EMAIL,"
		+ "a.APPLICANT_STATUS, a.APPLY_DATE, a.EMERGENCY_NAME, a.EMERGENCY_TEL, a.EMERGENCY_ADDRESS, a.NOTICE_NEWSPAPER, a.NOTICE_MAGAZINE, a.NOTICE_FRIEND, a.NOTICE_WEBSITE, a.NOTICE_OTHER, a.TRACKING_STATUS,"
		+ "a.EXPECTED_SALARY, a.CARD_ID, a.CARD_ISSUED_OFFICE, a.CARD_EXPIRY_DATE, a.MILITARY_FROM_YEAR, a.MILITARY_TO_YEAR, a.MILITARY_PLACE, a.MILITARY_SERVICE_NO, a.MILITARY_REASON, a.MILITARY_STATUS, a.NEWSPAPER_DESCRIPTION, a.MAGAZINE_DESCRIPTION, a.FRIEND_DESCRIPTION, a.WEBSITE_DESCRIPTION, a.OTHER_DESCRIPTION,"
		+ "a.NUMBER_OF_CHILDREN, a.SPOUSE_NAME, a.MARRIAGE_CERTIFICATE_NO, a.ISSUE_OFFICE_MARRIAGE, a.OCCUPATION_MARRIAGE, a.SCORE, a.TECH_SCORE, a.ATTITUDE_HOME, a.ATTITUDE_OFFICE, a.POSITION1_ID, a.POSITION2_ID, a.POSITION3_ID, a.NOW_EMPLOYED, a.EMPLOYED_NAME, a.EMPLOYED_POSITION,"
		+ "a.EMPLOYED_RELATION, a.BRANCH_SERVICE, a.PREVIOUS_EMPLOYERS, a.PREVIOUS_EMPLOYERS_REASON, a.DATE_TO_BE_DRAFTED, a.MARRIAGE_ADDRESS, null as POSITION_NAME, a.EMERGENCY_NAME,a.EMERGENCY_TEL,a.EMERGENCY_ADDRESS,a.RESUME,a.TRANSCRIPT,a.IMAGE,a.SEX,a.POSITION1_ID,a.POSITION2_ID,a.POSITION3_ID "
		+ " FROM APPLICANT a WHERE a.APPLICANT_ID = :ID", resultClass = ApplicantDto.class),
	
	@NamedNativeQuery(name = "MAX_ID_APPLICANT", query = "SELECT null as APPLICANT_CODE, null as FIRSTNAME_TH, null as FIRSTNAME_EN, null as LASTNAME_TH, null as LASTNAME_EN, null as NICKNAME_TH, null as NICKNAME_EN,"
			+ " null as BIRTHDATE, null as PLACE_BIRTH, null as AGE, null as HEIGHT, null as WEIGHT, null as RELIGION, null as NATIONALITY, null as TEL, null as EMAIL,"
			+ " null as APPLICANT_STATUS, null as APPLY_DATE, null as EMERGENCY_NAME, null as EMERGENCY_TEL, null as EMERGENCY_ADDRESS, null as NOTICE_NEWSPAPER, null as NOTICE_MAGAZINE, null as NOTICE_FRIEND, null as NOTICE_WEBSITE, null as NOTICE_OTHER, a.TRACKING_STATUS,"
			+ " null as EXPECTED_SALARY, null as CARD_ID, null as CARD_ISSUED_OFFICE, null as CARD_EXPIRY_DATE, null as MILITARY_FROM_YEAR, null as MILITARY_TO_YEAR, null as MILITARY_PLACE, null as MILITARY_SERVICE_NO, a.MILITARY_REASON, null as MILITARY_STATUS, null as NEWSPAPER_DESCRIPTION, null as MAGAZINE_DESCRIPTION, null as FRIEND_DESCRIPTION, null as WEBSITE_DESCRIPTION, null as OTHER_DESCRIPTION,"
			+ " null as NUMBER_OF_CHILDREN, null as SPOUSE_NAME, null as MARRIAGE_CERTIFICATE_NO, null as ISSUE_OFFICE_MARRIAGE, null as OCCUPATION_MARRIAGE, null as TECH_SCORE, null as POSITION1_ID, null as POSITION2_ID, null as POSITION3_ID, null as NOW_EMPLOYED, null as EMPLOYED_NAME, null as EMPLOYED_POSITION,"
			+ " null as EMPLOYED_RELATION, null as BRANCH_SERVICE, null as PREVIOUS_EMPLOYERS, null as PREVIOUS_EMPLOYERS_REASON, null as DATE_TO_BE_DRAFTED, null as MARRIAGE_ADDRESS, null as POSITION_NAME, null as EMERGENCY_NAME, null as EMERGENCY_TEL, null as EMERGENCY_ADDRESS, null as RESUME, null as TRANSCRIPT, null as IMAGE, null as SEX, null as POSITION1_ID, null as POSITION2_ID, null as POSITION3_ID, null as SCORE, null as TECH_SCORE, null as ATTITUDE_HOME, null as ATTITUDE_OFFICE, null as TRACKING_STATUS,"
			+ " MAX(a.APPLICANT_ID) AS APPLICANT_ID"
			+ " FROM APPLICANT a ", resultClass = ApplicantDto.class),
	
	@NamedNativeQuery(name = "SEARCH_APPLICANT", query = " SELECT null as FIRSTNAME_TH, null as LASTNAME_TH, null as NICKNAME_TH, null as NICKNAME_EN, "
			+ "null as BIRTHDATE, null as AGE, null as HEIGHT, null as WEIGHT, null as SEX, null as RELIGION, null as NATIONALITY, null as APPLICANT_STATUS, null as EMERGENCY_NAME, null as EMERGENCY_TEL,"
			+ "null as EMERGENCY_ADDRESS, null as NOTICE_NEWSPAPER, null as NOTICE_MAGAZINE, null as NOTICE_FRIEND, null as NOTICE_WEBSITE, null as NOTICE_OTHER, null as NEWSPAPER_DESCRIPTION, null as MAGAZINE_DESCRIPTION, null as FRIEND_DESCRIPTION, null as WEBSITE_DESCRIPTION, null as OTHER_DESCRIPTION, "
			+ "null as EXPECTED_SALARY, null as CARD_ID, null as CARD_ISSUED_OFFICE, null as CARD_EXPIRY_DATE, null as MILITARY_FROM_YEAR, null as MILITARY_TO_YEAR, null as MILITARY_PLACE,"
			+ "null as MILITARY_SERVICE_NO, null as MILITARY_REASON, null as MILITARY_STATUS, null as NUMBER_OF_CHILDREN, null as SPOUSE_NAME,"
			+ "null as MARRIAGE_CERTIFICATE_NO, null as ISSUE_OFFICE_MARRIAGE, null as OCCUPATION_MARRIAGE, null as SCORE, null as TECH_SCORE, null as ATTITUDE_HOME, null as ATTITUDE_OFFICE, null as PLACE_BIRTH, null as NOW_EMPLOYED, null as EMPLOYED_NAME, null as EMPLOYED_POSITION, "
			+ "null as EMPLOYED_RELATION, null as BRANCH_SERVICE, null as PREVIOUS_EMPLOYERS, null as PREVIOUS_EMPLOYERS_REASON, null as DATE_TO_BE_DRAFTED, null as MARRIAGE_ADDRESS, null as RESUME, null as TRANSCRIPT, null as IMAGE, "
			+ "a.APPLICANT_ID, a.APPLICANT_CODE, a.FIRSTNAME_EN, a.LASTNAME_EN, a.TEL, a.EMAIL, a.APPLY_DATE, a.POSITION1_ID, a.POSITION2_ID, a.POSITION3_ID, a.TRACKING_STATUS, p1.POSITION_NAME, p1.ID, p2.POSITION_NAME, p2.ID, p3.POSITION_NAME, p3.ID "
			+ "FROM APPLICANT a LEFT JOIN POSITION p1 ON a.POSITION1_ID = p1.ID "
			+ "LEFT JOIN POSITION p2 ON a.POSITION2_ID = p2.ID "
			+ "LEFT JOIN POSITION p3 ON a.POSITION3_ID= p3.ID "
			+ "WHERE p1.POSITION_NAME like :POSITION OR p2.POSITION_NAME like :POSITION OR p3.POSITION_NAME like :POSITION", resultClass = ApplicantDto.class),
	
	@NamedNativeQuery(name = "SEARCH_ALL", query = "SELECT null as FIRSTNAME_TH, null as LASTNAME_TH, null as NICKNAME_TH, null as NICKNAME_EN, "
			+ "null as BIRTHDATE, null as AGE, null as HEIGHT, null as WEIGHT, null as SEX, null as RELIGION, null as NATIONALITY, null as APPLICANT_STATUS, null as EMERGENCY_NAME, null as EMERGENCY_TEL,"
			+ "null as EMERGENCY_ADDRESS, null as NOTICE_NEWSPAPER, null as NOTICE_MAGAZINE, null as NOTICE_FRIEND, null as NOTICE_WEBSITE, null as NOTICE_OTHER, null as NEWSPAPER_DESCRIPTION, null as MAGAZINE_DESCRIPTION, null as FRIEND_DESCRIPTION, null as WEBSITE_DESCRIPTION, null as OTHER_DESCRIPTION,"
			+ "null as EXPECTED_SALARY, null as CARD_ID, null as CARD_ISSUED_OFFICE, null as CARD_EXPIRY_DATE, null as MILITARY_FROM_YEAR, null as MILITARY_TO_YEAR, null as MILITARY_PLACE,"
			+ "null as MILITARY_SERVICE_NO, null as MILITARY_REASON, null as MILITARY_STATUS, null as NUMBER_OF_CHILDREN, null as SPOUSE_NAME,"
			+ "null as MARRIAGE_CERTIFICATE_NO, null as ISSUE_OFFICE_MARRIAGE, null as OCCUPATION_MARRIAGE, null as SCORE, null as TECH_SCORE, null as ATTITUDE_HOME, null as ATTITUDE_OFFICE,"
			+ "null as PLACE_BIRTH, null as NOW_EMPLOYED, null as EMPLOYED_NAME, null as EMPLOYED_POSITION, null as EMPLOYED_RELATION, null as BRANCH_SERVICE, null as PREVIOUS_EMPLOYERS, null as PREVIOUS_EMPLOYERS_REASON,"
			+ "null as DATE_TO_BE_DRAFTED, null as MARRIAGE_ADDRESS, null as RESUME, null as TRANSCRIPT, null as IMAGE,"
			+ " a.APPLICANT_ID, a.APPLICANT_CODE, a.FIRSTNAME_EN, a.LASTNAME_EN, a.TEL, a.EMAIL, a.APPLY_DATE, a.POSITION1_ID, a.POSITION2_ID, a.POSITION3_ID, a.TRACKING_STATUS, p.POSITION_NAME, p.ID "
			+ " FROM APPLICANT a JOIN POSITION p ON a.POSITION1_ID = p.ID "
			+ "ORDER BY a.APPLY_DATE DESC", resultClass = ApplicantDto.class), // ORDER BY APPLICANT_ID ASC LIMIT 0,50

	@NamedNativeQuery(name = "SEARCH_BY_ID", query = "SELECT a.FIRSTNAME_TH, a.LASTNAME_TH, a.NICKNAME_TH, a.NICKNAME_EN, "
					+ "a.BIRTHDATE, a.AGE, a.HEIGHT, a.WEIGHT, a.SEX, a.RELIGION, a.NATIONALITY, a.APPLICANT_STATUS, a.EMERGENCY_NAME, a.EMERGENCY_TEL,"
					+ "a.EMERGENCY_ADDRESS, a.NOTICE_NEWSPAPER, a.NOTICE_MAGAZINE, a.NOTICE_FRIEND, a.NOTICE_WEBSITE, a.NOTICE_OTHER, a.NEWSPAPER_DESCRIPTION, a.MAGAZINE_DESCRIPTION, a.FRIEND_DESCRIPTION, a.WEBSITE_DESCRIPTION, a.OTHER_DESCRIPTION,"
					+ "a.EXPECTED_SALARY, a.CARD_ID, a.CARD_ISSUED_OFFICE, a.CARD_EXPIRY_DATE, a.MILITARY_FROM_YEAR, a.MILITARY_TO_YEAR, a.MILITARY_PLACE,"
					+ "a.MILITARY_SERVICE_NO, a.MILITARY_REASON, a.MILITARY_STATUS, a.NUMBER_OF_CHILDREN, a.SPOUSE_NAME,"
					+ "a.MARRIAGE_CERTIFICATE_NO, a.ISSUE_OFFICE_MARRIAGE, a.OCCUPATION_MARRIAGE, a.SCORE, a.TECH_SCORE, a.ATTITUDE_HOME, a.ATTITUDE_OFFICE,"
					+ "a.PLACE_BIRTH, a.NOW_EMPLOYED, a.EMPLOYED_NAME, a.EMPLOYED_POSITION, a.EMPLOYED_RELATION, a.BRANCH_SERVICE, a.PREVIOUS_EMPLOYERS,"
					+ "a.PREVIOUS_EMPLOYERS_REASON, a.DATE_TO_BE_DRAFTED, a.MARRIAGE_ADDRESS, a.RESUME, a.TRANSCRIPT, a.IMAGE,"
					+ " a.APPLICANT_ID, a.APPLICANT_CODE, a.FIRSTNAME_EN, a.LASTNAME_EN, a.TEL, a.EMAIL, a.APPLY_DATE, a.POSITION1_ID, a.POSITION2_ID, a.POSITION3_ID, a.TRACKING_STATUS, p.POSITION_NAME, p.ID "
					+ " FROM APPLICANT a LEFT JOIN POSITION p ON a.POSITION1_ID = p.ID WHERE a.APPLICANT_ID = :ID", resultClass = ApplicantDto.class), 

	})
public class ApplicantDto {
	@Column(name = "POSITION_NAME")
	private String positionName;

	@Id
	@Column(name = "APPLICANT_ID")
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

	@Column(name = "APPLY_DATE")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", locale = "en", timezone = "GMT")
	private Date applyDate;

	@Transient
	private String applyDateStr;

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

	@Column(name = "EXPECTED_SALARY")
	private String expectedSalary;

	@Column(name = "CARD_ID")
	private String cardId;

	@Column(name = "SEX")
	private String sex;

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
	
	@Column(name = "TRACKING_STATUS")
	private String trackingStatus;
	
	@Column(name = "MILITARY_STATUS")
	private String militaryStatus;

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
	
	@Column(name = "POSITION1_ID")
	private Integer positionId1;

	@Column(name = "POSITION2_ID")
	private Integer positionId2;

	@Column(name = "POSITION3_ID")
	private Integer positionId3;
	
	@Transient
	private MultipartFile resumeMultipartFile;
	
	@Transient
	private MultipartFile transcriptMultipartFile;
	
	@Transient
	private MultipartFile imageMultipartFile;

//	@Transient
//	private List<Reference> references;
//
//	@Transient
//	private List<Family> families;
//
//	@Transient
//	private List<AugEmployee> augEmployees;
//
//	@Transient
//	private List<Languages> languages;
//
//	@Transient
//	private List<Address> address;
//
//	@Transient
//	private List<Education> educations;
//
//	@Transient
//	private List<Skill> skills;
//
//	@Transient
//	private List<Experience> experiences;
//
//	@Transient
//	private Position position1;
//
//	@Transient
//	private Position position2;
//
//	@Transient
//	private Position position3;
//
//	@Transient
//	private List<Certificate> certificates;
	
	@Transient
	private String position1Str;

	@Transient
	private String position2Str;

	@Transient
	private String position3Str;
	
	
	public Integer getPositionId1() {
		return positionId1;
	}

	public void setPositionId1(Integer positionId1) {
		this.positionId1 = positionId1;
	}

	public Integer getPositionId2() {
		return positionId2;
	}

	public void setPositionId2(Integer positionId2) {
		this.positionId2 = positionId2;
	}

	public Integer getPositionId3() {
		return positionId3;
	}

	public void setPositionId3(Integer positionId3) {
		this.positionId3 = positionId3;
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

//	public List<Certificate> getCertificates() {
//		return certificates;
//	}
//
//	public void setCertificates(List<Certificate> certificates) {
//		this.certificates = certificates;
//	}
//
//	public List<Reference> getReferences() {
//		return references;
//	}
//
//	public void setReferences(List<Reference> references) {
//		this.references = references;
//	}
//
//	public List<Family> getFamilies() {
//		return families;
//	}
//
//	public void setFamilies(List<Family> families) {
//		this.families = families;
//	}
//
//	public List<AugEmployee> getAugEmployees() {
//		return augEmployees;
//	}
//
//	public void setAugEmployees(List<AugEmployee> augEmployees) {
//		this.augEmployees = augEmployees;
//	}
//
//	public List<Languages> getLanguages() {
//		return languages;
//	}
//
//	public void setLanguages(List<Languages> languages) {
//		this.languages = languages;
//	}
//
//	public List<Address> getAddress() {
//		return address;
//	}
//
//	public void setAddress(List<Address> address) {
//		this.address = address;
//	}
//
//	public List<Education> getEducations() {
//		return educations;
//	}
//
//	public void setEducations(List<Education> educations) {
//		this.educations = educations;
//	}
//
//	public List<Skill> getSkills() {
//		return skills;
//	}
//
//	public void setSkills(List<Skill> skills) {
//		this.skills = skills;
//	}
//
//	public List<Experience> getExperiences() {
//		return experiences;
//	}
//
//	public void setExperiences(List<Experience> experiences) {
//		this.experiences = experiences;
//	}

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

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
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

	public String getPlaceBirth() {
		return placeBirth;
	}

	public void setPlaceBirth(String placeBirth) {
		this.placeBirth = placeBirth;
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

	public String getApplyDateStr() {
		return applyDateStr;
	}

	public void setApplyDateStr(String applyDateStr) {
		this.applyDateStr = applyDateStr;
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
//
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

	public MultipartFile getResumeMultipartFile() {
		return resumeMultipartFile;
	}

	public void setResumeMultipartFile(MultipartFile resumeMultipartFile) {
		this.resumeMultipartFile = resumeMultipartFile;
	}

	public MultipartFile getTranscriptMultipartFile() {
		return transcriptMultipartFile;
	}

	public void setTranscriptMultipartFile(MultipartFile transcriptMultipartFile) {
		this.transcriptMultipartFile = transcriptMultipartFile;
	}

	public MultipartFile getImageMultipartFile() {
		return imageMultipartFile;
	}

	public void setImageMultipartFile(MultipartFile imageMultipartFile) {
		this.imageMultipartFile = imageMultipartFile;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMilitaryStatus() {
		return militaryStatus;
	}

	public void setMilitaryStatus(String militaryStatus) {
		this.militaryStatus = militaryStatus;
	}

	public String getPosition1Str() {
		return position1Str;
	}

	public void setPosition1Str(String position1Str) {
		this.position1Str = position1Str;
	}

	public String getPosition2Str() {
		return position2Str;
	}

	public void setPosition2Str(String position2Str) {
		this.position2Str = position2Str;
	}

	public String getPosition3Str() {
		return position3Str;
	}

	public void setPosition3Str(String position3Str) {
		this.position3Str = position3Str;
	}

}
