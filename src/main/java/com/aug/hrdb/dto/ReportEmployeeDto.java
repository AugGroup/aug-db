package com.aug.hrdb.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

@NamedNativeQueries({
	@NamedNativeQuery(
            name = "reportEmployee",
            query = "Select emp.id, "
            		+ "emp.employee_code as employeeCode,"
            		+ "CAST(official.start_work_date as DATE) as startWorkDate, "
            		+ "exp.salary as salary, "
            		+ "YEAR(CURDATE()) - YEAR(official.start_work_date) - IF(STR_TO_DATE(CONCAT(YEAR(CURDATE()), '-', MONTH(official.start_work_date), '-', DAY(official.start_work_date)) ,'%Y-%c-%e') > CURDATE(), 1, 0) as yearStart, "
            		+ "MONTH(curdate()) - MONTH(official.start_work_date) - IF(STR_TO_DATE(CONCAT(YEAR(CURDATE()), '-', MONTH(official.start_work_date), '-', DAY(official.start_work_date)) ,'%Y-%c-%e') > CURDATE(), 1, 0) as monthStart, "
            		+ "DAY(curdate()) - DAY(official.start_work_date) - IF(STR_TO_DATE(CONCAT(YEAR(CURDATE()), '-', MONTH(official.start_work_date), '-', DAY(official.start_work_date)) ,'%Y-%c-%e') > CURDATE(), 1, 0) as dayStart, "
            		+ "CAST(app.BIRTHDATE as DATE) as dateOfBirth, "
            		+ "YEAR(CURDATE()) - YEAR(app.BIRTHDATE) - IF(STR_TO_DATE(CONCAT(YEAR(CURDATE()), '-', MONTH(app.BIRTHDATE), '-', DAY(app.BIRTHDATE)) ,'%Y-%c-%e') > CURDATE(), 1, 0) as year, "
            		+ "MONTH(curdate()) - MONTH(app.BIRTHDATE) - IF(STR_TO_DATE(CONCAT(YEAR(CURDATE()), '-', MONTH(app.BIRTHDATE), '-', DAY(app.BIRTHDATE)) ,'%Y-%c-%e') > CURDATE(), 1, 0) as month, "
            		+ "DAY(curdate()) - DAY(app.BIRTHDATE) - IF(STR_TO_DATE(CONCAT(YEAR(CURDATE()), '-', MONTH(app.BIRTHDATE), '-', DAY(app.BIRTHDATE)) ,'%Y-%c-%e') > CURDATE(), 1, 0) as day, "
            		+ "app.FIRSTNAME_TH as nameThai, "
            		+ "app.FIRSTNAME_EN as nameEng, "
            		+ "app.NICKNAME_EN as nicknameEng, "
            		+ "app.tel as telMobile, "
            		+ "app.email as email, "
            		+ "mas_employment.name as employmentName, "
            		+ "mas_division.name as divisionName, "
            		+ "mas_technology.name as technologyName "
            		+ "from applicant as app "
            		+ "left join employee as emp on emp.applicant_id = app.id "
            		+ "left join official as official on app.official_id = official.id "
            		+ "left join mas_employment on emp.employment_id = mas_employment.id "
            		+ "left join mas_division on emp.division_id = mas_division.id "
            		+ "left join mas_technology on app.mastechnology_id = mas_technology.id "
            		+ "left join experience as exp on exp.applicant_id =app.id "
            		+ "where app.FIRSTNAME_EN like :name", 
            resultClass = ReportEmployeeDto.class),
            @NamedNativeQuery(
                    name = "reportEmployeeCode",
                    query = "Select emp.id, "
                    		+ "emp.employee_code as employeeCode,"
                    		+ "CAST(official.start_work_date as DATE) as startWorkDate, "
                    		+ "exp.salary as salary, "
                    		+ "YEAR(CURDATE()) - YEAR(official.start_work_date) - IF(STR_TO_DATE(CONCAT(YEAR(CURDATE()), '-', MONTH(official.start_work_date), '-', DAY(official.start_work_date)) ,'%Y-%c-%e') > CURDATE(), 1, 0) as yearStart, "
                    		+ "MONTH(curdate()) - MONTH(official.start_work_date) - IF(STR_TO_DATE(CONCAT(YEAR(CURDATE()), '-', MONTH(official.start_work_date), '-', DAY(official.start_work_date)) ,'%Y-%c-%e') > CURDATE(), 1, 0) as monthStart, "
                    		+ "DAY(curdate()) - DAY(official.start_work_date) - IF(STR_TO_DATE(CONCAT(YEAR(CURDATE()), '-', MONTH(official.start_work_date), '-', DAY(official.start_work_date)) ,'%Y-%c-%e') > CURDATE(), 1, 0) as dayStart, "
                    		+ "CAST(app.BIRTHDATE as DATE) as dateOfBirth, "
                    		+ "YEAR(CURDATE()) - YEAR(app.BIRTHDATE) - IF(STR_TO_DATE(CONCAT(YEAR(CURDATE()), '-', MONTH(app.BIRTHDATE), '-', DAY(app.BIRTHDATE)) ,'%Y-%c-%e') > CURDATE(), 1, 0) as year, "
                    		+ "MONTH(curdate()) - MONTH(app.BIRTHDATE) - IF(STR_TO_DATE(CONCAT(YEAR(CURDATE()), '-', MONTH(app.BIRTHDATE), '-', DAY(app.BIRTHDATE)) ,'%Y-%c-%e') > CURDATE(), 1, 0) as month, "
                    		+ "DAY(curdate()) - DAY(app.BIRTHDATE) - IF(STR_TO_DATE(CONCAT(YEAR(CURDATE()), '-', MONTH(app.BIRTHDATE), '-', DAY(app.BIRTHDATE)) ,'%Y-%c-%e') > CURDATE(), 1, 0) as day, "
                    		+ "app.FIRSTNAME_TH as nameThai, "
                    		+ "app.FIRSTNAME_EN as nameEng, "
                    		+ "app.NICKNAME_EN as nicknameEng, "
                    		+ "app.tel as telMobile, "
                    		+ "app.email as email, "
                    		+ "mas_employment.name as employmentName, "
                    		+ "mas_division.name as divisionName, "
                    		+ "mas_technology.name as technologyName "
                    		+ "from applicant as app "
                    		+ "left join employee as emp on emp.applicant_id = app.id "
                    		+ "join official as official on app.official_id = official.id "
                    		+ "join mas_employment on emp.employment_id = mas_employment.id "
                    		+ "join mas_division on emp.division_id = mas_division.id "
                    		+ "join mas_technology on app.mastechnology_id = mas_technology.id "
                    		+ "join experience as exp on exp.applicant_id =app.id "
                    		+ "where emp.employee_code like :code", 
                    resultClass = ReportEmployeeDto.class)
  })
@Entity
public class ReportEmployeeDto {
	
	@Id
	@Column(name ="ID")
	private Integer id;
	@Column(name = "employeeCode")
	private String employeeCode;
	@Column(name = "startWorkDate")
	private String startWorkDate;
	@Column(name = "yearStart")
	private Integer yearStart;
	@Column(name = "monthStart")
	private Integer monthStart;
	@Column(name = "dayStart")
	private Integer dayStart;
	@Column(name = "dateOfBirth")
	private String dateOfBirth;
	@Column(name = "nameEng")
	private String nameEng;
	@Column(name = "nameThai")
	private String nameThai;
	@Column(name = "nicknameEng")
	private String nicknameEng;
	@Column(name = "telMobile")
	private String telMobile;
	@Column(name = "year")
	private Integer year;
	@Column(name = "month")
	private Integer month;
	@Column(name = "day")
	private Integer day;
	@Column(name = "email")
	private String email;
	@Column(name = "employmentName")
	private String employmentName;
	@Column(name = "divisionName")
	private String divisionName;
	@Column(name = "technologyName")
	private String technologyName;
	@Column(name = "SALARY")
	private Integer salary;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getStartWorkDate() {
		return startWorkDate;
	}
	public void setStartWorkDate(String startWorkDate) {
		this.startWorkDate = startWorkDate;
	}
	public Integer getYearStart() {
		return yearStart;
	}
	public void setYearStart(Integer yearStart) {
		this.yearStart = yearStart;
	}
	public Integer getMonthStart() {
		return monthStart;
	}
	public void setMonthStart(Integer monthStart) {
		this.monthStart = monthStart;
	}
	public Integer getDayStart() {
		return dayStart;
	}
	public void setDayStart(Integer dayStart) {
		this.dayStart = dayStart;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getNameEng() {
		return nameEng;
	}
	public void setNameEng(String nameEng) {
		this.nameEng = nameEng;
	}
	public String getNameThai() {
		return nameThai;
	}
	public void setNameThai(String nameThai) {
		this.nameThai = nameThai;
	}
	public String getNicknameEng() {
		return nicknameEng;
	}
	public void setNicknameEng(String nicknameEng) {
		this.nicknameEng = nicknameEng;
	}
	public String getTelMobile() {
		return telMobile;
	}
	public void setTelMobile(String telMobile) {
		this.telMobile = telMobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmploymentName() {
		return employmentName;
	}
	public void setEmploymentName(String employmentName) {
		this.employmentName = employmentName;
	}
	public String getDivisionName() {
		return divisionName;
	}
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}
	public String getTechnologyName() {
		return technologyName;
	}
	public void setTechnologyName(String technologyName) {
		this.technologyName = technologyName;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public Integer getDay() {
		return day;
	}
	public void setDay(Integer day) {
		this.day = day;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	
	
}
