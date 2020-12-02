package com.ejercicio.service;

import java.util.List;

import com.ejercicio.model.Dato;

public interface IDataService {
	
	List<Dato> listar() throws Exception;
	String[] reestructurar(List<Dato> datos) throws Exception;
}
