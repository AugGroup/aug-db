package com.aug.hrdb.repositories;

import com.aug.hrdb.entities.MailTemplate;

public interface MailTemplateRepository extends GenericRepository<MailTemplate,Integer>{

	MailTemplate findByName(String name);

}
