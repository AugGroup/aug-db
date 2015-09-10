package services;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Education;
import com.aug.hrdb.services.EducationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-bean-db-test.xml")
public class EducationServiceTest {
	
	@Autowired
	private EducationService educationService;

	@Test
	@Transactional
	@Rollback(value = false)
	public void testInsertEducationService() throws Exception {
		Education education = new Education();
		education.setCertification("TOEIC 430");
//		education.setDegree("Master");
		education.setFaculty("Technology and Science");
		education.setGpa(3.0);
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
		educationService.deleteByApplicantId(2);
	}

	@Test
	@Transactional
	public void testFindByIdEducationService() throws Exception {
		Education education = educationService.findById(4);
		assertNotNull(education.getDegree());
		
	}

	@Test
	@Transactional
	public void testFindAllEducationService() throws Exception {
		List<Education> educations = educationService.findAll();
		for (Education education : educations){
			System.out.println("Education : " + education.getCertification());
			System.out.println("Education : " + education.getDegree());
			System.out.println("Education : " + education.getFaculty());
			System.out.println("Education : " + education.getGpa());
			System.out.println("Education : " + education.getMajor());
			System.out.println("Education : " + education.getUniversity());
		}
	}

}
