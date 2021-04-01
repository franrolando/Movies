package com.temperies.Movies.dto;

import java.io.Serializable;
import java.util.Date;

public class MovieDTO implements Serializable {

	private Integer id;
	private String name;
	private Integer durationInMinutes;
	private Date releaseDate;
	private Double criticReview;

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

}
