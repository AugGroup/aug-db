package com.aug.hrdb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MailTemplate;
import com.aug.hrdb.repositories.MailTemplateRepository;
import com.aug.hrdb.services.MailTemplateService;


@Service("mailTemplateService")
@Transactional
public class MailTemplateServiceImpl implements MailTemplateService{
	
	@Autowired
	private MailTemplateRepository mailTemplateRepository;
	
	public MailTemplate findById(Integer id) {
		return mailTemplateRepository.find(id);
	}
	
	public MailTemplate findByName(String name){
		return mailTemplateRepository.findByName(name);
	}

	public List<MailTemplate> findAll() {
		return mailTemplateRepository.findAll();
	}

	public void create(MailTemplate model) {
		mailTemplateRepository.create(model);
	}

	public void update(MailTemplate model) {
		mailTemplateRepository.update(model);
	}

	public void delete(MailTemplate model) {
		mailTemplateRepository.delete(model);
	}
	
	public void deleteById(Integer id) {
		mailTemplateRepository.deleteById(id);
	}
}
