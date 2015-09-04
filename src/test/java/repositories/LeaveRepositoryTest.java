/**
 *
 * @author Pranrajit
 * @date 4 ก.ย. 2558
 */
package repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;



import com.aug.hrdb.entities.Leave;
import com.aug.hrdb.repositories.LeaveRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class LeaveRepositoryTest {
	
	@Autowired LeaveRepository leaveRepository;
	
	@Test
	@Rollback(false)
	public void createLeave(){
		Leave leave=new Leave();
		leave.setReason("tire");
		leave.setAim("boy");
		leave.setStartTimeString("20-12-2014 09:00");
		leave.setEndTimeString("22-12-2014 16:00");
		leaveRepository.getCurrentSession().save(leave);
	}
	
	/*
	@Test
	@Rollback(false)
	public void updateLeave(){
		Leave leave=(Leave)leaveRepository.getCurrentSession().get(Leave.class,3);
		leave.setReason("sick2");
		leave.setAim("girl2");
		leave.setStartTimeString("04-09-2014 09:00");
		leave.setEndTimeString("05-09-2014 16:00");
		leaveRepository.getCurrentSession().update(leave);
	}*/

	
	
	/*@Test
	@Rollback(false)
	public void deleteLeave(){
		Leave leave=(Leave)leaveRepository.getCurrentSession().get(Leave.class,2);
		leaveRepository.getCurrentSession().delete(leave);
	}*/
	
	
	/*@SuppressWarnings({ "unchecked", "deprecation" })
	@Test
	public void findAllLeave(){
		
		Criteria c = leaveRepository.getCurrentSession().createCriteria(Leave.class);
		List<Leave> LeaveList = c.list();
		Assert.assertEquals(2, LeaveList.size());
		
		
	}
	*/
	
	
}
