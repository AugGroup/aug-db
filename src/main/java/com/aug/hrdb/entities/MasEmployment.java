/**
 *
 * @author natechanok
 * @date Apr 21, 2015
 */

package com.aug.hrdb.entities;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "MAS_EMPLOYMENT")
public class MasEmployment extends BaseEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "ID", length = 10)
	
	
	private Integer id;
	
	@Column(name = "NAME", nullable = false, length = 200)
	private String name;
	
	@Column(name = "CODE", nullable = false)
	private String code;
	
	@Column(name = "ISACTIVE", nullable = false)
	private Boolean isActive;

	
	/*@OneToMany(mappedBy = "masEmployment")
	private Set<Employee> employees = new HashSet<Employee>();*/


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


	/*public Set<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}*/


	/*@Override
	public String toString() {
		return "MasEmployment [id=" + id + ", name=" + name + ", code=" + code
				+ ", isActive=" + isActive + ", employees=" + employees + "]";
	}*/



}
