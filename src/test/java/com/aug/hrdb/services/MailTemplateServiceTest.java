package com.aug.hrdb.services;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.GreaterOrEqual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MailTemplate;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class MailTemplateServiceTest {

  @Autowired
  private MailTemplateService mailTemplateService;

  private MailTemplate mailTemplate;

  @Before
  public void setUp() {
    mailTemplate = new MailTemplate();
    mailTemplate.setName("JAVA TEMPLATE");
    mailTemplate.setTemplate("<!DOCTYPE html></html>");
    mailTemplateService.create(mailTemplate);

  }

  @Test
  public void testLoadServiceShouldPass() throws Exception {
    assertNotNull(mailTemplateService);
  }

  @Test
  public void testFindWithMailTemplateServiceShouldReturnMailTemplateThatSetup() throws Exception {
    MailTemplate result = mailTemplateService.findById(mailTemplate.getId());
    assertNotNull(result);
    assertThat(result.getName(), is("JAVA TEMPLATE"));
    assertThat(result.getTemplate(), is("<!DOCTYPE html></html>"));

  }

  @Test
  public void testFindAllWithMailTemplateServiceShouldReturnListOfAllMailTemplate() throws Exception {
    List<MailTemplate> result = mailTemplateService.findAll();
    assertNotNull(result);
    assertThat(result.size(), is(new GreaterOrEqual<>(1)));

  }

  @Test
  public void testUpdateWithMailTemplateServiceShouldReturnMailTemplateThatUpdate() throws Exception {
    MailTemplate update = mailTemplateService.findById(mailTemplate.getId());
    assertThat(update.getName(), is("JAVA TEMPLATE"));
    assertThat(update.getTemplate(), is("<!DOCTYPE html></html>"));

    update.setName("JAVA TEMPLATE Update");
    mailTemplateService.update(update);

    MailTemplate result = mailTemplateService.findById(update.getId());
    assertThat(result.getName(), is("JAVA TEMPLATE Update"));

  }

  @Test
  public void testDeleteWithMailTemplateServiceShouldNotFindThatMailTemplate() throws Exception {
    MailTemplate delete = mailTemplateService.findById(mailTemplate.getId());
    mailTemplateService.delete(delete);

    MailTemplate result = mailTemplateService.findById(delete.getId());
    assertNull(result);

  }

  @Test
  public void testDeleteByIdWithMailTemplateServiceShouldNotFindThatMailTemplate() throws Exception {
    MailTemplate delete = mailTemplateService.findById(mailTemplate.getId());
    mailTemplateService.deleteById(delete.getId());

    MailTemplate result = mailTemplateService.findById(delete.getId());
    assertNull(result);

  }

  @Test
  public void testFindByNameWithMailTemplateServiceShouldReturnMailTemplateOfThatName() throws Exception {
    MailTemplate result = mailTemplateService.findByName("JAVA TEMPLATE");
    assertThat(result.getName(), is("JAVA TEMPLATE"));
    assertThat(result.getTemplate(), is("<!DOCTYPE html></html>"));

  }

}