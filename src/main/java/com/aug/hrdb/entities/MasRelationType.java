package com.aug.hrdb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="MAS_RELATIONTYPE")
public class MasRelationType extends BaseEntity{
	
	private Integer id;
	private String  relationType;
	private String code;
	private Boolean isActive;


	
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	public Integer getId() {
		return id;
	}
	
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	@Column(name="RELATIONTYPE",nullable=false)
	public String getRelationType() {
		return relationType;
	}
	
	
	
	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}


	@Column(name = "CODE", nullable = false, length = 10)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
	@Column(name = "ISACTIVE", nullable = false)
	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}


	
	 


}
