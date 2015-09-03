/**
 *
 * @author natechanok
 * @date Apr 22, 2015
 */

package com.aug.hrdb.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="MAS_ADDRESSTYPE")
public class MasAddressType extends BaseEntity{
	
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Integer id;
	
	@Column(name="ADDRESSTYPENAME",nullable = false)
	private String name;
	
	@Column(name="ISACTIVE", nullable = false)
	private String isActive;
	
	@Column(name="CODE",nullable = false)
	private String code;
	
	 @OneToMany(mappedBy = "addressType")
	 private Set<Address> addresses = new HashSet<Address>();

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

	public String getIsactive() {
		return isActive;
	}

	public void setIsactive(String isactive) {
		this.isActive = isactive;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
	
}
