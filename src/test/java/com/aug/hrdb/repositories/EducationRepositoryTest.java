package com.aug.hrdb.repositories;

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
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.EducationDto;
import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.entities.Education;
import com.aug.hrdb.entities.MasDegreeType;
import com.aug.hrdb.entities.MasJobLevel;
import com.aug.hrdb.entities.MasTechnology;
import com.aug.hrdb.repositories.ApplicantRepository;
import com.aug.hrdb.repositories.EducationRepository;
import com.aug.hrdb.repositories.EmployeeRepository;
import com.aug.hrdb.repositories.MasDegreeTypeRepository;
import com.aug.hrdb.repositories.MasDivisionRepository;
import com.aug.hrdb.repositories.MasJoblevelRepository;
import com.aug.hrdb.repositories.MasTechnologyRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class EducationRepositoryTest {
	
	@Autowired
	private EducationRepository educationRepository;

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private MasJoblevelRepository masJoblevelRepository;
	
	@Autowired
	private ApplicantRepository applicantRepository;
	
	@Autowired
	private MasDivisionRepository masDivisionRepository;
	
	@Autowired
	private MasDegreeTypeRepository masDegreetypeRepository;
	
	@Autowired
	private MasTechnologyRepository masTechnologyRepository;
	
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

		MasDegreeType masDegreetype = new MasDegreeType();
		masDegreetype.setName("CEO");
		masDegreetype.setIsactive(true);
		masDegreetype.setCode("01");
		masDegreetype.setAuditFlag("C");
		masDegreetype.setCreatedBy(1);
		masDegreetype.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
		masDegreetypeRepository.create(masDegreetype);
		masDegreetypeRepository.find(1);

		applicantRepository.create(applicant);

		Education education = new Education();
		SimpleDateFormat dateFmt = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
		education.setApplicant(applicant);
		education.setCertification("TOEIC 430");
		education.setMasdegreetype(masDegreetype);
		education.setFaculty("Technology and Science");
		education.setGpa("3.00");
		education.setGraduated_date(dateFmt.parse("07/09/2015"));
		education.setAuditFlag("C");
		education.setCreatedBy(0);
		education.setCreatedTimeStamp(Calendar.getInstance().getTime());
		educationRepository.create(education);
		
	}
	
	@Test
	@Ignore
	@Rollback(true)
	public void insertEducationRepositoryTest() throws ParseException {
		SimpleDateFormat dateFmt = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
		Education education = new Education();

		education.setId(1);
		education.setCertification("TOEIC 430");
		education.setFaculty("Technology and Science");
		education.setGpa("3.00");
		education.setGraduated_date(dateFmt.parse("07/09/2015"));

		educationRepository.getCurrentSession().save(education);
		System.out.println("University : " + education.getUniversity());
	}

	@Test
	@Rollback(true)
	public void findByIdEducationRepositoryTest() {
		Education education = educationRepository.find(1);
		System.out.println("University : "+education.getUniversity());

	}
	
	@Test
	@Rollback(true)
	public void updateEducationRepositoryTest() {
		Education education = educationRepository.find(3);
		education.setMajor("Computer");
		educationRepository.update(education);
		System.out.println("University : " + education.getUniversity());

	}
	
	@Test
	@Rollback(true)
	public void deleteEducationRepositoryTest() {
		Education experience = educationRepository.find(3);
		educationRepository.delete(experience);
		System.out.println("Delete Experience : " + educationRepository.find(1));
	}
	
	@Test
	@Rollback(true)
	public void deleteByIdEducationRepositoryTest() {
		educationRepository.deleteById(3);
	}


}
