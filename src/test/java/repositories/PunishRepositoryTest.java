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
import com.aug.hrdb.entities.Punish;
import com.aug.hrdb.repositories.EmployeeRepository;
import com.aug.hrdb.repositories.PunishRepository;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class PunishRepositoryTest {
	
	@Autowired
	private PunishRepository punishRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	
	@Test
	@Rollback(false)
	public void createPunish(){
		
		Employee employee =  employeeRepository.find(1);
		Punish punish=new Punish();
		employee.setId(1);
		punish.setEmployee(employee);	
		Calendar cal = Calendar.getInstance();
		punish.setDatepunish(cal.getTime());
		punish.setDescription("aaaa");
		punish.setPenalty("test");		
		punishRepository.create(punish);
		
	}
	
	
//	@Test
//	@Rollback(false)
//	public void updatePunish(){
//		
//		Punish punish = (Punish) punishRepository.getCurrentSession().get(Punish.class,3);
//		Calendar cal = Calendar.getInstance();
//		punish.setDatepunish(cal.getTime());
//		punish.setDescription("bbb");
//		punish.setPenalty("test");
//		punishRepository.update(punish);
//	}
	
	
//	@Test
//	@Rollback(false)
//	public void deletePunish(){
//		
//		Punish punish = (Punish) punishRepository.getCurrentSession().get(Punish.class,3);
//		punishRepository.getCurrentSession().delete(punish);
//	}
	
	

	
//	@Test
//	public void findByIdPunish(){
//		
//		Punish punish = (Punish) punishRepository.getCurrentSession().get(Punish.class, 1);		
//		int id = punish.getId();
//		Assert.assertEquals(1, id);
//		
//	}
	
	
	

}
