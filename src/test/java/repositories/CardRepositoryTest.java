package repositories;

import java.util.Calendar;
import java.util.List;

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

import com.aug.hrdb.entities.Card;
import com.aug.hrdb.entities.Employee;
import com.aug.hrdb.repositories.CardRepository;
import com.aug.hrdb.repositories.EmployeeRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class CardRepositoryTest {

	@Autowired 
	private CardRepository cardRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@Test
	@Rollback(false)
	public void createDataCard(){
		
		Employee employee =  employeeRepository.find(1);
		Card card=new Card();
		employee.setId(1);
		card.setEmployee(employee);
		card.setCard_no("111");
		Calendar cal = Calendar.getInstance();
		card.setStartdate(cal.getTime());
		card.setEnddate(cal.getTime());
		card.setStatus("yes");
		card.setRemark("aaa");
		cardRepository.create(card);
	}
	

	
//	@Test
//	@Rollback(false)
//	public void updateCard(){
//		
//		Card card = (Card)cardRepository.getCurrentSession().get(Card.class,3);
//		card.setStatus("no");
//		card.setRemark("bbbb");
//		cardRepository.update(card);
//	}
//	
	
	
	
//	
//	@Test
//	@Rollback(false)
//	public void deleteCard(){
//		
//		Card card = (Card) cardRepository.getCurrentSession().get(Card.class,1);
//		cardRepository.getCurrentSession().delete(card);
//	}
//	
	
	


//	
//	@Test
//	public void findByIdCard(){
//		
//		Card card = (Card) cardRepository.getCurrentSession().get(Card.class, 1);		
//		int id = card.getId();
//		Assert.assertEquals(1, id);
//		
//	}
//	
//	

	
}
