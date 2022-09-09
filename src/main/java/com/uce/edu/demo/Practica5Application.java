package com.uce.edu.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.IVueloRepository;
import com.uce.edu.demo.repository.modelo.VueloLigero;
import com.uce.edu.demo.service.IClienteGestor;

@SpringBootApplication
public class Practica5Application implements CommandLineRunner {

	@Autowired
	private IVueloRepository vueloRepository;

	@Autowired
	private IClienteGestor clienteGestor;
	

	public static void main(String[] args) {
		SpringApplication.run(Practica5Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		List<VueloLigero> lv = this.vueloRepository.buscarVuelos("Quito", "Cuenca", LocalDateTime.of(2022, 11,1, 0, 0, 0));
//		for (VueloLigero v : lv) {
//			System.out.println(v);
//		}
//		List<VueloLigero> lv = this.clienteGestor.buscarVuelos("Ibarra", "Cuenca", "08/12/2022");
//		for (VueloLigero v : lv) {
//			System.out.println(v);
//		}
	}

}
