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
import com.peoples.apirest.services.AddressService;

@RestController
@RequestMapping(value = "/api")
public class AddressResource {

	@Autowired
	private AddressService service;

	@GetMapping(value = "/enderecos")
	public ResponseEntity<List<Address>> findAll() {

		List<Address> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/enderecos/{id}")
	public ResponseEntity<Address> findById(@PathVariable Long id) {

		Address address = service.findById(id);
		return ResponseEntity.ok().body(address);
	}

	@PostMapping(value = "/pessoas/{id}/endereco")
	public ResponseEntity<Address> createAddress(@PathVariable Long id, @RequestBody Address address) {
		Address newAddress = service.createAddress(id, address);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newAddress.getId())
				.toUri();
		return ResponseEntity.created(uri).body(newAddress);
	}

	@PutMapping(value = "/enderecos/{id}")
	public ResponseEntity<Address> updateAddress(@PathVariable Long id, @RequestBody Address address) {
		Address newAddress = service.updateAddress(id, address);
		return ResponseEntity.ok().body(newAddress);
	}

	@DeleteMapping(value = "/enderecos/{id}")
	public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
		service.deleteAddress(id);
		return ResponseEntity.noContent().build();
	}
}
