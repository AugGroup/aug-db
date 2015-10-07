/**
 *
 * @author natechanok
 * @date May 2, 2015
 */

package com.aug.hrdb.entities;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;


@NamedNativeQueries({
	
 

           @NamedNativeQuery(
		            name = "searchIdEmptoAddress",
		            //query = "select * from EMP_EMPLOYEE  ORDER BY createdTimeStamp LIMIT 1;", 
		            query = "select * from EMPLOYEE  ORDER BY ID desc LIMIT 1;",
		            resultClass = Employee.class)
  })



@Entity
@Table(name = "EMPLOYEE")
public class Employee extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "EMPLOYEE_CODE",nullable = false,unique=true)
	private String employeeCode;
	
	/*@Column(name = "NAME_THAI",nullable = false)
	private String nameThai;
	
	@Column(name = "SURNAME_THAI",nullable = true)
	private String surnameThai;
		
	@Column(name = "NICKNAME_THAI",nullable = true)
	private String nicknameThai;
	
	@Column(name = "NAME_ENG",nullable = false)
	private String nameEng;
	
	@Column(name = "SURNAME_ENG",nullable = true)
	private String surnameEng;
	
	@Column(name = "NICKNAME_ENG",nullable = true)
	private String nicknameEng;

	@Column(name = "EMAIL",nullable = false)
	private String email;*/
	
	@Column(name = "TEL_HOME",nullable = false)
	private String telHome;
	
	/*@Column(name = "TEL_MOBILE",nullable = false)
	private String telMobile;*/
	
	@Column(name = "TEL_FAX",nullable = true)
	private String telFax;
	
	@Column(name = "CONGENITAL_DISEASE",nullable = true)
	private String congenitalDisease;
	
	@Column(name = "HOSPITAL",nullable = true)
	private String hospital;
	
	/*@Column(name = "EMERGENCY_CONTACT",nullable = false)
	private String emergencyContact;*/
	
	@Column(name = "RELATIONSHIP_WITH_EMERGENCY_CONTACT",nullable = true)
	private String relationshipWithEmergencyContact;
	
	/*@Column(name = "EMERGENCY_CONTACT_ADDRESS",nullable = true)
	private String emergencyContactAddress;
	
	@Column(name = "EMERGENCY_CONTACT_PHONE_NUMBER",nullable = false)
	private String emergencyContactPhoneNumber;*/
	
   /* @DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "DATEOFBIRTH",nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfBirth;
	
	@Column(name = "PLACEOFBIRTH",nullable = true)
	private String placeOfBirth;
	
	@Column(name = "AGE",nullable = true)
	private Integer age;
	
	@Column(name = "RELIGION",nullable = true)
	private String religion;
	
	@Column(name = "ID_CARD",nullable = false)
	private String idCard;*/
	
	/*@Column(name = "ISSUED_OFFICE",nullable = true)
	private String issuedOffice;
	

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "EXPIRY_DATE",nullable = true)
	private Date expiryDate;*/
	
	/*@Column(name = "HEIGHT",nullable = true)
	private Integer height;
	
	@Column(name = "WEIGTH",nullable = true)
	private Integer weigth;
	
	@Column(name = "SEX",nullable = true)
	private String sex;*/

	/*@Column(name = "MARITAL_STATUS",nullable = true)
	private String maritalStatus;
	
	@Column(name = "NUMBER_OF_CHILDREN",nullable = true)
	private String numberOfChildren;
	
	@Column(name = "SPOUSE_NAME",nullable = true)
	private String spouseName;
	
	@Column(name = "MARRIAGE_CERTIFICATE_NO",nullable = true)
	private String marriageCertificateNo;
	
	@Column(name = "ISSUED_OFFICE2",nullable = true)
	private String issuedOffice2;*/
	
	/*@Column(name = "ADDRESS",nullable = true)
	private String address;
	
	@Column(name = "OCCUPATION",nullable = true)
	private String occupation;*/
	
	/*@Column(name = "KNOW_AUG_NEWSPAPER",nullable = true)
	private String knowAugNewspaper;
	
	@Column(name = "DESCRIPTION_NEWSPAPER",nullable = true)
	private String descriptionNewspaper;
	
	@Column(name = "KNOW_AUG_MAGAZINE",nullable = true)
	private String knowAugMagazine;
	
	@Column(name = "DESCRIPTION_MAGAZINE",nullable = true)
	private String descriptionMagazine;
	
	@Column(name = "KNOW_AUG_WEBSITE",nullable = true)
	private String knowAugWebsite;
	
	@Column(name = "DESCRIPTION_WEBSITE",nullable = true)
	private String descriptionWebsite;
	
	@Column(name = "KNOW_AUG_FRIEND",nullable = true)
	private String knowAugFriend;
	
	@Column(name = "DESCRIPTION_FRIEND",nullable = true)
	private String descriptionFriend;
	
	@Column(name = "KNOW_AUG_OTHER",nullable = true)
	private String knowAugOther;
	
	@Column(name = "DESCRIPTION_OTHER",nullable = true)
	private String descriptionOther;*/
	
	/*@Column(name = "KNOW_EMPLOYED",nullable = true)
	private String knowEmployed;
	
	@Column(name = "DESCRIPTION_YES",nullable = true)
	private String descriptionYes;*/
	
	/*@Column(name = "KNOW_EMPLOYER_NO",nullable = true)
	private String knowEmployerNo;*/
	
	/*@Column(name = "MILITARY_SERVICE",nullable = true)
	private String militaryService;
	
    @DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "FROM_YEAR",nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fromYear;
	

    @DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "TO_YEAR",nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date toYear;
	
	@Column(name = "BRANCH_OF_SERVICE",nullable = true)
	private String branchOfService;
	
	@Column(name = "SERVICE_NO",nullable = true)
	private String serviceNo;*/
	
	/*@Column(name = "MILITARY_SERVICE_NO",nullable = true)
	private String militaryServiceNo;*/
	
	/*@Column(name = "REASONS_NO",nullable = true)
	private String reasonsNo;
	

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "DATE_TO_BE_DRAFTED",nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateToBeDrafted;
	*/
	@Column(name = "PREVIOUS_EMPLOYER",nullable = true)
	private String previousEmployer;
	
	
	@Column(name = "PREVIOUSEMP_REASONS_NO",nullable = true)
	private String previousEmpreasonsNo;
	
	/*@Column(name = "IMAGE",nullable = true)
	private String image;*/
	
	@Column(name = "STATUSEMP",nullable = false)
	@NotEmpty
	private String statusemp;
		
	@Column(name = "ISMANAGER",nullable = true)
	private Integer isManager;
	
//------------------self relation-------------------
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="AIM_EMP_ID",referencedColumnName="id",nullable = true,insertable = true, updatable = true)
	private Employee aimempid;
	
	@OneToMany(mappedBy="aimempid", fetch=FetchType.EAGER,cascade=CascadeType.REMOVE)
	private Set<Employee> staffs = new HashSet<Employee>();
	
	
	public Employee getAimempid() {
		return aimempid;
	}

	public void setAimempid(Employee aimempid) {
		this.aimempid = aimempid;
	}


	public Set<Employee> getStaffs() {
		return staffs;
	}

	public void setStaffs(Set<Employee> staffs) {
		this.staffs = staffs;
	}



	
//------------------end self relation-----------------
	



	/*@Column(name = "ADDRESS_ID",nullable = true)
	@OneToMany(mappedBy = "employee", fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	private List<Address> addresses = new ArrayList<Address>();*/

	 
	/*@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	@JoinColumn(name = "OFFICIAL_ID",nullable = true)
	private Official official;*/
	 
	 
	/*@OneToMany(mappedBy = "employee", cascade=CascadeType.REMOVE)
	private Set<Education> educations = new HashSet<Education>();*/
	 
	@OneToMany(mappedBy = "employee", cascade=CascadeType.REMOVE)
	private Set<Allowances> allowances = new HashSet<Allowances>();
	 
	@OneToMany(mappedBy = "employee", cascade=CascadeType.REMOVE)
	private Set<History> histories = new HashSet<History>();
	 
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name= "MAS_CORE_SKILL_ID")
	private MasCoreSkill masCoreSkill;
	 
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name= "EMPLOYMENT_ID")
    @JsonIgnore
    private MasEmployment masEmployment;
    
    /*@OneToMany(mappedBy = "employee", fetch=FetchType.LAZY, cascade=CascadeType.REMOVE)
    private Set<Ability> abilities = new HashSet<Ability>();
    */

    /*@OneToMany(mappedBy = "employee", fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
    private Set<Reference> references = new HashSet<Reference>();*/

   
    /*@OneToMany(mappedBy = "employee", fetch=FetchType.LAZY, cascade=CascadeType.REMOVE)
    private Set<Certification> certifications  = new HashSet<Certification>();*/
    
    @OneToMany(mappedBy = "employee", fetch=FetchType.LAZY, cascade=CascadeType.REMOVE)
    private Set<Leave> leaves  = new HashSet<Leave>();
    
    @OneToMany(mappedBy = "employee", fetch=FetchType.LAZY, cascade=CascadeType.REMOVE)
    private Set<Punish> punishs  = new HashSet<Punish>();
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name= "DIVISION_ID", referencedColumnName="id",nullable = false)
    private MasDivision masDivision;
    
   /* @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name= "JOBLEVEL_ID", referencedColumnName="id",nullable = false)
    private MasJoblevel masJoblevel;
    
    @OneToMany(mappedBy = "employee", fetch=FetchType.LAZY, cascade=CascadeType.REMOVE)
    private Set<Experience> experiences = new HashSet<Experience>();
	    

    @ManyToOne(fetch=FetchType.EAGER) 
    @JoinColumn(name= "TECHNOLOGY_ID", referencedColumnName="id",nullable = true)
    private MasTechnology technology;
    */
    
    /*@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade=CascadeType.REMOVE)
    private Set<Family> families = new HashSet<Family>();*/ 
    
    
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade=CascadeType.REMOVE)
    @JsonIgnore
    private Set<Reward> rewards  = new HashSet<Reward>();
    
    
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY,cascade=CascadeType.REMOVE)
    @JsonIgnore
    private Set<Card> cards = new HashSet<Card>();
    
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name= "STAFFTYPE_ID")
    private MasStaffType masStaffType;


    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name= "LOCATION_ID")
    private MasLocation masLocation;
    
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade=CascadeType.REMOVE)
    @JsonIgnore
    private Set<Probation> probations = new HashSet<Probation>();
   
    @Transient
    private String status;
    
    
   @Transient
   private Integer masCoreSkillId;
    
   
   @Transient
   private Integer technologyId;
   

   /*@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY,cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
   private Set<Language> skillLanguage = new HashSet<Language>();*/
   
   
   
   @OneToMany(mappedBy = "employee", cascade=CascadeType.REMOVE)
   private Set<Site> site = new HashSet<Site>();
   
	@OneToOne(fetch=FetchType.LAZY,mappedBy="employee",cascade=CascadeType.REMOVE)
	private Login login;
	
	@OneToOne(mappedBy="employee", cascade=CascadeType.REMOVE)
	private Health health; 
   
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="APPLICANT_ID",nullable=false)
	private Applicant applicant;
	
	
	
 //-------------------------------------- getter setter --------------------------------------------------//

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


	/*public String getNameThai() {
		return nameThai;
	}


	public void setNameThai(String nameThai) {
		this.nameThai = nameThai;
	}


	public String getSurnameThai() {
		return surnameThai;
	}


	public void setSurnameThai(String surnameThai) {
		this.surnameThai = surnameThai;
	}


	public String getNicknameThai() {
		return nicknameThai;
	}


	public void setNicknameThai(String nicknameThai) {
		this.nicknameThai = nicknameThai;
	}


	public String getNameEng() {
		return nameEng;
	}


	public void setNameEng(String nameEng) {
		this.nameEng = nameEng;
	}


	public String getSurnameEng() {
		return surnameEng;
	}


	public void setSurnameEng(String surnameEng) {
		this.surnameEng = surnameEng;
	}


	public String getNicknameEng() {
		return nicknameEng;
	}


	public void setNicknameEng(String nicknameEng) {
		this.nicknameEng = nicknameEng;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}*/

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

	public String getTelHome() {
		return telHome;
	}


	public void setTelHome(String telHome) {
		this.telHome = telHome;
	}


	/*public String getTelMobile() {
		return telMobile;
	}


	public void setTelMobile(String telMobile) {
		this.telMobile = telMobile;
	}
*/

	public String getTelFax() {
		return telFax;
	}


	public void setTelFax(String telFax) {
		this.telFax = telFax;
	}


	/*public String getEmergencyContact() {
		return emergencyContact;
	}


	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}
*/

	public String getRelationshipWithEmergencyContact() {
		return relationshipWithEmergencyContact;
	}


	public void setRelationshipWithEmergencyContact(
			String relationshipWithEmergencyContact) {
		this.relationshipWithEmergencyContact = relationshipWithEmergencyContact;
	}


	/*public String getEmergencyContactAddress() {
		return emergencyContactAddress;
	}


	public void setEmergencyContactAddress(String emergencyContactAddress) {
		this.emergencyContactAddress = emergencyContactAddress;
	}


	public String getEmergencyContactPhoneNumber() {
		return emergencyContactPhoneNumber;
	}


	public void setEmergencyContactPhoneNumber(String emergencyContactPhoneNumber) {
		this.emergencyContactPhoneNumber = emergencyContactPhoneNumber;
	}*/


	/*public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getPlaceOfBirth() {
		return placeOfBirth;
	}


	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	public String getReligion() {
		return religion;
	}


	public void setReligion(String religion) {
		this.religion = religion;
	}


	public String getIdCard() {
		return idCard;

	}


	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}


	public String getIssuedOffice() {
		return issuedOffice;
	}


	public void setIssuedOffice(String issuedOffice) {
		this.issuedOffice = issuedOffice;
	}


	public Date getExpiryDate() {
		return expiryDate;
	}


	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}


	public Integer getHeight() {
		return height;
	}


	public void setHeight(Integer height) {
		this.height = height;
	}


	public Integer getWeigth() {
		return weigth;
	}


	public void setWeigth(Integer weigth) {
		this.weigth = weigth;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getMaritalStatus() {
		return maritalStatus;
	}


	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
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


	public String getIssuedOffice2() {
		return issuedOffice2;
	}


	public void setIssuedOffice2(String issuedOffice2) {
		this.issuedOffice2 = issuedOffice2;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getOccupation() {
		return occupation;
	}


	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}


	public String getKnowAugNewspaper() {
		return knowAugNewspaper;
	}


	public void setKnowAugNewspaper(String knowAugNewspaper) {
		this.knowAugNewspaper = knowAugNewspaper;
	}


	public String getDescriptionNewspaper() {
		return descriptionNewspaper;
	}


	public void setDescriptionNewspaper(String descriptionNewspaper) {
		this.descriptionNewspaper = descriptionNewspaper;
	}


	public String getKnowAugMagazine() {
		return knowAugMagazine;
	}


	public void setKnowAugMagazine(String knowAugMagazine) {
		this.knowAugMagazine = knowAugMagazine;
	}


	public String getDescriptionMagazine() {
		return descriptionMagazine;
	}


	public void setDescriptionMagazine(String descriptionMagazine) {
		this.descriptionMagazine = descriptionMagazine;
	}


	public String getKnowAugWebsite() {
		return knowAugWebsite;
	}


	public void setKnowAugWebsite(String knowAugWebsite) {
		this.knowAugWebsite = knowAugWebsite;
	}


	public String getDescriptionWebsite() {
		return descriptionWebsite;
	}


	public void setDescriptionWebsite(String descriptionWebsite) {
		this.descriptionWebsite = descriptionWebsite;
	}


	public String getKnowAugFriend() {
		return knowAugFriend;
	}


	public void setKnowAugFriend(String knowAugFriend) {
		this.knowAugFriend = knowAugFriend;
	}


	public String getDescriptionFriend() {
		return descriptionFriend;
	}


	public void setDescriptionFriend(String descriptionFriend) {
		this.descriptionFriend = descriptionFriend;
	}


	public String getKnowAugOther() {
		return knowAugOther;
	}


	public void setKnowAugOther(String knowAugOther) {
		this.knowAugOther = knowAugOther;
	}


	public String getDescriptionOther() {
		return descriptionOther;
	}


	public void setDescriptionOther(String descriptionOther) {
		this.descriptionOther = descriptionOther;
	}


	public String getKnowEmployed() {
		return knowEmployed;
	}


	public void setKnowEmployed(String knowEmployed) {
		this.knowEmployed = knowEmployed;
	}


	public String getDescriptionYes() {
		return descriptionYes;
	}


	public void setDescriptionYes(String descriptionYes) {
		this.descriptionYes = descriptionYes;
	}
*/

	/*public String getKnowEmployerNo() {
		return knowEmployerNo;
	}


	public void setKnowEmployerNo(String knowEmployerNo) {
		this.knowEmployerNo = knowEmployerNo;
	}*/


	/*public String getMilitaryService() {
		return militaryService;
	}


	public void setMilitaryService(String militaryServiceYes) {
		this.militaryService = militaryServiceYes;
	}


	public Date getFromYear() {
		return fromYear;
	}


	public void setFromYear(Date fromYear) {
		this.fromYear = fromYear;
	}


	public Date getToYear() {
		return toYear;
	}


	public void setToYear(Date toYear) {
		this.toYear = toYear;
	}


	public String getBranchOfService() {
		return branchOfService;
	}


	public void setBranchOfService(String branchOfService) {
		this.branchOfService = branchOfService;
	}
*/

	/*public String getMilitaryServiceNo() {
		return militaryServiceNo;
	}


	public void setMilitaryServiceNo(String militaryServiceNo) {
		this.militaryServiceNo = militaryServiceNo;
	}*/


	/*public String getReasonsNo() {
		return reasonsNo;
	}


	public void setReasonsNo(String reasonsNo) {
		this.reasonsNo = reasonsNo;
	}


	public Date getDateToBeDrafted() {
		return dateToBeDrafted;
	}


	public void setDateToBeDrafted(Date dateToBeDrafted) {
		this.dateToBeDrafted = dateToBeDrafted;
	}
*/

	public String getPreviousEmployer() {
		return previousEmployer;
	}


	public void setPreviousEmployer(String previousEmployerYes) {
		this.previousEmployer = previousEmployerYes;
	}


	public String getPreviousEmpreasonsNo() {
		return previousEmpreasonsNo;
	}


	public void setPreviousEmpreasonsNo(String previousEmpreasonsNo) {
		this.previousEmpreasonsNo = previousEmpreasonsNo;
	}


	/*public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}*/

/*	public Official getOfficial() {
		return official;
	}


	public void setOfficial(Official official) {
		this.official = official;
	}*/



	/*public String getServiceNo() {
		return serviceNo;
	}



	public void setServiceNo(String serviceNo) {
		this.serviceNo = serviceNo;
	}*/



	/*public Set<Education> getEducations() {
		return educations;
	}



	public void setEducations(Set<Education> educations) {
		this.educations = educations;
	}*/



	public MasCoreSkill getMasCoreSkill() {
		return masCoreSkill;
	}

	
	public void setMasCoreSkill(MasCoreSkill masCoreSkill) {
		this.masCoreSkill = masCoreSkill;
	}
	

	public MasEmployment getEmployment() {
		return masEmployment;
	}



	public void setEmployment(MasEmployment employment) {
		this.masEmployment = employment;
	}



	/*public Set<Ability> getAbilities() {
		return abilities;
	}



	public void setAbilities(Set<Ability> abilities) {
		this.abilities = abilities;
	}*/


	/*public Set<Reference> getReferences() {
		return references;
	}



	public void setReferences(Set<Reference> references) {
		this.references = references;
	}*/



	public MasDivision getMasDivision() {
		return masDivision;
	}



	public void setMasDivision(MasDivision masDivision) {
		this.masDivision = masDivision;
	}


	
	public Set<History> getHistories() {
		return histories;
	}



	public void setHistories(Set<History> histories) {
		this.histories = histories;
	}



	/*public Set<Experience> getExperiences() {
		return experiences;
	}



	public void setExperiences(Set<Experience> experiences) {
		this.experiences = experiences;
	}*/



	/*public Set<Family> getFamilies() {
		return families;
	}



	public void setFamilies(Set<Family> families) {
		this.families = families;
	}
	*/
	
	
	public MasEmployment getMasEmployment() {
		return masEmployment;
	}

	public void setMasEmployment(MasEmployment masEmployment) {
		this.masEmployment = masEmployment;
	}

	/*public MasJoblevel getMasJoblevel() {
		return masJoblevel;
	}

	public void setMasJoblevel(MasJoblevel masJoblevel) {
		this.masJoblevel = masJoblevel;
	}


	public MasTechnology getTechnology() {
		return technology;
	}

	public void setTechnology(MasTechnology technology) {
		this.technology = technology;
	}
*/
	public MasLocation getMasLocation() {
		return masLocation;
	}

	public void setMasLocation(MasLocation masLocation) {
		this.masLocation = masLocation;
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

	public MasStaffType getMasStaffType() {
		return masStaffType;
	}

	public void setMasStaffType(MasStaffType masStaffType) {
		this.masStaffType = masStaffType;
	}
	
	public Set<Probation> getProbations() {
		return probations;
	}

	public void setProbations(Set<Probation> probations) {
		this.probations = probations;
	}
	
	
	public Set<Punish> getPunishs() {
		return punishs;
	}

	public void setPunishs(Set<Punish> punishs) {
		this.punishs = punishs;
	}
	

	public Set<Leave> getLeaves() {
		return leaves;
	}

	public void setLeaves(Set<Leave> leaves) {
		this.leaves = leaves;
	}

	public Set<Site> getSite() {
		return site;
	}

	public void setSite(Set<Site> site) {
		this.site = site;
	}


	/*public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}*/


	
	/*public Set<Language> getSkillLanguage() {
		return skillLanguage;
	}

	public void setSkillLanguage(Set<Language> skillLanguage) {
		this.skillLanguage = skillLanguage;
	}*/
	

	public Set<Reward> getRewards() {
		return rewards;
	}

	public void setRewards(Set<Reward> rewards) {
		this.rewards = rewards;
	}
	
	public Set<Card> getAttendances() {
		return cards;
	}

	public void setAttendances(Set<Card> cards) {
		this.cards = cards;
	}

	/*public Set<Certification> getCertifications() {
		return certifications;
	}

	public void setCertifications(Set<Certification> certifications) {
		this.certifications = certifications;
	}*/
	
	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Integer getIsManager() {
		return isManager;
	}

	public void setIsManager(Integer isManager) {
		this.isManager = isManager;
	}

	
	public Health getHealth() {
		return health;
	}

	public void setHealth(Health health) {
		this.health = health;
	}

	public String getStatusemp() {
		return statusemp;
	}

	public void setStatusemp(String statusemp) {
		this.statusemp = statusemp;
	}

	public Set<Card> getCards() {
		return cards;
	}

	public void setCards(Set<Card> cards) {
		this.cards = cards;
	}

	public Set<Allowances> getAllowances() {
		return allowances;
	}

	public void setAllowances(Set<Allowances> allowances) {
		this.allowances = allowances;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	
	
	
	
	
	/*@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [id=");
		builder.append(id);
		builder.append(", employeeCode=");
		builder.append(employeeCode);
		builder.append(", nameThai=");
		builder.append(nameThai);
		builder.append(", surnameThai=");
		builder.append(surnameThai);
		builder.append(", nicknameThai=");
		builder.append(nicknameThai);
		builder.append(", nameEng=");
		builder.append(nameEng);
		builder.append(", surnameEng=");
		builder.append(surnameEng);
		builder.append(", nicknameEng=");
		builder.append(nicknameEng);
		builder.append(", email=");
		builder.append(email);
		builder.append(", telHome=");
		builder.append(telHome);
		builder.append(", telMobile=");
		builder.append(telMobile);
		builder.append(", telFax=");
		builder.append(telFax);
		builder.append(", congenitalDisease=");
		builder.append(congenitalDisease);
		builder.append(", hospital=");
		builder.append(hospital);
		builder.append(", emergencyContact=");
		builder.append(emergencyContact);
		builder.append(", relationshipWithEmergencyContact=");
		builder.append(relationshipWithEmergencyContact);
		builder.append(", emergencyContactAddress=");
		builder.append(emergencyContactAddress);
		builder.append(", emergencyContactPhoneNumber=");
		builder.append(emergencyContactPhoneNumber);
		builder.append(", dateOfBirth=");
		builder.append(dateOfBirth);
		builder.append(", placeOfBirth=");
		builder.append(placeOfBirth);
		builder.append(", age=");
		builder.append(age);
		builder.append(", religion=");
		builder.append(religion);
		builder.append(", idCard=");
		builder.append(idCard);
		builder.append(", issuedOffice=");
		builder.append(issuedOffice);
		builder.append(", expiryDate=");
		builder.append(expiryDate);
		builder.append(", height=");
		builder.append(height);
		builder.append(", weigth=");
		builder.append(weigth);
		builder.append(", sex=");
		builder.append(sex);
		builder.append(", maritalStatus=");
		builder.append(maritalStatus);
		builder.append(", numberOfChildren=");
		builder.append(numberOfChildren);
		builder.append(", spouseName=");
		builder.append(spouseName);
		builder.append(", marriageCertificateNo=");
		builder.append(marriageCertificateNo);
		builder.append(", issuedOffice2=");
		builder.append(issuedOffice2);
		builder.append(", address=");
		builder.append(address);
		builder.append(", occupation=");
		builder.append(occupation);
		builder.append(", knowAugNewspaper=");
		builder.append(knowAugNewspaper);
		builder.append(", descriptionNewspaper=");
		builder.append(descriptionNewspaper);
		builder.append(", knowAugMagazine=");
		builder.append(knowAugMagazine);
		builder.append(", descriptionMagazine=");
		builder.append(descriptionMagazine);
		builder.append(", knowAugWebsite=");
		builder.append(knowAugWebsite);
		builder.append(", descriptionWebsite=");
		builder.append(descriptionWebsite);
		builder.append(", knowAugFriend=");
		builder.append(knowAugFriend);
		builder.append(", descriptionFriend=");
		builder.append(descriptionFriend);
		builder.append(", knowAugOther=");
		builder.append(knowAugOther);
		builder.append(", descriptionOther=");
		builder.append(descriptionOther);
		builder.append(", knowEmployedYes=");
		builder.append(knowEmployedYes);
		builder.append(", descriptionYes=");
		builder.append(descriptionYes);
		builder.append(", knowEmployerNo=");
		builder.append(knowEmployerNo);
		builder.append(", militaryServiceYes=");
		builder.append(militaryServiceYes);
		builder.append(", fromYear=");
		builder.append(fromYear);
		builder.append(", toYear=");
		builder.append(toYear);
		builder.append(", branchOfService=");
		builder.append(branchOfService);
		builder.append(", serviceNo=");
		builder.append(serviceNo);
		builder.append(", militaryServiceNo=");
		builder.append(militaryServiceNo);
		builder.append(", reasonsNo=");
		builder.append(reasonsNo);
		builder.append(", dateToBeDrafted=");
		builder.append(dateToBeDrafted);
		builder.append(", previousEmployerYes=");
		builder.append(previousEmployerYes);
		builder.append(", previousEmployerNo=");
		builder.append(previousEmployerNo);
		builder.append(", previousEmpreasonsNo=");
		builder.append(previousEmpreasonsNo);
		builder.append(", image=");
		builder.append(image);
		builder.append(", statusemp=");
		builder.append(statusemp);
		builder.append(", isManager=");
		builder.append(isManager);
		builder.append(", aimempid=");
		builder.append(aimempid);
		builder.append(", staffs=");
		builder.append(staffs);
		builder.append(", addresses=");
		builder.append(addresses);
		builder.append(", official=");
		builder.append(official);
		builder.append(", educations=");
		builder.append(educations);
		builder.append(", allowances=");
		builder.append(allowances);
		builder.append(", histories=");
		builder.append(histories);
		builder.append(", masCoreSkill=");
		builder.append(masCoreSkill);
		builder.append(", masEmployment=");
		builder.append(masEmployment);
		builder.append(", abilities=");
		builder.append(abilities);
		builder.append(", references=");
		builder.append(references);
		builder.append(", certifications=");
		builder.append(certifications);
		builder.append(", leaves=");
		builder.append(leaves);
		builder.append(", punishs=");
		builder.append(punishs);
		builder.append(", masDivision=");
		builder.append(masDivision);
		builder.append(", masJoblevel=");
		builder.append(masJoblevel);
		builder.append(", experiences=");
		builder.append(experiences);
		builder.append(", technology=");
		builder.append(technology);
		builder.append(", families=");
		builder.append(families);
		builder.append(", rewards=");
		builder.append(rewards);
		builder.append(", cards=");
		builder.append(cards);
		builder.append(", masStaffType=");
		builder.append(masStaffType);
		builder.append(", masLocation=");
		builder.append(masLocation);
		builder.append(", probations=");
		builder.append(probations);
		builder.append(", status=");
		builder.append(status);
		builder.append(", masCoreSkillId=");
		builder.append(masCoreSkillId);
		builder.append(", technologyId=");
		builder.append(technologyId);
		builder.append(", skillLanguage=");
		builder.append(skillLanguage);
		builder.append(", site=");
		builder.append(site);
		builder.append(", login=");
		builder.append(login);
		builder.append(", health=");
		builder.append(health);
		builder.append("]");
		return builder.toString();
	}*/

	
	
	
}
