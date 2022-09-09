package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Vuelo;

public interface IVueloService {

	public Vuelo buscar(String numero);
	public void actualizar(Vuelo vuelo);
	
}
