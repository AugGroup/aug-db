/**
 *
 * @author Pranrajit
 * @date 4 ก.ย. 2558
 */
package repositories;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.entities.Employee;
import com.aug.hrdb.entities.Leave;
import com.aug.hrdb.entities.MasDivision;
import com.aug.hrdb.entities.MasJoblevel;
import com.aug.hrdb.entities.MasLeaveType;
import com.aug.hrdb.entities.MasTechnology;
import com.aug.hrdb.repositories.ApplicantRepository;
import com.aug.hrdb.repositories.EmployeeRepository;
import com.aug.hrdb.repositories.LeaveRepository;
import com.aug.hrdb.repositories.MasDivisionRepository;
import com.aug.hrdb.repositories.MasJoblevelRepository;
import com.aug.hrdb.repositories.MasLeaveTypeRepository;
import com.aug.hrdb.repositories.MasTechnologyRepository;
import com.aug.hrdb.services.MasTechnologyService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class LeaveRepositoryTest {
	
	@Autowired private LeaveRepository leaveRepository;
	@Autowired private EmployeeRepository employeeRepository;
	@Autowired private MasLeaveTypeRepository masLeaveTypeRepository;
	@Autowired private MasJoblevelRepository masJoblevelRepository;
	@Autowired private ApplicantRepository applicantRepository;
	@Autowired private MasDivisionRepository masDivisionRepository;
	@Autowired private MasTechnologyRepository masTechnologyRepository;
	
	private	 Employee employee;
	int id;
	int masdiId;
	int appId;
	int masjobId;
	int mastecId;
	int empId;
	
	@Before
	public void setleave() {
		employee = new Employee();
        employee.setIdCard("115310905001-9");
        employee.setNameThai("อภิวาท์");
        employee.setNameEng("apiva");
        employee.setNicknameThai("va");
        employee.setNicknameEng("va");
        employee.setSurnameThai("กิมเกถนอม");
        employee.setSurnameEng("kimkatanom");
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    	String dateInString = "31-08-1982";
    	Date date = null;
		try {
			date = sdf.parse(dateInString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
		employee.setDateOfBirth(date);
        employee.setEmail("test@gmail.com");
        employee.setEmergencyContact("mom");
        employee.setEmployeeCode("EMP-09");
        employee.setStatusemp("Employee");
        employee.setTelHome("089-0851022");
        employee.setTelMobile("089-0851022");
        employee.setEmergencyContactPhoneNumber("089-085-1022");
        employee.setAuditFlag("C");
        employee.setCreatedBy(1);
        employee.setCreatedTimeStamp(Calendar.getInstance().getTime());
        
        
        
        MasTechnology masTechnology = new MasTechnology();
		masTechnology.setName("java");
		masTechnology.setCode("001A");
		masTechnology.setIsActive(true);
		masTechnology.setAuditFlag("C");
		masTechnology.setCreatedBy(0);
		Calendar cal = Calendar.getInstance();
		masTechnology.setCreatedTimeStamp(cal.getTime());
		masTechnologyRepository.create(masTechnology);
		mastecId=masTechnology.getId();
		MasTechnology mTechnology= masTechnologyRepository.find(mastecId);
 		

		MasJoblevel masJoblevel = new MasJoblevel();
		masJoblevel.setName("CEO");
		masJoblevel.setIsActive(true);
		masJoblevel.setCode("01");
		masJoblevel.setAuditFlag("C");
		masJoblevel.setCreatedBy(1);
		masJoblevel.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masJoblevel.setCode("Division-01");

		masJoblevelRepository.create(masJoblevel);
		masjobId=masJoblevel.getId();
		MasJoblevel mJob= masJoblevelRepository.find(masjobId);
 		
        
        Applicant applicant = new Applicant();
		applicant.setCreatedBy(1);
		applicant.setCreatedTimeStamp(Calendar.getInstance().getTime());
		applicant.setAuditFlag("C");
		applicant.setCardId("115310905001-9");
		applicant.setTechnology(mTechnology);
		applicant.setJoblevel(mJob);
		applicantRepository.create(applicant);
		appId=applicant.getId();
		
        Applicant applicant1 = applicantRepository.find(appId);
        Hibernate.initialize(applicant1);
        
        
       
        
        employee.setApplicant(applicant1);
         
    
	
		MasDivision masDivision = new MasDivision();
		masDivision.setName("CEO");
		masDivision.setIsActive(true);
		masDivision.setCode("01");
		masDivision.setAuditFlag("C");
		masDivision.setCreatedBy(1);
		masDivision.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masDivision.setCode("Division-01");
		
		masDivisionRepository.create(masDivision);
		masdiId=masDivision.getId();
		masDivisionRepository.find(masdiId);
		employee.setMasDivision(masDivision);
		

		
		employee.setMasJoblevel(mJob);
		employeeRepository.create(employee);
		
		
		Employee employee= employeeRepository.find(1);
		
		
		
		MasLeaveType masLeaveType1=new MasLeaveType();
		masLeaveType1.setId(1);
		masLeaveType1.setName("holiday");
		masLeaveType1.setCreatedBy(1);
		masLeaveType1.setCode("LO-01");
		masLeaveType1.setIsactive(true);
		masLeaveType1.setAuditFlag("C");
		masLeaveType1.setCreatedBy(1);
		masLeaveType1.setCreatedTimeStamp(Calendar.getInstance().getTime());	
		masLeaveTypeRepository.create(masLeaveType1);
		
		int idMasLeaveType = masLeaveType1.getId();
		MasLeaveType masLeaveType =masLeaveTypeRepository.find(idMasLeaveType);
		
		Leave leave=new Leave();
		leave.setReason("tire");
		leave.setAim("boy");
		leave.setStartTimeString("20-12-2014 09:00");
		leave.setEndTimeString("22-12-2014 16:00");
		leave.setAuditFlag("C");
		leave.setCreatedBy(1);
		leave.setCreatedTimeStamp(Calendar.getInstance().getTime());
		leave.setEmployee(employee);
		leave.setMasleavetype(masLeaveType);
		leaveRepository.create(leave);
		
		
		id = leave.getId();
	    System.out.println("id: "+id);
	}
	
	
	@Test
	@Rollback(true)
	public void createLeave(){
		
		Employee employee= employeeRepository.find(1);
		MasLeaveType masLeaveType1=new MasLeaveType();
		masLeaveType1.setId(1);
		masLeaveType1.setName("holiday");
		masLeaveType1.setCreatedBy(1);
		masLeaveType1.setCode("LO-01");
		masLeaveType1.setIsactive(true);
		masLeaveType1.setAuditFlag("C");
		masLeaveType1.setCreatedBy(1);
		masLeaveType1.setCreatedTimeStamp(Calendar.getInstance().getTime());	
		masLeaveTypeRepository.create(masLeaveType1);
		int idMasLeaveType = masLeaveType1.getId();
		
		Leave leave=new Leave();
		leave.setReason("tire");
		leave.setAim("boy");
		leave.setStartTimeString("20-12-2014 09:00");
		leave.setEndTimeString("22-12-2014 16:00");
		leave.setAuditFlag("C");
		leave.setCreatedBy(1);
		leave.setCreatedTimeStamp(Calendar.getInstance().getTime());
		leave.setEmployee(employee);
		leave.setMasleavetype(masLeaveType1);
		leaveRepository.create(leave);
	}
	
	
	@Test
	@Rollback(true)
	public void updateLeave(){
		Leave leave=(Leave)leaveRepository.getCurrentSession().get(Leave.class,id);
		leave.setReason("sick2");
		leave.setAim("girl2");
		leave.setStartTimeString("04-09-2014 09:00");
		leave.setEndTimeString("05-09-2014 16:00");
		leaveRepository.update(leave);
	}

	
	
	@Test
	@Rollback(true)
	public void deleteLeave(){
		Leave leave=(Leave)leaveRepository.getCurrentSession().get(Leave.class,id);
		leaveRepository.getCurrentSession().delete(leave);
	}
	

	@Test
	public void findAllLeave(){
		
		Criteria c = leaveRepository.getCurrentSession().createCriteria(Leave.class);
		List<Leave> LeaveList = c.list();
		
		
		
	}
	
	
	
}
