package com.aug.hrdb.repositories.impl;

import org.springframework.stereotype.Repository;

import com.aug.hrdb.entities.Client;
import com.aug.hrdb.repositories.ClientRepository;

@Repository(value="clientRepository")
public class ClientRepositoryImpl extends GenericRepositoryImpl<Client, Integer> implements ClientRepository {

	public ClientRepositoryImpl() {
		super(Client.class);
	}
	
}
