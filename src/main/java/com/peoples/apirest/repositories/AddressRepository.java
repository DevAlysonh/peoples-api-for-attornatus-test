package com.peoples.apirest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.peoples.apirest.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
