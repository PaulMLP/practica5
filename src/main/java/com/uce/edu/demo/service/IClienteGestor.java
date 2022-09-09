package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Vuelo;
import com.uce.edu.demo.repository.modelo.VueloLigero;

public interface IClienteGestor {

	public List<VueloLigero>  buscarVuelos(String origen, String destino, String fecha);
	
	public void reservarPasajes(String numero, Integer cantidad, String numeroTarjeta);
	

	public List<VueloLigero> buscarTodo();
}
