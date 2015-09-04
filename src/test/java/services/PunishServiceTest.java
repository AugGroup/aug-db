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

import com.aug.hrdb.entities.Punish;
import com.aug.hrdb.services.PunishService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class PunishServiceTest {
	
	@Autowired
	private PunishService punishService;
	
	@Test
	@Rollback(false)
	public void createDataPunish(){
		Punish punish=new Punish();
		Calendar cal = Calendar.getInstance();
		punish.setDatepunish(cal.getTime());
		punish.setDescription("aaaa");
	    punish.setPenalty("test");
		punishService.create(punish);		
	}
	
	
	@Test
	@Rollback(false)
	public void updateDataPunish(){
		Punish punish= punishService.findById(2);
		punish.setDescription("aaaa");
		punishService.update(punish);
		
	}
	

	
//	@Test
//	public void deleteDataPunish(){
//		Punish punish=punishService.findById(1);
//		punishService.delete(punish);
//	}
//	
		
//	@Test
//	public void findAllDataPunish(){
//
//		List<Punish> punish = punishService.findAll();
//		Assert.assertEquals(3, punish.size());
//	}
//	
	
//	@Test
//	public void findDatabyIdPunish(){
//
//		Punish punish =(Punish) punishService.findById(2);
//		int id = punish.getId();
//		Assert.assertEquals(2,id);
//		
//	}

}
