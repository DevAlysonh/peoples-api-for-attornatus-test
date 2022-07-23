package com.peoples.apirest.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.peoples.apirest.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

	Optional<Address> findByIsMainAndPeople_Id(Boolean isMain, Long id);
	
}
