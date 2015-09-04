package com.aug.hrdb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.aug.hrdb.dto.ReferenceDto;


@Entity
@Table(name = "REFERENCE")
public class Reference extends BaseEntity{

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "TELEPHONE", nullable = false)
	private String tel;
	
	@Column(name = "OCCUPATION", nullable = false)
	private String occupation;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	public ReferenceDto toReferenceDto(){
		ReferenceDto referenceDto = new ReferenceDto();
		referenceDto.setId(this.id);
		referenceDto.setName(this.name);
		referenceDto.setAddress(this.address);
		referenceDto.setTel(this.tel);
		referenceDto.setOccupation(this.occupation);
//		referenceDto.setEmployeeId(this.employee.getId());
		return referenceDto;
	}

	public Reference fromReferenceDto(Reference reference,ReferenceDto referenceDto){
		//Reference reference = new Reference();
		reference.setId(referenceDto.getId());
		reference.setName(referenceDto.getName());
		reference.setAddress(referenceDto.getAddress());
		reference.setTel(referenceDto.getTel());		reference.setOccupation(referenceDto.getOccupation());				
//		Employee employee = new Employee();
//		employee.setId(referenceDto.getEmployeeId());
//		reference.setEmployee(employee);
		return reference;
	}
	
}
