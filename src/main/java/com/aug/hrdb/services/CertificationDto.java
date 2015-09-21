/**
 *
 * @author Preeyaporn
 * @date 25 พ.ค. 2558
 */
package com.aug.hrdb.services;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

@NamedNativeQueries({
	@NamedNativeQuery(
			name="searchCertification",
			query="select c.id,"
					+ "c.year,"
					+ "c.name, "
					+ "c.certification_from,"
					+ "c.description,"
					+ "c.employee_id "
					+ "from emp_certification as c,employee where c.employee_id=:empId  and c.employee_id = employee.id",																																																																					
			resultClass = CertificationDto.class)
			
})

@Entity
public class CertificationDto {

	@Column(name ="ID")
	@Id
	private Integer id;

	@Column(name = "YEAR")
	private String year;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "CERTIFICATION_FROM")
	private String certificationFrom;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "EMPLOYEE_ID")
	private Integer employeeId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCertificationFrom() {
		return certificationFrom;
	}

	public void setCertificationFrom(String certificationFrom) {
		this.certificationFrom = certificationFrom;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	
}
