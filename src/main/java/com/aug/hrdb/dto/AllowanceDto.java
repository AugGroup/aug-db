/**
 *
 * @author Preeyaporn
 * @date 3 มิ.ย. 2558
 */
package com.aug.hrdb.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

@NamedNativeQueries({
	@NamedNativeQuery(
			name="searchAllowances",
			query="SELECT ALLOWANCE.ID,"
					+ "ALLOWANCE.AMOUNT,"
					+ "ALLOWANCE.EMPLOYEE_ID,"
					+ "MAS_ALLOWANCE.ALLOWANCE_TYPE,"
					+ "ALLOWANCE.EMPLOYEE_ID,"
					+ "MAS_ALLOWANCE.ID as ALLO_ID, "
					+ "MAS_ALLOWANCE.AMOUNT_ALLOWANCE "
					+ "from ALLOWANCE,"
					+ "EMPLOYEE as emp ,"
					+ "MAS_ALLOWANCE "
					+ "where "
					+ "ALLOWANCE.EMPLOYEE_ID = :empId "
					+ "and ALLOWANCE.EMPLOYEE_ID = :empId "
					+ "and ALLOWANCE.MAS_ALLOWANCE_ID = MAS_ALLOWANCE.ID",
			resultClass = AllowanceDto.class)
			
})

@Entity
public class AllowanceDto {

	@Id
	@Column(name ="ID")
	private Integer id;

	@Column(name = "AMOUNT")
	private Double amount;

	@Column(name = "ALLOWANCE_TYPE" )
	private String masAllowance;

	@Column(name ="EMPLOYEE_ID")
	private Integer employeeId;

	@Column(name ="ALLO_ID")
	private Integer masAllowanceId;

	@Column(name ="AMOUNT_ALLOWANCE")
	private Double masAllowanceAmount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getMasAllowance() {
		return masAllowance;
	}

	public void setMasAllowance(String masAllowance) {
		this.masAllowance = masAllowance;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getMasAllowanceId() {
		return masAllowanceId;
	}

	public void setMasAllowanceId(Integer masAllowanceId) {
		this.masAllowanceId = masAllowanceId;
	}

	public Double getMasAllowanceAmount() {
		return masAllowanceAmount;
	}

	public void setMasAllowanceAmount(Double masAllowanceAmount) {
		this.masAllowanceAmount = masAllowanceAmount;
	}

}
