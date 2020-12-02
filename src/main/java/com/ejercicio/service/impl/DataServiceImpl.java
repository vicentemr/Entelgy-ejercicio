package com.ejercicio.service.impl;
	
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ejercicio.model.Dato;
import com.ejercicio.service.IDataService;

@Service
public class DataServiceImpl implements IDataService{
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public List<Dato> listar() throws Exception {
		
		String url = "https://jsonplaceholder.typicode.com/comments";
		ResponseEntity<List<Dato>> response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Dato>>() {});
		List<Dato> datos = response.getBody();
		return datos;
	}

	@Override
	public String[] reestructurar(List<Dato> datos) throws Exception {

		String[] reestructurados = new String[datos.size()];
		for (int i = 0; i < datos.size(); i++) {
			reestructurados[i] = datos.get(i).getPostId() + "|" + datos.get(i).getId() + "|" + datos.get(i).getEmail();
		}
		
		return reestructurados;
	}
	
	

}
