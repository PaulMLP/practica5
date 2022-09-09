package com.uce.edu.demo.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICompraPasajeRepository;
import com.uce.edu.demo.repository.IVueloRepository;
import com.uce.edu.demo.repository.modelo.CompraPasaje;
import com.uce.edu.demo.repository.modelo.Vuelo;
import com.uce.edu.demo.repository.modelo.VueloLigero;

@Service
public class ClienteGestorImpl implements IClienteGestor {

	@Autowired
	private IVueloRepository vueloRepository;

	@Autowired
	private ICompraPasajeRepository compraPasajeRepository;

	@Override
	public List<VueloLigero> buscarVuelos(String origen, String destino, String fecha) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime fechaVuelo = LocalDateTime.parse(fecha, formatter);

		List<VueloLigero> lista = this.vueloRepository.buscarVuelos(origen, destino, fechaVuelo);
		List<VueloLigero> listaDisponibles = lista.parallelStream()
				.filter(vuelo -> vuelo.getEstado().equalsIgnoreCase("D")).collect(Collectors.toList());

		List<VueloLigero> listaEconomico = listaDisponibles.parallelStream()
				.filter(catego -> catego.getCategoria().equalsIgnoreCase("E")).collect(Collectors.toList());

		List<VueloLigero> listaNegocios = listaDisponibles.parallelStream()
				.filter(catego -> catego.getCategoria().equalsIgnoreCase("N")).collect(Collectors.toList());

		List<VueloLigero> listaTurista = listaDisponibles.parallelStream()
				.filter(catego -> catego.getCategoria().equalsIgnoreCase("T")).collect(Collectors.toList());

		List<VueloLigero> listaFin = Stream.of(listaEconomico, listaNegocios, listaTurista).flatMap(Collection::stream)
				.collect(Collectors.toList());

		return listaFin;
	}

	@Override
	public void reservarPasajes(String numero, Integer cantidad, String numeroTarjeta) {

		Vuelo vuelo = this.vueloRepository.buscarPorNumero(numero);
		CompraPasaje cp = new CompraPasaje();
		cp.setCantidadAsientosComprados(cantidad);
		cp.setNumeroTarjeta(numeroTarjeta);
		cp.setFechaCompra(LocalDateTime.now());
		cp.setVuelo(vuelo);
		cp.setEstado("R");
		this.compraPasajeRepository.insertar(cp);

		if (vuelo.getAsientosDisponibles() <= cantidad) {
			cantidad = vuelo.getAsientosDisponibles();
		}

		vuelo.setAsientosDisponibles(vuelo.getAsientosDisponibles() - cantidad);
		vuelo.setAsientosOcupados(vuelo.getAsientosOcupados() + cantidad);

		if (vuelo.getAsientosDisponibles() == 0) {
			vuelo.setEstado("ND");
		}

		this.vueloRepository.actualizar(vuelo);

	}

	@Override
	public List<VueloLigero> buscarTodo() {
		return this.vueloRepository.buscarTodos();
	}

}
