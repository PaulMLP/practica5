package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IVueloRepository;
import com.uce.edu.demo.repository.modelo.Vuelo;

@Service
public class VueloServiceImpl implements IVueloService {

	@Autowired
	private IVueloRepository vueloRepository;
	
	@Override
	public Vuelo buscar(String numero) {
		return this.vueloRepository.buscarPorNumero(numero);
	}

	
	@Override
	public void actualizar(Vuelo vuelo) {
		this.vueloRepository.actualizar(vuelo);
	}

	
}
