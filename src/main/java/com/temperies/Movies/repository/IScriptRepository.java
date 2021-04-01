package com.temperies.Movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.temperies.Movies.domain.Script;

@Repository
public interface IScriptRepository extends JpaRepository<Script, Integer> {

	Script findByMovie_Id(Integer movieId);

}
