package services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.entities.Appointment;
import com.aug.hrdb.services.ApplicantService;
import com.aug.hrdb.services.AppointmentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-bean-db-test.xml")
@Transactional
public class AppointmentServiceTest {
	
	
	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
	private ApplicantService applicantService;
	
	private Appointment appointment;
	
	private Applicant applicant;
	
	@Before
	private void setUp(){
		
	}
	
}
