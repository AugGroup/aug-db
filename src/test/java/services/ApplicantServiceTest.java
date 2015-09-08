package services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.services.ApplicantService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-bean-db-test.xml")
@Transactional
public class ApplicantServiceTest {
	@Autowired
	private ApplicantService applicantService;
	
	@Test
	@Rollback(value = false)
	public void testInsertApplicantService() {
		Applicant applicant = new Applicant();
		applicant.setFirstNameEN("Monkey");
		applicantService.create(applicant);
	}
	
	@Test
	public void testFindByIdApplicantService() {
		Applicant applicant = applicantService.findById(2);
		assertNotNull(applicant.getFirstNameEN());
		
	}
	
	@Test
	@Rollback(value = false)
	public void testUpdateApplicantService() {
		Applicant applicant = applicantService.findById(2);
		applicant.setFirstNameEN("wan");
		applicantService.update(applicant);	
	}
	
	@Test
	@Rollback(value = false)
	public void testDeleteByIdApplicantService() {
		applicantService.deleteById(2);
		assertNull(applicantService.findById(2));
	}
	
	@Test
	public void testFindAll() {
		List<Applicant> applicants = applicantService.findAll();
		for (Applicant applicant : applicants)
			System.out.println("applicant : "
					+ applicant.getFirstNameEN());
	}

}
