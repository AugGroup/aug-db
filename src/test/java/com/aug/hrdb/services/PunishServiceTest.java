package com.aug.hrdb.services;

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

import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.entities.Employee;
import com.aug.hrdb.entities.MasDivision;
import com.aug.hrdb.entities.MasJobLevel;
import com.aug.hrdb.entities.MasTechnology;
import com.aug.hrdb.entities.Punish;
import com.aug.hrdb.entities.Reward;
import com.aug.hrdb.services.ApplicantService;
import com.aug.hrdb.services.EmployeeService;
import com.aug.hrdb.services.MasDivisionService;
import com.aug.hrdb.services.MasJobLevelService;
import com.aug.hrdb.services.MasTechnologyService;
import com.aug.hrdb.services.PunishService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class PunishServiceTest {
	
	@Autowired
	private PunishService punishService;
	@Autowired 
	private EmployeeService employeeService;
	@Autowired 
	private MasJobLevelService masJoblevelService;
	@Autowired 
	private ApplicantService applicantService;
	@Autowired 
	private MasDivisionService masDivisionService;
	@Autowired 
	private MasTechnologyService masTechnologyService;
	
	private	 Employee employee;
	int id;
	int empId;
	int masjobId;
	int appId; 
	int mastecId;
	
	
	
	
	
	@Before
	public void setPunish() {
		employee = new Employee();
		/*employee.setIdCard("115310905001-9");
        employee.setNameThai("ธัญลักษณ์์");
        employee.setNameEng("thanyalak");
        employee.setNicknameThai("กิ๊ก");
        employee.setNicknameEng("kik");
        employee.setSurnameThai("พิมสวรรค์");
        employee.setSurnameEng("Pimsawan");*/
        
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
        employee.setEmployeeCode("EMP-99");
        employee.setStatusEmp("Employee");
        employee.setTelHome("089-0851022");
        /*employee.setTelMobile("089-0851022");
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
		mastecId = masTechnology.getId();
		MasTechnology mTechnology = masTechnologyService.findById(mastecId);

		MasJobLevel masJoblevel = new MasJobLevel();
		masJoblevel.setName("CEO");
		masJoblevel.setIsActive(true);
		masJoblevel.setCode("01");
		masJoblevel.setAuditFlag("C");
		masJoblevel.setCreatedBy(1);
		masJoblevel.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masJoblevel.setCode("Division-01");

		masJoblevelService.create(masJoblevel);
		masjobId = masJoblevel.getId();
		MasJobLevel mJob = masJoblevelService.findById(masjobId);
         			
        
        
        Applicant applicant = new Applicant();
		applicant.setCreatedBy(1);
		applicant.setCreatedTimeStamp(Calendar.getInstance().getTime());
		applicant.setAuditFlag("C");
		applicant.setCardId("115310905001-9");
		applicant.setTechnology(mTechnology);
		applicant.setJoblevel(mJob);
		applicantService.create(applicant);
		appId=applicant.getId();
		
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
		masDivisionService.findById(1);
		
		employee.setMasDivision(masDivision);	
		//employee.setMasJoblevel(mJob);
		employeeService.create(employee);
		empId=employee.getId();
		
		
	
		Employee employee =employeeService.findById(1);
		   
		Punish punish=new Punish();
		employee.setId(1);		
		punish.setEmployee(employee);	
//		Calendar cal = Calendar.getInstance();
		punish.setDatepunish(cal.getTime());
		punish.setDescription("aaaa");
	    punish.setPenalty("test");
	    punish.setAuditFlag("C");
	    punish.setCreatedBy(0);
	    punish.setCreatedTimeStamp(cal.getTime());
		punishService.create(punish);
		
		
	    id = punish.getId();
	    System.out.println("id: "+id);
	
	}
	
	
	@Test
	@Rollback(true)
	public void createDataPunish(){
		
		Employee employee=employeeService.findById(1);	
		Punish punish=new Punish();
		employee.setId(1);		
		punish.setEmployee(employee);	
		Calendar cal = Calendar.getInstance();
		punish.setDatepunish(cal.getTime());
		punish.setDescription("aaaa");
	    punish.setPenalty("test");
	    punish.setAuditFlag("C");
	    punish.setCreatedBy(0);
	    punish.setCreatedTimeStamp(cal.getTime());
		punishService.create(punish);		
	}
	
	
	@Test
	@Rollback(true)
	public void updateDataPunish(){
		Punish punish= (Punish)punishService.findById(id);
		punish.setDescription("bb");
		punishService.update(punish);
		
	}
	

	
	@Test
	@Rollback(true)
	public void deleteDataPunish(){
		Punish punish=punishService.findById(id);
		punishService.delete(punish);
	}
	
		
	@Test
	public void findAllDataPunish(){

		List<Punish> punish = punishService.findAll();
//		Assert.assertEquals(3, punish.size());
	}
	
	
	@Test
	public void findDatabyIdPunish(){

		Punish punish =(Punish) punishService.findById(id);
		int id = punish.getId();
		Assert.assertEquals(id,id);
		
	}
	
	
	
	

}
