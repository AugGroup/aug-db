package com.aug.hrdb.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name = "MAS_SPECIALTY")
public class MasSpecialty extends BaseEntity{
	
	@Id
	@Column(name="SPEC_ID")
	@GeneratedValue
	private Integer id;

	@Column(name = "NAME" ,nullable = false)
	private String name;
	
	@Column(name = "CODE" ,nullable = false)
	private String code;
	
	@Column(name = "ISACTIVE")
	private Boolean isActive;
	
//	@JsonIgnore
	@OneToMany(mappedBy = "masspecialty")

	private Set<Ability> abilities;

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




	public Set<Ability> getAbilities() {
		return abilities;
	}




	public void setAbilities(Set<Ability> abilities) {
		this.abilities = abilities;
	}
	
	
	
	
}
