package com.aug.hrdb.services;

import com.aug.hrdb.entities.MailTemplate;

public interface MailTemplateService {
	
	public MailTemplate findById(Integer id);
	
	public MailTemplate findByName(String name);

	public void create(MailTemplate model);

	public void update(MailTemplate model);

	public void delete(MailTemplate model); 
	
}
