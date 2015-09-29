package com.aug.hrdb.entities;

import javax.persistence.*;

@NamedQueries(
		@NamedQuery(name = "FIND_BY_NAME_MAIL_TEMPLATE", query = "FROM MailTemplate WHERE name =:NAME")
	)
@Table(name="MAIL_TEMPLATE")
@Entity
public class MailTemplate {
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Integer id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="TEMPLATE",columnDefinition="TEXT")
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