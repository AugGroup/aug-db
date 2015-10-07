/**
 *
 * @author Pranrajit
 * @date 4 ก.ย. 2558
 */
package repositories;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

import com.aug.hrdb.entities.Ability;
import com.aug.hrdb.entities.Address;
import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.entities.Employee;
import com.aug.hrdb.entities.MasDivision;
import com.aug.hrdb.entities.MasJoblevel;
import com.aug.hrdb.entities.MasSpecialty;
import com.aug.hrdb.entities.MasTechnology;
import com.aug.hrdb.repositories.AbilityRepository;
import com.aug.hrdb.repositories.ApplicantRepository;
import com.aug.hrdb.repositories.EmployeeRepository;
import com.aug.hrdb.repositories.MasDivisionRepository;
import com.aug.hrdb.repositories.MasJoblevelRepository;
import com.aug.hrdb.repositories.MasSpecialtyRepository;
import com.aug.hrdb.repositories.MasTechnologyRepository;
import com.aug.hrdb.services.MasJoblevelService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class AbilityRepositoryTest {

	@Autowired private AbilityRepository abilityRepository;
	@Autowired private EmployeeRepository employeeRepository;
	@Autowired private MasSpecialtyRepository MasSpecialtyRepository;
	@Autowired private MasJoblevelRepository masJoblevelRepository;
	@Autowired private ApplicantRepository applicantRepository;
	@Autowired private MasDivisionRepository masDivisionRepository;
	@Autowired private MasTechnologyRepository masTechnologyRepository;
	
	private	 Employee employee;
	int id;
	int masdiId;
	int appId;
	int masjobId;
	int mastecId;
	int empId;
	
	@Before
	public void setAbility() {
		employee = new Employee();
        /*employee.setIdCard("115310905001-9");
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
        
        
        MasTechnology masTechnology = new MasTechnology();
		masTechnology.setName("java");
		masTechnology.setCode("001A");
		masTechnology.setIsActive(true);
		masTechnology.setAuditFlag("C");
		masTechnology.setCreatedBy(0);
		Calendar cal = Calendar.getInstance();
		masTechnology.setCreatedTimeStamp(cal.getTime());
		masTechnologyRepository.create(masTechnology);
 		mastecId=masTechnology.getId();
		MasTechnology mTechnology= masTechnologyRepository.find(mastecId);
 		

		MasJoblevel masJoblevel = new MasJoblevel();
		masJoblevel.setName("CEO");
		masJoblevel.setIsActive(true);
		masJoblevel.setCode("01");
		masJoblevel.setAuditFlag("C");
		masJoblevel.setCreatedBy(1);
		masJoblevel.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masJoblevel.setCode("Division-01");

		masJoblevelRepository.create(masJoblevel);
		masjobId=masJoblevel.getId();
		MasJoblevel mJob= masJoblevelRepository.find(masjobId);
 		
	

        
        
        Applicant applicant = new Applicant();
		applicant.setCreatedBy(1);
		applicant.setCreatedTimeStamp(Calendar.getInstance().getTime());
		applicant.setAuditFlag("C");
		applicant.setCardId("115310905001-9");
		applicant.setTechnology(mTechnology);
		applicant.setJoblevel(mJob);
		applicantRepository.create(applicant);
		
		appId=applicant.getId();
        Applicant applicant1 = applicantRepository.find(appId);
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
		
		masDivisionRepository.create(masDivision);
		masdiId=masDivision.getId();
		masDivisionRepository.find(masdiId);
		employee.setMasDivision(masDivision);
		

			
		//employee.setMasJoblevel(mJob);
		employeeRepository.create(employee);
		empId=employee.getId();
		
		Employee employee=employeeRepository.find(empId);
		MasSpecialty maspecialty=MasSpecialtyRepository.find(1);
		Ability ability=new Ability();
		ability.setRank(10);
		ability.setAuditFlag("C");
		ability.setCreatedBy(1);
		ability.setCreatedTimeStamp(Calendar.getInstance().getTime());
		//ability.setEmployee(employee);
		ability.setMasspecialty(maspecialty);
		abilityRepository.create(ability);
	
		
		id = ability.getId();
	    System.out.println("id: "+id);
	}
	
	
	
	
	
	
	
	@Test
	@Rollback(true)
	public void createAbility(){
		
		
		Employee employee=employeeRepository.find(1);
		MasSpecialty maspecialty=MasSpecialtyRepository.find(1);
		

		
		Ability ability=new Ability();
		ability.setRank(10);
		ability.setAuditFlag("C");
		ability.setCreatedBy(1);
		ability.setCreatedTimeStamp(Calendar.getInstance().getTime());
		//ability.setEmployee(employee);
		ability.setMasspecialty(maspecialty);
		abilityRepository.create(ability);
	
	}
	
	
	
	@Test
	@Rollback(true)
	public void updateAbility(){
		Ability ability= abilityRepository.find(id);
		ability.setRank(2);
		
		abilityRepository.update(ability);
	
	}
	
	@Test
	@Rollback(true)
	public void deleteAbility(){
	
		Ability ability = (Ability) abilityRepository.getCurrentSession().get(Ability.class,id);
		abilityRepository.getCurrentSession().delete(ability);
	}
	
	
	
	
	
	
	@Test
	public void listAbility(){
		
		Criteria c = abilityRepository.getCurrentSession().createCriteria(Ability.class);
		List<Ability> AbilityList = c.list();
		Assert.assertEquals(1, AbilityList.size());
		
	}
	
	
	@Test
	public void findAllAbility(){
		
		Criteria c = abilityRepository.getCurrentSession().createCriteria(Ability.class);
		List<Ability> AbilityList = c.list();
		
		
		
	}
	
}
