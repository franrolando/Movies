package com.temperies.Movies.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.sun.istack.NotNull;

@Entity
public class Gender implements Serializable {

	@Id
	@NotNull
	public Integer id;
	@NotNull
	public String description;

	@OneToMany(mappedBy = "gender")
	private List<Screenwriter> screewriters;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
