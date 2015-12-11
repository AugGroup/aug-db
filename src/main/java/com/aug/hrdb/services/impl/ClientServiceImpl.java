package com.aug.hrdb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Client;
import com.aug.hrdb.repositories.ClientRepository;
import com.aug.hrdb.services.ClientService;

@Service(value="clientService")
@Transactional
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public List<Client> findAll() throws DataAccessException {
		return clientRepository.findAll();
	}

	@Override
	public Client findById(Integer id) {
		return clientRepository.find(id);
	}

	@Override
	public void create(Client e) {
		clientRepository.create(e);
	}

	@Override
	public void update(Client e) {
		clientRepository.update(e);
	}

	@Override
	public void delete(Client e) {
		clientRepository.delete(e);
	}

	@Override
	public void deleteById(Integer id) {
		clientRepository.deleteById(id);
	}
	
}
