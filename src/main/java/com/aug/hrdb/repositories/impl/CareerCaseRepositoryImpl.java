package com.aug.hrdb.repositories.impl;

import org.springframework.stereotype.Repository;

import com.aug.hrdb.entities.CareerCase;
import com.aug.hrdb.repositories.CareerCaseRepository;

@Repository(value="careerCaseRepository")
public class CareerCaseRepositoryImpl extends GenericRepositoryImpl<CareerCase, Integer> implements CareerCaseRepository {

	public CareerCaseRepositoryImpl() {
		super(CareerCase.class);
	}
	
//	@Override
//	public String generateCareerCaseCode(MasDivision masDivision) {
//		
//		System.out.println("-----generateCareerCaseCode-----");
//		
//		String code = null;
//		
//		String hql = "FROM CareerCase C WHERE C.masDivision.code = :code ORDER BY C.code DESC";
//		Query query = getCurrentSession().createQuery(hql);
//		query.setParameter("code", masDivision.getCode());
//		query.setMaxResults(1);
//		
//		try {
//			
//			CareerCase careerCase = (CareerCase)query.list().get(0);
//			
//			System.out.println("Last : " + careerCase.getCode());
//			System.out.println("Division: " + masDivision.getCode());
//			
//			String[] split = careerCase.getCode().split(masDivision.getCode());
//			
//			int number = Integer.parseInt(split[1]) + 1;
//			
//			code = masDivision.getCode() + String.format("%04d", number); 
//			
//			System.out.println("CODE: " + code);
//			
//		} catch (Exception e) {
//			code = masDivision.getCode() + String.format("%04d", 1);
//		}
//		
//		System.out.println("-----------------------------");
//		
//		return code;
//		
//	}

}