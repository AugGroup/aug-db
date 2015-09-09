/**
 *
 * @author Pranrajit
 * @date 25 พ.ค. 2558
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


@Entity
@Table(name="MAS_LEAVETYPE")
public class MasLeaveType extends BaseEntity{
	@Id
	@Column(name = "LEAVETYPE_ID")
	@GeneratedValue
	private Integer id;

	@Column(name = "NAME", nullable = false)
	private String name;
	
	@Column(name = "CODE",nullable =false)
	private String code;
	
	@Column(name = "ISACTIVE" ,nullable =false)
	private Boolean isactive;

	@OneToMany(mappedBy = "masleavetype")
	//@JsonManagedReference
	private Set<Leave> leaves = new HashSet<Leave>();

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

	public Boolean getIsactive() {
		return isactive;
	}

	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}

	public Set<Leave> getLeaves() {
		return leaves;
	}

	public void setLeaves(Set<Leave> leaves) {
		this.leaves = leaves;
	}

}
