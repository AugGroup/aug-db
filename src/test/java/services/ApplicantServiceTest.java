package services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
import com.aug.hrdb.repositories.EmployeeRepository;
import com.aug.hrdb.services.ApplicantService;
import com.aug.hrdb.services.EmployeeService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-bean-db-test.xml")
@Transactional
public class ApplicantServiceTest {
	@Autowired
	private ApplicantService applicantService;
	
	@Autowired
	private EmployeeService employeeService;
	
	private Applicant applicant;
	@Before
    public void setUp() {
		
		
        applicant = new Applicant();
        applicant.setFirstNameEN("Uthaiwan");
        applicant.setLastNameEN("Siloodjai");
        applicant.setNickNameEN("wan");
        applicant.setNickNameTH("วรรณ");
        applicant.setEmployee(employeeService.findById(1));
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
        applicantService.create(applicant);
    }
	
	@Test
	@Rollback(value = true)
	public void testInsertApplicantService() {
		Applicant applicant = new Applicant();
		applicant.setFirstNameEN("Monkey");
		applicant.setAuditFlag("C");
		applicant.setCreatedBy(1);
		applicant.setCreatedTimeStamp(Calendar.getInstance().getTime());
		applicantService.create(applicant);
	}
	
	@Test
	public void testFindByIdApplicantService() {
		Applicant applicant = applicantService.findById(2);
		assertNotNull(applicant.getFirstNameEN());
		
	}
	
	@Test
	@Rollback(value = true)
	public void testUpdateApplicantService() {
		Applicant applicant = applicantService.findById(3);
		applicant.setFirstNameEN("wan");
		applicant.setAuditFlag("U");
		applicant.setCreatedBy(1);
		applicant.setCreatedTimeStamp(Calendar.getInstance().getTime());
		applicantService.update(applicant);	
	}
	
	@Test
	@Rollback(value = true)
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
