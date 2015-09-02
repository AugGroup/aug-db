/**
 *
 * @author natechanok
 * @date May 24, 2015
 */

package com.aug.hrdb.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

import org.springframework.stereotype.Component;


@NamedNativeQueries({
	@NamedNativeQuery(
			name="searchAddress",
			query="select address.ID,address.ADDRESSTYPE_ID,mas_addresstype.ADDRESSTYPENAME,address.HOUSE_NO,address.ROAD,address.DISTRICT,address.SUB_DISTRICT,address.PROVINCE_ID,mas_province.PROVINCENAME,address.ZIPCODE,address.EMPLOYEE_ID "
					+ "from EMP_ADDRESS as address join EMP_EMPLOYEE as employee on address.EMPLOYEE_ID = employee.ID "
					+ "join MAS_ADDRESSTYPE as mas_addresstype on mas_addresstype.ID = address.ADDRESSTYPE_ID "
					+ "join MAS_PROVINCE  as mas_province on mas_province.ID = address.PROVINCE_ID "
					+ "where address.EMPLOYEE_ID=:empId",
			resultClass = AddressDto.class)

})


@Component
@Entity
public class AddressDto {
	
	@Id
	@Column(name="ID")
	private Integer id;
	
	/*@Column(name="ADDRESSTYPE_ID")
	private Integer addressTypeId;
	
	
	@Column(name = "ADDRESSTYPENAME")
	private String masaddresstypeName;*/
	
	@Column(name="HOUSE_NO")
	private String houseNo;
	
	@Column(name="ROAD")
	private String road;
	
	@Column(name="DISTRICT")
	private String district;
	
	@Column(name="SUB_DISTRICT")
	private String subDistrict;;
	
	/*@Column(name = "PROVINCE_ID")
	private Integer masprovinceId;
	
	@Column(name = "PROVINCENAME")
	private String masprovinceName;*/
	
	@Column(name="ZIPCODE")
	private Integer zipcode;
	
	/*@Column(name ="EMPLOYEE_ID")
	private Integer employeeId;	
	
	@Transient
	private String status;
*/

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	/*public Integer getAddressTypeId() {
		return addressTypeId;
	}


	public void setAddressTypeId(Integer addressTypeId) {
		this.addressTypeId = addressTypeId;
	}


	public String getMasaddresstypeName() {
		return masaddresstypeName;
	}*/

/*
	public void setMasaddresstypeName(String masaddresstypeName) {
		this.masaddresstypeName = masaddresstypeName;
	}


	
	public Integer getMasprovinceId() {
		return masprovinceId;
	}


	public void setMasprovinceId(Integer masprovinceId) {
		this.masprovinceId = masprovinceId;
	}*/

	/*public Integer getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
*/

	/*public String getMasprovinceName() {
		return masprovinceName;
	}


	public void setMasprovinceName(String masprovinceName) {
		this.masprovinceName = masprovinceName;
	}*/


	public Integer getZipcode() {
		return zipcode;
	}


	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}


	/*public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}*/


	public String getHouseNo() {
		return houseNo;
	}


	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}


	public String getRoad() {
		return road;
	}


	public void setRoad(String road) {
		this.road = road;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public String getSubDistrict() {
		return subDistrict;
	}


	public void setSubDistrict(String subDistrict) {
		this.subDistrict = subDistrict;
	}


	
	
	
}
