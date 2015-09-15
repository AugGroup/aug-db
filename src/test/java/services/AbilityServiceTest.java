/**
 *
 * @author Pranrajit
 * @date 4 ก.ย. 2558
 */
package services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;






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

import com.aug.hrdb.entities.Ability;
import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.entities.Employee;
import com.aug.hrdb.entities.MasDivision;
import com.aug.hrdb.entities.MasJoblevel;
import com.aug.hrdb.entities.MasSpecialty;
import com.aug.hrdb.repositories.ApplicantRepository;
import com.aug.hrdb.repositories.EmployeeRepository;
import com.aug.hrdb.repositories.MasDivisionRepository;
import com.aug.hrdb.repositories.MasJoblevelRepository;
import com.aug.hrdb.services.AbilityService;
import com.aug.hrdb.services.ApplicantService;
import com.aug.hrdb.services.EmployeeService;
import com.aug.hrdb.services.MasDivisionService;
import com.aug.hrdb.services.MasJoblevelService;
import com.aug.hrdb.services.MasSpecialtyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class AbilityServiceTest {
	
	@Autowired private AbilityService abilityService;
	@Autowired private EmployeeService employeeService;
	@Autowired private MasSpecialtyService masSpecialtyService;
	
	@Autowired private MasJoblevelService masJoblevelService;
	@Autowired private ApplicantService applicantService;
	@Autowired private MasDivisionService masDivisionService;
	

	
	private	 Employee employee;
	int id;
	
	@Before
	public void setAbility() {
		employee = new Employee();
        employee.setIdCard("115310905001-9");
        employee.setNameThai("อภิวาท์");
        employee.setNameEng("apiva");
        employee.setNicknameThai("va");
        employee.setNicknameEng("va");
        employee.setSurnameThai("กิมเกถนอม");
        employee.setSurnameEng("kimkatanom");
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    	String dateInString = "31-08-1982";
    	Date date = null;
		try {
			date = sdf.parse(dateInString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
		employee.setDateOfBirth(date);
        employee.setEmail("test@gmail.com");
        employee.setEmergencyContact("mom");
        employee.setEmployeeCode("EMP-19");
        employee.setStatusemp("Employee");
        employee.setTelHome("089-0851022");
        employee.setTelMobile("089-0851022");
        employee.setEmergencyContactPhoneNumber("089-085-1022");
        employee.setAuditFlag("C");
        employee.setCreatedBy(1);
        employee.setCreatedTimeStamp(Calendar.getInstance().getTime());
        
        Applicant applicant = new Applicant();
		applicant.setCreatedBy(1);
		applicant.setCreatedTimeStamp(Calendar.getInstance().getTime());
		applicant.setAuditFlag("C");
		applicant.setCardId("115310905001-9");
		applicantService.create(applicant);
		
        Applicant applicant1 = applicantService.findById(1);
        Hibernate.initialize(applicant1);
        
        
        employee.setApplicant(applicant1);
         

	
		MasDivision masDivision = new MasDivision();
		masDivision.setName("CEO");
		masDivision.setIsActive(true);
		masDivision.setCode("01");
		masDivision.setAuditFlag("C");
		masDivision.setCreatedBy(1);
		masDivision.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masDivision.setCode("Division-01");
		
		masDivisionService.create(masDivision);
		masDivisionService.findById(1);
		employee.setMasDivision(masDivision);
		

		MasJoblevel masJoblevel = new MasJoblevel();
		masJoblevel.setName("CEO");
		masJoblevel.setIsActive(true);
		masJoblevel.setCode("01");
		masJoblevel.setAuditFlag("C");
		masJoblevel.setCreatedBy(1);
		masJoblevel.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masJoblevel.setCode("Division-01");

		masJoblevelService.create(masJoblevel);
		masJoblevelService.find(1);		
		employee.setMasJoblevel(masJoblevel);
		employeeService.create(employee);
		
		
	
		Employee employee=employeeService.findById(1);
		MasSpecialty masSpecialty=masSpecialtyService.findById(1);
		Ability ability=new Ability();
		ability.setRank(10);
		ability.setAuditFlag("C");
		ability.setCreatedBy(1);
		ability.setCreatedTimeStamp(Calendar.getInstance().getTime());
		ability.setEmployee(employee);
		ability.setMasspecialty(masSpecialty);
		abilityService.create(ability);
		
	    id = ability.getId();
	    System.out.println("id: "+id);
	
	}
	
	
	@Test
	@Rollback(true)
	public void createAbility() {
		
		Employee employee=employeeService.findById(1);
		MasSpecialty masSpecialty=masSpecialtyService.findById(1);
		Ability ability=new Ability();
		ability.setRank(10);
		ability.setAuditFlag("C");
		ability.setCreatedBy(1);
		ability.setCreatedTimeStamp(Calendar.getInstance().getTime());
		ability.setEmployee(employee);
		ability.setMasspecialty(masSpecialty);
		abilityService.create(ability);
		
		
		
		
		
		
	}
	
	@Test
	@Rollback(true)
	public void updateAbility() {
	
	Ability ability=(Ability)abilityService.find(id);
	ability.setRank(2);
	abilityService.update(ability);
	}

	
	@Test
	@Rollback(true)
	public void deleteAbility(){
		Ability ability=abilityService.find(id);
		abilityService.delete(ability);
	}
	
	
	@Test
	public void findAllDataAbility(){

		List<Ability> ability = abilityService.findAll();
		Assert.assertEquals(1, ability.size());
	}
	
	
	

	@Test
	public void findDatabyIdAbility(){

		Ability ability =(Ability) abilityService.find(id);
		int id = ability.getId();
		Assert.assertEquals(id,id);
		
		
		
	}
	
}
