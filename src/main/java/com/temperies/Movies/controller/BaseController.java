package com.temperies.Movies.controller;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseController<SERV> {

	protected SERV service;

	public SERV getService() {
		return service;
	}

	@Autowired
	public void setService(SERV service) {
		this.service = service;
	}

}
