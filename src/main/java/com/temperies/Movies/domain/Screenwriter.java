package com.temperies.Movies.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.sun.istack.NotNull;

@Entity
public class Screenwriter implements Serializable {

	@Id
	@NotNull
	private Integer id;
	@NotNull
	private String name;
	private Integer age;

	@ManyToOne
	@JoinColumn(name = "idgender")
	private Gender gender;

	@ManyToMany
	@JoinTable(name = "screenwriter_movie", joinColumns = @JoinColumn(name = "idscreenwriter"), inverseJoinColumns = @JoinColumn(name = "idmovie"))
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
