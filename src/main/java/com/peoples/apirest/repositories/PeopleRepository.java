package com.peoples.apirest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.peoples.apirest.entities.People;

public interface PeopleRepository extends JpaRepository<People, Long> {

	List<People> findAll();

}
