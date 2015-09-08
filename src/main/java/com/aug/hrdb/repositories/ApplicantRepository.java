package com.aug.hrdb.repositories;

import java.io.Serializable;
import java.util.List;

import com.aug.hrdb.dto.ApplicantDto;
import com.aug.hrdb.dto.ReportApplicantDto;
import com.aug.hrdb.entities.Applicant;

public interface ApplicantRepository extends GenericRepository<Applicant, Serializable> {
	public List<ApplicantDto> findByPosition(String position);
	
	public List<ApplicantDto> findAllApplicant();
	
	public ApplicantDto findApplicantById(Integer id);
	
	public ApplicantDto findApplicationById(Integer id);

	/*-------------------- report --------------------*/
	public List<ReportApplicantDto> reportApplicant();
	
	public List<ReportApplicantDto> findReportByCriteria(Integer position, String degree, String major, String schoolName, Double gpa);

	/*-------------------- Monthly report --------------------*/
	public List<ReportApplicantDto> findReportByMonth(String startDate,String endDate);	
	public void update(ApplicantDto applicantDto);
	
	public ApplicantDto getMaxApplicantId();

}
