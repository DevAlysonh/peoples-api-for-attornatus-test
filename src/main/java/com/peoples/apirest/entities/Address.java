package com.peoples.apirest.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Address implements Serializable {
	
	private static final long serialVersionUID= 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 255, nullable = false)
	private String street;
	
	@Column(length = 50)
	private String postalCode;
	
	@Column(length = 50)
	private String number;
	
	@Column(length = 50)
	private String city;
	
	@Column
	private Boolean isMain = false;
	
	@ManyToOne
	@JoinColumn(name = "people_id")
	@JsonIgnore
	private People people;
	
	public Address() {
		
	}

	public Address(Long id, String street, String postalCode, String number, String city) {
		super();
		this.id = id;
		this.street = street;
		this.postalCode = postalCode;
		this.number = number;
		this.city = city;
	}

	public Long getId() {
		return id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
	public People getPeople() {
		return people;
	}

	public void setPeople(People people) {
		this.people = people;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	public Boolean getIsMain() {
		return isMain;
	}

	public void setIsMain(Boolean isMain) {
		this.isMain = isMain;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(id, other.id);
	}
		

}
