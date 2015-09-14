package services;

import java.util.Calendar;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Employee;
import com.aug.hrdb.entities.Reward;
import com.aug.hrdb.services.EmployeeService;
import com.aug.hrdb.services.RewardService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class RewardServiceTest {
	
	@Autowired
	private RewardService rewardService;
	@Autowired
	private EmployeeService EmployeeService;
	
	
	@Test
	@Rollback(false)
	public void createDataReward(){
		
		Employee employee=EmployeeService.findById(1);		
		Reward reward=new Reward();	
		employee.setId(1);		
		reward.setEmployee(employee);
		reward.setTypereward("aa");
		reward.setYear("1991");
		reward.setReason("reason");
		Calendar cal = Calendar.getInstance();
		reward.setAuditFlag("C");
		reward.setCreatedBy(0);
		reward.setCreatedTimeStamp(cal.getTime());
		rewardService.create(reward);
		
	}
	
	
	
//	@Test
//	@Rollback(false)
//	public void updateDataReward(){
//		Reward reward=(Reward)rewardService.findById(2);
//		reward.setTypereward("b");
//		reward.setYear("2015");
//		reward.setReason("rrrrr");
//		rewardService.update(reward);
//		
//	}
	

	
	
//	@Test
//	public void deleteDataReward(){
//		Reward reward=rewardService.findById(1);
//		rewardService.delete(reward);
//	}
//	
//	@Test
//	public void findAllDataReward(){
//
//		List<Reward> ability = rewardService.findAll();
//		Assert.assertEquals(3, ability.size());
//	}
	
//	
//	@Test
//	public void findDatabyIdReward(){
//
//		Reward reward =(Reward) rewardService.findById(2);
//		int id = reward.getId();
//		Assert.assertEquals(2,id);
//		
//		
//		
//	}
	

}
