/**
 *
 * @author Pranrajit
 * @date 4 ก.ย. 2558
 */
package repositories;

import java.util.Calendar;
import java.util.List;




import org.hibernate.Criteria;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;












import com.aug.hrdb.entities.Employee;
import com.aug.hrdb.entities.Leave;
import com.aug.hrdb.entities.MasLeaveType;
import com.aug.hrdb.repositories.EmployeeRepository;
import com.aug.hrdb.repositories.LeaveRepository;
import com.aug.hrdb.repositories.MasLeaveTypeRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class LeaveRepositoryTest {
	
	@Autowired LeaveRepository leaveRepository;
	@Autowired EmployeeRepository employeeRepository;
	@Autowired MasLeaveTypeRepository masLeaveTypeRepository;
	
	@Test
	@Rollback(false)
	public void createLeave(){
		
		Employee employee= employeeRepository.find(1);
		MasLeaveType masLeaveType =masLeaveTypeRepository.find(1);
		
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
	}
	
	
/*	@Test
	@Rollback(false)
	public void updateLeave(){
		Leave leave=(Leave)leaveRepository.getCurrentSession().get(Leave.class,1);
		leave.setReason("sick2");
		leave.setAim("girl2");
		leave.setStartTimeString("04-09-2014 09:00");
		leave.setEndTimeString("05-09-2014 16:00");
		leaveRepository.update(leave);
	}*/

	
	
	/*@Test
	@Rollback(false)
	public void deleteLeave(){
		Leave leave=(Leave)leaveRepository.getCurrentSession().get(Leave.class,1);
		leaveRepository.getCurrentSession().delete(leave);
	}
	*/
	/*
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Test
	public void findAllLeave(){
		
		Criteria c = leaveRepository.getCurrentSession().createCriteria(Leave.class);
		List<Leave> LeaveList = c.list();
		Assert.assertEquals(1, LeaveList.size());
		
		
	}*/
	
	
	
}
