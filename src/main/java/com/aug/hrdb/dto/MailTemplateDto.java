package com.aug.hrdb.dto;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@NamedQueries(
		@NamedQuery(name = "FIND_BY_NAME_MAIL_TEMPLATE", query = "FROM MailTemplate WHERE name =:NAME")
	)
@Component
@Entity
public class MailTemplateDto {
	
	@Id
	@Column(name="ID")
	private Integer id;
	
	private String name;
	
	@Column(columnDefinition="TEXT")
	private String template;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}	
}