/**
 *
 * @author natechanok
 * @date Apr 29, 2015
 */

package com.aug.hrdb.services.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.InvalidTransactionException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.TransactionManager;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.JDBCException;
import org.hibernate.Transaction;
import org.hibernate.util.JDBCExceptionReporter;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.AddressDto;
import com.aug.hrdb.dto.ApplicantDto;
import com.aug.hrdb.dto.EmployeeDto;
import com.aug.hrdb.dto.OfficialDto;
import com.aug.hrdb.entities.Address;
import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.entities.Employee;
import com.aug.hrdb.entities.MasAddressType;
import com.aug.hrdb.entities.MasCoreSkill;
import com.aug.hrdb.entities.MasDivision;
import com.aug.hrdb.entities.MasEmployment;
import com.aug.hrdb.entities.MasJoblevel;
import com.aug.hrdb.entities.MasLocation;
import com.aug.hrdb.entities.MasProvince;
import com.aug.hrdb.entities.MasStaffType;
import com.aug.hrdb.entities.MasTechnology;
import com.aug.hrdb.entities.Official;
import com.aug.hrdb.repositories.EmployeeRepository;
import com.aug.hrdb.services.AddressService;
import com.aug.hrdb.services.ApplicantService;
import com.aug.hrdb.services.EmployeeService;
import com.aug.hrdb.services.MasAddressTypeService;
import com.aug.hrdb.services.MasCoreSkillService;
import com.aug.hrdb.services.MasDivisionService;
import com.aug.hrdb.services.MasEmploymentService;
import com.aug.hrdb.services.MasJoblevelService;
import com.aug.hrdb.services.MasLocationService;
import com.aug.hrdb.services.MasProvinceService;
import com.aug.hrdb.services.MasStaffTypeService;
import com.aug.hrdb.services.MasTechnologyService;
import com.aug.hrdb.services.OfficialService;



@Service("employeeService")
@Transactional(rollbackFor=Exception.class)
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
	private OfficialService afficialService;
	@Autowired
	private MasLocationService masLocationService;
	@Autowired
	private MasCoreSkillService masCoreSkillService;
	@Autowired
	private MasEmploymentService masEmploymentService;
	@Autowired
	private MasDivisionService masDevisionService;
	@Autowired
	private MasJoblevelService masJoblevelService;
	@Autowired
	private MasTechnologyService masTechnologyService;
	@Autowired
	private MasStaffTypeService masStaffTypeService;
	@Autowired
	private ApplicantService applicantService;
	
	/*@Autowired
	private UploadService uploadService;*/
	
	
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
		
		return  employeeRepository.find(Id);
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
	public Employee searhEmpIdtoAddress() {		
		return employeeRepository.searhEmpIdtoAddress();
	}

	

	

	@Override
	public EmployeeDto findEmployeeByEmployeeIdWithSetToDto(Integer id) {
		
		Employee employee = employeeRepository.find(id);	

		
		Hibernate.initialize(employee.getApplicant());
		Applicant applicant = applicantService.findById(employee.getApplicant().getId());
		Hibernate.initialize(applicant.getOfficial());

		
		//System.out.println(employee.getOfficial().getId());
		
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setId(employee.getId());
		employeeDto.setStatusemp(employee.getStatusemp()); 
		employeeDto.setIsManager(employee.getIsManager()); 
		

		if(applicant.getOfficial()!=null){
	        employeeDto.setOfficialDate(applicant.getApplyDate()); 
	        employeeDto.setStartWorkDate(applicant.getOfficial().getStartWorkDate());
	        employeeDto.setEndWorkDate(applicant.getOfficial().getEndWorkDate());
	    	employeeDto.setPositionAppliedFor(applicant.getEmployedPosition());
			employeeDto.setSalaryExpected(applicant.getExpectedSalary());
			employeeDto.setOfficialId(applicant.getOfficial().getId());
			employeeDto.setProbationDate(applicant.getOfficial().getProbationDate());
			
			System.out.println("official: "+applicant.getEmployedPosition());
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
        //employeeDto.setKnowEmployerNo(employee.getKnowEmployerNo());
        employeeDto.setMilitaryService(applicant.getMilitaryStatus());
        //employeeDto.setFromYear(applicant.getMilitaryFromYear());
        //employeeDto.setToYear(applicant.getMilitarytoYear());
        employeeDto.setBranchOfService(applicant.getBranchService());
        employeeDto.setServiceNo(applicant.getMilitaryServiceNo());
        employeeDto.setReasonsNo(applicant.getMilitaryReason());
        employeeDto.setDateToBeDrafted(applicant.getDateToBeDrafted());
        employeeDto.setPreviousEmployer(employee.getPreviousEmployer());
        employeeDto.setPreviousEmpreasonsNo(employee.getPreviousEmpreasonsNo());
        employeeDto.setImage(applicant.getImage());
        
        if(employee.getAimempid()!=null){
        	employeeDto.setAimempid(employee.getAimempid().getId());
        }
        
        if(employee.getMasCoreSkill()!=null){
        	employeeDto.setMasCoreSkill(employee.getMasCoreSkill().getId());
        }
        
        if(employee.getMasEmployment()!=null){
        	employeeDto.setMasEmployment(employee.getMasEmployment().getId());
        }
        
        if(employee.getMasDivision()!=null){
        	employeeDto.setMasDivision(employee.getMasDivision().getId());
        }
        
        if(applicant.getJoblevel()!=null){
        	employeeDto.setMasJoblevel(applicant.getJoblevel().getId());
        }
        
        if(applicant.getTechnology()!=null){
        	employeeDto.setTechnology(applicant.getTechnology().getId());
        }
        
        if(employee.getMasStaffType()!=null){
        	employeeDto.setMasStaffType(employee.getMasStaffType().getId());
        }
        
        if(employee.getMasLocation()!=null){
        	employeeDto.setMasLocation(employee.getMasLocation().getCode());
        	employeeDto.setMasLocationId(employee.getMasLocation().getId());
        }

        
        employeeDto.setApplicateId(employee.getApplicant().getId());
        
        List<AddressDto> addressDtoList  = addressService.findAddressByApplicantId(employee.getApplicant().getId());
        
        
        if(addressDtoList!=null && addressDtoList.isEmpty()==false){
        	employeeDto.setAddressList(addressDtoList);
        }
		
		return employeeDto;

	}
	
	
	
	
/*
	@Override
	@Transactional
	public Employee createEmployeeAndReturnId(EmployeeDto employeeDto,String employeeCode) throws JDBCException{
		
				
		//Save Official 
		Official official = new Official();
		official.setStartWorkDate(employeeDto.getStartWorkDate());
		official.setEndWorkDate(employeeDto.getEndWorkDate());
		official.setPositionAppliedFor(employeeDto.getPositionAppliedFor());
		official.setProbationDate(employeeDto.getProbationDate());
		official.setOfficialDate(employeeDto.getOfficialDate());
		official.setSalaryExpected(employeeDto.getSalaryExpected());
		
		afficialService.create(official);
		
		
		//Save Employee
		Employee employee = new Employee();
		

		employee.setEmployeeCode(employeeCode); 
		employee.setNameThai(employeeDto.getNameThai());
		employee.setSurnameThai(employeeDto.getSurnameThai());
		employee.setNicknameThai(employeeDto.getNicknameThai());
		employee.setNameEng(employeeDto.getNameEng());
		employee.setSurnameEng(employeeDto.getSurnameEng()); 
		employee.setNicknameEng(employeeDto.getNicknameEng()); 
		employee.setEmail(employeeDto.getEmail());
		employee.setCongenitalDisease(employeeDto.getCongenitalDisease());
		employee.setHospital(employeeDto.getHospital());
		employee.setTelHome(employeeDto.getTelHome());
		employee.setTelMobile(employeeDto.getTelMobile());
		employee.setTelFax(employeeDto.getTelFax());
		employee.setEmergencyContact(employeeDto.getEmergencyContact());
		employee.setRelationshipWithEmergencyContact(employeeDto.getRelationshipWithEmergencyContact());
		employee.setEmergencyContactAddress(employeeDto.getEmergencyContactAddress());
		employee.setEmergencyContactPhoneNumber(employeeDto.getEmergencyContactPhoneNumber());
		employee.setDateOfBirth(employeeDto.getDateOfBirth());
		employee.setPlaceOfBirth(employeeDto.getPlaceOfBirth());
		employee.setAge(employeeDto.getAge());
		employee.setReligion(employeeDto.getReligion());
		employee.setIdCard(employeeDto.getIdCard());
		employee.setIssuedOffice(employeeDto.getIssuedOffice());
		employee.setIssuedOffice2(employeeDto.getIssuedOffice2()); 
		employee.setExpiryDate(employeeDto.getExpiryDate());
		employee.setHeight(employeeDto.getHeight());
		employee.setWeigth(employeeDto.getWeigth());
		employee.setSex(employeeDto.getSex());
		employee.setMaritalStatus(employeeDto.getMaritalStatus());
		employee.setNumberOfChildren(employeeDto.getNumberOfChildren()); 
		employee.setSpouseName(employeeDto.getSpouseName()); 
		employee.setMarriageCertificateNo(employeeDto.getMarriageCertificateNo());
		employee.setAddress(employeeDto.getAddress()); 
		employee.setOccupation(employeeDto.getOccupation());
		employee.setKnowAugNewspaper(employeeDto.getKnowAugNewspaper());
		employee.setDescriptionNewspaper(employeeDto.getDescriptionNewspaper());
		employee.setKnowAugMagazine(employeeDto.getKnowAugMagazine());
		employee.setDescriptionMagazine(employeeDto.getDescriptionMagazine());
		employee.setKnowAugWebsite(employeeDto.getKnowAugWebsite());
		employee.setDescriptionWebsite(employeeDto.getDescriptionWebsite());
		employee.setKnowAugFriend(employeeDto.getKnowAugFriend()); 
		employee.setDescriptionFriend(employeeDto.getDescriptionFriend());
		employee.setKnowAugOther(employeeDto.getKnowAugOther()); 
		employee.setDescriptionOther(employeeDto.getDescriptionOther()); 
		employee.setKnowEmployed(employeeDto.getKnowEmployed());
		employee.setDescriptionYes(employeeDto.getDescriptionYes());
		employee.setMilitaryService(employeeDto.getMilitaryService());
		employee.setFromYear(employeeDto.getFromYear());
		employee.setToYear(employeeDto.getToYear());
		employee.setBranchOfService(employeeDto.getBranchOfService());
		employee.setReasonsNo(employeeDto.getReasonsNo());
		employee.setDateToBeDrafted(employeeDto.getDateToBeDrafted()); 
		employee.setPreviousEmployer(employeeDto.getPreviousEmployer());
		employee.setPreviousEmpreasonsNo(employeeDto.getPreviousEmpreasonsNo());			
		employee.setServiceNo(employeeDto.getServiceNo());		
		
		if(employeeDto.getMasCoreSkill()!=null){
			MasCoreSkill masCoreSkill =  masCoreSkillService.find(employeeDto.getMasCoreSkill());
			if(masCoreSkill.getId()!=null){
				employee.setMasCoreSkill(masCoreSkill);
			}
		}
		
		
		if(employeeDto.getMasEmployment()!=null){
			MasEmployment masEmployment = masEmploymentService.findById(employeeDto.getMasEmployment());
			if(masEmployment.getId()!=null){
				employee.setMasEmployment(masEmployment);
			}
		}
		
		if(employeeDto.getMasDivision()!=null){
			MasDivision masDevision = masDevisionService.findById(employeeDto.getMasDivision());
			if(masDevision.getId()!=null){
				employee.setMasDivision(masDevision);
			}
		}

		if(employeeDto.getMasJoblevel()!=null){
			MasJoblevel masJoblevel = masJoblevelService.find(employeeDto.getMasJoblevel());
			if(masJoblevel.getId()!=null){			
				employee.setMasJoblevel(masJoblevel);						
			}
		}
		
		
		if(employeeDto.getTechnology()!=null){
			MasTechnology masTechnology = masTechnologyService.find(employeeDto.getTechnology());
			if(masTechnology.getId()!=null){
				employee.setTechnology(masTechnology);
			}
		}
		
		if(employeeDto.getMasLocation()!=null&&employeeDto.getMasLocation().isEmpty()==false){
			MasLocation masLocation = masLocationService.findByLocationCode(employeeDto.getMasLocation());
			System.out.println("id location: "+masLocation.getId());
			if(masLocation.getId()!=null){
				employee.setMasLocation(masLocation); 
			}
		}
		
		employee.setStatusemp(employeeDto.getStatusemp());
		
		if(employeeDto.getMasStaffType()!=null){
			MasStaffType masStaffType = masStaffTypeService.find(employeeDto.getMasStaffType());
			if(masStaffType.getId()!=null){
				employee.setMasStaffType(masStaffType);
			}
		}

		employee.setImage(employeeDto.getImage()); 
		employee.setIsManager(employeeDto.getIsManager());
		
		if(employeeDto.getAimempid()!=null){
			Employee aim = employeeRepository.find(employeeDto.getAimempid());
			if(aim.getId()!=null){
				employee.setAimempid(aim);
			}
		}
		
		employee.setOfficial(official);
		
		Applicant applicant = applicantService.findById(employeeDto.getApplicateId());
		if(employeeDto.getApplicateId()!=null){
			employee.setApplicant(applicant);
		}
		
		try{
			
			employeeRepository.create(employee);
		
			
		}catch(JDBCException jdbce){
			
			
			System.out.println("state: "+jdbce.getSQLState());
			if(jdbce.getSQLState().equals("23000")&& jdbce.getErrorCode()==1062){
				
				
				System.out.println("SQLState: "+jdbce.getSQLState());
				throw jdbce;
											
			}
			
			
		}
		
		
		
		
		
		//Address
		if(employeeDto.getAddressList()!=null){
			
			
			 System.out.println("aaaa");
	
				
				for(AddressDto addressDto:employeeDto.getAddressList()){
					
					
					
					if(addressDto.getId()!=null){
						
						
						if(addressDto.getStatus().equals("add")&&addressDto.getId()==0){
							    
							    System.out.println("add address");
						
								Address address = new Address();		
								address.setHouseNo(addressDto.getHouseNo());
								address.setSubDistrict(addressDto.getSubDistrict());
								address.setDistrict(addressDto.getSubDistrict());
								address.setRoad(addressDto.getRoad());
								
								
								MasProvince masProvince = masProvinceService.find(addressDto.getMasprovinceId());
								if(masProvince!=null){
									address.setProvince(masProvince);
								}
								
								MasAddressType masAddressType = masAddressTypeService.findById(addressDto.getAddressTypeId());
								if(masProvince!=null){
									address.setAddressType(masAddressType);
								}
								
								address.setZipcode(addressDto.getZipcode());
								
								
								if(applicant!=null){
									address.setApplicant(applicant);
								}
							
								
								List<Address> addressList = new ArrayList<Address>();
								addressList.add(address);
								addressService.create(address);
						
						}else if(addressDto.getStatus().equals("edit")){
							
							
							   System.out.println("address edit: "+addressDto.getStatus());

							
								Address address = new Address();
								address = addressService.find(addressDto.getId());
								address.setHouseNo(addressDto.getHouseNo());
								address.setSubDistrict(addressDto.getSubDistrict());
								address.setDistrict(addressDto.getSubDistrict());
								address.setRoad(addressDto.getRoad());
								
								MasProvince masProvince = masProvinceService.find(addressDto.getMasprovinceId());
								if(masProvince.getId()!=null){
									address.setProvince(masProvince);
								}
								
								MasAddressType masAddressType = masAddressTypeService.findById(addressDto.getAddressTypeId());
								if(masProvince.getId()!=null){
									address.setAddressType(masAddressType);
								}
								
								address.setZipcode(addressDto.getZipcode());
								
								
								if(applicant!=null){
									address.setApplicant(applicant);
								}
									
								
								List<Address> addressList = new ArrayList<Address>();
								addressList.add(address);

								addressService.update(address);
							
							
						}else if(addressDto.getStatus().equals("delete")){
							
								
								System.out.println("delete address: "+addressDto.getStatus());
								Address address = new Address();
								address = addressService.find(addressDto.getId());
								addressService.delete(address);
							
						}

					}
				}
			}

		
		return employee;
	}
*/
	
	
	@Override
	@Transactional
	public Employee updateEmployeeAndReturnId(EmployeeDto employeeDto,String employeeCode,String img) throws DataIntegrityViolationException {
		
		Employee employee = employeeRepository.find(employeeDto.getId());	

		Hibernate.initialize(employee.getApplicant());
		Applicant applicant = applicantService.findById(employee.getApplicant().getId());
		Hibernate.initialize(applicant.getOfficial());


		
		//update official if id is null but id not null it change to save
		
		if(applicant.getOfficial()==null){
			Official official = new Official();
			official.setStartWorkDate(employeeDto.getStartWorkDate());
			official.setEndWorkDate(employeeDto.getEndWorkDate());
			applicant.setEmployedPosition(employeeDto.getPositionAppliedFor());
			official.setProbationDate(employeeDto.getProbationDate());
			applicant.setApplyDate(employeeDto.getOfficialDate());
			applicant.setExpectedSalary(employeeDto.getSalaryExpected());
			
			afficialService.create(official);
			
			applicant.setOfficial(official);
			
		}else if(applicant.getOfficial()!=null){
			

			  if(applicant.getOfficial().getId()!=null){
				Official official1 = afficialService.findById(applicant.getOfficial().getId());

				
				official1.setStartWorkDate(employeeDto.getStartWorkDate());
				official1.setEndWorkDate(employeeDto.getEndWorkDate());
				applicant.setEmployedPosition(employeeDto.getPositionAppliedFor());
				official1.setProbationDate(employeeDto.getProbationDate());
				applicant.setApplyDate(employeeDto.getOfficialDate());
				applicant.setExpectedSalary(employeeDto.getSalaryExpected());
				afficialService.update(official1);
			  }
			
			}
		
		
		
		
		
		//update applicant
		
		
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
		/*applicant.setFromYear(employeeDto.getFromYear());
		applicant.setToYear(employeeDto.getToYear());*/
		applicant.setBranchService(employeeDto.getBranchOfService());
		applicant.setMilitaryReason(employeeDto.getReasonsNo());
		applicant.setDateToBeDrafted(employeeDto.getDateToBeDrafted());
		applicant.setMilitaryServiceNo(employeeDto.getServiceNo());		
		
		
		if(employeeDto.getMasJoblevel()!=null){
			MasJoblevel masJoblevel = masJoblevelService.find(employeeDto.getMasJoblevel());
			if(masJoblevel.getId()!=null){			
				applicant.setJoblevel(masJoblevel);						
			}
		}
		
		
		if(employeeDto.getTechnology()!=null){
			MasTechnology masTechnology = masTechnologyService.find(employeeDto.getTechnology());
			if(masTechnology.getId()!=null){
				applicant.setTechnology(masTechnology);
			}
		}
		
		
		applicantService.update(applicant);

		
		
	
		//update employee
		
		employee.setEmployeeCode(employeeCode); 
		employee.setCongenitalDisease(employeeDto.getCongenitalDisease());
		employee.setHospital(employeeDto.getHospital());
		employee.setTelHome(employeeDto.getTelHome());
		employee.setTelFax(employeeDto.getTelFax());
		employee.setRelationshipWithEmergencyContact(employeeDto.getRelationshipWithEmergencyContact());	 
		employee.setPreviousEmployer(employeeDto.getPreviousEmployer());
		employee.setPreviousEmpreasonsNo(employeeDto.getPreviousEmpreasonsNo());			
		
		if(employeeDto.getMasCoreSkill()!=null){
			MasCoreSkill masCoreSkill =  masCoreSkillService.find(employeeDto.getMasCoreSkill());
			if(masCoreSkill.getId()!=null){
				employee.setMasCoreSkill(masCoreSkill);
			}
		}
		
		
		if(employeeDto.getMasEmployment()!=null){
			MasEmployment masEmployment = masEmploymentService.findById(employeeDto.getMasEmployment());
			if(masEmployment.getId()!=null){
				employee.setMasEmployment(masEmployment);
			}
		}
		
		if(employeeDto.getMasDivision()!=null){
			MasDivision masDevision = masDevisionService.findById(employeeDto.getMasDivision());
			if(masDevision.getId()!=null){
				employee.setMasDivision(masDevision);
			}
		}

		
		
		
		if(employeeDto.getMasLocation()!=null&&employeeDto.getMasLocation().isEmpty()==false){
			MasLocation masLocation = masLocationService.findByLocationCode(employeeDto.getMasLocation());
			if(masLocation.getId()!=null){
				employee.setMasLocation(masLocation); 
			}
		}
		
		employee.setStatusemp(employeeDto.getStatusemp());
		
		if(employeeDto.getMasStaffType()!=null){
			MasStaffType masStaffType = masStaffTypeService.find(employeeDto.getMasStaffType());
			if(masStaffType.getId()!=null){
				employee.setMasStaffType(masStaffType);
			}
		}

		
		applicant.setImage(img);
		employee.setIsManager(employeeDto.getIsManager());
		
		if(employeeDto.getAimempid()!=null){
			Employee aim = employeeRepository.find(employeeDto.getAimempid());
			if(aim.getId()!=null){
				employee.setAimempid(aim);
			}
		}
		
		
		if(employeeDto.getAimempid()==null){
			employee.setAimempid(null);
		}
		
		
		try{
			
			employeeRepository.update(employee);
		
		}catch(DataIntegrityViolationException jdbce){
			
			
			   System.out.println("massge exception: "+jdbce.getMessage());
			   if(jdbce.getMessage()!=null){
								
				throw jdbce;
											
			   }			
		}
		
		
		
		
		
		
		//update Address
				
		
			if(employeeDto.getAddressList()!=null){
		
					
					for(AddressDto addressDto:employeeDto.getAddressList()){
						
						
						
						if(addressDto.getId()!=null){
							
							System.out.println("address : "+addressDto.getStatus());
							
							if(addressDto.getStatus().equals("add")&&addressDto.getId()==0){
								
								    System.out.println("add");
							
									Address address = new Address();		
									address.setHouseNo(addressDto.getHouseNo());
									address.setSubDistrict(addressDto.getSubDistrict());
									address.setDistrict(addressDto.getDistrict());
									address.setRoad(addressDto.getRoad());
									
									
									MasProvince masProvince = masProvinceService.find(addressDto.getMasprovinceId());
									if(masProvince!=null){
										address.setProvince(masProvince);
									}
									
									MasAddressType masAddressType = masAddressTypeService.findById(addressDto.getAddressTypeId());
									if(masProvince!=null){
										address.setAddressType(masAddressType);
									}
									
									address.setZipcode(addressDto.getZipcode());
									
									Applicant applicant1 = applicantService.findById(addressDto.getApplicantId());
									
									if(applicant1!=null){
										address.setApplicant(applicant1);
									}
								
								
									List<Address> addressList = new ArrayList<Address>();
									addressList.add(address);
									addressService.create(address);
							
							}else if(addressDto.getStatus().equals("edit")){
								
								
								   System.out.println("address edit: "+addressDto.getStatus());

								
									Address address = new Address();
									address = addressService.find(addressDto.getId());
									address.setHouseNo(addressDto.getHouseNo());
									address.setSubDistrict(addressDto.getSubDistrict());
									address.setDistrict(addressDto.getSubDistrict());
									address.setRoad(addressDto.getRoad());
									
									MasProvince masProvince = masProvinceService.find(addressDto.getMasprovinceId());
									if(masProvince!=null){
										address.setProvince(masProvince);
									}
									
									MasAddressType masAddressType = masAddressTypeService.findById(addressDto.getAddressTypeId());
									if(masProvince!=null){
										address.setAddressType(masAddressType);
									}
									
									address.setZipcode(addressDto.getZipcode());
									
									Applicant applicant1 = applicantService.findById(addressDto.getApplicantId());
									
									if(applicant1!=null){
										address.setApplicant(applicant1);
									}
										
									
									List<Address> addressList = new ArrayList<Address>();
									addressList.add(address);

									addressService.update(address);
								
								
							}else if(addressDto.getStatus().equals("delete")){
								
									
									System.out.println("delete address: "+addressDto.getStatus());
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
	public void deleteEmployeeByHibernate(Employee employee) {
		// TODO Auto-generated method stub
		
		
		employeeRepository.delete(employee);
		
	}

	
	@Override
	public Employee findAndinitializeOfficial(Integer id) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepository.find(id);
		Applicant applicant = applicantService.findById(employee.getApplicant().getId());
		Hibernate.initialize(applicant.getOfficial());
		Hibernate.initialize(employee.getLeaves());
		return employee;
	}

	
	@Override
	public List<Employee> findAimRelateWithEmployee(Integer id) {
		// TODO Auto-generated method stub
		return employeeRepository.findAimRelateWithEmployee(id);
	}

	
	@Override	
	public Employee findOfficial(Integer id) {
		// TODO Auto-generated method stub
		return employeeRepository.findOfficial(id);
	}


	public Employee findEmployeeCode(Integer locationId) {
		// TODO Auto-generated method stub
		return employeeRepository.findEmployeeCode(locationId);
	}
	
	

	@Override
	@Transactional
	public String generateEmployeeCode(EmployeeDto employeeDto){
		
		ApplicantDto applicantDto = new ApplicantDto();
		Employee employeeForCode = new Employee();
		String empCode = null;
		System.out.print("masloc# "+applicantDto.getMasLocation());
		
		if(masLocationService.findByLocationCode(applicantDto.getMasLocation())==null){
			   
			System.out.println("----null location id-----");
		}else if(masLocationService.findByLocationCode(applicantDto.getMasLocation())!=null){
			
			MasLocation masLocation = masLocationService.findByLocationCode(applicantDto.getMasLocation());
			System.out.println("id: "+masLocation.getId());
			employeeForCode = employeeRepository.findEmployeeCode(masLocation.getId());
			   		   
			   
			if(employeeForCode==null){
				empCode = applicantDto.getMasLocation()+"10"+"001";
				System.out.println("empCode: "+empCode);
			}else if(employeeForCode!=null){	   
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
				int employeeCodePlusOne = Integer.parseInt(myNumbers.toString())+1;
				empCode = employeeDto.getMasLocation()+Integer.toString(employeeCodePlusOne);
				System.out.println("empCode: "+empCode);
				    		   
			}
				   
		}
		   
		return empCode;
				
	}
	
	@Override
	@Transactional
	public String generateEmployeeCodeFixData(String location){
		
		Applicant applicant = new Applicant();
		Employee employeeForCode = new Employee();
		String empCode = null;
		MasLocation masLocations = masLocationService.findByLocationCode(location);
		System.out.println("LOCATIONNNN :: " + masLocations);
		employeeForCode = employeeRepository.findEmployeeCode(1);
		
		System.out.println("employeeForCodeCreatedTime :: " + employeeForCode.getCreatedTimeStamp());
		System.out.println("employeeForCodeFirstName :: " + employeeForCode.getName());
		
		if(employeeForCode==null && ("TH").equals(location)){
			
			   
			empCode = applicant.getMasLocation()+"10"+"001";
			System.out.println("empCode: "+empCode);
			   
			   
		}else if(employeeForCode!=null && ("TH").equals(location)){
			
    		StringBuilder myNumbers = new StringBuilder();
    		for (int i = 0; i < employeeForCode.getEmployeeCode().length(); i++) {
    			
    		    if (Character.isDigit(employeeForCode.getEmployeeCode().charAt(i))) {
    		    	myNumbers.append(employeeForCode.getEmployeeCode().charAt(i));
    		        System.out.println(employeeForCode.getEmployeeCode().charAt(i) + " is a digit.");
    		    }else{
    		        System.out.println(employeeForCode.getEmployeeCode().charAt(i) + " not a digit.");
    		    }
    		}
    		
    		System.out.println("Your numbers: " + myNumbers.toString());
    		int employeeCodePlusOne = Integer.parseInt(myNumbers.toString())+1;
    		System.out.println("LOCATIONTOSTRING :: " + location);
    		empCode = location+Integer.toString(employeeCodePlusOne);
    		System.out.println("empCode: "+empCode);   		   
		   }
		   
		return empCode;
				
	}
	
}

