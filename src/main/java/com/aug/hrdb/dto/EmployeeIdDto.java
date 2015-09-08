package com.aug.hrdb.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

@NamedNativeQueries({
	@NamedNativeQuery(
            name = "findCurrentId",
              query = "select ID from EMPLOYEE "
              		+ "order by createdTimeStamp desc "
              		+ "LIMIT 1",
            resultClass = EmployeeIdDto.class)
  })



@Entity
public class EmployeeIdDto {
	
	@Id
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
