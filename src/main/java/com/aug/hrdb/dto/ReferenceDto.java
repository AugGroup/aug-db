package com.aug.hrdb.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

@NamedNativeQueries({
	@NamedNativeQuery(
            name = "searchReference",
            query = "select ref.id,ref.name,"
            		+ "ref.address, ref.telephone,"
            		+ "ref.occupation,"
            		+ "ref.applicant_id "
            		+ "from reference as ref "
            		+ "where ref.applicant_id=:appId", 
            resultClass = ReferenceDto.class),
	@NamedNativeQuery(name = "SEARCH_REFERENCE_ID", query = "select ref.id,ref.name,"
            		+ "ref.address, ref.telephone,"
            		+ "ref.occupation,"
            		+ "ref.applicant_id"
            		+ "from reference as ref"
            		+ " FROM REFERENCE ref WHERE ref.ID =:ID", resultClass = ReferenceDto.class)
	})
@Entity
public class ReferenceDto {
	@Id
	private Integer id;	
	private String name;		
	private String address;
	@Column(name="TELEPHONE")
	private String tel;
	private String occupation;
	@Column(name="APPLICANT_ID")
	private Integer applicantId;
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Integer getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(Integer applicantId) {
		this.applicantId = applicantId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
}
