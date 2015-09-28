/**
 *
 * @author natechanok
 * @date May 20, 2015
 */

package com.aug.hrdb.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

@NamedNativeQueries({
	@NamedNativeQuery(
			 name = "listEmployeeAim",
	            query = "select emp.ID, emp.NAME_ENG, emp.AIM_EMP_ID from EMPLOYEE as emp where ISMANAGER IS NOT NULL", 
	            resultClass = AimEmployeeDto.class),
	@NamedNativeQuery(
			 name = "listEmployeeAimUpdateEmployee",
	            query = "select emp.ID, emp.NAME_ENG, emp.AIM_EMP_ID from EMPLOYEE as emp where ISMANAGER IS NOT NULL and emp.ID !=:empId", 
	            resultClass = AimEmployeeDto.class)
	  })

@Entity
public class AimEmployeeDto {
	
	@Id
	@Column(name ="ID")
	private Integer id;
	
	@Column(name ="NAME_ENG")
	private String name_eng;
	
	@Column(name ="AIM_EMP_ID")
	private String aimempid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName_eng() {
		return name_eng;
	}

	public void setName_eng(String name_eng) {
		this.name_eng = name_eng;
	}

	public String getAimempid() {
		return aimempid;
	}

	public void setAimempid(String aimempid) {
		this.aimempid = aimempid;
	}

	
	

}
