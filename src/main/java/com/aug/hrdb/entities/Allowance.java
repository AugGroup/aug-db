/**
 *
 * @author Preeyaporn
 * @date 3 มิ.ย. 2558
 */
package com.aug.hrdb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.aug.hrdb.dto.AllowancesDto;

@Entity
@Table(name = "ALLOWANCES")
public class Allowance extends BaseEntity{

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;
	
	@Column(name = "AMOUNT" ,nullable = false)
	private Double amount;

	@ManyToOne()
	@JoinColumn(name = "EMPLOYEE_ID", referencedColumnName="id", nullable = false)
	private Employee employee;
	
	@ManyToOne()
	@JoinColumn(name = "MAS_ALLOWANCES_ID", referencedColumnName="ID", nullable = false)
	private MasAllowance masallowance;
	
	/*---------------------- getter / setter ----------------------*/
	
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

	public MasAllowance getMasallowance() {
		return masallowance;
	}

	public void setMasallowances(MasAllowance masallowances) {
		this.masallowance = masallowances;
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Allowance fromAllowancesDto(Allowance allowances, AllowancesDto allowancesDto) {
		
		allowances.setAmount(allowancesDto.getAmount());
		
		Employee employee = new Employee();
		employee.setId(allowancesDto.getEmployeeId());
		allowances.setEmployee(employee);
		
		MasAllowance masAllowances = new MasAllowance();
		masAllowances.setId(allowancesDto.getMasAllowancesId());
		masAllowances.setAllowance_type(allowancesDto.getMasallowances());
		allowances.setMasallowances(masAllowances);
		
		return allowances;
	}

	
	public AllowancesDto toAllowancesDto() {
		
		AllowancesDto allowancesDto = new AllowancesDto();
		
		allowancesDto.setId(this.id);
		allowancesDto.setAmount(this.amount);
		allowancesDto.setEmployeeId(this.employee.getId());
		allowancesDto.setMasAllowancesId(this.masallowance.getId());
		allowancesDto.setMasallowances(this.masallowance.getAllowance_type());
		
		return allowancesDto;
	}
	
}
