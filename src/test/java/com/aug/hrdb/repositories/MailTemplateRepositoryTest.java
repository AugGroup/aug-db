package com.aug.hrdb.repositories;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import com.aug.hrdb.entities.MailTemplate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.GreaterOrEqual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class MailTemplateRepositoryTest {

  @Autowired
  private MailTemplateRepository mailTemplateRepository;

  private MailTemplate mailTemplate;

  @Before
  public void setUp() {
    mailTemplate = new MailTemplate();
    mailTemplate.setName("JAVA TEMPLATE");
    mailTemplate.setTemplate("<!DOCTYPE html></html>");
    mailTemplateRepository.create(mailTemplate);

  }

  @Test
  public void testLoadRepositoryShouldPass() throws Exception {
    assertNotNull(mailTemplateRepository);
  }

  @Test
  public void testFindWithMailTemplateRepositoryShouldReturnMailTemplateThatSetup() throws Exception {
    MailTemplate result = mailTemplateRepository.find(mailTemplate.getId());
    assertNotNull(result);
    assertThat(result.getName(), is("JAVA TEMPLATE"));
    assertThat(result.getTemplate(), is("<!DOCTYPE html></html>"));

  }

  @Test
  public void testFindAllWithMailTemplateRepositoryShouldReturnListOfAllMailTemplate() throws Exception {
    List<MailTemplate> result = mailTemplateRepository.findAll();
    assertNotNull(result);
    assertThat(result.size(), is(new GreaterOrEqual<>(1)));

  }

  @Test
  public void testUpdateWithMailTemplateRepositoryShouldReturnMailTemplateThatUpdate() throws Exception {
    MailTemplate update = mailTemplateRepository.find(mailTemplate.getId());
    assertThat(update.getName(), is("JAVA TEMPLATE"));
    assertThat(update.getTemplate(), is("<!DOCTYPE html></html>"));

    update.setName("JAVA TEMPLATE Update");
    mailTemplateRepository.update(update);

    MailTemplate result = mailTemplateRepository.find(update.getId());
    assertThat(result.getName(), is("JAVA TEMPLATE Update"));

  }

  @Test
  public void testDeleteWithMailTemplateRepositoryShouldNotFindThatMailTemplate() throws Exception {
    MailTemplate delete = mailTemplateRepository.find(mailTemplate.getId());
    mailTemplateRepository.delete(delete);

    MailTemplate result = mailTemplateRepository.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testDeleteByIdWithMailTemplateRepositoryShouldNotFindThatMailTemplate() throws Exception {
    MailTemplate delete = mailTemplateRepository.find(mailTemplate.getId());
    mailTemplateRepository.deleteById(delete.getId());

    MailTemplate result = mailTemplateRepository.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testFindByNameWithMailTemplateRepositoryShouldReturnMailTemplateOfThatName() throws Exception {
    MailTemplate result = mailTemplateRepository.findByName("JAVA TEMPLATE");
    assertThat(result.getName(), is("JAVA TEMPLATE"));
    assertThat(result.getTemplate(), is("<!DOCTYPE html></html>"));

  }

}