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

import com.aug.hrdb.entities.Card;
import com.aug.hrdb.services.CardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class CardServiceTest {
	
	@Autowired
	private CardService cardService;
	
	@Test
	@Rollback(false)
	public void createDataCard(){
		
		Card card = new Card();
		card.setCard_no("111");
		Calendar cal = Calendar.getInstance();
		card.setStartdate(cal.getTime());
		card.setEnddate(cal.getTime());
		card.setStatus("yes");
		card.setRemark("aaa");
		cardService.create(card);
	}
	
	
//	@Test
//	@Rollback(false)
//	public void updateCard(){
//		
//		Card card = (Card)cardService.findById(1);
//		card.setStatus("no");
//		card.setRemark("bbbb");
//		cardService.update(card);
//	}
	
	
//	@Test
//	public void deleteDataCard(){
//		Card card=cardService.findById(1);
//		cardService.delete(card);
//	}

	
	
//	@Test
//	public void findAllDataCard(){
//
//		List<Card> card = cardService.findAll();
//		Assert.assertEquals(3, card.size());
//	}
//	
	
	
	
//	@Test
//	public void findDatabyIdCard(){
//
//		Card card =(Card) cardService.findById(2);
//		int id = card.getId();
//		Assert.assertEquals(2,id);
//		
//			
//	}
	

}



