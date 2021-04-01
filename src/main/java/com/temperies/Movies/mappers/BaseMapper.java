package com.temperies.Movies.mappers;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;

import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseMapper<DTO extends Serializable, DOM> {

	private Class<DTO> dtoClass;
	private Class<DOM> domainClass;
	private ObjectMapper mapper;

	public BaseMapper() {
		Class<?>[] arguments = GenericTypeResolver.resolveTypeArguments(this.getClass(), BaseMapper.class);
		if (arguments != null && arguments.length > 0) {
			this.dtoClass = (Class<DTO>) arguments[0];
			this.domainClass = (Class<DOM>) arguments[1];
		}
	}

	public DTO toDTO(DOM entity) {
		return this.mapper.convertValue(entity, this.dtoClass);
	}

	public DOM fromDTO(DTO entity) {
		return this.mapper.convertValue(entity, this.domainClass);
	}

	public List<DTO> toDTOS(List<DOM> entities) {
		List<DTO> mapped = new ArrayList<>();
		for (DOM entity : entities) {
			mapped.add(this.toDTO(entity));
		}
		return mapped;
	}

	public List<DOM> fromDTOS(List<DTO> entities) {
		List<DOM> mapped = new ArrayList<>();
		for (DTO entity : entities) {
			mapped.add(this.fromDTO(entity));
		}
		return mapped;
	}

	public DTO fromString(String serializedDTO) {
		try {
			return this.mapper.readValue(serializedDTO, this.dtoClass);
		} catch (IOException e) {

		}
		return null;
	}

	@Autowired
	public void setMapper(ObjectMapper mapper) {
		this.mapper = mapper;
	}

}