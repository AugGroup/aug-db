package com.aug.hrdb.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;


@NamedNativeQueries({
    @NamedNativeQuery(
            name = "searchPasswordByEmail",
            query =   "SELECT emp.id,"
            		+ "email ,password "
            		+ "FROM login as log,applicant as app,employee as emp "
            		+ "WHERE emp.id = log.id AND app.id=emp.id AND app.email =:EMAIL",
            resultClass = CardDto.class),
})

@Entity
public class LoginForgotDto {
	@Column(name = "ID")
	@Id
	private Integer id;	
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
