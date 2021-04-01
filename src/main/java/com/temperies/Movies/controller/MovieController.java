package com.temperies.Movies.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.temperies.Movies.dto.MovieInsertDTO;
import com.temperies.Movies.dto.ScreenwriterDTO;
import com.temperies.Movies.dto.ScriptDTO;
import com.temperies.Movies.service.impl.MovieService;

@RestController
@RequestMapping("Movies")
public class MovieController extends BaseController<MovieService> {

	@GetMapping("Script")
	public ResponseEntity<ScriptDTO> getMovieScript(@RequestParam(name = "id") Integer id) {
		return new ResponseEntity<ScriptDTO>(service.getScriptByMovieId(id), HttpStatus.OK);
	}
	
	@GetMapping("Screenwriter")
	public ResponseEntity<List<ScreenwriterDTO>> getScreenwriters(@RequestParam(name = "id") Integer id) {
		return new ResponseEntity<List<ScreenwriterDTO>>(service.getScreenwriterByMovieId(id), HttpStatus.OK);
	}
	
	@PutMapping("newMovie")
	public ResponseEntity<MovieInsertDTO> insertMovie(@RequestBody MovieInsertDTO movie){
		return new ResponseEntity<MovieInsertDTO>(service.insertMovie(movie), HttpStatus.OK);
	}
	
}
