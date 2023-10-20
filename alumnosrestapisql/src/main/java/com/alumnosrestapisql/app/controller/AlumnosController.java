package com.alumnosrestapisql.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alumnosrestapisql.app.entity.Alumnos;
import com.alumnosrestapisql.app.service.IAlumnosService;



@RestController
@RequestMapping("api/alumnos")
public class AlumnosController {
	
	@Autowired
	private IAlumnosService alumnosService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Alumnos alumnos){
		return ResponseEntity.status(HttpStatus.CREATED).body(alumnosService.save(alumnos));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value="id") Long alumnosId){
		Optional<Alumnos> oAlumnos=alumnosService.findById(alumnosId);
		
		if(!oAlumnos.isPresent()) {
			return ResponseEntity.notFound().build();
		}
			
		return ResponseEntity.ok(oAlumnos);
	}
}
