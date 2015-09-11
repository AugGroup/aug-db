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

import com.aug.hrdb.entities.Punish;
import com.aug.hrdb.repositories.PunishRepository;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class PunishRepositoryTest {
	
	@Autowired
	private PunishRepository punishRepository;
//	
//	@Test
//	@Rollback(false)
//	public void createPunish(){
//		Punish punish=new Punish();
//		Calendar cal = Calendar.getInstance();
//		punish.setDatepunish(cal.getTime());
//		punish.setDescription("aaaa");
//		punish.setPenalty("test");
//		punishRepository.getCurrentSession().save(punish);
//		
//	}
//	
	
//	@Test
//	@Rollback(false)
//	public void updatePunish(){
//		
//		Punish punish = (Punish)punishRepository.find(1);
//		punish.setDescription("bbb");;	
//		punishRepository.update(punish);
//	}
	
//	@Test
//	@Rollback(false)
//	public void deletePunish(){
//		
//		Punish punish = (Punish) punishRepository.getCurrentSession().get(Punish.class,1);
//		punishRepository.getCurrentSession().delete(punish);
//	}
	
	
//	@Test
//	public void listPunish(){
//		
//		Criteria c = punishRepository.getCurrentSession().createCriteria(Punish.class);
//		List<Punish> PunishList = c.list();
//		Assert.assertEquals(2, PunishList.size());
//		
//	}

	
//	@Test
//	public void findByIdPunish(){
//		
//		Punish punish = (Punish) punishRepository.getCurrentSession().get(Punish.class, 1);		
//		int id = punish.getId();
//		Assert.assertEquals(1, id);
//		
//	}
//	
	
	

}
