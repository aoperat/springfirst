package com.cos.board;

import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.board.model.Person;
import com.cos.board.repository.PersonRepository;

@RestController
public class PersonController {

	@Autowired
	PersonRepository repository;

	
	//GET (select), POST(insert), PUT(update), DELETE(delete)
	@GetMapping("/person/{id}")
	public Person getPerson(@PathVariable int id) {
		Person person = repository.findById(id);
		return person;
	}

	//Person person
	//param, x-www-form-urlencoded
	//Json 데이터는 받지 못한다. json 데이터를 받고싶으면 @RequestBody 어노테이션을 사용하면 된다.
	@PostMapping("/person")
	public int setPerson(Person person) {
		try {
			repository.save(person);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		
	}
	
	@DeleteMapping("/person/{id}")
	public int deletePerson(@PathVariable int id) {
		
		try {
			repository.delete(id);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		
	}
	
	@PutMapping("/person")
	public int updatePerson(Person person) {
		try {
			repository.update(person);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		
	}

	
//	@DeleteMapping("/person/{id}")
//	public Person delete(@PathVariable int id) {
//		Person person = repository.findById(id);
//		return person;
//	}
}
