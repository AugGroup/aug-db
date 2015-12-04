/**
 *
 * @author Preeyaporn
 * @date 5 มิ.ย. 2558
 */
package com.aug.hrdb.entities;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "MAS_ALLOWANCES")
public class MasAllowance extends BaseEntity{

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;
	
	@Column(name = "ALLOWANCES_TYPE" ,nullable = false)
	private String allowances_type;
	
	@Column(name = "AMOUNT_ALLOWANCES")
	private Double amount_allowances;

	@Column(name = "CODE",nullable =false)
	private String code;
	
	@Column(name = "ISACTIVE" ,nullable =false)
	private Boolean isactive;
	
	@JsonIgnore
	@OneToMany(mappedBy = "masallowances")
	private Set<Allowance> allowances = new HashSet<Allowance>();

	/*---------------------- getter / setter ----------------------*/
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAllowances_type() {
		return allowances_type;
	}

	public void setAllowances_type(String allowances_type) {
		this.allowances_type = allowances_type;
	}

	public Double getAmount_allowances() {
		return amount_allowances;
	}

	public void setAmount_allowances(Double amount_allowances) {
		this.amount_allowances = amount_allowances;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Boolean getIsactive() {
		return isactive;
	}

	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}

	public Set<Allowance> getAllowances() {
		return allowances;
	}

	public void setAllowances(Set<Allowance> allowances) {
		this.allowances = allowances;
	}
	
}
