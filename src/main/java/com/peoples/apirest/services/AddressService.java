package com.peoples.apirest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peoples.apirest.entities.Address;
import com.peoples.apirest.entities.People;
import com.peoples.apirest.repositories.AddressRepository;
import com.peoples.apirest.repositories.PeopleRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository repository;

	@Autowired
	private PeopleRepository peopleRepository;

	public List<Address> findAll() {
		return repository.findAll();
	}

	public Address findById(Long id) {
		Optional<Address> address = repository.findById(id);
		return address.get();
	}

	public Address createAddress(Long id, Address address) {
		People people = peopleRepository.getReferenceById(id);
		address.setPeople(people);
		setIsMainAddress(address);
		return repository.save(address);
	}

	public Address updateAddress(Long id, Address address) {
		Address newAddress = repository.getReferenceById(id);
		updateData(newAddress, address);
		return repository.save(newAddress);
	}

	public void deleteAddress(Long id) {
		repository.deleteById(id);
	}

	private void updateData(Address newAddress, Address address) {
		// TODO Auto-generated method stub
		newAddress.setStreet(address.getStreet());
		newAddress.setPostalCode(address.getPostalCode());
		newAddress.setNumber(address.getNumber());
		newAddress.setCity(address.getCity());
	}
	
	/*Define se é o endereço principal do usuário*/
	private void setIsMainAddress(Address address) {
		if(address.getIsMain() == null) {
			address.setIsMain(false);
		}
	}
}
