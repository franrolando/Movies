package com.temperies.Movies.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.temperies.Movies.domain.Company;
import com.temperies.Movies.domain.Movie;
import com.temperies.Movies.dto.CompanyDTO;
import com.temperies.Movies.dto.MovieDTO;
import com.temperies.Movies.exception.InexistentCompanyException;
import com.temperies.Movies.mappers.CompanyMapper;
import com.temperies.Movies.mappers.MovieMapper;
import com.temperies.Movies.repository.IMovieRepository;
import com.temperies.Movies.service.BaseService;

@Service
public class CompanyService extends BaseService<CompanyMapper, CompanyDTO, Company> {

	private IMovieRepository movieRepository;
	private MovieMapper movieMapper;

	public List<MovieDTO> getMoviesFromCompany(Integer idCompany) {
		List<Movie> movies = movieRepository.findAllByCompany_id(idCompany);
		if (movies.isEmpty()) {
			throw new InexistentCompanyException();
		}
		List<MovieDTO> moviesDTO = movieMapper.toDTOS(movies);
		return moviesDTO;
	}

	public IMovieRepository getMovieRepository() {
		return movieRepository;
	}

	@Autowired
	public void setMovieRepository(IMovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	public MovieMapper getMovieMapper() {
		return movieMapper;
	}

	@Autowired
	public void setMovieMapper(MovieMapper movieMapper) {
		this.movieMapper = movieMapper;
	}

}
