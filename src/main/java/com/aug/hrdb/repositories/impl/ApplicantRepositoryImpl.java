package com.aug.hrdb.repositories.impl;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.ApplicantDto;
import com.aug.hrdb.dto.ReportApplicantDto;
import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.repositories.ApplicantRepository;

@Repository(value = "applicantRepository")
@Transactional
public class ApplicantRepositoryImpl extends GenericRepositoryImpl<Applicant, Serializable> implements ApplicantRepository {
	public ApplicantRepositoryImpl() {
		super(Applicant.class);
	}

	@Override
	public List<ApplicantDto> findByPosition(String position) {
		Query query = getCurrentSession().getNamedQuery("SEARCH_APPLICANT");
		query.setParameter("POSITION", "%" + position + "%");
		List<ApplicantDto> results = query.list();
		return results;
	}

	@Override
	public List<ApplicantDto> findAllApplicant() {
		Query query = getCurrentSession().getNamedQuery("SEARCH_ALL");
		List<ApplicantDto> results = query.list();
		return results;
	}

	@Override
	public ApplicantDto findApplicantById(Integer id) {
		Query query = getCurrentSession().getNamedQuery("SEARCH_BY_ID");
		query.setParameter("ID", id);
		List<ApplicantDto> result = query.list();
		ApplicantDto app = result.get(0);
		return app;
	}
/*-------------------- report --------------------*/
	@Override
	public List<ReportApplicantDto> reportApplicant() {
		Query query = getCurrentSession().getNamedQuery("REPORT_APPLICANT");
		List<ReportApplicantDto> results = query.list();
		return results;
	}

	@Override
	public List<ReportApplicantDto> findReportByCriteria(Integer position, String degree, String major, String schoolName, Double gpa) {
		Query query = getCurrentSession().getNamedQuery(
				"REPORT_SEARCH_BY_CRITERIA");
		String queryStr = query.getQueryString();
		if (position > 0) {
			queryStr = query.getQueryString();
			queryStr += " AND (positionId1.ID = :POSITION OR positionId2.ID = :POSITION OR positionId3.ID = :POSITION ) ";
			query = getCurrentSession().createSQLQuery(queryStr).addEntity(ReportApplicantDto.class);
			query.setParameter("POSITION", position);
		}
		if (gpa != null) {
			queryStr = query.getQueryString();
			queryStr += " AND education.GPA = :GPA";
			query = getCurrentSession().createSQLQuery(queryStr).addEntity(ReportApplicantDto.class);
			query.setParameter("GPA", gpa);
		}
		query = getCurrentSession().createSQLQuery(queryStr).addEntity(ReportApplicantDto.class);
		if (position > 0) {
			query.setParameter("POSITION", position);
		}
		if (gpa != null) {
			query.setParameter("GPA", gpa);
			System.out.println("TEST:::" + queryStr);
		}

		query.setParameter("DEGREE", "%" + degree + "%");
		query.setParameter("MAJOR", "%" + major + "%");
		query.setParameter("SCHOOL_NAME", "%"+ schoolName +"%");
		
		List<ReportApplicantDto> results = query.list();
		//System.out.println("queryStr :"+ queryStr);
		return results;
	}
	
	
	/*-------------------- Monthly report --------------------*/
	public List<ReportApplicantDto> findReportByMonth(String startDate,String endDate){
		Query query = getCurrentSession().getNamedQuery("REPORT_SEARCH_BY_MONTH"); 
		
			query.setParameter("STARTDATE", startDate);
			query.setParameter("ENDDATE", endDate);

			
			System.out.println("STARTDATE "+startDate+" ENDDATE "+endDate);
		//}
		List<ReportApplicantDto> results = query.list();
		return results;
	}
	
	@Override
	public ApplicantDto findApplicationById(Integer id) {
		Query query = getCurrentSession().getNamedQuery("SEARCH_BY_ID_APPLICATION");
		query.setParameter("ID", id);
		List<ApplicantDto> result = query.list();
		ApplicantDto app = result.get(0);
		return app;
	}

	@Override
	public void update(ApplicantDto applicantDto) {
		Applicant applicant= new Applicant();
		try {
			getCurrentSession().saveOrUpdate(applicant.fromApplicantDTO(applicant, applicantDto));
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ApplicantDto getMaxApplicantId() {
		Query query = getCurrentSession().getNamedQuery("MAX_ID_APPLICANT");
		List<ApplicantDto> result = query.list();
		ApplicantDto app = result.get(0);
		return app;
	}
	
	

}
