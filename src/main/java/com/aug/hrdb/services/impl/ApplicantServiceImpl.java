package com.aug.hrdb.services.impl;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.ApplicantDto;
import com.aug.hrdb.dto.ReportApplicantDto;
import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.repositories.ApplicantRepository;
import com.aug.hrdb.services.ApplicantService;

@Service(value = "applicantService")
@Transactional
public class ApplicantServiceImpl implements ApplicantService{
	@Autowired
	private ApplicantRepository applicantRepository;
	
//	@Autowired
//	private PositionRepository positionRepository;
	
//	@Autowired
//	private AddressRepository addressRepository;

	@Override
	public Applicant findById(Integer id) {
		return applicantRepository.find(id);
	}

	@Override
	public void create(Applicant applicant) {
		applicantRepository.create(applicant);

	}

	@Override
	public void update(Applicant applicant) {
		applicantRepository.update(applicant);

	}

	@Override
	public void delete(Applicant applicant) {
		applicantRepository.delete(applicant);

	}

	@Override
	public void deleteById(Integer id) {
		applicantRepository.deleteById(id);

	}

	@Override
	public List<Applicant> findAll() {
		List<Applicant> applicants = applicantRepository.findAll();
		return applicants;
	}

//	@Override
//	public List<ApplicantDto> findByPosition(String position) {
//		List<ApplicantDto> applicants = applicantRepository.findByPosition(position);
//		for (ApplicantDto appl : applicants) {
//			String position1 = positionRepository.findById(appl.getPositionId1()).getPositionName();
//			String position2 = positionRepository.findById(appl.getPositionId2()).getPositionName();
//			String position3 = positionRepository.findById(appl.getPositionId3()).getPositionName();
//			appl.setPosition1Str(position1);
//			appl.setPosition2Str(position2);
//			appl.setPosition3Str(position3);
//		}
//		return applicants;
//	}

//	@Override
//	public List<ApplicantDto> findAllApplicant() {
//		List<ApplicantDto> applicants = applicantRepository.findAllApplicant();
//		for (ApplicantDto appl : applicants) {
//			String position1 = positionRepository.findById(appl.getPositionId1()).getPositionName();
//			String position2 = positionRepository.findById(appl.getPositionId2()).getPositionName();
//			String position3 = positionRepository.findById(appl.getPositionId3()).getPositionName();
//			appl.setPosition1Str(position1);
//			appl.setPosition2Str(position2);
//			appl.setPosition3Str(position3);
//		}
//		return applicants;
//	}

//	@Override
//	public ApplicantDto findApplicantById(Integer id) {
//		ApplicantDto applicants = applicantRepository.findApplicantById(id);
//		String position1 = positionRepository.findById(applicants.getPositionId1()).getPositionName();
//		String position2 = positionRepository.findById(applicants.getPositionId2()).getPositionName();
//		String position3 = positionRepository.findById(applicants.getPositionId3()).getPositionName();
//		applicants.setPosition1Str(position1);
//		applicants.setPosition2Str(position2);
//		applicants.setPosition3Str(position3);
//
//		return applicants;
//	}

	
	@Override
	public ApplicantDto findApplicationById(Integer id) {
		ApplicantDto applicants = applicantRepository.findApplicationById(id);

		return applicants;
	}
	
	@Override
	public ApplicantDto findByIdApplicant(Integer id) {
		return applicantRepository.findApplicationById(id);
		
	}

	@Override
	public ApplicantDto saveInformations(ApplicantDto applicantDto) {
		Applicant applicant = new Applicant();
		applicant.setTrackingStatus("Waiting for consider");
		try {
			applicantRepository.create(applicant.fromApplicantDTO(applicant,applicantDto));
			
		} catch (ParseException e) {
			e.printStackTrace();
		}

		applicantDto.setId(applicant.getId());
		return applicantDto;
	}
	

   
	  /*-------------------- Report --------------------*/
		//findAll
		public List<ReportApplicantDto> reportApplicant() {
			return applicantRepository.reportApplicant();
		}
		//find by criteria
		@Override
		public List<ReportApplicantDto> findReportByCriteria(Integer position, String degree, String major, String schoolName, Double gpa) {
			return applicantRepository.findReportByCriteria(position, degree, major, schoolName, gpa);
		}
		
		/*-------------------- Monthly report --------------------*/
		@Override
		public List<ReportApplicantDto> findReportByMonth(String startDate,String endDate) {
			return applicantRepository.findReportByMonth(startDate,endDate);
		}

		@Override
		public void update(ApplicantDto applicantDto) {
			applicantRepository.update(applicantDto);
			
		}

		@Override
		public ApplicantDto getMaxApplicantId() {
			return applicantRepository.getMaxApplicantId();
		}
}
