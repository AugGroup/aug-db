/**
 *
 * @author Pranrajit
 * @date 19 พ.ค. 2558
 */
package com.aug.hrdb.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;










@NamedNativeQueries({
	@NamedNativeQuery(
			name="searchAbility",

			query="select ability.id, "
					+ "ability.rank, "
					+ "mas_specialty.name, "
					+ "ability.applicant_id,"
					+ "mas_specialty.id as SPEC_ID "
					+ "from ability, mas_specialty "
					+ "WHERE ability.APPLICANT_ID=:ID and ability.specialty_id = mas_specialty.id",
					/*+ ""
					+					+ ",employee as emp, mas_specialty "
					+					+ "where ability.employee_id=:empId and ability.employee_id = emp.id"
					+					+ " and  ability.specialty_id = mas_specialty.ID ",
					+					
					+					
					+					FROM EDUCATION ed LEFT JOIN MAS_DEGREETYPE as mas_degreetype on mas_degreetype.ID = ed.DEGREETYPE_ID "
					+							+ "LEFT JOIN APPLICANT a on ed.APPLICANT_ID = a.APPLICANT_ID WHERE ed.APPLICANT_ID =:ID", resultClass = EducationDto.class),
					+							*/

									
					resultClass = AbilityDto.class)	
})



@Entity
public class AbilityDto {
	@Column(name="ID")
	@Id
	private Integer id;
	@Column(name = "RANK",nullable = false)
	private Integer rank;
	
	@Column(name = "NAME")
	private String masspecialty;
	
	/*@Column(name ="EMPLOYEE_ID")
	private Integer employeeId;	
	@Column(name = "EMPLOYEE_CODE")
	private String employeeCode;
	*/
	@Column(name = "SPEC_ID")
	private Integer masspecialtyId;
	
	
	
	@Column(name="APPLICANT_ID")
	private Integer applicantId;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	

/*	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}*/

	public String getMasspecialty() {
		return masspecialty;
	}

	public void setMasspecialty(String masspecialty) {
		this.masspecialty = masspecialty;
	}

	public Integer getMasspecialtyId() {
		return masspecialtyId;
	}

	public void setMasspecialtyId(Integer masspecialtyId) {
		this.masspecialtyId = masspecialtyId;
	}

	public Integer getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(Integer applicantId) {
		this.applicantId = applicantId;
	}

	



	
	
	
	
}
