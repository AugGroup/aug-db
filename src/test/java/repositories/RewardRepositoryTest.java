package repositories;

import java.util.Calendar;
import java.util.List;
import org.hibernate.Criteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Employee;
import com.aug.hrdb.entities.Reward;
import com.aug.hrdb.repositories.EmployeeRepository;
import com.aug.hrdb.repositories.RewardRepository;

import junit.framework.Assert;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class RewardRepositoryTest {
	
	@Autowired
	private RewardRepository rewardRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Test
	@Rollback(false)
	public void createReward(){
		
		Employee employee =  employeeRepository.find(2);
		Reward reward=new Reward();
		employee.setId(2);
		reward.setEmployee(employee);     	
		reward.setTypereward("aa");
		reward.setYear("1991");
		reward.setReason("reason");
		Calendar cal = Calendar.getInstance();
		reward.setAuditFlag("C");
		reward.setCreatedBy(0);
		reward.setCreatedTimeStamp(cal.getTime());
		rewardRepository.create(reward);
	}
	
	
	
	
//	@Test
//	@Rollback(false)
//	public void updateReward(){
//		
//		Reward reward = (Reward) rewardRepository.getCurrentSession().get(Reward.class,1);	  
//		reward.setTypereward("bb");
//		reward.setYear("1992");
//		reward.setReason("reason");
//		Calendar cal = Calendar.getInstance();
//		reward.setAuditFlag("C");
//		reward.setCreatedBy(0);
//		reward.setCreatedTimeStamp(cal.getTime());
//		rewardRepository.update(reward);
//	}
	
	
	
//	@Test
//	@Rollback(false)
//	public void deleteReward(){
//		
//		Reward reward = (Reward) rewardRepository.getCurrentSession().get(Reward.class,1);
//		rewardRepository.getCurrentSession().delete(reward);
//	}
	
	
	
		
	
	
//	@Test
//	public void findByIdReward(){
//		
//		Reward reward = (Reward) rewardRepository.getCurrentSession().get(Reward.class, 2);		
//		int id = reward.getId();
//		Assert.assertEquals(2, id);
//		
//	}
	
	

}
