package com.aug.hrdb.services;

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

import com.aug.hrdb.dto.HealthDto;
import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.entities.Employee;
import com.aug.hrdb.entities.Health;
import com.aug.hrdb.entities.MasDivision;
import com.aug.hrdb.entities.MasJobLevel;
import com.aug.hrdb.entities.MasTechnology;
import com.aug.hrdb.services.ApplicantService;
import com.aug.hrdb.services.EmployeeService;
import com.aug.hrdb.services.HealthService;
import com.aug.hrdb.services.MasDivisionService;
import com.aug.hrdb.services.MasJobLevelService;
import com.aug.hrdb.services.MasTechnologyService;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class HealthServiceTest {
	
	@Autowired HealthService healthService;
	@Autowired EmployeeService employeeService;
	@Autowired MasJobLevelService masJoblevelService;
	@Autowired ApplicantService applicantService;
	@Autowired MasDivisionService masDivisionService;
	@Autowired MasTechnologyService masTechnologyService;
	
	private Employee employee;
	int id;
	int empId;
	int masdi;
	int appId;
	int masjobId;
	int mastec;
	
	@Before
	public void setUp() {
		
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
        employee.setEmployeeCode("EMP-09");
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
		masTechnologyService.create(masTechnology);
		mastec=masTechnology.getId();
 		
		MasTechnology mTechnology= masTechnologyService.find(mastec);
 		

		MasJobLevel masJoblevel = new MasJobLevel();
		masJoblevel.setName("CEO");
		masJoblevel.setIsActive(true);
		masJoblevel.setCode("01");
		masJoblevel.setAuditFlag("C");
		masJoblevel.setCreatedBy(1);
		masJoblevel.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masJoblevel.setCode("Division-01");

		masJoblevelService.create(masJoblevel);
		masjobId=masJoblevel.getId();
		MasJobLevel mJob= masJoblevelService.findById(masjobId);
        
        Applicant applicant = new Applicant();
		applicant.setCreatedBy(1);
		applicant.setCreatedTimeStamp(Calendar.getInstance().getTime());
		applicant.setAuditFlag("C");
		applicant.setCardId("115310905001-9");
		applicant.setTechnology(mTechnology);
		applicant.setJoblevel(mJob);
		applicantService.create(applicant);
		int appId = applicant.getId();
        Applicant applicant1 = applicantService.findById(appId);
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
		int masDivisionId = masDivision.getId();
		masDivisionService.findById(masDivisionId);
		employee.setMasDivision(masDivision);
		
		//employee.setMasJoblevel(mJob);
		employeeService.create(employee);
		
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
		healthService.create(health);
		
		id = health.getId();
	}
	
	
	@Test
	@Rollback(true)
	public void create() {
	
		Health health = healthService.find(id);
		Assert.assertEquals("Hypertensions", health.getCongenitalDiseaseExplain());
	
	}
	
	
	@Test
	@Rollback(true)
	public void update() {
	
		Health health = healthService.find(id);
		health.setCongenitalDiseaseExplain("heart disease");
		health.setAuditFlag("U");
		health.setUpdatedBy(1);
		health.setUpdatedTimeStamp(Calendar.getInstance().getTime());
		healthService.update(health);
		
	}

	
	
	@Test
	@Rollback(true)
	public void delete() {
	
		Health health = healthService.find(id);
		healthService.delete(health);
		
	}
	
	
	
	@Test
	public void find() {
	
		Health health = healthService.find(id);
		Assert.assertEquals(id, id);
	}
	
	
	
	
	
	@Test
	public void findAll() {
	
		List<Health> health = healthService.findAll();
	
	
	}
	
	
	@Test
	@Rollback(true)
	public void deleteById() {
	
		Health health = healthService.find(id);
		healthService.deleteById(health.getId());
	
	}
		
	
	@Test
	@Rollback(true)
	public void createSetDtoToEnity() {
	
		HealthDto healthDto = new HealthDto();
		
		
		healthDto.setCongenitalDisease("Yes");
		healthDto.setCongenitalDiseaseExplain("Hypertension"); //ความดัน
		healthDto.setCongenitalDiseaseExplain2("Allergy"); //ภูมิแพ้
		healthDto.setCongenitalDiseaseExplain2("asthma"); //หอบหืด
		healthDto.setGeneticDisease("Yes");
		healthDto.setGeneticDiseaseExplain("Hypertension");
		healthDto.setGeneticDiseaseExplain2("Allergy");
		healthDto.setGeneticDiseaseExplain3("asthma");
		healthDto.setIntolerance("Yes");
		healthDto.setIntoleranceExplain("CPM");
		healthDto.setTakeMedicine("Yes");
		healthDto.setTakeMedicineExplain("amoxilin");
		healthDto.setEmployeeId(1);
		healthService.createSetDtoToEnity(healthDto);
		
	}
	
	
	
	
	@Test
	@Rollback(true)
	public void updateSetDtoToEntity() {
	
		HealthDto healthDto = new HealthDto();
		healthDto.setId(id);
		healthDto.setCongenitalDisease("Yes"); 
		healthDto.setCongenitalDiseaseExplain("heart disease");
		healthDto.setGeneticDisease("Yes");
		healthDto.setGeneticDiseaseExplain("Hypertension");
		healthDto.setGeneticDiseaseExplain2("Allergy");
		healthDto.setGeneticDiseaseExplain3("asthma");
		healthDto.setIntolerance("Yes");
		healthDto.setIntoleranceExplain("CPM");
		healthDto.setTakeMedicine("Yes");
		healthDto.setTakeMedicineExplain("amoxilin");
		healthDto.setEmployeeId(1);
		healthService.updateSetDtoToEntity(healthDto);
		
	}
	
	
	
	@Test
	public void findByIdReturnToDto(){
		
		HealthDto healthDto = new HealthDto();
		healthDto = healthService.findByIdReturnToDto(id);
		
		Assert.assertEquals("Yes", healthDto.getCongenitalDisease());
		System.out.println("Congenital Disease: "+healthDto.getCongenitalDisease());
		
	}

}
