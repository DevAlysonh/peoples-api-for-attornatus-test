package com.peoples.apirest.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.peoples.apirest.entities.People;
import com.peoples.apirest.services.AddressService;
import com.peoples.apirest.services.PeopleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Cadastro de Pessoas e Endereços")
@CrossOrigin(origins = "*")
public class PeopleResource {

	@Autowired
	private PeopleService service;
	
	@Autowired
	private AddressService addressService;

	@GetMapping(value = "/pessoas")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Retorna todas as pessoas cadastradas, e seus endereços.")
	public List<People> findAll() {
		return service.findAll();
	}

	@GetMapping(value = "/pessoas/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Retorna uma pessoa, e seus endereços.")
	public People findById(@PathVariable Long id) {
		return service.findById(id);
	}

	@PostMapping(value = "/pessoas")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Cria uma nova Pessoa.")
	public People create(@RequestBody @Valid People people) {
		return service.createPeople(people);
	}

	@PutMapping(value = "/pessoas/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	@ApiOperation(value = "Atualiza os dados de uma pessoa já cadastrada.")
	public People updatePeople(@PathVariable Long id, @RequestBody @Valid People people) {
		return service.updatePeople(id, people);
	}
	
	@DeleteMapping(value = "/pessoas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Deleta uma pessoa da base de dados.")
	public void delete(@PathVariable Long id) {
		service.deletePeople(id);
	}
	

}
