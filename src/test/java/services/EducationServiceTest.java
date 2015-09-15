package services;

import static org.junit.Assert.assertNotNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Education;
import com.aug.hrdb.entities.MasAllowances;
import com.aug.hrdb.entities.MasDegreetype;
import com.aug.hrdb.services.EducationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-bean-db-test.xml")
public class EducationServiceTest {
	
	@Autowired
	private EducationService educationService;

	private MasDegreetype masDegreeType = new MasDegreetype();
	
	@Test
	@Transactional
	@Rollback(value = false)
	public void testInsertEducationService() throws Exception {
		SimpleDateFormat dateFmt = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
		Education education = new Education();
		masDegreeType.setName("Test");
		education.setCertification("TOEIC 430");
		education.setMasdegreetype(masDegreeType);
		education.setFaculty("Technology and Science");
		education.setGpa(3.0);
		education.setAuditFlag("C");
		education.setCreatedBy(0);
		education.setCreatedTimeStamp(dateFmt.parse("04/09/2015"));
		educationService.create(education);
	}

	@Test
	@Transactional
	@Rollback(value = false)
	public void testUpdateEducationService() throws Exception {

		Education education = educationService.findById(4);
		education.setCertification("TOEIC 600");
		education.setMajor("Computer Science");
		education.setUniversity("Thammasat");
		educationService.update(education);
	}

	@Test
	@Transactional
	@Rollback(value = false)
	public void testDeleteByIdEducationService() throws Exception {
		educationService.deleteById(2);
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
