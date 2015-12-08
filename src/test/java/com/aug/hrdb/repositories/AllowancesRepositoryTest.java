/**
 *
 * @author Preeyaporn
 * @date 7 ก.ย. 2558
 */
package com.aug.hrdb.repositories;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Allowance;
import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.entities.Employee;
import com.aug.hrdb.entities.MasAllowance;
import com.aug.hrdb.entities.MasDivision;
import com.aug.hrdb.entities.MasJobLevel;
import com.aug.hrdb.entities.MasTechnology;
import com.aug.hrdb.repositories.AllowancesRepository;
import com.aug.hrdb.repositories.ApplicantRepository;
import com.aug.hrdb.repositories.EmployeeRepository;
import com.aug.hrdb.repositories.MasAllowanceRepository;
import com.aug.hrdb.repositories.MasDivisionRepository;
import com.aug.hrdb.repositories.MasJoblevelRepository;
import com.aug.hrdb.repositories.MasTechnologyRepository;
import com.aug.hrdb.services.MasAllowanceService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class AllowancesRepositoryTest {

	@Autowired private AllowancesRepository allowancesRepository;
	@Autowired private MasAllowanceRepository  masAllowancesRepository;
	@Autowired private EmployeeRepository employeeRepository;
	@Autowired private MasJoblevelRepository masJoblevelRepository;
	@Autowired private ApplicantRepository applicantRepository;
	@Autowired private MasDivisionRepository masDivisionRepository;
	@Autowired private MasTechnologyRepository masTechnologyRepository;	
	
	
	private	 Employee employee;
	int id;
	
	@Before
	public void setAbility() {
		employee = new Employee();
       /* employee.setIdCard("115310905001-9");
        employee.setNameThai("อภิวาท์");
        employee.setNameEng("apiva");
        employee.setNicknameThai("va");
        employee.setNicknameEng("va");
        employee.setSurnameThai("กิมเกถนอม");
        employee.setSurnameEng("kimkatanom");*/
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    	String dateInString = "31-08-1982";
    	Date date = null;
		try {
			date = sdf.parse(dateInString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
		/*employee.setDateOfBirth(date);
        employee.setEmail("test@gmail.com");
        employee.setEmergencyContact("mom");*/
        employee.setEmployeeCode("EMP-19");
        employee.setStatusemp("Employee");
        employee.setTelHome("089-0851022");
       /* employee.setTelMobile("089-0851022");
        employee.setEmergencyContactPhoneNumber("089-085-1022");*/
        employee.setAuditFlag("C");
        employee.setCreatedBy(1);
        employee.setCreatedTimeStamp(Calendar.getInstance().getTime());
        
        Applicant applicant = new Applicant();
		applicant.setCreatedBy(1);
		applicant.setCreatedTimeStamp(Calendar.getInstance().getTime());
		applicant.setAuditFlag("C");
		applicant.setCardId("115310905001-9");
	
		
        Applicant applicant1 = applicantRepository.find(1);
        Hibernate.initialize(applicant1);
        
        MasJobLevel masJoblevel = new MasJobLevel();
		masJoblevel.setName("CEO");
		masJoblevel.setIsActive(true);
		masJoblevel.setCode("01");
		masJoblevel.setAuditFlag("C");
		masJoblevel.setCreatedBy(1);
		masJoblevel.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masJoblevel.setCode("Division-01");
		masJoblevelRepository.create(masJoblevel);
		masJoblevelRepository.find(1);
		applicant.setJoblevel(masJoblevel);
		//employee.setMasJoblevel(masJoblevel);
		
		MasTechnology masTech = new MasTechnology();
		masTech.setName("Java");
		masTech.setCode("001A");
		masTech.setIsActive(true);
		masTech.setAuditFlag("C");
		masTech.setCreatedBy(0);
		Calendar cal = Calendar.getInstance();
		masTech.setCreatedTimeStamp(cal.getTime());
		masTechnologyRepository.create(masTech);
		applicant.setTechnology(masTech);
		
		applicantRepository.create(applicant);
              
        employee.setApplicant(applicant1);
         	
		MasDivision masDivision = new MasDivision();
		masDivision.setName("CEO");
		masDivision.setIsActive(true);
		masDivision.setCode("01");
		masDivision.setAuditFlag("C");
		masDivision.setCreatedBy(1);
		masDivision.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masDivision.setCode("Division-01");	
		masDivisionRepository.create(masDivision);
		masDivisionRepository.find(1);
		employee.setMasDivision(masDivision);			
	
		employeeRepository.create(employee);
	
		MasAllowance masAllowances = new MasAllowance();	
		masAllowances.setAllowance_type("Mother");
		masAllowances.setAmount_allowances(40000d);
		masAllowances.setCode("004A");
		masAllowances.setIsactive(true);	
		masAllowances.setAuditFlag("C");
		masAllowances.setCreatedBy(1);
		masAllowances.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masAllowancesRepository.create(masAllowances);
		
		
		Allowance allowances = new Allowance();	
		allowances.setAmount(6000d);	
		allowances.setAuditFlag("C");
		allowances.setCreatedBy(1);
		allowances.setCreatedTimeStamp(Calendar.getInstance().getTime());
		MasAllowance masallowances = masAllowancesRepository.find(1);
		allowances.setMasallowances(masallowances);
		allowances.setEmployee(employee);
		
		allowancesRepository.create(allowances);

		id = allowances.getId();
	}
	
	
	@Test
	@Rollback(true)
	public void create()  {

		Allowance allowances = new Allowance();		
		allowances.setAmount(6000d);		
		allowances.setAuditFlag("C");
		allowances.setCreatedBy(1);
		allowances.setCreatedTimeStamp(Calendar.getInstance().getTime());	
		MasAllowance masallowances = masAllowancesRepository.find(1);
		allowances.setMasallowances(masallowances);
		allowances.setEmployee(employee);
		
		allowancesRepository.create(allowances);

	}

	@Test
	@Rollback(true)
	public void update() {

		Allowance allowances = (Allowance) allowancesRepository.getCurrentSession().get(
				Allowance.class, id);
		allowances.setAmount(1000d);

		allowancesRepository.update(allowances);
	}

	@Test
	@Rollback(true)
	public void delete() {

		Allowance allowances = (Allowance) allowancesRepository.getCurrentSession().get(
				Allowance.class, id);

		allowancesRepository.delete(allowances);
	}


	@Test
	@Rollback(true)
	public void list() {

		Criteria c = allowancesRepository.getCurrentSession().createCriteria(
				Allowance.class);
		List<Allowance> allowances = c.list();
		Assert.assertEquals(3, allowances.size());

	}
}
