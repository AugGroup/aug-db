/**
 *
 * @author natechanok
 * @date Apr 27, 2015
 */

package com.aug.hrdb.repositories.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.aug.hrdb.dto.AimEmployeeDto;
import com.aug.hrdb.dto.EmployeeCodeDto;
import com.aug.hrdb.dto.EmployeeDto;
import com.aug.hrdb.dto.EmployeeIdDto;
import com.aug.hrdb.dto.ReportEmployeeDto;
import com.aug.hrdb.dto.ReportLeaveDto;
import com.aug.hrdb.dto.ReportStatusEmployeeDto;
import com.aug.hrdb.entities.Employee;
import com.aug.hrdb.repositories.EmployeeRepository;
import com.mysql.jdbc.StringUtils;


@Repository
public class EmployeerepositoryImpl extends GenericRepositoryImpl<Employee, Integer> implements EmployeeRepository{

	public EmployeerepositoryImpl() {
		super(Employee.class);
	}

	
	@SuppressWarnings("unchecked")
	public List<Employee> findByCriteria(Employee employee) {
		
		Criteria c = getCurrentSession().createCriteria(Employee.class);
		if (!StringUtils.isNullOrEmpty(employee.getNameEng())) {
			c.add(Restrictions.like("name", "%" + employee.getNameEng() + "%"));
		}
		return c.list();
		
	}

	
	/*public Employee deleteById(Integer id) {
		
		Employee employee =(Employee)getCurrentSession().load(Employee.class, id);
		getCurrentSession().delete(employee);
		return employee;
	}*/




	@SuppressWarnings("unchecked")
	public List<EmployeeDto> searchEmployee() {
		Query namedQuery = getCurrentSession().getNamedQuery("searchEmployee");
		List<EmployeeDto> empDto = namedQuery.list();
		return empDto;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<AimEmployeeDto> listEmployeeAim() {
		Query aimnamedQuery = getCurrentSession().getNamedQuery("listEmployeeAim");
		List<AimEmployeeDto> aimemp = aimnamedQuery.list();
		return aimemp;
	}


	@Override
	public void saveEmployee() {
		// TODO Auto-generated method stub
		
	}

	
	

	
public Employee findOfficial(Integer id) {
		
		Criteria c = getCurrentSession().createCriteria(Employee.class,"employee");
		c.setFetchMode("official",FetchMode.JOIN);
		c.createAlias("official", "official");
		c.add(Restrictions.eq("employee.id", id));
		return (Employee) c.uniqueResult();
		
	}
	

	@Override
	public void saveByNameQuery(EmployeeDto allEmployeeDto) {
		

	if(allEmployeeDto.getIsManager()==null){
		
		if(allEmployeeDto.getAimempid()==null){
		
		Query query = getCurrentSession().getNamedQuery("insertEmployeeNullIsManagerAim");
		query.setString("EMPLOYEE_CODE", allEmployeeDto.getEmployeeCode());
		query.setString("NAME_THAI", allEmployeeDto.getNameThai());
		query.setString("SURNAME_THAI", allEmployeeDto.getSurnameThai());
		
		query.setString("NICKNAME_THAI", allEmployeeDto.getNicknameThai());
		query.setString("NAME_ENG", allEmployeeDto.getNameEng());
		query.setString("SURNAME_ENG", allEmployeeDto.getSurnameEng());
		
		query.setString("NICKNAME_ENG", allEmployeeDto.getNicknameEng());
		query.setString("EMAIL", allEmployeeDto.getEmail());
		query.setString("TEL_HOME", allEmployeeDto.getTelHome());
		
		query.setString("TEL_MOBILE", allEmployeeDto.getTelMobile());
		query.setString("TEL_FAX", allEmployeeDto.getTelFax());
		query.setString("CONGENITAL_DISEASE", allEmployeeDto.getCongenitalDisease());
		
		query.setString("HOSPITAL", allEmployeeDto.getHospital());
		query.setString("EMERGENCY_CONTACT", allEmployeeDto.getEmergencyContact());
		query.setString("RELATIONSHIP_WITH_EMERGENCY_CONTACT", allEmployeeDto.getRelationshipWithEmergencyContact());
		
		query.setString("EMERGENCY_CONTACT_ADDRESS", allEmployeeDto.getEmergencyContactAddress());
		query.setString("EMERGENCY_CONTACT_PHONE_NUMBER", allEmployeeDto.getEmergencyContactPhoneNumber());
		query.setDate("DATEOFBIRTH", allEmployeeDto.getDateOfBirth());
		
		query.setString("PLACEOFBIRTH", allEmployeeDto.getPlaceOfBirth());
		query.setInteger("AGE", allEmployeeDto.getAge());
		query.setString("RELIGION", allEmployeeDto.getReligion());
		
		query.setString("ID_CARD", allEmployeeDto.getIdCard());
		query.setString("ISSUED_OFFICE", allEmployeeDto.getIssuedOffice());
		query.setDate("EXPIRY_DATE", allEmployeeDto.getExpiryDate());
		
		query.setInteger("HEIGHT", allEmployeeDto.getHeight());
		query.setInteger("WEIGTH", allEmployeeDto.getWeigth());
		query.setString("SEX", allEmployeeDto.getSex());
		
		query.setString("MARITAL_STATUS", allEmployeeDto.getMaritalStatus());
		query.setString("NUMBER_OF_CHILDREN", allEmployeeDto.getNumberOfChildren());
		query.setString("SPOUSE_NAME", allEmployeeDto.getSpouseName());
		
		query.setString("MARRIAGE_CERTIFICATE_NO", allEmployeeDto.getMarriageCertificateNo());
		query.setString("ISSUED_OFFICE2", allEmployeeDto.getIssuedOffice2());
		query.setString("ADDRESS", allEmployeeDto.getAddress());
		
		query.setString("OCCUPATION", allEmployeeDto.getOccupation());
		query.setString("KNOW_AUG_NEWSPAPER", allEmployeeDto.getKnowAugNewspaper());
		query.setString("DESCRIPTION_NEWSPAPER", allEmployeeDto.getDescriptionNewspaper());
		
		query.setString("KNOW_AUG_MAGAZINE", allEmployeeDto.getKnowAugMagazine());
		query.setString("DESCRIPTION_MAGAZINE", allEmployeeDto.getDescriptionMagazine());
		query.setString("KNOW_AUG_WEBSITE", allEmployeeDto.getKnowAugWebsite());
		
		query.setString("DESCRIPTION_WEBSITE", allEmployeeDto.getDescriptionWebsite());
		query.setString("KNOW_AUG_FRIEND", allEmployeeDto.getKnowAugFriend());
		query.setString("DESCRIPTION_FRIEND", allEmployeeDto.getDescriptionFriend());
		
		query.setString("KNOW_AUG_OTHER", allEmployeeDto.getKnowAugOther());
		query.setString("DESCRIPTION_OTHER", allEmployeeDto.getDescriptionOther());
		query.setString("KNOW_EMPLOYED", allEmployeeDto.getKnowEmployed());
		
		query.setString("DESCRIPTION_YES", allEmployeeDto.getDescriptionYes());
		/*query.setString("KNOW_EMPLOYER_NO", allEmployeeDto.getKnowEmployerNo());*/
		query.setString("MILITARY_SERVICE", allEmployeeDto.getMilitaryService());
		
		query.setDate("FROM_YEAR", allEmployeeDto.getFromYear());
		query.setDate("TO_YEAR", allEmployeeDto.getToYear());
		query.setString("BRANCH_OF_SERVICE", allEmployeeDto.getBranchOfService());
		
		query.setString("SERVICE_NO", allEmployeeDto.getServiceNo());
		query.setString("REASONS_NO", allEmployeeDto.getReasonsNo());
		
		query.setDate("DATE_TO_BE_DRAFTED", allEmployeeDto.getDateToBeDrafted());
		query.setString("PREVIOUS_EMPLOYER", allEmployeeDto.getPreviousEmployer());
		query.setString("PREVIOUSEMP_REASONS_NO", allEmployeeDto.getPreviousEmpreasonsNo());
		query.setString("IMAGE", allEmployeeDto.getImage());
		query.setString("STATUSEMP", allEmployeeDto.getStatusemp());
		
		query.setInteger("DIVISION_ID", allEmployeeDto.getMasDivision());
		query.setInteger("JOBLEVEL_ID", allEmployeeDto.getMasDivision());
		query.setInteger("EMPLOYMENT_ID", allEmployeeDto.getMasEmployment());
		query.setInteger("TECHNOLOGY_ID", allEmployeeDto.getTechnology());
		query.setInteger("MAS_CORE_SKILL_ID", allEmployeeDto.getMasCoreSkill());
		query.setInteger("STAFFTYPE_ID", allEmployeeDto.getMasStaffType());
		query.setInteger("LOCATION_ID", allEmployeeDto.getMasLocationId());
		query.setInteger("OFFICIAL_ID", allEmployeeDto.getOfficialId());	
		query.executeUpdate();
			
		}else if(allEmployeeDto.getAimempid()!=null){
			
			Query query = getCurrentSession().getNamedQuery("insertEmployeeNullIsManager");
			query.setString("EMPLOYEE_CODE", allEmployeeDto.getEmployeeCode());
			query.setString("NAME_THAI", allEmployeeDto.getNameThai());
			query.setString("SURNAME_THAI", allEmployeeDto.getSurnameThai());
			
			query.setString("NICKNAME_THAI", allEmployeeDto.getNicknameThai());
			query.setString("NAME_ENG", allEmployeeDto.getNameEng());
			query.setString("SURNAME_ENG", allEmployeeDto.getSurnameEng());
			
			query.setString("NICKNAME_ENG", allEmployeeDto.getNicknameEng());
			query.setString("EMAIL", allEmployeeDto.getEmail());
			query.setString("TEL_HOME", allEmployeeDto.getTelHome());
			
			query.setString("TEL_MOBILE", allEmployeeDto.getTelMobile());
			query.setString("TEL_FAX", allEmployeeDto.getTelFax());
			query.setString("CONGENITAL_DISEASE", allEmployeeDto.getCongenitalDisease());
			
			query.setString("HOSPITAL", allEmployeeDto.getHospital());
			query.setString("EMERGENCY_CONTACT", allEmployeeDto.getEmergencyContact());
			query.setString("RELATIONSHIP_WITH_EMERGENCY_CONTACT", allEmployeeDto.getRelationshipWithEmergencyContact());
			
			query.setString("EMERGENCY_CONTACT_ADDRESS", allEmployeeDto.getEmergencyContactAddress());
			query.setString("EMERGENCY_CONTACT_PHONE_NUMBER", allEmployeeDto.getEmergencyContactPhoneNumber());
			query.setDate("DATEOFBIRTH", allEmployeeDto.getDateOfBirth());
			
			query.setString("PLACEOFBIRTH", allEmployeeDto.getPlaceOfBirth());
			query.setInteger("AGE", allEmployeeDto.getAge());
			query.setString("RELIGION", allEmployeeDto.getReligion());
			
			query.setString("ID_CARD", allEmployeeDto.getIdCard());
			query.setString("ISSUED_OFFICE", allEmployeeDto.getIssuedOffice());
			query.setDate("EXPIRY_DATE", allEmployeeDto.getExpiryDate());
			
			query.setInteger("HEIGHT", allEmployeeDto.getHeight());
			query.setInteger("WEIGTH", allEmployeeDto.getWeigth());
			query.setString("SEX", allEmployeeDto.getSex());
			
			query.setString("MARITAL_STATUS", allEmployeeDto.getMaritalStatus());
			query.setString("NUMBER_OF_CHILDREN", allEmployeeDto.getNumberOfChildren());
			query.setString("SPOUSE_NAME", allEmployeeDto.getSpouseName());
			
			query.setString("MARRIAGE_CERTIFICATE_NO", allEmployeeDto.getMarriageCertificateNo());
			query.setString("ISSUED_OFFICE2", allEmployeeDto.getIssuedOffice2());
			query.setString("ADDRESS", allEmployeeDto.getAddress());
			
			query.setString("OCCUPATION", allEmployeeDto.getOccupation());
			query.setString("KNOW_AUG_NEWSPAPER", allEmployeeDto.getKnowAugNewspaper());
			query.setString("DESCRIPTION_NEWSPAPER", allEmployeeDto.getDescriptionNewspaper());
			
			query.setString("KNOW_AUG_MAGAZINE", allEmployeeDto.getKnowAugMagazine());
			query.setString("DESCRIPTION_MAGAZINE", allEmployeeDto.getDescriptionMagazine());
			query.setString("KNOW_AUG_WEBSITE", allEmployeeDto.getKnowAugWebsite());
			
			query.setString("DESCRIPTION_WEBSITE", allEmployeeDto.getDescriptionWebsite());
			query.setString("KNOW_AUG_FRIEND", allEmployeeDto.getKnowAugFriend());
			query.setString("DESCRIPTION_FRIEND", allEmployeeDto.getDescriptionFriend());
			
			query.setString("KNOW_AUG_OTHER", allEmployeeDto.getKnowAugOther());
			query.setString("DESCRIPTION_OTHER", allEmployeeDto.getDescriptionOther());
			query.setString("KNOW_EMPLOYED", allEmployeeDto.getKnowEmployed());
			
			query.setString("DESCRIPTION_YES", allEmployeeDto.getDescriptionYes());
			/*query.setString("KNOW_EMPLOYER_NO", allEmployeeDto.getKnowEmployerNo());*/
			query.setString("MILITARY_SERVICE", allEmployeeDto.getMilitaryService());
			
			query.setDate("FROM_YEAR", allEmployeeDto.getFromYear());
			query.setDate("TO_YEAR", allEmployeeDto.getToYear());
			query.setString("BRANCH_OF_SERVICE", allEmployeeDto.getBranchOfService());
			
			query.setString("SERVICE_NO", allEmployeeDto.getServiceNo());
			/*query.setString("MILITARY_SERVICE_NO", allEmployeeDto.getMilitaryServiceNo());*/
			query.setString("REASONS_NO", allEmployeeDto.getReasonsNo());
			
			query.setDate("DATE_TO_BE_DRAFTED", allEmployeeDto.getDateToBeDrafted());
			query.setString("PREVIOUS_EMPLOYER", allEmployeeDto.getPreviousEmployer());
			query.setString("PREVIOUSEMP_REASONS_NO", allEmployeeDto.getPreviousEmpreasonsNo());
			query.setString("IMAGE", allEmployeeDto.getImage());
			query.setString("STATUSEMP", allEmployeeDto.getStatusemp());
			
			query.setInteger("DIVISION_ID", allEmployeeDto.getMasDivision());
			query.setInteger("JOBLEVEL_ID", allEmployeeDto.getMasDivision());
			query.setInteger("EMPLOYMENT_ID", allEmployeeDto.getMasEmployment());
			query.setInteger("TECHNOLOGY_ID", allEmployeeDto.getTechnology());
			query.setInteger("MAS_CORE_SKILL_ID", allEmployeeDto.getMasCoreSkill());
			query.setInteger("STAFFTYPE_ID", allEmployeeDto.getMasStaffType());
			query.setInteger("LOCATION_ID", allEmployeeDto.getMasLocationId());
			query.setInteger("OFFICIAL_ID", allEmployeeDto.getOfficialId());	
			query.setInteger("AIM_EMP_ID", allEmployeeDto.getAimempid());
			query.executeUpdate();
			
		}
		
		
		
		}else if(allEmployeeDto.getIsManager()!=null){
			
			if(allEmployeeDto.getAimempid()==null){
				
				Query query = getCurrentSession().getNamedQuery("insertEmployeeNullAim");
				query.setString("EMPLOYEE_CODE", allEmployeeDto.getEmployeeCode());
				query.setString("NAME_THAI", allEmployeeDto.getNameThai());
				query.setString("SURNAME_THAI", allEmployeeDto.getSurnameThai());
				
				query.setString("NICKNAME_THAI", allEmployeeDto.getNicknameThai());
				query.setString("NAME_ENG", allEmployeeDto.getNameEng());
				query.setString("SURNAME_ENG", allEmployeeDto.getSurnameEng());
				
				query.setString("NICKNAME_ENG", allEmployeeDto.getNicknameEng());
				query.setString("EMAIL", allEmployeeDto.getEmail());
				query.setString("TEL_HOME", allEmployeeDto.getTelHome());
				
				query.setString("TEL_MOBILE", allEmployeeDto.getTelMobile());
				query.setString("TEL_FAX", allEmployeeDto.getTelFax());
				query.setString("CONGENITAL_DISEASE", allEmployeeDto.getCongenitalDisease());
				
				query.setString("HOSPITAL", allEmployeeDto.getHospital());
				query.setString("EMERGENCY_CONTACT", allEmployeeDto.getEmergencyContact());
				query.setString("RELATIONSHIP_WITH_EMERGENCY_CONTACT", allEmployeeDto.getRelationshipWithEmergencyContact());
				
				query.setString("EMERGENCY_CONTACT_ADDRESS", allEmployeeDto.getEmergencyContactAddress());
				query.setString("EMERGENCY_CONTACT_PHONE_NUMBER", allEmployeeDto.getEmergencyContactPhoneNumber());
				query.setDate("DATEOFBIRTH", allEmployeeDto.getDateOfBirth());
				
				query.setString("PLACEOFBIRTH", allEmployeeDto.getPlaceOfBirth());
				query.setInteger("AGE", allEmployeeDto.getAge());
				query.setString("RELIGION", allEmployeeDto.getReligion());
				
				query.setString("ID_CARD", allEmployeeDto.getIdCard());
				query.setString("ISSUED_OFFICE", allEmployeeDto.getIssuedOffice());
				query.setDate("EXPIRY_DATE", allEmployeeDto.getExpiryDate());
				
				query.setInteger("HEIGHT", allEmployeeDto.getHeight());
				query.setInteger("WEIGTH", allEmployeeDto.getWeigth());
				query.setString("SEX", allEmployeeDto.getSex());
				
				query.setString("MARITAL_STATUS", allEmployeeDto.getMaritalStatus());
				query.setString("NUMBER_OF_CHILDREN", allEmployeeDto.getNumberOfChildren());
				query.setString("SPOUSE_NAME", allEmployeeDto.getSpouseName());
				
				query.setString("MARRIAGE_CERTIFICATE_NO", allEmployeeDto.getMarriageCertificateNo());
				query.setString("ISSUED_OFFICE2", allEmployeeDto.getIssuedOffice2());
				query.setString("ADDRESS", allEmployeeDto.getAddress());
				
				query.setString("OCCUPATION", allEmployeeDto.getOccupation());
				query.setString("KNOW_AUG_NEWSPAPER", allEmployeeDto.getKnowAugNewspaper());
				query.setString("DESCRIPTION_NEWSPAPER", allEmployeeDto.getDescriptionNewspaper());
				
				query.setString("KNOW_AUG_MAGAZINE", allEmployeeDto.getKnowAugMagazine());
				query.setString("DESCRIPTION_MAGAZINE", allEmployeeDto.getDescriptionMagazine());
				query.setString("KNOW_AUG_WEBSITE", allEmployeeDto.getKnowAugWebsite());
				
				query.setString("DESCRIPTION_WEBSITE", allEmployeeDto.getDescriptionWebsite());
				query.setString("KNOW_AUG_FRIEND", allEmployeeDto.getKnowAugFriend());
				query.setString("DESCRIPTION_FRIEND", allEmployeeDto.getDescriptionFriend());
				
				query.setString("KNOW_AUG_OTHER", allEmployeeDto.getKnowAugOther());
				query.setString("DESCRIPTION_OTHER", allEmployeeDto.getDescriptionOther());
				query.setString("KNOW_EMPLOYED", allEmployeeDto.getKnowEmployed());
				
				query.setString("DESCRIPTION_YES", allEmployeeDto.getDescriptionYes());
				/*query.setString("KNOW_EMPLOYER_NO", allEmployeeDto.getKnowEmployerNo());*/
				query.setString("MILITARY_SERVICE", allEmployeeDto.getMilitaryService());
				
				query.setDate("FROM_YEAR", allEmployeeDto.getFromYear());
				query.setDate("TO_YEAR", allEmployeeDto.getToYear());
				query.setString("BRANCH_OF_SERVICE", allEmployeeDto.getBranchOfService());
				
				query.setString("SERVICE_NO", allEmployeeDto.getServiceNo());
				query.setString("REASONS_NO", allEmployeeDto.getReasonsNo());
				
				query.setDate("DATE_TO_BE_DRAFTED", allEmployeeDto.getDateToBeDrafted());
				query.setString("PREVIOUS_EMPLOYER", allEmployeeDto.getPreviousEmployer());
				query.setString("PREVIOUSEMP_REASONS_NO", allEmployeeDto.getPreviousEmpreasonsNo());
				query.setString("IMAGE", allEmployeeDto.getImage());
				query.setString("STATUSEMP", allEmployeeDto.getStatusemp());
				
				query.setInteger("DIVISION_ID", allEmployeeDto.getMasDivision());
				query.setInteger("JOBLEVEL_ID", allEmployeeDto.getMasDivision());
				query.setInteger("EMPLOYMENT_ID", allEmployeeDto.getMasEmployment());
				query.setInteger("TECHNOLOGY_ID", allEmployeeDto.getTechnology());
				query.setInteger("MAS_CORE_SKILL_ID", allEmployeeDto.getMasCoreSkill());
				query.setInteger("STAFFTYPE_ID", allEmployeeDto.getMasStaffType());
				query.setInteger("LOCATION_ID", allEmployeeDto.getMasLocationId());
				query.setInteger("OFFICIAL_ID", allEmployeeDto.getOfficialId());	
				query.setInteger("ISMANAGER", allEmployeeDto.getIsManager());
				query.executeUpdate();
				
				
			}else if(allEmployeeDto.getAimempid()!=null){
				
				
				Query query = getCurrentSession().getNamedQuery("insertEmployee");
				query.setString("EMPLOYEE_CODE", allEmployeeDto.getEmployeeCode());
				query.setString("NAME_THAI", allEmployeeDto.getNameThai());
				query.setString("SURNAME_THAI", allEmployeeDto.getSurnameThai());
				
				query.setString("NICKNAME_THAI", allEmployeeDto.getNicknameThai());
				query.setString("NAME_ENG", allEmployeeDto.getNameEng());
				query.setString("SURNAME_ENG", allEmployeeDto.getSurnameEng());
				
				query.setString("NICKNAME_ENG", allEmployeeDto.getNicknameEng());
				query.setString("EMAIL", allEmployeeDto.getEmail());
				query.setString("TEL_HOME", allEmployeeDto.getTelHome());
				
				query.setString("TEL_MOBILE", allEmployeeDto.getTelMobile());
				query.setString("TEL_FAX", allEmployeeDto.getTelFax());
				query.setString("CONGENITAL_DISEASE", allEmployeeDto.getCongenitalDisease());
				
				query.setString("HOSPITAL", allEmployeeDto.getHospital());
				query.setString("EMERGENCY_CONTACT", allEmployeeDto.getEmergencyContact());
				query.setString("RELATIONSHIP_WITH_EMERGENCY_CONTACT", allEmployeeDto.getRelationshipWithEmergencyContact());
				
				query.setString("EMERGENCY_CONTACT_ADDRESS", allEmployeeDto.getEmergencyContactAddress());
				query.setString("EMERGENCY_CONTACT_PHONE_NUMBER", allEmployeeDto.getEmergencyContactPhoneNumber());
				query.setDate("DATEOFBIRTH", allEmployeeDto.getDateOfBirth());
				
				query.setString("PLACEOFBIRTH", allEmployeeDto.getPlaceOfBirth());
				query.setInteger("AGE", allEmployeeDto.getAge());
				query.setString("RELIGION", allEmployeeDto.getReligion());
				
				query.setString("ID_CARD", allEmployeeDto.getIdCard());
				query.setString("ISSUED_OFFICE", allEmployeeDto.getIssuedOffice());
				query.setDate("EXPIRY_DATE", allEmployeeDto.getExpiryDate());
				
				query.setInteger("HEIGHT", allEmployeeDto.getHeight());
				query.setInteger("WEIGTH", allEmployeeDto.getWeigth());
				query.setString("SEX", allEmployeeDto.getSex());
				
				query.setString("MARITAL_STATUS", allEmployeeDto.getMaritalStatus());
				query.setString("NUMBER_OF_CHILDREN", allEmployeeDto.getNumberOfChildren());
				query.setString("SPOUSE_NAME", allEmployeeDto.getSpouseName());
				
				query.setString("MARRIAGE_CERTIFICATE_NO", allEmployeeDto.getMarriageCertificateNo());
				query.setString("ISSUED_OFFICE2", allEmployeeDto.getIssuedOffice2());
				query.setString("ADDRESS", allEmployeeDto.getAddress());
				
				query.setString("OCCUPATION", allEmployeeDto.getOccupation());
				query.setString("KNOW_AUG_NEWSPAPER", allEmployeeDto.getKnowAugNewspaper());
				query.setString("DESCRIPTION_NEWSPAPER", allEmployeeDto.getDescriptionNewspaper());
				
				query.setString("KNOW_AUG_MAGAZINE", allEmployeeDto.getKnowAugMagazine());
				query.setString("DESCRIPTION_MAGAZINE", allEmployeeDto.getDescriptionMagazine());
				query.setString("KNOW_AUG_WEBSITE", allEmployeeDto.getKnowAugWebsite());
				
				query.setString("DESCRIPTION_WEBSITE", allEmployeeDto.getDescriptionWebsite());
				query.setString("KNOW_AUG_FRIEND", allEmployeeDto.getKnowAugFriend());
				query.setString("DESCRIPTION_FRIEND", allEmployeeDto.getDescriptionFriend());
				
				query.setString("KNOW_AUG_OTHER", allEmployeeDto.getKnowAugOther());
				query.setString("DESCRIPTION_OTHER", allEmployeeDto.getDescriptionOther());
				query.setString("KNOW_EMPLOYED", allEmployeeDto.getKnowEmployed());
				
				query.setString("DESCRIPTION_YES", allEmployeeDto.getDescriptionYes());
				/*query.setString("KNOW_EMPLOYER_NO", allEmployeeDto.getKnowEmployerNo());*/
				query.setString("MILITARY_SERVICE", allEmployeeDto.getMilitaryService());
				
				query.setDate("FROM_YEAR", allEmployeeDto.getFromYear());
				query.setDate("TO_YEAR", allEmployeeDto.getToYear());
				query.setString("BRANCH_OF_SERVICE", allEmployeeDto.getBranchOfService());
				
				query.setString("SERVICE_NO", allEmployeeDto.getServiceNo());
				query.setString("REASONS_NO", allEmployeeDto.getReasonsNo());
				
				query.setDate("DATE_TO_BE_DRAFTED", allEmployeeDto.getDateToBeDrafted());
				query.setString("PREVIOUS_EMPLOYER", allEmployeeDto.getPreviousEmployer());
				query.setString("PREVIOUSEMP_REASONS_NO", allEmployeeDto.getPreviousEmpreasonsNo());
				query.setString("IMAGE", allEmployeeDto.getImage());
				query.setString("STATUSEMP", allEmployeeDto.getStatusemp());
				
				query.setInteger("DIVISION_ID", allEmployeeDto.getMasDivision());
				query.setInteger("JOBLEVEL_ID", allEmployeeDto.getMasDivision());
				query.setInteger("EMPLOYMENT_ID", allEmployeeDto.getMasEmployment());
				query.setInteger("TECHNOLOGY_ID", allEmployeeDto.getTechnology());
				query.setInteger("MAS_CORE_SKILL_ID", allEmployeeDto.getMasCoreSkill());
				query.setInteger("STAFFTYPE_ID", allEmployeeDto.getMasStaffType());
				query.setInteger("LOCATION_ID", allEmployeeDto.getMasLocationId());
				query.setInteger("OFFICIAL_ID", allEmployeeDto.getOfficialId());	
				query.setInteger("ISMANAGER", allEmployeeDto.getIsManager());
				query.setInteger("AIM_EMP_ID", allEmployeeDto.getAimempid());
				query.executeUpdate();
				
			}
			
		}
	
	
	
	
	
	
	}


	@Override
	public Employee searhEmpIdtoAddress() {
		Query query = getCurrentSession().getNamedQuery("searchIdEmptoAddress");
		List<Employee> employee = query.list();	
		return employee.get(0);
	}


	@Override
	public EmployeeCodeDto serchRunningNo(String code) {
		// TODO Auto-generated method stub
		Query query = getCurrentSession().getNamedQuery("runningNo").setString("location",code);
		List<EmployeeCodeDto> employeeCode = query.list();	
		return employeeCode.get(0);
	}


	@Override
	public List<ReportEmployeeDto> reportEmployee(String nameEng) {
		Query query = getCurrentSession().getNamedQuery("reportEmployee").setString("name","%"+ nameEng +"%");
		List<ReportEmployeeDto> employees = query.list();	
		return employees;
	}
	
	@Override
	public List<ReportEmployeeDto> reportEmployeeCode(String code) {
		Query query = getCurrentSession().getNamedQuery("reportEmployeeCode").setString("code","%"+ code +"%");
		List<ReportEmployeeDto> employees = query.list();	
		return employees;
	}

	
	@Override
	public List<ReportStatusEmployeeDto> reportStatusEmployee(String statusStaff) {
		
		Query query = getCurrentSession().getNamedQuery("reportStatusEmployee").setString("statusStaff","%"+ statusStaff +"%");
		List<ReportStatusEmployeeDto> employee = query.list();	
		return employee;
	}

	@Override
	public List<ReportLeaveDto> reportLeave(String nameEng) {
		Query query = getCurrentSession().getNamedQuery("reportLeave").setString("name","%"+ nameEng +"%");
				List<ReportLeaveDto> leaves = query.list();	
		return leaves;
	}
	
	@SuppressWarnings("unchecked")
	public List<ReportEmployeeDto> findByName(Employee employee) {
		
		Criteria c = getCurrentSession().createCriteria(ReportEmployeeDto.class);
		if (!StringUtils.isNullOrEmpty(employee.getNameEng())) {
			c.add(Restrictions.like("name", "%" + employee.getNameEng() + "%"));
		}
		return c.list();
		
	}
	

	
	@SuppressWarnings("unchecked")
	public List<ReportStatusEmployeeDto> findByNameStatus(Employee employee) {
		
		Criteria c = getCurrentSession().createCriteria(ReportEmployeeDto.class);
		if (!StringUtils.isNullOrEmpty(employee.getNameEng())) {
			c.add(Restrictions.like("name", "%" + employee.getNameEng() + "%"));
		}
		return c.list();
		
	}
	

	

	public void updateByNameQuery(EmployeeDto allEmployeeDto) {
		// TODO Auto-generated method stub
		Query query = getCurrentSession().getNamedQuery("updateEmployee");
		query.setString("EMPLOYEE_CODE", allEmployeeDto.getEmployeeCode());
		query.setString("NAME_THAI", allEmployeeDto.getNameThai());
		query.setString("SURNAME_THAI", allEmployeeDto.getSurnameThai());
		
		query.setString("NICKNAME_THAI", allEmployeeDto.getNicknameThai());
		query.setString("NAME_ENG", allEmployeeDto.getNameEng());
		query.setString("SURNAME_ENG", allEmployeeDto.getSurnameEng());
		
		query.setString("NICKNAME_ENG", allEmployeeDto.getNicknameEng());
		query.setString("EMAIL", allEmployeeDto.getEmail());
		query.setString("TEL_HOME", allEmployeeDto.getTelHome());
		
		query.setString("TEL_MOBILE", allEmployeeDto.getTelMobile());
		query.setString("TEL_FAX", allEmployeeDto.getTelFax());
		query.setString("CONGENITAL_DISEASE", allEmployeeDto.getCongenitalDisease());
		
		query.setString("HOSPITAL", allEmployeeDto.getHospital());
		query.setString("EMERGENCY_CONTACT", allEmployeeDto.getEmergencyContact());
		query.setString("RELATIONSHIP_WITH_EMERGENCY_CONTACT", allEmployeeDto.getRelationshipWithEmergencyContact());
		
		query.setString("EMERGENCY_CONTACT_ADDRESS", allEmployeeDto.getEmergencyContactAddress());
		query.setString("EMERGENCY_CONTACT_PHONE_NUMBER", allEmployeeDto.getEmergencyContactPhoneNumber());
		query.setDate("DATEOFBIRTH", allEmployeeDto.getDateOfBirth());
		
		query.setString("PLACEOFBIRTH", allEmployeeDto.getPlaceOfBirth());
		query.setInteger("AGE", allEmployeeDto.getAge());
		query.setString("RELIGION", allEmployeeDto.getReligion());
		
		query.setString("ID_CARD", allEmployeeDto.getIdCard());
		query.setString("ISSUED_OFFICE", allEmployeeDto.getIssuedOffice());
		query.setDate("EXPIRY_DATE", allEmployeeDto.getExpiryDate());
		
		query.setInteger("HEIGHT", allEmployeeDto.getHeight());
		query.setInteger("WEIGTH", allEmployeeDto.getWeigth());
		query.setString("SEX", allEmployeeDto.getSex());
		
		query.setString("MARITAL_STATUS", allEmployeeDto.getMaritalStatus());
		query.setString("NUMBER_OF_CHILDREN", allEmployeeDto.getNumberOfChildren());
		query.setString("SPOUSE_NAME", allEmployeeDto.getSpouseName());
		
		query.setString("MARRIAGE_CERTIFICATE_NO", allEmployeeDto.getMarriageCertificateNo());
		query.setString("ISSUED_OFFICE2", allEmployeeDto.getIssuedOffice2());
		query.setString("ADDRESS", allEmployeeDto.getAddress());
		
		query.setString("OCCUPATION", allEmployeeDto.getOccupation());
		query.setString("KNOW_AUG_NEWSPAPER", allEmployeeDto.getKnowAugNewspaper());
		query.setString("DESCRIPTION_NEWSPAPER", allEmployeeDto.getDescriptionNewspaper());
		
		query.setString("KNOW_AUG_MAGAZINE", allEmployeeDto.getKnowAugMagazine());
		query.setString("DESCRIPTION_MAGAZINE", allEmployeeDto.getDescriptionMagazine());
		query.setString("KNOW_AUG_WEBSITE", allEmployeeDto.getKnowAugWebsite());
		
		query.setString("DESCRIPTION_WEBSITE", allEmployeeDto.getDescriptionWebsite());
		query.setString("KNOW_AUG_FRIEND", allEmployeeDto.getKnowAugFriend());
		query.setString("DESCRIPTION_FRIEND", allEmployeeDto.getDescriptionFriend());
		
		query.setString("KNOW_AUG_OTHER", allEmployeeDto.getKnowAugOther());
		query.setString("DESCRIPTION_OTHER", allEmployeeDto.getDescriptionOther());
		query.setString("KNOW_EMPLOYED", allEmployeeDto.getKnowEmployed());
		
		query.setString("DESCRIPTION_YES", allEmployeeDto.getDescriptionYes());
		/*query.setString("KNOW_EMPLOYER_NO", allEmployeeDto.getKnowEmployerNo());*/
		query.setString("MILITARY_SERVICE", allEmployeeDto.getMilitaryService());
		
		query.setDate("FROM_YEAR", allEmployeeDto.getFromYear());
		query.setDate("TO_YEAR", allEmployeeDto.getToYear());
		query.setString("BRANCH_OF_SERVICE", allEmployeeDto.getBranchOfService());
		
		query.setString("SERVICE_NO", allEmployeeDto.getServiceNo());
		query.setString("REASONS_NO", allEmployeeDto.getReasonsNo());
		
		query.setDate("DATE_TO_BE_DRAFTED", allEmployeeDto.getDateToBeDrafted());
		query.setString("PREVIOUS_EMPLOYER", allEmployeeDto.getPreviousEmployer());
		query.setString("PREVIOUSEMP_REASONS_NO", allEmployeeDto.getPreviousEmpreasonsNo());
		query.setString("IMAGE", allEmployeeDto.getImage());
		query.setString("STATUSEMP", allEmployeeDto.getStatusemp());
		
		query.setInteger("DIVISION_ID", allEmployeeDto.getMasDivision());
		query.setInteger("JOBLEVEL_ID", allEmployeeDto.getMasDivision());
		query.setInteger("EMPLOYMENT_ID", allEmployeeDto.getMasEmployment());
		query.setInteger("TECHNOLOGY_ID", allEmployeeDto.getTechnology());
		query.setInteger("MAS_CORE_SKILL_ID", allEmployeeDto.getMasCoreSkill());
		query.setInteger("STAFFTYPE_ID", allEmployeeDto.getMasStaffType());
		query.setInteger("LOCATION_ID", allEmployeeDto.getMasLocationId());
		query.setInteger("OFFICIAL_ID", allEmployeeDto.getOfficialId());	
		query.setInteger("ISMANAGER", allEmployeeDto.getIsManager());
		query.setInteger("AIM_EMP_ID", allEmployeeDto.getAimempid());
		query.setInteger("id", allEmployeeDto.getId());
		query.executeUpdate();

	}


	@Override
	public EmployeeIdDto findCurrentId() {
		// TODO Auto-generated method stub

		Query query = getCurrentSession().getNamedQuery("findCurrentId");
		return (EmployeeIdDto) query.list().get(0);
	}


	@Override
	public Employee findEmployeeAndOfficial(Integer id) {
		// TODO Auto-generated method stub
		Criteria c = getCurrentSession().createCriteria(Employee.class,"employee");
		c.setFetchMode("official", FetchMode.JOIN);
		c.createAlias("official", "official");
		c.add(Restrictions.eq("employee.id", id));				 
		return (Employee) c.uniqueResult();
	}


	@Override
	public void deleteEmployeeByNameQuery(Employee employee) {
		// TODO Auto-generated method stub
		Query query = getCurrentSession().getNamedQuery("deleteEmployee");
		query.setInteger("id", employee.getId());
		query.executeUpdate();
		
	}


	@Override
	public List<Employee> findAimRelateWithEmployee(Integer id) {
		// TODO Auto-generated method stub
		Criteria c = getCurrentSession().createCriteria(Employee.class,"employee");
		c.setFetchMode("aimempid", FetchMode.JOIN)	;
		c.createAlias("aimempid", "aimempid");
		c.add(Restrictions.eq("aimempid.id", id));
		return c.list();
	}


	@Override
	public Employee findEmployeeCode(Integer locationId) {
		// TODO Auto-generated method stub
		Criteria c = getCurrentSession().createCriteria(Employee.class,"employee");
		c.add(Restrictions.eq("employee.masLocation.id",locationId));
		c.addOrder(Order.desc("employee.createdTimeStamp"));
	    c.setMaxResults(1);
		return  (Employee) c.uniqueResult();
	}

}
	
