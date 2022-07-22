package com.peoples.apirest.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.peoples.apirest.entities.Address;
import com.peoples.apirest.entities.People;
import com.peoples.apirest.services.AddressService;
import com.peoples.apirest.services.PeopleService;

@RestController
@RequestMapping(value = "/pessoas")
public class PeopleResource {

	@Autowired
	private PeopleService service;
	
	@Autowired
	private AddressService addressService;

	@GetMapping
	public ResponseEntity<List<People>> findAll() {
		List<People> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<People> findById(@PathVariable Long id) {
		People obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<People> create(@RequestBody People people) {
		People obj = service.createPeople(people);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<People> updatePeople(@PathVariable Long id, @RequestBody People people) {
		People newData = service.updatePeople(id, people);
		return ResponseEntity.ok().body(newData);
	}
	
	@PostMapping(value = "/{id}/endereco")
	public ResponseEntity<Address> createAddress(@PathVariable Long id, @RequestBody Address address) {
		Address newAddress = addressService.createAddress(id, address);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newAddress.getId()).toUri();
		return ResponseEntity.created(uri).body(newAddress);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.deletePeople(id);
		return ResponseEntity.noContent().build();
	}

}
