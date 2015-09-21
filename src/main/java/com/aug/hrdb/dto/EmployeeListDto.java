package com.aug.hrdb.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

@NamedNativeQueries({
	@NamedNativeQuery(
            name = "searchEmployee",
              query = "select emp.ID as ID,emp.employee_code as EMPLOYEE_CODE,emp.name_eng  as NAME_ENG,emp.surname_eng as SURNAME_ENG "
              		+ "from employee as emp",             		
            resultClass = EmployeeListDto.class)
  })


@Entity
public class EmployeeListDto {
	

	
	private Integer id;
	private String employeeCode;
	private String nameEng;
	private String surnameEng;
	
	@Id
	@Column(name="ID")
	public Integer getId() {
		return id;
	}
	
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="EMPLOYEE_CODE")
	public String getEmployeeCode() {
		return employeeCode;
	}
	
	
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	
	
	
	@Column(name="NAME_ENG")
	public String getNameEng() {
		return nameEng;
	}
	
	
	public void setNameEng(String nameEng) {
		this.nameEng = nameEng;
	}
	
	
	@Column(name="SURNAME_ENG")
	public String getSurnameEng() {
		return surnameEng;
	}
	
	
	public void setSurnameEng(String surnameEng) {
		this.surnameEng = surnameEng;
	}
	
	
	
	

}
