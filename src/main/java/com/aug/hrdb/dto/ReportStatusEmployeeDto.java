package com.aug.hrdb.dto;



import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import com.fasterxml.jackson.annotation.JsonFormat;



@NamedNativeQueries({
		@NamedNativeQuery(
				name = "reportStatusEmployee",
				query = "Select emp.id, "
						+"emp.EMPLOYEE_CODE as employeeCode, "
						+"emp.NAME_THAI as nameThai, "
						+"emp.NAME_ENG as nameEng, "
						+"emp.DATEOFBIRTH as dateOfBirth, "
						+"emp.AGE as age, "
						+"staff.STAFFTYPENAME as statusStaff, "
						+"EMP_OFFICIAL.START_WORK_DATE as startWorkDate, "
						+"site.PROJECTOWNER as projectOwner, "
						+"site.STARTDATE as startDate, "
						+"site.ENDDATE as endDate, "			
						+"YEAR(CURDATE()) - YEAR(dateOfBirth) - IF(STR_TO_DATE(CONCAT(YEAR(CURDATE()), '/', MONTH(dateOfBirth), '/', DAY(dateOfBirth)) ,'%Y-%c-%e') > CURDATE(), 1, 0) as year, "
						+"MONTH(curdate()) - MONTH(dateOfBirth) - IF(STR_TO_DATE(CONCAT(YEAR(CURDATE()), '/', MONTH(dateOfBirth), '/', DAY(dateOfBirth)) ,'%Y-%c-%e') > CURDATE(), 1, 0) as month, "
						+"DAY(curdate()) - DAY(dateOfBirth) - IF(STR_TO_DATE(CONCAT(YEAR(CURDATE()), '/', MONTH(dateOfBirth), '/', DAY(dateOfBirth)) ,'%Y-%c-%e') > CURDATE(), 1, 0) as day, "
						+"YEAR(CURDATE()) - YEAR(START_WORK_DATE) - IF(STR_TO_DATE(CONCAT(YEAR(CURDATE()), '/', MONTH(START_WORK_DATE), '/', DAY(START_WORK_DATE)) ,'%Y-%c-%e') > CURDATE(), 1, 0) as yearwork, "
						+"MONTH(curdate()) - MONTH(START_WORK_DATE) - IF(STR_TO_DATE(CONCAT(YEAR(CURDATE()), '/', MONTH(START_WORK_DATE), '/', DAY(START_WORK_DATE)) ,'%Y-%c-%e') > CURDATE(), 1, 0) as monthwork, "
						+"DAY(curdate()) - DAY(START_WORK_DATE) - IF(STR_TO_DATE(CONCAT(YEAR(CURDATE()), '/', MONTH(START_WORK_DATE), '/', DAY(START_WORK_DATE)) ,'%Y-%c-%e') > CURDATE(), 1, 0) as daywork "
						+"from EMPLOYEE as emp "
						+"join EMP_SITE as site on site.employee_ID = emp.ID "
						+"join EMP_OFFICIAL on emp.OFFICIAL_ID = EMP_OFFICIAL.ID "
						+"join MAS_STAFFTYPE as staff on staff.ID = emp.ID " 
						+"where staff.STAFFTYPENAME like :statusStaff",
		
					resultClass = ReportStatusEmployeeDto.class)

})
@Entity
public class ReportStatusEmployeeDto {
	
		@Id
		@Column(name ="ID")
		private Integer id;
		
//		@Column(name = "employeeCode")
		private String employeeCode;
//		@Column(name = "nameThai")
		private String nameThai;
//		@Column(name = "nameEng")
		private String nameEng;
//		@Column(name = "dateOfBirth")
		private Date dateOfBirth;		
//		@Column(name = "age")
		private Integer age;
//		@Column(name="projectOwner")
		private String projectOwner;	
//		@Column(name="startWorkDate")
		public Date startWorkDate;	
//		@Column(name="startDate")
		private Date startDate;	
//		@Column(name="endDate")
		public Date endDate;		
//		@Column(name = "year")
		private Integer year;
//		@Column(name = "month")
		private Integer month;
//		@Column(name = "day")
		private Integer day;
//		@Column(name = "yearwork")
		private Integer yearwork;
//		@Column(name = "monthwork")
		private Integer monthwork;
//		@Column(name = "daywork")
		private Integer daywork;
//		@Column(name = "masstafftype")
		private String statusStaff;
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
		public String getNameThai() {
			return nameThai;
		}
		public void setNameThai(String nameThai) {
			this.nameThai = nameThai;
		}
		public String getNameEng() {
			return nameEng;
		}
		public void setNameEng(String nameEng) {
			this.nameEng = nameEng;
		}
		public Date getDateOfBirth() {
			return dateOfBirth;
		}
		public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		public Integer getAge() {
			return age;
		}
		public void setAge(Integer age) {
			this.age = age;
		}
		public String getProjectOwner() {
			return projectOwner;
		}
		public void setProjectOwner(String projectOwner) {
			this.projectOwner = projectOwner;
		}
		public Date getStartWorkDate() {
			return startWorkDate;
		}
		public void setStartWorkDate(Date startWorkDate) {
			this.startWorkDate = startWorkDate;
		}
		public Date getStartDate() {
			return startDate;
		}
		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}
		public Date getEndDate() {
			return endDate;
		}
		public void setEndDate(Date endDate) {
			this.endDate = endDate;
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
		public Integer getYearwork() {
			return yearwork;
		}
		public void setYearwork(Integer yearwork) {
			this.yearwork = yearwork;
		}
		public Integer getMonthwork() {
			return monthwork;
		}
		public void setMonthwork(Integer monthwork) {
			this.monthwork = monthwork;
		}
		public Integer getDaywork() {
			return daywork;
		}
		public void setDaywork(Integer daywork) {
			this.daywork = daywork;
		}
		public String getStatusStaff() {
			return statusStaff;
		}
		public void setStatusStaff(String statusStaff) {
			this.statusStaff = statusStaff;
		}
		
		

		
}
