package services;

import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

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
import com.aug.hrdb.entities.Education;
import com.aug.hrdb.entities.MasDegreetype;
import com.aug.hrdb.entities.MasJoblevel;
import com.aug.hrdb.services.ApplicantService;
import com.aug.hrdb.services.EducationService;
import com.aug.hrdb.services.EmployeeService;
import com.aug.hrdb.services.MasDegreetypeService;
import com.aug.hrdb.services.MasDivisionService;
import com.aug.hrdb.services.MasJoblevelService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-bean-db-test.xml")
public class EducationServiceTest {
	
	@Autowired
	private EducationService educationService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private MasJoblevelService masJoblevelService;
	
	@Autowired
	private ApplicantService applicantService;
	
	@Autowired
	private MasDivisionService masDivisionService;
	
	@Autowired
	private MasDegreetypeService masDegreetypeService;
	
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
		applicantService.create(applicant);
		
        Applicant applicant1 = applicantService.findById(1);
        Hibernate.initialize(applicant1);

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

		applicant.setJoblevel(masJoblevel);
		
		MasDegreetype masDegreetype = new MasDegreetype();
		masDegreetype.setName("CEO");
		masDegreetype.setIsactive(true);
		masDegreetype.setCode("01");
		masDegreetype.setAuditFlag("C");
		masDegreetype.setCreatedBy(1);
		masDegreetype.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
		masDegreetypeService.create(masDegreetype);
		masDegreetype = masDegreetypeService.find(1);

		applicantService.create(applicant);
		
		
	    applicant1 =  applicantService.findById(1);
		Education education = new Education();
		SimpleDateFormat dateFmt = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
		education.setApplicant(applicant);
		education.setCertification("TOEIC 430");
		education.setMasdegreetype(masDegreetype);
		education.setFaculty("Technology and Science");
		education.setGpa(3.0);
		education.setGraduated_date(dateFmt.parse("07/09/2015"));
		education.setAuditFlag("C");
		education.setCreatedBy(0);
		education.setCreatedTimeStamp(Calendar.getInstance().getTime());
		educationService.create(education);
		
	}
	
	@Test
	@Transactional
	@Rollback(value = true)
	public void testInsertEducationService() throws Exception {
		SimpleDateFormat dateFmt = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
		Education education = new Education();
		education.setId(1);
		education.setCertification("TOEIC 430");
		education.setFaculty("Technology and Science");
		education.setGpa(3.0);
		education.setGraduated_date(dateFmt.parse("07/09/2015"));
		educationService.create(education);
	}

	@Test
	@Transactional
	@Rollback(value = true)
	public void testUpdateEducationService() throws Exception {

		Education education = educationService.findById(4);
		education.setCertification("TOEIC 600");
		education.setMajor("Computer Science");
		education.setUniversity("Thammasat");
		educationService.update(education);
	}

	@Test
	@Transactional
	@Rollback(value = true)
	public void testDeleteByIdEducationService() throws Exception {
		educationService.deleteById(1);
	}

	@Test
	@Transactional
	public void testFindByIdEducationService() throws Exception {
		Education education = educationService.findById(4);
		assertNotNull(education.getMajor());
		
	}

	@Test
	@Transactional
	public void testFindAllEducationService() throws Exception {
		List<Education> educations = educationService.findAll();
		assertNotNull(educations);
//		for (Education education : educations){
//			System.out.println("Education : " + education.getCertification());
//			System.out.println("Education : " + education.getFaculty());
//			System.out.println("Education : " + education.getGpa());
//			System.out.println("Education : " + education.getMajor());
//			System.out.println("Education : " + education.getUniversity());
//		}
	}

}
