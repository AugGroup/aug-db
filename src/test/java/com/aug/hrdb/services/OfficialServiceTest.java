/**
 *
 * @author natechanok
 * @date Sep 4, 2015
 */

package com.aug.hrdb.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

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
import com.aug.hrdb.entities.MasDivision;
import com.aug.hrdb.entities.MasJobLevel;
import com.aug.hrdb.entities.MasTechnology;
import com.aug.hrdb.entities.Official;
import com.aug.hrdb.services.ApplicantService;
import com.aug.hrdb.services.EmployeeService;
import com.aug.hrdb.services.MasDivisionService;
import com.aug.hrdb.services.MasJobLevelService;
import com.aug.hrdb.services.MasTechnologyService;
import com.aug.hrdb.services.OfficialService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class OfficialServiceTest {

	@Autowired
	private OfficialService officialService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private ApplicantService applicantService;
	@Autowired
	private MasDivisionService masDivisionService;
	@Autowired
	private MasJobLevelService masJoblevelService;
	@Autowired
	private MasTechnologyService masTechnologyService;
	
	Employee employee;
	
	int idEmployee;
	int id;
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
        employee.setEmployeeCode("EMP-018");
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
 		
		MasTechnology mTechnology= masTechnologyService.findById(mastec);
 		

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
		

		//employee.setMasJoblevel(mJob);
		employeeService.create(employee);
		
		Official official = new Official();
		//official.setOfficialDate(cal.getTime());
		official.setStartWorkDate(cal.getTime());
		official.setEndWorkDate(cal.getTime());
		//official.setPositionAppliedFor("Develop");
		//official.setSalaryExpected("500000000");
		official.setProbationDate(cal.getTime());
		official.setAuditFlag("C");
		official.setCreatedBy(1);
		official.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
		officialService.create(official);
		id = official.getId();
	}
	
	@Test
	@Rollback(true)
	public void create() {
		
		Official official = new Official();
		Calendar cal = Calendar.getInstance();
		//official.setOfficialDate(cal.getTime());
		official.setStartWorkDate(cal.getTime());
		official.setEndWorkDate(cal.getTime());
		//official.setPositionAppliedFor("Account");
		//official.setSalaryExpected("500000000");
		official.setProbationDate(cal.getTime());
		official.setAuditFlag("C");
		official.setCreatedBy(1);
		official.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
		officialService.create(official);
		
	}
	
	@Test
	@Rollback(true)
	public void updateOfficial(){
		
		Official official = (Official)officialService.findById(id);
		//official.setPositionAppliedFor("Developper");
		officialService.update(official);
		
	}
	

	@Test
	@Rollback(true)
	public void deleteOfficial(){
		
		Official official = (Official)officialService.findById(id);
		officialService.delete(official);
	}
	
	@Test
	@Rollback(true)
	public void findAllOfficial(){

		List<Official> ability = officialService.findAll();

	}
	
	
	
	@Test
	@Rollback(true)
	public void findbyIdOfficial(){

		Official official =(Official) officialService.findById(id);
		int id = official.getId();
	//	Assert.assertEquals("Develop",official.getPositionAppliedFor());
		
		
		
	}
}
