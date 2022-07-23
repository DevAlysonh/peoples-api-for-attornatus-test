package com.peoples.apirest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peoples.apirest.entities.People;
import com.peoples.apirest.repositories.PeopleRepository;

@Service
public class PeopleService {

	@Autowired
	private PeopleRepository repository;

	public List<People> findAll() {
		return repository.findAll();
	}

	public People findById(Long id) {
		Optional<People> obj = repository.findById(id);
		return obj.get();
	}

	public People createPeople(People obj) {

		return repository.save(obj);
	}

	public People updatePeople(Long id, People people) {
		People newPeople = repository.getReferenceById(id);
		updateData(newPeople, people);
		return repository.save(newPeople);
	}

	public void deletePeople(Long id) {
		repository.deleteById(id);
	}

	/*Função para atualizar os dados da pessoa*/
	private void updateData(People newData, People data) {
		// TODO Auto-generated method stub
		newData.setName(data.getName());
		newData.setBirthDate(data.getBirthDate());
	}
}
