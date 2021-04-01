package com.temperies.Movies.dto;

import java.io.Serializable;

public class CompanyDTO implements Serializable {

	private String name;
	private String address;
	private Double value;

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
