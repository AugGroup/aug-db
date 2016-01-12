package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.entities.MailTemplate;

public interface MailTemplateService {
	
	MailTemplate findById(Integer id);
	
	MailTemplate findByName(String name);
	
	List<MailTemplate> findAll();

	void create(MailTemplate model);

	void update(MailTemplate model);

	void delete(MailTemplate model);
	
	void deleteById (Integer id);
	
}