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
			query="select allowances.id,"
					+ "allowances.amount,"
					+ "allowances.EMPLOYEE_ID,"
					+ "mas_allowances.ALLOWANCES_TYPE,"
					+ "allowances.EMPLOYEE_ID,"
					+ "mas_allowances.ALLO_ID, "
					+ "mas_allowances.AMOUNT_ALLOWANCES "
					+ "from allowances,"
					+ "employee as emp ,"
					+ "mas_allowances "
					+ "where "
					+ "allowances.employee_id=:empId "
					+ "and allowances.employee_id = emp.id "
					+ "and allowances.MAS_ALLOWANCES_ID = mas_allowances.ALLO_ID",																																																																					
			resultClass = AllowancesDto.class)
			
})

@Entity
public class AllowancesDto {

	@Column(name ="ID")
	@Id
	private Integer id;
	@Column(name = "AMOUNT")
	private Double amount;
	@Column(name = "ALLOWANCES_TYPE" )
	private String masallowances;
	@Column(name ="EMPLOYEE_ID")
	private Integer employeeId;
	@Column(name ="ALLO_ID")
	private Integer masAllowancesId;
	@Column(name ="AMOUNT_ALLOWANCES")
	private Double masAllowancesAmount;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMasallowances() {
		return masallowances;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public void setMasallowances(String masallowances) {
		this.masallowances = masallowances;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public Integer getMasAllowancesId() {
		return masAllowancesId;
	}
	public void setMasAllowancesId(Integer masAllowancesId) {
		this.masAllowancesId = masAllowancesId;
	}
	public Double getMasAllowancesAmount() {
		return masAllowancesAmount;
	}
	public void setMasAllowancesAmount(Double masAllowancesAmount) {
		this.masAllowancesAmount = masAllowancesAmount;
	}
	
}
