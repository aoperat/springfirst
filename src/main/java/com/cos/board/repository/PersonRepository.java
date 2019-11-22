package com.cos.board.repository;

import com.cos.board.model.Person;

public interface PersonRepository {
	Person findById(int id);
	void save(Person person);//파라메터가 2개이상이면 맵퍼에 연결하지 못한다.
	void delete(int id);
	void update(Person person);
}
