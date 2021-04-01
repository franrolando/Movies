package com.temperies.Movies.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.temperies.Movies.domain.Movie;
import com.temperies.Movies.domain.Screenwriter;
import com.temperies.Movies.domain.Script;
import com.temperies.Movies.dto.MovieDTO;
import com.temperies.Movies.dto.MovieInsertDTO;
import com.temperies.Movies.dto.ScreenwriterDTO;
import com.temperies.Movies.dto.ScriptDTO;
import com.temperies.Movies.exception.InexistentMovieException;
import com.temperies.Movies.exception.MovieDuplicatedException;
import com.temperies.Movies.mappers.MovieMapper;
import com.temperies.Movies.mappers.ScreenwriterMapper;
import com.temperies.Movies.mappers.ScriptMapper;
import com.temperies.Movies.repository.IMovieRepository;
import com.temperies.Movies.repository.IScreenwriterRepository;
import com.temperies.Movies.repository.IScriptRepository;
import com.temperies.Movies.service.BaseService;

@Service
public class MovieService extends BaseService<MovieMapper, MovieDTO, Movie> {

	private IScriptRepository scriptRepository;
	private IScreenwriterRepository screenwriterRepository;
	private IMovieRepository movieRepository;
	private ScriptMapper scriptMapper;
	private ScreenwriterMapper screenwriterMapper;

	public ScriptDTO getScriptByMovieId(Integer movieId) {
		Script script = scriptRepository.findByMovie_Id(movieId);
		if (Objects.isNull(script)) {
			throw new InexistentMovieException();
		}
		return scriptMapper.toDTO(script);
	}

	public List<ScreenwriterDTO> getScreenwriterByMovieId(Integer movieId) {
		List<Screenwriter> screenwriters = screenwriterRepository.findAllByMovies_IdOrderByGender_Description(movieId);
		if (screenwriters.isEmpty()) {
			throw new InexistentMovieException();
		}
		return screenwriterMapper.toDTOS(screenwriters);
	}

	public MovieInsertDTO insertMovie(MovieInsertDTO movie) {
		Movie m = mapper.fromDTO(movie.getMovie());
		if (movieRepository.existsById(m.getId())) {
			throw new MovieDuplicatedException();
		}
		Script script = scriptMapper.fromDTO(movie.getScript());
		movieRepository.save(m);
		scriptRepository.save(script);
		return movie;
	}

	public IScriptRepository getScriptRepository() {
		return scriptRepository;
	}

	@Autowired
	public void setScriptRepository(IScriptRepository scriptRepository) {
		this.scriptRepository = scriptRepository;
	}

	public IScreenwriterRepository getScreenwriterRepository() {
		return screenwriterRepository;
	}

	@Autowired
	public void setScreenwriterRepository(IScreenwriterRepository screenwriterRepository) {
		this.screenwriterRepository = screenwriterRepository;
	}

	public IMovieRepository getMovieRepository() {
		return movieRepository;
	}

	@Autowired
	public void setMovieRepository(IMovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	public ScriptMapper getScriptMapper() {
		return scriptMapper;
	}

	@Autowired
	public void setScriptMapper(ScriptMapper scriptMapper) {
		this.scriptMapper = scriptMapper;
	}

	public ScreenwriterMapper getScreenwriterMapper() {
		return screenwriterMapper;
	}

	@Autowired
	public void setScreenwriterMapper(ScreenwriterMapper screenwriterMapper) {
		this.screenwriterMapper = screenwriterMapper;
	}

}
