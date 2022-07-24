package com.peoples.apirest.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.peoples.apirest.entities.Address;
import com.peoples.apirest.services.AddressService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Cadastro de Pessoas e Endereços")
@CrossOrigin(origins = "*")
public class AddressResource {

	@Autowired
	private AddressService service;

	@GetMapping(value = "/enderecos")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Retorna todos os endereços cadastrados.")
	public List<Address> findAll() {
		
		return service.findAll();
	}

	@GetMapping(value = "/enderecos/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Retorna um endereço cadastrado.")
	public Address findById(@PathVariable Long id) {

		return service.findById(id);
	}

	@PostMapping(value = "/pessoas/{id}/endereco")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Cadastra um novo endereço relacionando-o ao Id do usuário.")
	public Address createAddress(@PathVariable Long id, @RequestBody @Valid Address address) {

		return service.createAddress(id, address);
	}

	@PutMapping(value = "/enderecos/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	@ApiOperation(value = "Atualiza um endereço.")
	public Address updateAddress(@PathVariable Long id, @RequestBody @Valid Address address) {

		return service.updateAddress(id, address);
	}

	@DeleteMapping(value = "/enderecos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Deleta um endereço da base de dados.")
	public void deleteAddress(@PathVariable Long id) {
		
		service.deleteAddress(id);
	}
	

}
