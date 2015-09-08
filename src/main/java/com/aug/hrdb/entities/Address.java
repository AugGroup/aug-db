/**
 *
 * @author natechanok
 * @date Apr 22, 2015
 */

package com.aug.hrdb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;




@NamedNativeQueries({
	@NamedNativeQuery(
            name = "insertAddress",
            query = "insert into ADDRESS("
            		+ "HOUSE_NO,"
            		+ "ROAD,"
            		+ "DISTRICT,"
            		+ "SUB_DISTRICT,"
            		+ "ZIPCODE,"
            		+ "EMPLOYEE_ID,"
            		+ "ADDRESSTYPE_ID,"
            		+ "PROVINCE_ID,"
            		+ "createdTimeStamp,"
            	    + "createdBy,"
            	    + "auditFlag "
            		+ ") "
            		+ " values("
            		+ ":HOUSE_NO,"
            		+ ":ROAD,"
            		+ ":DISTRICT,"
            		+ ":SUB_DISTRICT,"
            		+ ":ZIPCODE,"
            		+ ":EMPLOYEE_ID,"
            		+ ":ADDRESSTYPE_ID,"
            		+ ":PROVINCE_ID,"
            		+ "NOW(),"
            	    + "0,"
            	    + "'C'" 
            		+ ")"
            	
            		,resultClass= Address.class),
            		
        @NamedNativeQuery(
            name = "updateAddress",
            query = "update ADDRESS set HOUSE_NO =:HOUSE_NO,"
            	     + "ROAD =:ROAD,"
            		 + "DISTRICT =:DISTRICT,"
            	     + "SUB_DISTRICT =:SUB_DISTRICT,"
            	     + "ZIPCODE =:ZIPCODE,"
            	     + "EMPLOYEE_ID =:EMPLOYEE_ID,"
            	     + "ADDRESSTYPE_ID =:ADDRESSTYPE_ID,"
            	     + "PROVINCE_ID =:PROVINCE_ID, "
            	     + "updatedTimeStamp = NOW(), "
                	 + "updatedBy =:updatedBy,"
                	 + "auditFlag ='U'"
            	     + "where ID =:ID",
            	     resultClass = Address.class),
            	     
         @NamedNativeQuery(
             name = "deleteAddress",
            	 query = "delete from ADDRESS where ID=:id",
            	 resultClass = Address.class),    	     
  })

@Entity
@Table(name = "ADDRESS",uniqueConstraints = {@UniqueConstraint(columnNames = {"HOUSE_NO","DISTRICT"})})
public class Address extends BaseEntity{
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Integer id;
	
	@Column(name="HOUSE_NO")
	private String houseNo;
	
	@Column(name="ROAD")
	private String road;
	
	@Column(name="DISTRICT")
	private String district;
	
	@Column(name="SUB_DISTRICT")
	private String subDistrict;
	
	@Column(name="ZIPCODE")
	private Integer zipcode;
	
	/*@Transient
    private Integer addressTypeId;
	@Transient
	private Integer provinceId;
   */
	
/*	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name= "EMPLOYEE_ID")

//	@JsonIgnore
    private Employee employee;*/
	
/*	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name= "ADDRESSTYPE_ID")

//	@JsonIgnore
    private MasAddressType addressType;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name= "PROVINCE_ID")

//	@JsonIgnore
    private MasProvince province;
	*/
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public Integer getZipcode() {
		return zipcode;
	}

	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}
	

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

	/*public Integer getAddressTypeId() {
		return addressTypeId;
	}

	public void setAddressTypeId(Integer addressTypeId) {
		this.addressTypeId = addressTypeId;
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}*/


	/*public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}*/


	/*public MasAddressType getAddressType() {
		return addressType;
	}

	public void setAddressType(MasAddressType addressType) {
		this.addressType = addressType;
	}

	public MasProvince getProvince() {
		return province;
	}

	public void setProvince(MasProvince province) {
		this.province = province;
	}
*/
	
	
}


