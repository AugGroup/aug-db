package com.aug.hrdb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.repositories.MailTemplateRepository;

@Service
@Transactional
public class MailTemplateDtoService {

	@Autowired
	private MailTemplateRepository mailTemplateRepository;
	
	
}
