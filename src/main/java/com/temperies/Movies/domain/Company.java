package com.temperies.Movies.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.sun.istack.NotNull;

@Entity
public class Company implements Serializable {

	@Id
	@NotNull
	private Integer id;
	@NotNull
	private String name;
	private String address;
	private Double value;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
	private List<Movie> movies;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

}
