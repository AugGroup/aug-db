package com.aug.hrdb.repositories.impl;

import org.springframework.stereotype.Repository;

import com.aug.hrdb.entities.MasRole;
import com.aug.hrdb.repositories.MasRoleRepository;

@Repository
public class MasRoleRepositoryImpl extends GenericRepositoryImpl<MasRole, Integer> implements MasRoleRepository{

		public MasRoleRepositoryImpl() {
			super(MasRole.class);
		}
		
		public MasRole deleteById(Integer id) {
			MasRole masRole =(MasRole)getCurrentSession().load(MasRole.class, id);
			getCurrentSession().delete(masRole);
			return masRole;
		}
}
