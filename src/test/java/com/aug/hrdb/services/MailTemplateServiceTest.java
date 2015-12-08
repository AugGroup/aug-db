package com.aug.hrdb.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.hibernate.Query;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MailTemplate;
import com.aug.hrdb.services.MailTemplateService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class MailTemplateServiceTest {
	
	@Autowired
	private MailTemplateService mailTemplateService;
	
	@Before
	public void setUp(){
		MailTemplate mailTemplate = new MailTemplate();
		mailTemplate.setName("JAVA TEMPLATE");
		mailTemplate.setTemplate("TEMPLATE");
		mailTemplateService.create(mailTemplate);
		
	}
	
	@Test
	@Rollback(true)
	public void createMailTemplate(){
		
		MailTemplate mailTemplate = new MailTemplate();
		mailTemplate.setName("JAVA TEMPLATE");
		mailTemplate.setTemplate("TEMPLATE");
		mailTemplateService.create(mailTemplate);
		
	}
	
	@Test
	@Rollback(true)
	public void updateMailTemplate(){
		MailTemplate mailTemplate = mailTemplateService.findById(1);
		mailTemplate.setName(".NET TEMPLATE");
		mailTemplateService.update(mailTemplate);
		
		MailTemplate mailTemplateAfter = mailTemplateService.findById(1);
		assertEquals(".NET TEMPLATE", mailTemplateAfter.getName());
	
	}
	
	@Test
	@Rollback(true)
	public void deleteMailTemplate(){
		MailTemplate mailTemplate = mailTemplateService.findById(1);
		mailTemplateService.delete(mailTemplate);
	
	}
	
	@Test
	@Rollback(true)
	public void findByNameMailTemplate(){
		MailTemplate mailTemplate = mailTemplateService.findByName("JAVA TEMPLATE");
		assertNotNull(mailTemplate);
	}
	
}