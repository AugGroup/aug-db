package repositories;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Hibernate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.entities.Employee;
import com.aug.hrdb.entities.Health;
import com.aug.hrdb.entities.MasDivision;
import com.aug.hrdb.entities.MasJoblevel;
import com.aug.hrdb.entities.Site;
import com.aug.hrdb.repositories.ApplicantRepository;
import com.aug.hrdb.repositories.EmployeeRepository;
import com.aug.hrdb.repositories.MasDivisionRepository;
import com.aug.hrdb.repositories.MasJoblevelRepository;
import com.aug.hrdb.repositories.SiteRepository;

import junit.framework.Assert;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class SiteRepositoryTest {
	
	@Autowired SiteRepository siteRepository;
	@Autowired EmployeeRepository employeeRepository;
	@Autowired MasJoblevelRepository massJoblevelRepository;
	@Autowired ApplicantRepository applicantRepository;
	@Autowired MasDivisionRepository masDivisionRepository;
	
	private Employee employee;
	int id;
	int empId;
	
	@Before
	public void setUp() {
		
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
        employee.setEmployeeCode("EMP-09");
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
		applicantRepository.create(applicant);
		int appId = applicant.getId();
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
		int masDivisionId = masDivision.getId();
		masDivisionRepository.find(masDivisionId);
		employee.setMasDivision(masDivision);
		

		MasJoblevel masJoblevel = new MasJoblevel();
		masJoblevel.setName("CEO");
		masJoblevel.setIsActive(true);
		masJoblevel.setCode("01");
		masJoblevel.setAuditFlag("C");
		masJoblevel.setCreatedBy(1);
		masJoblevel.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masJoblevel.setCode("Division-01");

		massJoblevelRepository.create(masJoblevel);
		int masJobLevelId = masJoblevel.getId();
		
		massJoblevelRepository.find(masJobLevelId);		
		employee.setMasJoblevel(masJoblevel);
		employeeRepository.create(employee);
		int empId = employee.getId();
		Employee employee1= employeeRepository.find(empId);
		
		
		Calendar calendarStartDate = new GregorianCalendar(2013,10,28);	//GregorianCalendar jan=0,12=Jan
		Calendar calendarEndDate = new GregorianCalendar(2014,11,28);

		
		Site site = new Site();
		site.setProjectName("Augmentis-01");
		site.setStartDate(calendarStartDate.getTime());
		site.setEndDate(calendarEndDate.getTime());
		site.setProjectOwner("Augmentis");
		site.setProjectOwnerContact("PM");
		site.setEmployee(employee1);
		site.setAuditFlag("C");
		site.setCreatedBy(1);
		site.setCreatedTimeStamp(Calendar.getInstance().getTime());
		siteRepository.create(site);
		
		id = site.getId();
	}
	
	

	@Test
	@Rollback(true)
	public void create() {
	
		Site site = siteRepository.find(id);
		Assert.assertEquals("Augmentis-01", site.getProjectName());
		

	}
	
	
	
	@Test
	@Rollback(true)
	public void update() {
				
				Site site = siteRepository.find(id);
				site.setProjectName("AugHrSystem");
				site.setAuditFlag("U");
				site.setUpdatedBy(1);
				site.setUpdatedTimeStamp(Calendar.getInstance().getTime());
				siteRepository.update(site);
	}
	
	
	
	@Test
	@Rollback(true)
	public void delete() {
				
				Site site = siteRepository.find(id);
				siteRepository.delete(site);
	}

	
	
	
	@Test
	@Rollback(true)
	public void deleteById() {
				
				Site site = siteRepository.find(id);
				siteRepository.deleteById(site.getId());;
	}
	
	
	
	@Test
	public void find() {
	
		Site site = siteRepository.find(id);
		Assert.assertEquals(id, id);
	}
	
	
	
	
	
	@Test
	public void findAll() {
	
		List<Site> siteList = siteRepository.findAll();

	}
	

}
