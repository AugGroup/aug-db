/**
 *
 * @author Pranrajit
 * @date 4 ก.ย. 2558
 */
package services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
import com.aug.hrdb.repositories.EmployeeRepository;
import com.aug.hrdb.services.ApplicantService;
import com.aug.hrdb.services.EmployeeService;
import com.aug.hrdb.services.LeaveService;
import com.aug.hrdb.services.MasDivisionService;
import com.aug.hrdb.services.MasJoblevelService;
import com.aug.hrdb.services.MasLeaveTypeService;
import com.aug.hrdb.services.MasTechnologyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class LeaveServiceTest {
	
	@Autowired private LeaveService leaveService;
	@Autowired private EmployeeService employeeService;
	@Autowired private MasLeaveTypeService masLeaveTypeService;
	@Autowired private MasJoblevelService masJoblevelService;
	@Autowired private ApplicantService applicantService;
	@Autowired private MasDivisionService masDivisionService;
	@Autowired private MasTechnologyService masTechnologyService;

	
	
	private	 Employee employee;
	int id;
	int masdiId;
	int appId;
	int masjobId;
	int mastecId;
	int empId;
	
	@Before
	public void setAbility() {
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
        employee.setEmployeeCode("EMP-18");
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
		masTechnologyService.create(masTechnology);
		mastecId=masTechnology.getId();
 		
		MasTechnology mTechnology= masTechnologyService.find(mastecId);
 		

		MasJoblevel masJoblevel = new MasJoblevel();
		masJoblevel.setName("CEO");
		masJoblevel.setIsActive(true);
		masJoblevel.setCode("01");
		masJoblevel.setAuditFlag("C");
		masJoblevel.setCreatedBy(1);
		masJoblevel.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masJoblevel.setCode("Division-01");

		masJoblevelService.create(masJoblevel);
		masjobId=masJoblevel.getId();
		MasJoblevel mJob= masJoblevelService.find(masjobId);
 			
        
        Applicant applicant = new Applicant();
		applicant.setCreatedBy(1);
		applicant.setCreatedTimeStamp(Calendar.getInstance().getTime());
		applicant.setAuditFlag("C");
		applicant.setCardId("115310905001-9");
		applicant.setTechnology(mTechnology);
		applicant.setJoblevel(mJob);

		applicantService.create(applicant);
		appId=applicant.getId();
        Applicant applicant1 = applicantService.findById(appId);
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
		
		masDivisionService.create(masDivision);
		masdiId=masDivision.getId();
		masDivisionService.findById(masdiId);
		employee.setMasDivision(masDivision);
		
	
		employee.setMasJoblevel(mJob);
		employeeService.create(employee);
		empId=employee.getId();
		
		
		Employee employee=employeeService.findById(empId);
		
		MasLeaveType masLeaveType1=new MasLeaveType();
		masLeaveType1.setId(1);
		masLeaveType1.setName("holiday");
		masLeaveType1.setCreatedBy(1);
		masLeaveType1.setCode("LO-01");
		masLeaveType1.setIsactive(true);
		masLeaveType1.setAuditFlag("C");
		masLeaveType1.setCreatedBy(1);
		masLeaveType1.setCreatedTimeStamp(Calendar.getInstance().getTime());	
		masLeaveTypeService.create(masLeaveType1);
		
		int idMasLeaveType = masLeaveType1.getId();
		MasLeaveType masLeaveType =masLeaveTypeService.find(idMasLeaveType);
		
	
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
		leaveService.create(leave);
		
		id = leave.getId();
	    System.out.println("id: "+id);
	}
	
	
	
	@Test
	@Rollback(true)
	public void create(){
		
		Employee employee=employeeService.findById(1);
		
		MasLeaveType masLeaveType1=new MasLeaveType();
		masLeaveType1.setId(1);
		masLeaveType1.setName("holiday");
		masLeaveType1.setCreatedBy(1);
		masLeaveType1.setCode("LO-01");
		masLeaveType1.setIsactive(true);
		masLeaveType1.setAuditFlag("C");
		masLeaveType1.setCreatedBy(1);
		masLeaveType1.setCreatedTimeStamp(Calendar.getInstance().getTime());	
		masLeaveTypeService.create(masLeaveType1);
		
		int idMasLeaveType = masLeaveType1.getId();
		MasLeaveType masLeaveType =masLeaveTypeService.find(idMasLeaveType);
		
		/*MasLeaveType masLeaveType=masLeaveTypeService.find(1);*/
		
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
		leaveService.create(leave);
		
		
	}

	
	@Test
	@Rollback(true)
	public void update(){
		Leave leave=(Leave)leaveService.findById(id);
		leave.setReason("sick2");
		leave.setAim("girl2");
		leave.setStartTimeString("04-09-2014 09:00");
		leave.setEndTimeString("05-09-2014 16:00");
		leaveService.update(leave);
	}
	
	
	@Test
	@Rollback(true)
	public void delete(){
		Leave leave = leaveService.findById(id);
		leaveService.delete(leave);
		
	}
	
	@Test
	public void findAllLeave(){

		List<Leave> leave = leaveService.findAll();
		
	}
	
	
	

	@Test
	public void findDatabyIdLeave(){

		Leave leave =(Leave)leaveService.findById(id);
		int id = leave.getId();
		Assert.assertEquals(id,id);
		
		
		
	}
	
}
