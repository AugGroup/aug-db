package com.aug.hrdb.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

@NamedNativeQueries({
	@NamedNativeQuery(
            name = "searchReference",
            query = "select ref.id,ref.name, "
            		+ "ref.address, ref.tel, "
            		+ "ref.occupation, "
            		+ "ref.employee_id "
            		+ "from emp_reference as ref,emp_employee as emp "
            		+ "where ref.employee_id =:empId and ref.employee_id=emp.id", 
            resultClass = ReferenceDto.class)
  })

@Entity
public class ReferenceDto {
	@Id
	private Integer id;	
	private String name;		
	private String address;
	private String tel;
	private String occupation;
	private Integer employeeId;
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
}
