package com.ejercicio.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ejercicio.model.Dato;
import com.ejercicio.service.impl.DataServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class DataServiceMockitoTest {
	
	private IDataService dataService = Mockito.mock(IDataService.class);
	
	@Test
	public void listarTest() throws Exception {
		
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
		
		List<Dato> datosTest = new ArrayList<Dato>(); 
		
		datosTest.add(dato1);
		datosTest.add(dato2);
		datosTest.add(dato3);
		datosTest.add(dato4);
		
		Mockito.when(dataService.listar()).thenReturn(null);
		assertNull(dataService.listar());
		
		Mockito.when(dataService.listar()).thenReturn(datosTest);
		assertNotNull("No se pudo obtener el listado de Datos.", dataService.listar());
	}
	
	@Test
	public void reestructurarTest() throws Exception {
		
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
		
		List<Dato> datosTest = new ArrayList<Dato>(); 
		
		datosTest.add(dato1);
		datosTest.add(dato2);
		datosTest.add(dato3);
		datosTest.add(dato4);
		
		String[] datosEsperados = new String[datosTest.size()];
		for (int i = 0; i < datosTest.size(); i++) {
			datosEsperados[i] = datosTest.get(i).getPostId() + "|" + datosTest.get(i).getId() + "|" + datosTest.get(i).getEmail();
		}
		
		Mockito.when(dataService.reestructurar(datosTest)).thenReturn(null);
		assertNull(dataService.reestructurar(datosTest));
		
		Mockito.when(dataService.reestructurar(datosTest)).thenReturn(datosEsperados);
		assertNotNull("No hay datos Reestructurados", dataService.reestructurar(datosTest));

	}
}
