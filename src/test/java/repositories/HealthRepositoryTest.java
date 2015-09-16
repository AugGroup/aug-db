package repositories;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import com.aug.hrdb.entities.MasTechnology;
import com.aug.hrdb.repositories.ApplicantRepository;
import com.aug.hrdb.repositories.EmployeeRepository;
import com.aug.hrdb.repositories.HealthRepository;
import com.aug.hrdb.repositories.MasDivisionRepository;
import com.aug.hrdb.repositories.MasJoblevelRepository;
import com.aug.hrdb.repositories.MasTechnologyRepository;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class HealthRepositoryTest {
	
	@Autowired HealthRepository healthRepository;
	@Autowired EmployeeRepository employeeRepository;
	@Autowired MasJoblevelRepository masJoblevelRepository;
	@Autowired ApplicantRepository applicantRepository;
	@Autowired MasDivisionRepository masDivisionRepository;
	@Autowired MasTechnologyRepository masTechnologyRepository;
	
	private Employee employee;
	int id;
	int masdi;
	int appId;
	int masjobId;
	int mastec;
	
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

        MasTechnology masTechnology = new MasTechnology();
		masTechnology.setName("java");
		masTechnology.setCode("001A");
		masTechnology.setIsActive(true);
		masTechnology.setAuditFlag("C");
		masTechnology.setCreatedBy(0);
		Calendar cal = Calendar.getInstance();
		masTechnology.setCreatedTimeStamp(cal.getTime());
		masTechnologyRepository.create(masTechnology);
		mastec=masTechnology.getId();
 		
		MasTechnology mTechnology= masTechnologyRepository.find(mastec);
 		

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
		

		employee.setMasJoblevel(mJob);
		employeeRepository.create(employee);
		
		
		
		 Applicant applicant2=applicantRepository.find(appId);
		
		Health health = new Health();
		health.setCongenitalDisease("Yes");
		health.setCongenitalDiseaseExplain("Hypertensions"); //ความดัน
		health.setCongenitalDiseaseExplain2("Allergy"); //ภูมิแพ้
		health.setCongenitalDiseaseExplain2("asthma"); //หอบหืด
		health.setGeneticDisease("Yes");
		health.setGeneticDiseaseExplain("Hypertension");
		health.setGeneticDiseaseExplain2("Allergy");
		health.setGeneticDiseaseExplain3("asthma");
		health.setIntolerance("Yes");
		health.setIntoleranceExplain("CPM");
		health.setTakeMedicine("Yes");
		health.setTakeMedicineExplain("amoxilin");
		health.setAuditFlag("C");
		health.setCreatedBy(1);
		health.setCreatedTimeStamp(Calendar.getInstance().getTime());
		health.setEmployee(employee);
		healthRepository.create(health);
		
		id = health.getId();
		
		
	}
	
	

	@Test
	@Rollback(true)
	public void create() {
	
		Health health = healthRepository.find(id);
		Assert.assertEquals("Hypertensions", health.getCongenitalDiseaseExplain());

	
	}
	
	
	
	
	@Test
	@Rollback(true)
	public void update() {
	
		Health health = healthRepository.find(id);
		health.setCongenitalDiseaseExplain("heart disease");
		health.setAuditFlag("U");
		health.setUpdatedBy(1);
		health.setUpdatedTimeStamp(Calendar.getInstance().getTime());
		healthRepository.update(health);
		
	}

	
	
	@Test
	@Rollback(true)
	public void delete() {
	
		Health health = healthRepository.find(id);
		healthRepository.delete(health);
		
	}
	
	
	
	@Test
	public void find() {
	
		Health health = healthRepository.find(id);
		Assert.assertEquals(id, id);
	}
	
	
	
	
	
	@Test
	public void findAll() {
	
		List<Health> health = healthRepository.findAll();
	
	
	}
	
	
	
	@Test
	@Rollback(true)
	public void deleteById() {
	
		Health health = healthRepository.find(id);
		healthRepository.deleteById(health.getId());
	
	}

	
}
