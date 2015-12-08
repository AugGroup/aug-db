package com.aug.hrdb.repositories;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
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
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.entities.Experience;
import com.aug.hrdb.entities.MasJobLevel;
import com.aug.hrdb.entities.MasTechnology;
import com.aug.hrdb.repositories.ApplicantRepository;
import com.aug.hrdb.repositories.EmployeeRepository;
import com.aug.hrdb.repositories.ExperienceRepository;
import com.aug.hrdb.repositories.MasDegreeTypeRepository;
import com.aug.hrdb.repositories.MasDivisionRepository;
import com.aug.hrdb.repositories.MasJobLevelRepository;
import com.aug.hrdb.repositories.MasTechnologyRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class ExperienceRepositoryTest {

	@Autowired
	private ExperienceRepository experienceRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private MasJobLevelRepository masJoblevelRepository;
	
	@Autowired
	private ApplicantRepository applicantRepository;
	
	@Autowired
	private MasDivisionRepository masDivisionRepository;
	
	@Autowired
	private MasDegreeTypeRepository masDegreetypeRepository;
	
	@Autowired
	private MasTechnologyRepository masTechnologyRepository;
	
	@Before
	public void setExperience() throws ParseException {
        
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

		masJoblevelRepository.create(masJoblevel);
		MasJobLevel mJoblevel= masJoblevelRepository.find(1);

		MasTechnology masTechnology = new MasTechnology();
		masTechnology.setName("java");
		masTechnology.setCode("001A");
		masTechnology.setIsActive(true);
		masTechnology.setAuditFlag("C");
		masTechnology.setCreatedBy(0);
		Calendar cal = Calendar.getInstance();
		masTechnology.setCreatedTimeStamp(cal.getTime());
		masTechnologyRepository.create(masTechnology);
		
		MasTechnology mTechnology= masTechnologyRepository.find(1);
		
		applicant.setJoblevel(mJoblevel);
		applicant.setTechnology(mTechnology);
		applicantRepository.create(applicant);
		
	    Applicant applicant1 =  applicantRepository.find(1);
		Experience experience = new Experience();
		SimpleDateFormat dateFmt = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
		experience.setApplicant(applicant);
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
		experienceRepository.create(experience);
		
	}

	@Test
	@Ignore
	@Rollback(true)
	public void insertExperienceRepositoryTest() throws ParseException {
		SimpleDateFormat dateFmt = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
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
		experience.setSalary(20000);
		experience.setAuditFlag("C");
		experience.setCreatedBy(1);
		experience.setCreatedTimeStamp(Calendar.getInstance().getTime());

		experienceRepository.getCurrentSession().save(experience);
		System.out.println("ExperienceId : "+experience.getId());
		System.out.println("ExperienceRepositoryTest : " + experience.getDateTo());

	}

	@Test
	@Ignore
	@Rollback(true)
	public void findByIdExperienceRepositoryTest() {
		Experience experience = experienceRepository.find(1);
		System.out.println("Experience Address : "+experience.getName());

	}
	@Test
	@Ignore
	@Rollback(true)
	public void findAllExperienceRepositoryTest() {
		List<Experience> experience = experienceRepository.findAll();
		for(Experience exp : experience){
		System.out.println("Experience Address : "+exp.getName());
		}
	}
	
	@Test
	@Ignore
	@Rollback(true)
	public void updateExperienceRepositoryTest() {
		Experience experience = experienceRepository.find(2);
		experience.setCompanyName("companyNameUpdateTest ");
		experience.setAuditFlag("U");
		experience.setCreatedBy(1);
		experience.setCreatedTimeStamp(Calendar.getInstance().getTime());
		experienceRepository.update(experience);
		System.out.println("Experience Name : " + experience.getCompanyName());

	}
	
	@Test
	@Ignore
	@Rollback(true)
	public void deleteByIdExperienceRepositoryTest() {
		//Experience experience = experienceRepository.find(5);
		experienceRepository.deleteById(5);
		System.out.println("Delete Experience : " + experienceRepository.find(5));
	}

}
