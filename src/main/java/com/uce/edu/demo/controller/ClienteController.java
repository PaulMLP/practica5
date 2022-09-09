package com.uce.edu.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.demo.repository.modelo.CompraPasaje;
import com.uce.edu.demo.repository.modelo.Vuelo;
import com.uce.edu.demo.repository.modelo.VueloLigero;
import com.uce.edu.demo.service.IClienteGestor;
import com.uce.edu.demo.service.IVueloService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private IClienteGestor clienteGestor;
	
	@Autowired
	private IVueloService vueloService;

	@GetMapping("/buscarTodos")
	public String buscarVuelos(Model modelo) {

		List<VueloLigero> lista = this.clienteGestor.buscarTodo();
		modelo.addAttribute("vuelos", lista);
		return "vistaBusqueda";
	}
	
	@GetMapping("/buscar/{origen}/{destino}/{fecha}")
	public String buscarVuelos(@PathVariable("origen") String origen, @PathVariable("destino") String destino,
			@PathVariable("fecha") String fecha, Model modelo) {
		List<VueloLigero> lista = this.clienteGestor.buscarVuelos(origen, destino,
				fecha);
		modelo.addAttribute("vuelos", lista);
		return "vistaBusqueda";
	}
	
	@GetMapping("/buscarCampos")
	public String buscarVuelos(VueloLigero vueloLigero) {
		return "vistaVuelo";
	}
	
	@GetMapping("/buscarVuelo/{numero}")
	public String buscarVuelo(@PathVariable("numero") String numero, CompraPasaje compraPasaje,Model  modelo) {
		Vuelo vuelo = this.vueloService.buscar(numero);
		modelo.addAttribute("vuelo", vuelo);
		return "vistaEleccion";
	}

	@PostMapping("/reservar/{numero}")
	public String buscarV(@PathVariable("numero") String numero, CompraPasaje compraPasaje) {
		this.clienteGestor.reservarPasajes(numero, compraPasaje.getCantidadAsientosComprados(), compraPasaje.getNumeroTarjeta());
		return "redirect:/clientes/buscarTodos";
	}

}
