/**
 *
 * @author Pranrajit
 * @date 13 พ.ค. 2558
 */
package com.aug.hrdb.entities;



import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "MAS_LOCATION")
public class MasLocation extends BaseEntity {

	@Id
	@GeneratedValue
	@Column(name="ID")
	private Integer id;
	
	@Column(name = "NAME", nullable = false, length = 200)
	private String name;
	
	@Column(name = "CODE",nullable =false)
	private String code;
	
	@Column(name = "ISACTIVE" ,nullable =false)
	private Boolean isActive;
	
	
	@OneToMany(mappedBy = "masLocation", cascade=CascadeType.ALL, orphanRemoval=true)
	private Set<Employee> employees = new HashSet<Employee>();
	
	@OneToMany(mappedBy = "masLocation", cascade=CascadeType.ALL, orphanRemoval=true)
	private Set<Login> logins = new HashSet<Login>();
	


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


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	


	public Boolean getIsActive() {
		return isActive;
	}


	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}


	public Set<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}


	public Set<Login> getLogins() {
		return logins;
	}


	public void setLogins(Set<Login> logins) {
		this.logins = logins;
	}

	
	

	
	
}
