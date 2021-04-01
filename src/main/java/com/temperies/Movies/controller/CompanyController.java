package com.temperies.Movies.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.temperies.Movies.dto.MovieDTO;
import com.temperies.Movies.service.impl.CompanyService;

@RestController
@RequestMapping("Companies")
public class CompanyController extends BaseController<CompanyService> {

	@GetMapping("Movies")
	public ResponseEntity<List<MovieDTO>> getCompanyMovies(@RequestParam(name = "id") Integer id) {
		return new ResponseEntity<List<MovieDTO>>(service.getMoviesFromCompany(id), HttpStatus.OK);
	}

}
