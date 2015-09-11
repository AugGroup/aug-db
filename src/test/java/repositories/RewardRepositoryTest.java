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
import junit.framework.Assert;

import com.aug.hrdb.entities.Employee;
import com.aug.hrdb.entities.Reward;
import com.aug.hrdb.repositories.RewardRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class RewardRepositoryTest {
	
	@Autowired
	private RewardRepository rewardRepository;
	
	@Test
	@Rollback(false)
	public void createReward(){
		Reward reward=new Reward();
		Employee employee = new Employee();
		employee.setId(1);
      	reward.setEmployee(employee);
      	
		reward.setTypereward("aa");
		reward.setYear("1991");
		reward.setReason("reason");
		Calendar cal = Calendar.getInstance();
		reward.setAuditFlag("C");
		reward.setCreatedBy(0);
		reward.setCreatedTimeStamp(cal.getTime());
		rewardRepository.getCurrentSession().save(reward);
	}
	
	
	
	
//	@Test
//	@Rollback(false)
//	public void updateReward(){
//		
//		Reward reward = (Reward)rewardRepository.find(1);
//		reward.setTypereward("b");
//		reward.setYear("2015");
//		reward.setReason("rrrrr");
//		Calendar cal = Calendar.getInstance();
//		reward.setAuditFlag("C");
//		reward.setCreatedBy(0);
//		reward.setCreatedTimeStamp(cal.getTime());
//		rewardRepository.update(reward);
//	}
//	
	
	
//	@Test
//	@Rollback(false)
//	public void deleteReward(){
//		
//		Reward reward = (Reward) rewardRepository.getCurrentSession().get(Reward.class,1);
//		rewardRepository.getCurrentSession().delete(reward);
//	}
	
	
//	@Test
//	public void listReward(){
//		
//		Criteria c = rewardRepository.getCurrentSession().createCriteria(Reward.class);
//		List<Reward> RewardList = c.list();
//		Assert.assertEquals(2, RewardList.size());
//		
//	}

	
//	@Test
//	public void findByIdReward(){
//		
//		Reward reward = (Reward) rewardRepository.getCurrentSession().get(Reward.class, 1);		
//		int id = reward.getId();
//		Assert.assertEquals(1, id);
//		
//	}
//	
//	

}
