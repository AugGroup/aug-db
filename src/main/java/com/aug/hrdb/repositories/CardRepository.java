package com.aug.hrdb.repositories;

import java.util.List;

import com.aug.hrdb.dto.CardDto;
import com.aug.hrdb.entities.Card;



public interface CardRepository extends GenericRepository<Card, Integer>{

	public List<Card> findByCriteria(Card card);

	public Card deleteById(Integer id);

	public List<CardDto> searchCard(Integer id);

	

}
