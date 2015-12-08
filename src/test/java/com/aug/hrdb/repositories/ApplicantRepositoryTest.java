package com.aug.hrdb.repositories;

import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.entities.MasJobLevel;
import com.aug.hrdb.entities.MasTechnology;
import com.aug.hrdb.repositories.ApplicantRepository;
import com.aug.hrdb.repositories.EmployeeRepository;
import com.aug.hrdb.repositories.MasJobLevelRepository;
import com.aug.hrdb.repositories.MasTechnologyRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
public class ApplicantRepositoryTest {
	@Autowired
	ApplicantRepository applicantRepository;
	@Autowired
	EmployeeRepository employeeRepository;
	private Applicant applicant;
	@Autowired
	private MasJobLevelRepository masJoblevelRepository;
	@Autowired
	private MasTechnologyRepository masTechnologyRepository;
	
	@Before
    public void setUp() {
		
		
        applicant = new Applicant();
        applicant.setFirstNameEN("Uthaiwan");
        applicant.setLastNameEN("Siloodjai");
        applicant.setNickNameEN("wan");
        applicant.setNickNameTH("วรรณ");
        applicant.setEmployee(employeeRepository.find(1));
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    	String dateInString = "31-08-1982";
    	Date date = null;
		try {
			date = sdf.parse(dateInString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		applicant.setBirthDate(date);
		applicant.setEmail("test@gmail.com");
        applicant.setAuditFlag("C");
        applicant.setCreatedBy(1);
        applicant.setCreatedTimeStamp(Calendar.getInstance().getTime());
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
		
    }
	
	
	
	@Test
	@Transactional
	@Rollback(value = true)
	public void testInsertApplicantRepository() throws Exception {
		Applicant applicant = new Applicant();
		applicant.setFirstNameEN("yam");
		applicant.setAuditFlag("C");
		applicant.setCreatedBy(1);
		applicant.setCreatedTimeStamp(Calendar.getInstance().getTime());
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
		masTechnology.setName(".NET");
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
	}
	
	@Test
	@Transactional
	@Rollback(value = true)
	public void testUpdateApplicantRepository() throws Exception {
		Applicant applicant =applicantRepository.find(3);
		applicant.setFirstNameEN("net");
		applicant.setAuditFlag("U");
		applicant.setCreatedBy(2);
		applicant.setCreatedTimeStamp(Calendar.getInstance().getTime());
		applicantRepository.update(applicant);
	}
	
	@Test
	@Transactional
	@Rollback(value = true)
	public void testDeleteByIdApplicantRepository() throws Exception {
		applicantRepository.deleteById(1);
	}
	
	@Test
	@Transactional
	@Rollback(value = true)
	public void testDeleteApplicantRepository() throws Exception {
		Applicant applicant = applicantRepository.find(3);
		applicantRepository.delete(applicant);			
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
