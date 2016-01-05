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

import com.aug.hrdb.dto.AllowanceDto;

@Entity
@Table(name = "ALLOWANCE")
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
	@JoinColumn(name = "MAS_ALLOWANCE_ID", referencedColumnName="ID", nullable = false)
	private MasAllowance masAllowance;

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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public MasAllowance getMasAllowance() {
		return masAllowance;
	}

	public void setMasAllowance(MasAllowance masAllowance) {
		this.masAllowance = masAllowance;
	}

	public Allowance fromAllowanceDto(Allowance allowance, AllowanceDto allowanceDto) {
		allowance.setAmount(allowanceDto.getAmount());
		Employee employee = new Employee();
		employee.setId(allowanceDto.getEmployeeId());
		allowance.setEmployee(employee);
		MasAllowance masAllowances = new MasAllowance();
		masAllowances.setId(allowanceDto.getMasAllowanceId());
		masAllowances.setAllowance_type(allowanceDto.getMasAllowance());
		allowance.setMasAllowance(masAllowances);

		return allowance;

	}

	public AllowanceDto toAllowanceDto() {
		AllowanceDto allowancesDto = new AllowanceDto();
		allowancesDto.setId(this.id);
		allowancesDto.setAmount(this.amount);
		allowancesDto.setEmployeeId(this.employee.getId());
		allowancesDto.setMasAllowanceId(this.masAllowance.getId());
		allowancesDto.setMasAllowance(this.masAllowance.getAllowance_type());

		return allowancesDto;

	}
	
}
