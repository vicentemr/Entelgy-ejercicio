package com.ejercicio.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ejercicio.model.Dato;
import com.ejercicio.service.IDataService;

@SpringBootTest
public class DataControllerJUnitTest {
	
	private IDataService service;
	@Autowired
	private DataController controller = new DataController(service);
	
	@Test
	public void listarTest() throws Exception{
		
		ResponseEntity<List<Dato>> respListar = controller.listar();
		assertEquals(respListar.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void reestructurar() throws Exception{
		
		ResponseEntity<String[]> respReestructurar = controller.reestructurar();
		assertEquals(respReestructurar.getStatusCode(), HttpStatus.CREATED);
	}
}
