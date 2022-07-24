package com.peoples.apirest.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.peoples.apirest.entities.Address;
import com.peoples.apirest.entities.People;
import com.peoples.apirest.repositories.PeopleRepository;

@ExtendWith(MockitoExtension.class)
class PeopleServiceTest {

	@InjectMocks
	private PeopleService service;

	@Mock
	private PeopleRepository repository;

	@Test
	void findAllPeopleTest() {
		Long id = 1L;
		People people = new People(id, "Alyson Henrique", LocalDate.now());
		List<Address> addresses = List.of(new Address(id, "Rua 01", "58052188", "22", "João Pesoa", false));
		people.setAddress(addresses);
		List<People> peopleList = List.of(people);
		
		Mockito.when(repository.findAll()).thenReturn(peopleList);
		
		Assertions.assertNotNull(service.findAll());
		
	}
	
	@Test
	void findPeopleById() {
		Long id = 1L;
		People people = new People(id, "Alyson Henrique", LocalDate.now());
		
		Mockito.when(repository.findById(id)).thenReturn(Optional.of(people));
		
		Assertions.assertNotNull(service.findById(id));
		
	}
	
	@Test
	void createPeopleTest() {
		Long id = 1L;
		People people = new People(id, "Alyson Henrique", LocalDate.now());
		
		Mockito.when(repository.save(people)).thenReturn(people);
		
		Assertions.assertNotNull(service.createPeople(people));
	}
	
	@Test
	void updatePeopleTest() {
		Long id = 1L;
		People people = new People(id, "Alyson Henrique", LocalDate.now());
		People newPeople = new People(id, "Henrique Alyson Nunes", LocalDate.now());
		
		Mockito.when(repository.getReferenceById(id)).thenReturn(people);
		Mockito.when(repository.save(newPeople)).thenReturn(newPeople);
		
		Assertions.assertEquals(newPeople, service.updatePeople(id, newPeople));
		
	}

}
