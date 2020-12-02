package com.ejercicio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.model.Dato;
import com.ejercicio.service.IDataService;

@RequestMapping("/datos")
@RestController
public class DataController {

	private IDataService service;
	
	@Autowired
    public DataController(IDataService service) {
        this.service = service;
    }
	
	@GetMapping
	public ResponseEntity<List<Dato>> listar() throws Exception{
		List<Dato> lista = service.listar();
		return new ResponseEntity<List<Dato>>(lista, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String[]> reestructurar() throws Exception{
		List<Dato> datos = service.listar();
		String[] datosReestructurado = service.reestructurar(datos);
		return new ResponseEntity<String[]>(datosReestructurado, HttpStatus.CREATED);
	}
}
