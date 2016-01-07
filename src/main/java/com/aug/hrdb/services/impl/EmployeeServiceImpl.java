/**
 * @author natechanok
 * @date Apr 29, 2015
 */

package com.aug.hrdb.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.aug.hrdb.dto.*;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Address;
import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.entities.Employee;
import com.aug.hrdb.entities.MasAddressType;
import com.aug.hrdb.entities.MasCoreSkill;
import com.aug.hrdb.entities.MasDivision;
import com.aug.hrdb.entities.MasEmployment;
import com.aug.hrdb.entities.MasJobLevel;
import com.aug.hrdb.entities.MasLocation;
import com.aug.hrdb.entities.MasProvince;
import com.aug.hrdb.entities.MasStaffType;
import com.aug.hrdb.entities.MasTechnology;
import com.aug.hrdb.entities.Official;
import com.aug.hrdb.repositories.EmployeeRepository;
import com.aug.hrdb.services.AddressService;
import com.aug.hrdb.services.ApplicantService;
import com.aug.hrdb.services.EmployeeCodeDtoService;
import com.aug.hrdb.services.EmployeeService;
import com.aug.hrdb.services.MasAddressTypeService;
import com.aug.hrdb.services.MasCoreSkillService;
import com.aug.hrdb.services.MasDivisionService;
import com.aug.hrdb.services.MasEmploymentService;
import com.aug.hrdb.services.MasJobLevelService;
import com.aug.hrdb.services.MasLocationService;
import com.aug.hrdb.services.MasProvinceService;
import com.aug.hrdb.services.MasStaffTypeService;
import com.aug.hrdb.services.MasTechnologyService;
import com.aug.hrdb.services.OfficialService;


@Service("employeeService")
@Transactional(rollbackFor = Exception.class)
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Autowired
  private MasAddressTypeService masAddressTypeService;

  @Autowired
  private MasProvinceService masProvinceService;

  @Autowired
  private AddressService addressService;

  @Autowired
  private OfficialService officialService;

  @Autowired
  private MasLocationService masLocationService;

  @Autowired
  private MasCoreSkillService masCoreSkillService;

  @Autowired
  private MasEmploymentService masEmploymentService;

  @Autowired
  private MasDivisionService masDevisionService;

  @Autowired
  private MasJobLevelService masJoblevelService;

  @Autowired
  private MasTechnologyService masTechnologyService;

  @Autowired
  private MasStaffTypeService masStaffTypeService;

  @Autowired
  private ApplicantService applicantService;

  @Autowired
  private EmployeeCodeDtoService employeeCodeService;

  @Override
  public void create(Employee employee) {
    employeeRepository.create(employee);
  }

  @Override
  public void update(Employee employee) {
    employeeRepository.update(employee);
  }

  @Override
  public void delete(Employee employee) {
    employeeRepository.delete(employee);
  }


  @Override
  public List<Employee> findAll() {
    return employeeRepository.findAll();
  }

  @Override
  public Employee findById(Integer Id) {
    return employeeRepository.find(Id);
  }

  @Override
  public void deleteById(Integer id) {
    employeeRepository.deleteById(id);
  }

  @Override
  public List<Employee> findByCriteria(Employee employee) {
    return employeeRepository.findByCriteria(employee);
  }

  @Override
  public Employee searchEmpIdToAddress() {
    return employeeRepository.searchEmpIdToAddress();
  }

  @Override
  public List<EmployeeListDto> searchEmployee() {
    return employeeRepository.searchEmployee();
  }

  @Override
  public List<AimEmployeeDto> listEmployeeAim() {
    return employeeRepository.listEmployeeAim();
  }



  @Override
  public List<Employee> findAimRelateWithEmployee(Integer id) {
    // TODO Auto-generated method stub
    return employeeRepository.findAimRelateWithEmployee(id);
  }



  @Override
  @Transactional
  public String generateEmployeeCodeFixData(String location) {

    Applicant applicant = new Applicant();
    List<EmployeeCodeDto> employeeCodeDtoList = new ArrayList<EmployeeCodeDto>();
    EmployeeCodeDto employeeForCode = new EmployeeCodeDto();
    String empCode = null;
    MasLocation masLocations = masLocationService.findByLocationCode(location);
    System.out.println("LOCATIONNNN :: " + masLocations);
    employeeCodeDtoList = employeeCodeService.findEmployeeCode(1);

    if (employeeCodeDtoList.size() == 0) {
      employeeForCode = null;
    } else if (employeeCodeDtoList.size() > 0) {
      employeeForCode = employeeCodeService.findEmployeeCode(1).get(0);
    }


    if (employeeForCode == null && ("TH").equals(location)) {


      empCode = applicant.getMasLocation() + "10" + "001";
      System.out.println("empCode: " + empCode);


    } else if (employeeForCode != null && ("TH").equals(location)) {

      StringBuilder myNumbers = new StringBuilder();
      for (int i = 0; i < employeeForCode.getEmployeeCode().length(); i++) {

        if (Character.isDigit(employeeForCode.getEmployeeCode().charAt(i))) {
          myNumbers.append(employeeForCode.getEmployeeCode().charAt(i));
          System.out.println(employeeForCode.getEmployeeCode().charAt(i) + " is a digit.");
        } else {
          System.out.println(employeeForCode.getEmployeeCode().charAt(i) + " not a digit.");
        }
      }

      System.out.println("Your numbers: " + myNumbers.toString());
      int employeeCodePlusOne = Integer.parseInt(myNumbers.toString()) + 1;
      System.out.println("LOCATIONTOSTRING :: " + location);
      empCode = location + Integer.toString(employeeCodePlusOne);
      System.out.println("empCode: " + empCode);
    }

    return empCode;

  }

  @Override
  public List<ReportEmployeeDto> reportEmployee(String nameEng) {
    return employeeRepository.reportEmployee(nameEng);
  }

  @Override
  public List<ReportStatusEmployeeDto> reportStatusEmployee(String statusStaff) {
    return employeeRepository.reportStatusEmployee(statusStaff);
  }

  @Override
  public EmployeeIdDto findCurrentId() {
    return employeeRepository.findCurrentId();
  }

  @Override
  public List<ReportEmployeeDto> findByName(Employee employee) {
    return employeeRepository.findByName(employee);
  }

  @Override
  public List<EmployeeCodeDto> findEmployeeCode(Integer location_id) {
    return employeeRepository.findEmployeeCode(location_id);
  }

  @Override
  public List<DivisionDto> checkTag(String tag) {

    return employeeRepository.checkTag(tag);
  }

  @Override
  public List<JoblevelDto> checkTagDivision(String tag) {
    return employeeRepository.checkTagDivision(tag);
  }

  @Override
  public String findByIdDivision(Integer id) {
    return employeeRepository.findByIdDivision(id);
  }

  @Override
  public EmployeeDto findEmployeeByEmployeeIdWithSetToDto(Integer id) {
    Employee employee = employeeRepository.find(id);

    //Hibernate.initialize(employee.getApplicant());

    //Applicant applicant = applicantService.findById(employee.getApplicant().getId());
    Applicant applicant = employee.getApplicant();

    //Hibernate.initialize(applicant.getOfficial());

    EmployeeDto employeeDto = new EmployeeDto();
    employeeDto.setId(employee.getId());
    employeeDto.setStatusemp(employee.getStatusEmp());
    employeeDto.setIsManager(employee.getIsManager());

    if (applicant.getOfficial() != null) {
      employeeDto.setOfficialDate(applicant.getApplyDate());
      employeeDto.setStartWorkDate(applicant.getOfficial().getStartWorkDate());
      employeeDto.setEndWorkDate(applicant.getOfficial().getEndWorkDate());
      employeeDto.setPositionAppliedFor(applicant.getEmployedPosition());
      employeeDto.setSalaryExpected(applicant.getExpectedSalary());
      employeeDto.setOfficialId(applicant.getOfficial().getId());
      employeeDto.setProbationDate(applicant.getOfficial().getProbationDate());

    }

    employeeDto.setEmployeeCode(employee.getEmployeeCode());
    employeeDto.setNameThai(applicant.getFirstNameTH());
    employeeDto.setSurnameThai(applicant.getLastNameTH());
    employeeDto.setNicknameThai(applicant.getNickNameTH());
    employeeDto.setNameEng(applicant.getFirstNameEN());
    employeeDto.setSurnameEng(applicant.getLastNameEN());
    employeeDto.setNicknameEng(applicant.getNickNameEN());
    employeeDto.setEmail(applicant.getEmail());
    employeeDto.setTelMobile(applicant.getTel());
    employeeDto.setTelHome(employee.getTelHome());
    employeeDto.setTelFax(employee.getTelFax());
    employeeDto.setCongenitalDisease(employee.getCongenitalDisease());
    employeeDto.setHospital(employee.getHospital());
    employeeDto.setEmergencyContact(applicant.getEmergencyName());
    employeeDto.setRelationshipWithEmergencyContact(employee.getRelationshipWithEmergencyContact());
    employeeDto.setEmergencyContactAddress(applicant.getEmergencyAddress());
    employeeDto.setEmergencyContactPhoneNumber(applicant.getEmergencyTel());
    employeeDto.setDateOfBirth(applicant.getBirthDate());
    employeeDto.setPlaceOfBirth(applicant.getPlaceBirth());
    employeeDto.setDateToBeDrafted(applicant.getDateToBeDrafted());
    employeeDto.setAge(applicant.getAge());
    employeeDto.setReligion(applicant.getReligion());
    employeeDto.setIdCard(applicant.getCardId());
    employeeDto.setIssuedOffice(applicant.getCardIssuedOffice());
    employeeDto.setExpiryDate(applicant.getCardExpiryDate());
    employeeDto.setHeight(applicant.getHeight());
    employeeDto.setWeigth(applicant.getWeight());
    employeeDto.setSex(applicant.getSex());
    employeeDto.setMaritalStatus(applicant.getApplicantStatus());
    employeeDto.setNumberOfChildren(applicant.getNumberOfChildren());
    employeeDto.setSpouseName(applicant.getSpouseName());
    employeeDto.setMarriageCertificateNo(applicant.getMarriageCertificateNo());
    employeeDto.setIssuedOffice2(applicant.getIssueOficeMarriage());
    employeeDto.setAddress(applicant.getMarriageAddress());
    employeeDto.setOccupation(applicant.getOccupationMarriage());
    employeeDto.setKnowAugNewspaper(applicant.getNoticeNewspaper());
    employeeDto.setDescriptionNewspaper(applicant.getNewspaperDescription());
    employeeDto.setKnowAugMagazine(applicant.getNoticeMagazine());
    employeeDto.setDescriptionMagazine(applicant.getMagazineDescription());
    employeeDto.setKnowAugWebsite(applicant.getNoticeWebSite());
    employeeDto.setDescriptionWebsite(applicant.getWebSiteDescription());
    employeeDto.setKnowAugFriend(applicant.getNoticeFriend());
    employeeDto.setDescriptionFriend(applicant.getFriendDescription());
    employeeDto.setKnowAugOther(applicant.getNoticeOther());
    employeeDto.setDescriptionOther(applicant.getOtherDescription());
    employeeDto.setKnowEmployed(applicant.getNowEmployed());
    employeeDto.setDescriptionYesName(applicant.getEmployedName());
    employeeDto.setRelationYes(applicant.getEmployedRelation());
    employeeDto.setPositionYes(applicant.getEmployedPosition());
    employeeDto.setMilitaryService(applicant.getMilitaryStatus());
    employeeDto.setBranchOfService(applicant.getBranchService());
    employeeDto.setServiceNo(applicant.getMilitaryServiceNo());
    employeeDto.setReasonsNo(applicant.getMilitaryReason());
    employeeDto.setDateToBeDrafted(applicant.getDateToBeDrafted());
    employeeDto.setPreviousEmployer(employee.getPreviousEmployer());
    employeeDto.setPreviousEmpreasonsNo(employee.getPreviousEmpReasonsNo());
    employeeDto.setImage(applicant.getImage());

    if (employee.getAimEmpId() != null) {
      employeeDto.setAimempid(employee.getAimEmpId().getId());
    }

    if (employee.getMasCoreSkill() != null) {
      employeeDto.setMasCoreSkill(employee.getMasCoreSkill().getId());
    }

    if (employee.getMasEmployment() != null) {
      employeeDto.setMasEmployment(employee.getMasEmployment().getId());
    }

    if (employee.getMasDivision() != null) {
      employeeDto.setMasDivision(employee.getMasDivision().getId());
    }

    if (applicant.getJobLevel() != null) {
      employeeDto.setMasJoblevel(applicant.getJobLevel().getId());
    }

    if (applicant.getTechnology() != null) {
      employeeDto.setTechnology(applicant.getTechnology().getId());
    }

    if (employee.getMasStaffType() != null) {
      employeeDto.setMasStaffType(employee.getMasStaffType().getId());
    }

    if (employee.getMasLocation() != null) {
      employeeDto.setMasLocation(employee.getMasLocation().getCode());
      employeeDto.setMasLocationId(employee.getMasLocation().getId());
    }

    employeeDto.setApplicateId(employee.getApplicant().getId());

    List<AddressDto> addressDtoList = addressService.findAddressByApplicantId(employee.getApplicant().getId());

    if (addressDtoList != null && addressDtoList.isEmpty() == false) {
      employeeDto.setAddressList(addressDtoList);
    }

    return employeeDto;

  }

  @Override
  @Transactional
  public Employee updateEmployeeAndReturnId(EmployeeDto employeeDto) throws DataIntegrityViolationException {
    Employee employee = employeeRepository.find(employeeDto.getId());
    String employeeCode = employeeDto.getEmployeeCode();
    String img = employeeDto.getImage();

    //Hibernate.initialize(employee.getApplicant());
    //Applicant applicant = applicantService.findById(employee.getApplicant().getId());

    Applicant applicant = employee.getApplicant();

    //Hibernate.initialize(applicant.getOfficial());

    if (applicant.getOfficial() == null) {
      Official official = new Official();
      official.setStartWorkDate(employeeDto.getStartWorkDate());
      official.setEndWorkDate(employeeDto.getEndWorkDate());
      official.setProbationDate(employeeDto.getProbationDate());
      officialService.create(official);

      applicant.setOfficial(official);
      applicant.setEmployedPosition(employeeDto.getPositionAppliedFor());
      applicant.setApplyDate(employeeDto.getOfficialDate());
      applicant.setExpectedSalary(employeeDto.getSalaryExpected());
    } else if (applicant.getOfficial() != null && applicant.getOfficial().getId() != null) {
      Official official1 = officialService.findById(applicant.getOfficial().getId());
      official1.setStartWorkDate(employeeDto.getStartWorkDate());
      official1.setEndWorkDate(employeeDto.getEndWorkDate());
      official1.setProbationDate(employeeDto.getProbationDate());
      officialService.update(official1);

      applicant.setEmployedPosition(employeeDto.getPositionAppliedFor());
      applicant.setApplyDate(employeeDto.getOfficialDate());
      applicant.setExpectedSalary(employeeDto.getSalaryExpected());

    }

    applicant.setFirstNameTH(employeeDto.getNameThai());
    applicant.setLastNameTH(employeeDto.getSurnameThai());
    applicant.setNickNameTH(employeeDto.getNicknameThai());
    applicant.setFirstNameEN(employeeDto.getNameEng());
    applicant.setLastNameEN(employeeDto.getSurnameEng());
    applicant.setNickNameEN(employeeDto.getNicknameEng());
    applicant.setEmail(employeeDto.getEmail());
    applicant.setTel(employeeDto.getTelMobile());
    applicant.setEmergencyName(employeeDto.getEmergencyContact());
    applicant.setEmergencyAddress(employeeDto.getEmergencyContactAddress());
    applicant.setEmergencyTel(employeeDto.getEmergencyContactPhoneNumber());
    applicant.setBirthDate(employeeDto.getDateOfBirth());
    applicant.setPlaceBirth(employeeDto.getPlaceOfBirth());
    applicant.setAge(employeeDto.getAge());
    applicant.setReligion(employeeDto.getReligion());
    applicant.setCardId(employeeDto.getIdCard());
    applicant.setCardIssuedOffice(employeeDto.getIssuedOffice());
    applicant.setIssueOficeMarriage(employeeDto.getIssuedOffice2());
    applicant.setCardExpiryDate(employeeDto.getExpiryDate());
    applicant.setHeight(employeeDto.getHeight());
    applicant.setWeight(employeeDto.getWeigth());
    applicant.setSex(employeeDto.getSex());
    applicant.setApplicantStatus(employeeDto.getMaritalStatus());
    applicant.setNumberOfChildren(employeeDto.getNumberOfChildren());
    applicant.setSpouseName(employeeDto.getSpouseName());
    applicant.setMarriageCertificateNo(employeeDto.getMarriageCertificateNo());
    applicant.setMarriageAddress(employeeDto.getAddress());
    applicant.setOccupationMarriage(employeeDto.getOccupation());
    applicant.setNoticeNewspaper(employeeDto.getKnowAugNewspaper());
    applicant.setNewspaperDescription(employeeDto.getDescriptionNewspaper());
    applicant.setNoticeMagazine(employeeDto.getKnowAugMagazine());
    applicant.setMagazineDescription(employeeDto.getDescriptionMagazine());
    applicant.setNoticeWebSite(employeeDto.getKnowAugWebsite());
    applicant.setWebSiteDescription(employeeDto.getDescriptionWebsite());
    applicant.setNoticeFriend(employeeDto.getKnowAugFriend());
    applicant.setFriendDescription(employeeDto.getDescriptionFriend());
    applicant.setNoticeOther(employeeDto.getKnowAugOther());
    applicant.setOtherDescription(employeeDto.getDescriptionOther());
    applicant.setNowEmployed(employeeDto.getKnowEmployed());
    applicant.setMilitaryStatus(employeeDto.getMilitaryService());
    applicant.setBranchService(employeeDto.getBranchOfService());
    applicant.setMilitaryReason(employeeDto.getReasonsNo());
    applicant.setDateToBeDrafted(employeeDto.getDateToBeDrafted());
    applicant.setMilitaryServiceNo(employeeDto.getServiceNo());

    if (employeeDto.getMasJoblevel() != null) {
      MasJobLevel masJoblevel = masJoblevelService.findById(employeeDto.getMasJoblevel());
      if (masJoblevel.getId() != null) {
        applicant.setJoblevel(masJoblevel);
      }
    }

    if (employeeDto.getTechnology() != null) {
      MasTechnology masTechnology = masTechnologyService.findById(employeeDto.getTechnology());
      if (masTechnology.getId() != null) {
        applicant.setTechnology(masTechnology);
      }
    }

    applicantService.update(applicant);

    employee.setEmployeeCode(employeeCode);
    employee.setCongenitalDisease(employeeDto.getCongenitalDisease());
    employee.setHospital(employeeDto.getHospital());
    employee.setTelHome(employeeDto.getTelHome());
    employee.setTelFax(employeeDto.getTelFax());
    employee.setRelationshipWithEmergencyContact(employeeDto.getRelationshipWithEmergencyContact());
    employee.setPreviousEmployer(employeeDto.getPreviousEmployer());
    employee.setPreviousEmpReasonsNo(employeeDto.getPreviousEmpreasonsNo());

    if (employeeDto.getMasCoreSkill() != null) {
      MasCoreSkill masCoreSkill = masCoreSkillService.findById(employeeDto.getMasCoreSkill());
      if (masCoreSkill.getId() != null) {
        employee.setMasCoreSkill(masCoreSkill);
      }
    }

    if (employeeDto.getMasEmployment() != null) {
      MasEmployment masEmployment = masEmploymentService.findById(employeeDto.getMasEmployment());
      if (masEmployment.getId() != null) {
        employee.setMasEmployment(masEmployment);
      }
    }

    if (employeeDto.getMasDivision() != null) {
      MasDivision masDevision = masDevisionService.findById(employeeDto.getMasDivision());
      if (masDevision.getId() != null) {
        employee.setMasDivision(masDevision);
      }
    }

    if (employeeDto.getMasLocation() != null && !employeeDto.getMasLocation().isEmpty()) {
      MasLocation masLocation = masLocationService.findByLocationCode(employeeDto.getMasLocation());
      if (masLocation.getId() != null) {
        employee.setMasLocation(masLocation);
      }
    }

    employee.setStatusEmp(employeeDto.getStatusemp());

    if (employeeDto.getMasStaffType() != null) {
      MasStaffType masStaffType = masStaffTypeService.findById(employeeDto.getMasStaffType());
      if (masStaffType.getId() != null) {
        employee.setMasStaffType(masStaffType);
      }
    }

    applicant.setImage(img);
    employee.setIsManager(employeeDto.getIsManager());

    if (employeeDto.getAimempid() != null) {
      Employee aim = employeeRepository.find(employeeDto.getAimempid());
      if (aim.getId() != null) {
        employee.setAimEmpId(aim);
      }
    }

    if (employeeDto.getAimempid() == null) {
      employee.setAimEmpId(null);
    }

    try {
      employeeRepository.update(employee);
    } catch (DataIntegrityViolationException jdbc) {
      System.out.println("massge exception: " + jdbc.getMessage());
      if (jdbc.getMessage() != null) {
        throw jdbc;
      }
    }

    //update Address
    if (employeeDto.getAddressList() != null) {
      for (AddressDto addressDto : employeeDto.getAddressList()) {
        if (addressDto.getId() != null) {
          if (addressDto.getStatus().equals("add") && addressDto.getId() == 0) {
            Address address = new Address();
            address.setHouseNo(addressDto.getHouseNo());
            address.setSubDistrict(addressDto.getSubDistrict());
            address.setDistrict(addressDto.getDistrict());
            address.setRoad(addressDto.getRoad());

            MasProvince masProvince = masProvinceService.findById(addressDto.getMasprovinceId());
            if (masProvince != null) {
              address.setProvince(masProvince);
            }

            MasAddressType masAddressType = masAddressTypeService.findById(addressDto.getAddressTypeId());
            if (masProvince != null) {
              address.setAddressType(masAddressType);
            }

            address.setZipcode(addressDto.getZipcode());

            Applicant applicant1 = applicantService.findById(addressDto.getApplicantId());

            if (applicant1 != null) {
              address.setApplicant(applicant1);
            }

            List<Address> addressList = new ArrayList<Address>();
            addressList.add(address);
            addressService.create(address);

          } else if (addressDto.getStatus().equals("edit")) {
            Address address = addressService.find(addressDto.getId());
            address.setHouseNo(addressDto.getHouseNo());
            address.setSubDistrict(addressDto.getSubDistrict());
            address.setDistrict(addressDto.getSubDistrict());
            address.setRoad(addressDto.getRoad());

            MasProvince masProvince = masProvinceService.findById(addressDto.getMasprovinceId());
            if (masProvince != null) {
              address.setProvince(masProvince);
            }

            MasAddressType masAddressType = masAddressTypeService.findById(addressDto.getAddressTypeId());
            if (masProvince != null) {
              address.setAddressType(masAddressType);
            }

            address.setZipcode(addressDto.getZipcode());

            Applicant applicant1 = applicantService.findById(addressDto.getApplicantId());
            if (applicant1 != null) {
              address.setApplicant(applicant1);
            }

            List<Address> addressList = new ArrayList<Address>();
            addressList.add(address);

            addressService.update(address);

          } else if (addressDto.getStatus().equals("delete")) {
            Address address = new Address();
            address = addressService.find(addressDto.getId());
            addressService.delete(address);

          }
        }
      }
    }

    return employee;

  }

  @Override
  public Employee findAndInitializeOfficial(Integer id) {
    Employee employee = employeeRepository.find(id);
    Applicant applicant = applicantService.findById(employee.getApplicant().getId());
    Hibernate.initialize(applicant.getOfficial());
    Hibernate.initialize(employee.getLeaves());

    return employee;

  }

  @Override
  @Transactional
  public String generateEmployeeCode(EmployeeDto employeeDto) {

    EmployeeCodeDto employeeForCode = new EmployeeCodeDto();
    String empCode = null;

    if (masLocationService.findByLocationCode(employeeDto.getMasLocation()) != null) {
      MasLocation masLocation = masLocationService.findByLocationCode(employeeDto.getMasLocation());
      List<EmployeeCodeDto> employeeCodeDtoList = employeeCodeService.findEmployeeCode(masLocation.getId());

      if (employeeCodeDtoList.size() == 0) {
        employeeForCode = null;
      } else if (employeeCodeDtoList.size() > 0) {
        employeeForCode = employeeCodeService.findEmployeeCode(masLocation.getId()).get(0);
      }

      if (employeeForCode == null) {
        empCode = employeeDto.getMasLocation() + "10" + "001";
      } else if (employeeForCode != null) {
        StringBuilder myNumbers = new StringBuilder();
        for (int i = 0; i < employeeForCode.getEmployeeCode().length(); i++) {
          if (Character.isDigit(employeeForCode.getEmployeeCode().charAt(i))) {
            myNumbers.append(employeeForCode.getEmployeeCode().charAt(i));
          }
        }
        int employeeCodePlusOne = Integer.parseInt(myNumbers.toString()) + 1;
        empCode = employeeDto.getMasLocation() + Integer.toString(employeeCodePlusOne);

      }
    }

    return empCode;

  }

}

