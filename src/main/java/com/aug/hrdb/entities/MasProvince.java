/**
 *
  * @author natechanok
 * @date Apr 22, 2015
 */
package com.aug.hrdb.entities;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "MAS_PROVINCE")
public class MasProvince extends BaseEntity {
	
	@Id @GeneratedValue @Column(name = "ID")
	private Integer id;
	
	@Column(name = "PROVINCENAME", nullable = false)
	private String name;
	
	@Column(name = "CODE",nullable = false)
	private String code;
	
	@Column(name = "ISACTIVE", nullable = false)
	private Boolean isActive;
	
	@JsonIgnore
	@OneToMany(mappedBy = "province", fetch = FetchType.LAZY)
	private List<Address> addresses;

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

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	 
}