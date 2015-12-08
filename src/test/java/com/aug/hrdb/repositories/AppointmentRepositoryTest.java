package com.aug.hrdb.repositories;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.repositories.AppointmentRepository;
import com.aug.hrdb.repositories.EmployeeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
public class AppointmentRepositoryTest {

	@Autowired private AppointmentRepository appointmentRepository ;
	
	@Autowired private EmployeeRepository employeeRepository;
	
	private Applicant applicant;
	
	@Before
	public void setUp(){
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
      
	}
}
