package com.temperies.Movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.temperies.Movies.domain.Company;

@Repository
public interface ICompanyRepository extends JpaRepository<Company, Integer> {

}
