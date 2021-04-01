package com.temperies.Movies.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import com.temperies.Movies.mappers.BaseMapper;

public class BaseService<MAP, DTO extends Serializable, ENT> {

	protected BaseMapper<DTO, ENT> mapper;

	public BaseMapper<DTO, ENT> getMapper() {
		return mapper;
	}

	@Autowired
	public void setMapper(BaseMapper<DTO, ENT> mapper) {
		this.mapper = mapper;
	}

}
