package repositories;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Query;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MailTemplate;
import com.aug.hrdb.repositories.MailTemplateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class MailTemplateRepositoryTest {

	@Autowired
	private MailTemplateRepository mailTemplateRepository;
	
	@Before
	public void setUp(){
		MailTemplate mailTemplate = new MailTemplate();
		mailTemplate.setName("JAVA TEMPLATE");
		mailTemplate.setTemplate("TEMPLATE");
		mailTemplateRepository.create(mailTemplate);		
	}
	
	@Test
	@Rollback(true)
	public void createMailTemplate(){
		
		MailTemplate mailTemplate = new MailTemplate();
		mailTemplate.setName("JAVA TEMPLATE");
		mailTemplate.setTemplate("TEMPLATE");
		mailTemplateRepository.create(mailTemplate);
		
	}
	
	@Test
	@Rollback(true)
	public void updateMailTemplate(){
		MailTemplate mailTemplateBefore = mailTemplateRepository.find(1);
		
		mailTemplateBefore.setName(".NET TEMPLATE");
		mailTemplateRepository.update(mailTemplateBefore);
		MailTemplate mailTemplateAfter = mailTemplateRepository.find(1);

		assertEquals(".NET TEMPLATE", mailTemplateAfter.getName());
	
	}
	
	@Test
	@Rollback(true)
	public void deleteMailTemplate(){
		MailTemplate mailTemplate = mailTemplateRepository.find(1);
		mailTemplateRepository.delete(mailTemplate);	
	}
	
	@Test
	@Rollback(true)
	public void findByNameMailTemplate(){
		MailTemplate mailTemplate = mailTemplateRepository.findByName("JAVA TEMPLATE");
		assertNotNull(mailTemplate);
	}
	
}
