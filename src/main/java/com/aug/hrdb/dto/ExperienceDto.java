package com.aug.hrdb.dto;

import java.util.Date;

import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

@NamedNativeQueries({
		@NamedNativeQuery(name = "SEARCH_EXPERIENCE", query = "SELECT e.id, e.address, e.typeOfBusiness, e.dateFrom, e.dateTo, e.position, e.reason, e.reference, e.responsibility, e.salary"
				+ " FROM EXPERIENCE e LEFT JOIN APPLICANT a on e.APPLICANT_ID = a.APPLICANT_ID WHERE e.APPLICANT_ID = :ID", resultClass = ExperienceDto.class),

		@NamedNativeQuery(name = "SEARCH_EXPERIENCE_ID", query = "SELECT e.id, e.address, e.typeOfBusiness, e.dateFrom, e.dateTo, e.position, e.reason, e.reference, e.responsibility, e.salary" 
				+ " FROM EXPERIENCE e WHERE e.id = :ID", resultClass = ExperienceDto.class) })

public class ExperienceDto {
	/*
	 * @JoinColumn(name="APPLICANT_ID") private Applicant applicant;
	 * 
	 * @JoinColumn(name="EMPLOYEE_ID") private Employee employee;
	 */

	private Integer id;

	private String address;

	private String typeOfBusiness;

	private Date dateFrom;

	private Date dateTo;

	private String position;

	private String reason;

	private String reference;

	private String responsibility;

	private long salary;
}
