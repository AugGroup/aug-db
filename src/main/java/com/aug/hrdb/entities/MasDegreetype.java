/**
 *
 * @author Pranrajit
 * @date 22 เม.ย. 2558
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
@Table(name = "MAS_DEGREETYPE")
public class MasDegreetype extends BaseEntity{

	@Id
	@Column(name = "DEGREETYPE_ID")
	@GeneratedValue
	private Integer id;

	@Column(name = "NAME", nullable = false, length = 200)
	private String name;
	
	@Column(name = "CODE",nullable =false)
	private String code;
	
	@Column(name = "ISACTIVE" ,nullable =false)
	private Boolean isactive;
	
	@OneToMany(mappedBy = "masdegreetype")
	private Set<Education> educations = new HashSet<Education>();

	
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

	public Set<Education> getEducations() {
		return educations;
	}

	public void setEducations(Set<Education> educations) {
		this.educations = educations;
	}

}
