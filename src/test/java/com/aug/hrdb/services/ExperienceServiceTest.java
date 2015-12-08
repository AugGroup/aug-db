package com.aug.hrdb.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import org.hibernate.Hibernate;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.entities.Experience;
import com.aug.hrdb.entities.MasJobLevel;
import com.aug.hrdb.entities.MasTechnology;
import com.aug.hrdb.services.ApplicantService;
import com.aug.hrdb.services.EmployeeService;
import com.aug.hrdb.services.ExperienceService;
import com.aug.hrdb.services.MasDivisionService;
import com.aug.hrdb.services.MasJoblevelService;
import com.aug.hrdb.services.MasTechnologyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
public class ExperienceServiceTest {

	@Autowired
	private ExperienceService experienceService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private MasJoblevelService masJoblevelService;
	
	@Autowired
	private ApplicantService applicantService;
	
	@Autowired
	private MasDivisionService masDivisionService;
	
	@Autowired
	private MasTechnologyService masTechnologyService;

	@Before
	public void setEducation() throws ParseException {
        
        Applicant applicant = new Applicant();
        applicant.setCardId("115310905001-9");
        applicant.setFirstNameTH("อรอนงค์");
        applicant.setFirstNameEN("Ornanong");
        applicant.setNickNameEN("nong");
        applicant.setNickNameTH("นงค์");
        applicant.setLastNameEN("Namlongnamken");
        applicant.setLastNameTH("น้ำลงน้ำขึ้น");
		applicant.setCreatedBy(1);
		applicant.setCreatedTimeStamp(Calendar.getInstance().getTime());
		applicant.setAuditFlag("C");
		applicant.setCardId("115310905001-9");
		
		MasJobLevel masJoblevel = new MasJobLevel();
		masJoblevel.setName("CEO");
		masJoblevel.setIsActive(true);
		masJoblevel.setCode("01");
		masJoblevel.setAuditFlag("C");
		masJoblevel.setCreatedBy(1);
		masJoblevel.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masJoblevel.setCode("Division-01");

		masJoblevelService.create(masJoblevel);
		MasJobLevel mJoblevel= masJoblevelService.find(1);

		MasTechnology masTechnology = new MasTechnology();
		masTechnology.setName("java");
		masTechnology.setCode("001A");
		masTechnology.setIsActive(true);
		masTechnology.setAuditFlag("C");
		masTechnology.setCreatedBy(0);
		Calendar cal = Calendar.getInstance();
		masTechnology.setCreatedTimeStamp(cal.getTime());
		masTechnologyService.create(masTechnology);
		
		MasTechnology mTechnology= masTechnologyService.find(1);
		
		applicant.setJoblevel(mJoblevel);
		applicant.setTechnology(mTechnology);
		applicantService.create(applicant);
		
	    Applicant applicant1 =  applicantService.findById(1);
		Experience experience = new Experience();
		SimpleDateFormat dateFmt = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
		experience.setAddress("ExperienceAddressTest");
		experience.setTypeOfBusiness("TypeTest");
		experience.setCompanyName("companyNameTest");
		experience.setDateFrom(dateFmt.parse("04/01/2015"));
		experience.setDateTo(dateFmt.parse("04/09/2015"));
		experience.setPosition("positionTest");
		experience.setReason("reasonTest");
		experience.setReference("referenceTest");
		experience.setResponsibility("responsibilityTest");
		experience.setSalary(20000);
		experience.setAuditFlag("C");
		experience.setCreatedBy(1);
		experience.setCreatedTimeStamp(Calendar.getInstance().getTime());
		experienceService.create(experience);
		
	}
	
	@Test
	@Ignore
	@Rollback(false)
	public void insertExperienceServiceTest() throws ParseException {
		SimpleDateFormat dateFmt = new SimpleDateFormat("dd/MM/yyyy",
				Locale.ENGLISH);
		Experience experience = new Experience();

		experience.setAddress("ExperienceAddressTest");
		experience.setTypeOfBusiness("TypeTest");
		experience.setCompanyName("companyNameTest");
		experience.setDateFrom(dateFmt.parse("04/01/2015"));
		experience.setDateTo(dateFmt.parse("04/09/2015"));
		experience.setPosition("positionTest");
		experience.setReason("reasonTest");
		experience.setReference("referenceTest");
		experience.setResponsibility("responsibilityTest");
		experience.setSalary(40000);
		
		experience.setAuditFlag("C");
		experience.setCreatedBy(1);
		experience.setCreatedTimeStamp(Calendar.getInstance().getTime());

		experienceService.create(experience);
		System.out.println("ExperienceServiceTest " + experience.getDateTo());
	}
	
	@Test
	@Ignore
	@Rollback(false)
	public void findByIdExperienceServiceTest() {
		Experience experience = experienceService.findById(1);
		System.out.println("Experience Address : "+experience.getAddress());

	}
	
	@Test
	@Ignore
	@Rollback(false)
	public void updateExperienceServiceTest() {
		Experience experience = experienceService.findById(4);
		experience.setCompanyName("companyNameUpdateServiceTest ");
		experience.setAuditFlag("U");
		experience.setCreatedBy(1);
		experience.setCreatedTimeStamp(Calendar.getInstance().getTime());
		experienceService.update(experience);
		System.out.println("Experience Name : " + experience.getId());

	}
	
	@Test
	@Ignore
	@Rollback(false)
	public void deleteByIdExperienceServiceTest() {
		//Experience experience =  experienceService.findById(5);
		experienceService.deleteById(7);
		System.out.println("Delete Experience : " + experienceService.findById(5));
	}


}
