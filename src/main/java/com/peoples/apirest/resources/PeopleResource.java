package com.peoples.apirest.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.peoples.apirest.entities.Address;
import com.peoples.apirest.entities.People;
import com.peoples.apirest.services.AddressService;
import com.peoples.apirest.services.PeopleService;

@RestController
@RequestMapping(value = "/api")
public class PeopleResource {

	@Autowired
	private PeopleService service;
	
	@Autowired
	private AddressService addressService;

	@GetMapping(value = "/pessoas")
	@ResponseStatus(HttpStatus.OK)
	public List<People> findAll() {
		return service.findAll();
	}

	@GetMapping(value = "/pessoas/{id}")
	@ResponseStatus(HttpStatus.OK)
	public People findById(@PathVariable Long id) {
		return service.findById(id);
	}

	@PostMapping(value = "/pessoas")
	@ResponseStatus(HttpStatus.CREATED)
	public People create(@RequestBody People people) {
		return service.createPeople(people);
	}

	@PutMapping(value = "/pessoas/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public People updatePeople(@PathVariable Long id, @RequestBody People people) {
		return service.updatePeople(id, people);
	}
	
	@DeleteMapping(value = "/pessoas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.deletePeople(id);
	}

}
