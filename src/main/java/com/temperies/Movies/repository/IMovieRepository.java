package com.temperies.Movies.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.temperies.Movies.domain.Movie;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Integer> {

	List<Movie> findAllByCompany_id(Integer idCompany);

}
