package com.aug.hrdb.repositories;

import com.aug.hrdb.entities.MailTemplate;
import com.aug.hrdb.repositories.MailTemplateRepository;

public interface MailTemplateRepository extends GenericRepository<MailTemplate,Integer>{

	public MailTemplate findByName(String name);

}
