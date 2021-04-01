package com.temperies.Movies.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.sun.istack.NotNull;

@Entity
public class Script implements Serializable {

	@Id
	@NotNull
	private Integer id;
	private Integer timesModified;
	@NotNull
	private Date lastModified;

	@OneToOne
	@JoinColumn(name = "IDMOVIE", updatable = false, nullable = false)
	private Movie movie;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTimesModified() {
		return timesModified;
	}

	public void setTimesModified(Integer timesModified) {
		this.timesModified = timesModified;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

}
