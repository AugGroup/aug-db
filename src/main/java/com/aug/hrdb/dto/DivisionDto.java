/**
 *
 * @author Pranrajit
 * @date 28 ต.ค. 2558
 */
package com.aug.hrdb.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

@Entity
@NamedNativeQueries({
	
	@NamedNativeQuery(name="CHECK_DIVISION",query="SELECT divi.ID,divi.NAME,divi.TAG "
			+ "FROM MAS_DIVISION divi "
			+ "WHERE divi.TAG=:TAG",resultClass=DivisionDto.class),
})


public class DivisionDto {
	
	@Id
	@Column(name = "ID")
	private Integer divisionId;
	
	@Column(name = "NAME")
	private String divisionName;
	
	@Column(name = "TAG")
	private String tag;

	

	public Integer getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(Integer divisionId) {
		this.divisionId = divisionId;
	}

	

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	
	
}
