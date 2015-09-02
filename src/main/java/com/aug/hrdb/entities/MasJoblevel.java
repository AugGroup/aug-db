package com.aug.hrdb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MAS_JOBLEVEL")
public class MasJoblevel extends BaseEntity {
	
	@Id
	@Column(name="ID" ,nullable=false)
	@GeneratedValue
	private Integer id;
	
	@Column(name="NAME" ,nullable = false)
	private String name;
	
	@Column(name = "CODE" ,nullable = false)
	private String code;
	
	@Column(name = "ISACTIVE" ,nullable = false)
	private Boolean isActive;

//	@OneToMany(mappedBy="masJoblevel",fetch=FetchType.LAZY)
//	private Set<Employee> employees = new HashSet<Employee>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
}
