package com.temperies.Movies.dto;

import java.io.Serializable;
import java.util.Date;

public class ScriptDTO implements Serializable {

	private Integer id;
	private Integer timesModified;
	private Date lastModified;

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
}
