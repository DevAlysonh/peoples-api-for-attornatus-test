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
import com.peoples.apirest.repositories.AddressRepository;
import com.peoples.apirest.repositories.PeopleRepository;

@ExtendWith(MockitoExtension.class)
class AddressServiceTest {

	@InjectMocks
	private AddressService service;

	@Mock
	private AddressRepository repository;

	@Mock
	private PeopleRepository peopleRepository;

	@Test
	void findAllAddressTest() {
		Address addresses = new Address(1L, "Rua 01", "58052188", "22", "João Pesoa", false);
		List<Address> listAddress = List.of(addresses);

		Mockito.when(repository.findAll()).thenReturn(listAddress);
		Assertions.assertNotNull(service.findAll());
	}

}
