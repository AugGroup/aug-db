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

import com.aug.hrdb.entities.Login;
import com.aug.hrdb.services.LoginService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class LoginServiceTest {
	
	@Autowired
	private LoginService loginService;
	
	@Test
	@Rollback(false)
	public void createDataLogin(){
		
		Login login =new Login();		
		login.setUsername("Kik");
		login.setPassword("admin");	
		loginService.create(login);
	}
	
	
	
//	@Test
//	@Rollback(false)
//	public void updateLogin(){
//		
//		Login login = (Login)loginService.find(1);
//		login.setUsername("Kik");
//		login.setPassword("admin");
//		loginService.update(login);
//	}


//	@Test
//	public void deleteDataLogin(){
//		Login login=loginService.find(1);
//		loginService.delete(login);
//	}

	
	
//	@Test
//	public void findAllDataLogin(){
//
//		List<Login> login = loginService.findAll();
//		Assert.assertEquals(3, login.size());
//	}
	
	
	
	
//	@Test
//	public void findDatabyIdLogin(){
//
//		Login login =(Login) loginService.find(2);
//		int id = login.getId();
//		Assert.assertEquals(2,id);
//		
//	}

}
