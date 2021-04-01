package com.temperies.Movies.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.sun.istack.NotNull;

@Entity
public class Movie implements Serializable {

	@Id
	@NotNull
	private Integer id;
	@NotNull
	private String name;
	@NotNull
	private Integer durationInMinutes;
	@NotNull
	private Date releaseDate;
	private Double criticReview;

	@ManyToOne
	@JoinColumn(name = "IDCOMPANY", nullable = false, updatable = false)
	private Company company;

	@OneToOne(mappedBy = "movie", cascade = CascadeType.ALL)
	private Script script;

	@ManyToMany(mappedBy = "movies")
	private List<Screenwriter> screenwriters;

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

	public Integer getDurationInMinutes() {
		return durationInMinutes;
	}

	public void setDurationInMinutes(Integer durationInMinutes) {
		this.durationInMinutes = durationInMinutes;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Double getCriticReview() {
		return criticReview;
	}

	public void setCriticReview(Double criticReview) {
		this.criticReview = criticReview;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
