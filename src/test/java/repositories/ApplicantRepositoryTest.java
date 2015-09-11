package repositories;

import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.repositories.ApplicantRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
public class ApplicantRepositoryTest {
	@Autowired ApplicantRepository applicantRepository;
	
	@Test
	@Transactional
	@Rollback(value = false)
	public void testInsertApplicantRepository() throws Exception {
		Applicant applicant = new Applicant();
		applicant.setFirstNameEN("yam");
		applicant.setAuditFlag("C");
		applicant.setCreatedBy(1);
		applicant.setCreatedTimeStamp(Calendar.getInstance().getTime());
		applicantRepository.create(applicant);
	}
	
	@Test
	@Transactional
	@Rollback(value = false)
	public void testUpdateApplicantRepository() throws Exception {
		Applicant applicant =applicantRepository.find(2);
		applicant.setFirstNameEN("net");
		applicant.setAuditFlag("U");
		applicant.setCreatedBy(2);
		applicant.setCreatedTimeStamp(Calendar.getInstance().getTime());
		applicantRepository.update(applicant);
	}
	
	@Test
	@Transactional
	@Rollback(value = false)
	public void testDeleteByIdApplicantRepository() throws Exception {
		applicantRepository.deleteById(6);
	}

	@Test
	@Transactional
	public void testFindByIdApplicantRepository() throws Exception {
		Applicant applicant = applicantRepository.find(2);
		assertNotNull(applicant.getFirstNameEN());
		
	}

	@Test
	@Transactional
	public void testFindAllApplicantRepository() throws Exception {
		List<Applicant> applicants = applicantRepository.findAll();
		for (Applicant applicant : applicants)
			System.out.println("applicant : "
					+ applicant.getFirstNameEN());
	}
	
	
	
	
	
	
	
	
	
	
}
