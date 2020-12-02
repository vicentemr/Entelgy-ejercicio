package com.ejercicio.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ejercicio.model.Dato;
import com.ejercicio.service.IDataService;

public class DataControllerMockitoTest {

	private IDataService dataService = Mockito.mock(IDataService.class);
	private DataController controller = new DataController(dataService);
	
	@Test
	public void controllerTest() throws Exception {
		
		List<Dato> datosTest = new ArrayList<>(); 
		Dato dato1 = new Dato();
		dato1.setPostId(1);
		dato1.setId(1);
		dato1.setEmail("email1@test.com");
		dato1.setBody("body1");
		
		Dato dato2 = new Dato();
		dato2.setPostId(1);
		dato2.setId(2);
		dato2.setEmail("email2@test.com");
		dato2.setBody("body2");
		
		Dato dato3 = new Dato();
		dato3.setPostId(2);
		dato3.setId(3);
		dato3.setEmail("email3@test.com");
		dato3.setBody("body3");
		
		Dato dato4 = new Dato();
		dato4.setPostId(3);
		dato4.setId(4);
		dato4.setEmail("email4@test.com");
		dato4.setBody("body4");
		
		datosTest.add(dato1);
		datosTest.add(dato2);
		datosTest.add(dato3);
		datosTest.add(dato4);
		
		String[] datosReestructuradosTest = new String[datosTest.size()];
		for (int i = 0; i < datosTest.size(); i++) {
			datosReestructuradosTest[i] = datosTest.get(i).getPostId() + "|" + datosTest.get(i).getId() + "|" + datosTest.get(i).getEmail();
		}
		
		//Test listar()
		Mockito.when(dataService.listar()).thenReturn(datosTest);
		ResponseEntity<List<Dato>> respListar = controller.listar();
		
		Assert.assertEquals(respListar.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(datosTest, respListar.getBody());
        
        //Test reestructurar()
        Mockito.when(dataService.reestructurar(datosTest)).thenReturn(datosReestructuradosTest);
        ResponseEntity<String[]> respReestructurar = controller.reestructurar();
        
        Assert.assertEquals(respReestructurar.getStatusCode(), HttpStatus.CREATED);
        Assert.assertArrayEquals(datosReestructuradosTest, respReestructurar.getBody());
		
	}
}
