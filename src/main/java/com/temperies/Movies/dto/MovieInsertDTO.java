package com.temperies.Movies.dto;

import java.io.Serializable;

public class MovieInsertDTO implements Serializable {

	private MovieDTO movie;
	private ScriptDTO script;

	public MovieDTO getMovie() {
		return movie;
	}

	public void setMovie(MovieDTO movie) {
		this.movie = movie;
	}

	public ScriptDTO getScript() {
		return script;
	}

	public void setScript(ScriptDTO script) {
		this.script = script;
	}

}
