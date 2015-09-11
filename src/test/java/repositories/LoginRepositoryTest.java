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
import com.aug.hrdb.entities.Login;
import com.aug.hrdb.repositories.LoginRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class LoginRepositoryTest {
	
	@Autowired
	private LoginRepository loginRepository;
	private Employee employee = new Employee();
	
	
	@Test
	@Rollback(false)
	public void createLogin(){
		
		Login login =new Login();	
		employee.setId(1);
		login.setEmployee(employee);
		
		login.setUsername("Kik");
		login.setPassword("admin");	
		Calendar cal = Calendar.getInstance();
		login.setAuditFlag("C");
		login.setCreatedBy(0);
		login.setCreatedTimeStamp(cal.getTime());
		loginRepository.getCurrentSession().save(login);
	}
	
	
//	@Test
//	@Rollback(false)
//	public void updateLogin(){
//		
//		Login login = (Login)loginRepository.find(1);
//		login.setUsername("Kik");
//		login.setPassword("admin");
//		loginRepository.update(login);
//	}


//	@Test
//	@Rollback(false)
//	public void deleteLogin(){
//		
//		Login login = (Login) loginRepository.getCurrentSession().get(Login.class,1);
//		loginRepository.getCurrentSession().delete(login);
//	}
	
	
//	@Test
//	public void listCard(){
//		
//		Criteria c = loginRepository.getCurrentSession().createCriteria(Login.class);
//		List<Login> LoginList = c.list();
//		Assert.assertEquals(2, LoginList.size());
//		
//	}
//	
	
}
