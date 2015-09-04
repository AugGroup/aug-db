/**
 *
 * @author Pranrajit
 * @date 4 ก.ย. 2558
 */
package services;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Leave;
import com.aug.hrdb.services.LeaveService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class LeaveServiceTest {
	
	@Autowired LeaveService leaveService;
	
	@Test
	@Rollback(false)
	public void create(){
		Leave leave=new Leave();
		leave.setReason("tire");
		leave.setAim("boy");
		leave.setStartTimeString("20-12-2014 09:00");
		leave.setEndTimeString("22-12-2014 16:00");
		leaveService.create(leave);
		
		
	}

	
	/*@Test
	@Rollback(false)
	public void update(){
		Leave leave=(Leave)leaveService.findById(1);
		leave.setReason("sick2");
		leave.setAim("girl2");
		leave.setStartTimeString("04-09-2014 09:00");
		leave.setEndTimeString("05-09-2014 16:00");
		leaveService.update(leave);
	}*/
	
	/*
	@Test
	@Rollback(false)
	public void delete(){
		Leave leave = leaveService.findById(2);
		leaveService.delete(leave);
		
	}*/
	
	/*@SuppressWarnings("deprecation")
	@Test
	public void findAllLeave(){

		List<Leave> leave = leaveService.findAll();
		Assert.assertEquals(3,leave.size());
	}
	*/
	
	
	/*@SuppressWarnings("deprecation")
	@Test
	public void findDatabyIdLeave(){

		Leave leave =(Leave)leaveService.findById(3);
		int id = leave.getId();
		Assert.assertEquals(3,id);
		
		
		
	}*/
	
}
