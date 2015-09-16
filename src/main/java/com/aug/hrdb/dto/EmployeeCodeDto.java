package com.aug.hrdb.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;


@NamedNativeQueries({
	@NamedNativeQuery(
            name = "runningNo",
              query = "select emp.LOCATION_ID,SUBSTRING(EMPLOYEE_CODE,5,3) as RUNNING_NO from EMPLOYEE emp join MAS_LOCATION location on emp.LOCATION_ID=location.ID "
              		+ "where location.CODE=:location "
              		+ "order by emp.ID desc "
              		+ "LIMIT 1",
            resultClass = EmployeeCodeDto.class)
  })




@Entity
public class EmployeeCodeDto {
	
	private Integer id;
	private Integer rungingNumber;
	
	@Id
	@Column(name="LOCATION_ID")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="RUNNING_NO")
	public Integer getRungingNumber() {
		return rungingNumber;
	}
	
	
	public void setRungingNumber(Integer rungingNumber) {
		this.rungingNumber = rungingNumber;
	}
	
	

}
