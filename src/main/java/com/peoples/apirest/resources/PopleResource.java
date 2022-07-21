package com.peoples.apirest.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peoples.apirest.entities.People;

@RestController
@RequestMapping(value = "/pessoas")
public class PopleResource {

	@GetMapping
	public ResponseEntity<People> findAll(){
		People u = new People();
		return ResponseEntity.ok().body(u);
	}
}
