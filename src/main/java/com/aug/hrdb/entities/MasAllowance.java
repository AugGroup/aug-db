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
@Table(name = "MAS_ALLOWANCE")
public class MasAllowance extends BaseEntity{

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;
	
	@Column(name = "ALLOWANCE_TYPE" ,nullable = false)
	private String allowance_type;
	
	@Column(name = "AMOUNT_ALLOWANCE")
	private Double amount_allowance;

	@Column(name = "CODE",nullable =false)
	private String code;
	
	@Column(name = "ISACTIVE" ,nullable =false)
	private Boolean isactive;
	
	@JsonIgnore
	@OneToMany(mappedBy = "masAllowance")
	private Set<Allowance> allowances = new HashSet<Allowance>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAllowance_type() {
		return allowance_type;
	}

	public void setAllowance_type(String allowance_type) {
		this.allowance_type = allowance_type;
	}

	public Double getAmount_allowance() {
		return amount_allowance;
	}

	public void setAmount_allowance(Double amount_allowance) {
		this.amount_allowance = amount_allowance;
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
