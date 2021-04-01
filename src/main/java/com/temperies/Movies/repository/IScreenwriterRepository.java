package com.temperies.Movies.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.temperies.Movies.domain.Screenwriter;

public interface IScreenwriterRepository extends JpaRepository<Screenwriter, Integer> {

	List<Screenwriter> findAllByMovies_IdOrderByGender_Description(Integer moveId);

}
