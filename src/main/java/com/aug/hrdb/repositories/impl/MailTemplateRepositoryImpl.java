package com.aug.hrdb.repositories.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.aug.hrdb.entities.MailTemplate;
import com.aug.hrdb.repositories.MailTemplateRepository;

@Repository(value = "mailTemplateRepository")
public class MailTemplateRepositoryImpl extends GenericRepositoryImpl<MailTemplate, Integer> implements MailTemplateRepository {

  public MailTemplateRepositoryImpl() {
    super(MailTemplate.class);
  }

  @Override
  public MailTemplate findByName(String name) {
    Query query = getCurrentSession().getNamedQuery("FIND_BY_NAME_MAIL_TEMPLATE");
    query.setParameter("NAME", name);
    List<MailTemplate> mailTemplates = query.list();

    if (mailTemplates != null) {
      return mailTemplates.get(0);
    }

    return null;

  }

}
