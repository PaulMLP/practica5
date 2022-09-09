package com.uce.edu.demo.repository.modelo;

import java.math.BigDecimal;

public class VueloLigero {

	private String numero;

	private String origen;

	private String destino;

	private String categoria;

	private String nombreAvion;

	private BigDecimal valorAsiento;

	private String fecha;

	private String estado;

	public VueloLigero() {
	}

	public VueloLigero(String numero, String origen, String destino, String categoria, String nombreAvion,
			BigDecimal valorAsiento, String estado) {
		super();
		this.numero = numero;
		this.origen = origen;
		this.destino = destino;
		this.categoria = categoria;
		this.nombreAvion = nombreAvion;
		this.valorAsiento = valorAsiento;
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "VueloLigero [numero=" + numero + ", origen=" + origen + ", destino=" + destino + ", categoria="
				+ categoria + ", nombreAvion=" + nombreAvion + ", valorAsiento=" + valorAsiento + ", estado=" + estado
				+ "]";
	}

	// SET y GET
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNombreAvion() {
		return nombreAvion;
	}

	public void setNombreAvion(String nombreAvion) {
		this.nombreAvion = nombreAvion;
	}

	public BigDecimal getValorAsiento() {
		return valorAsiento;
	}

	public void setValorAsiento(BigDecimal valorAsiento) {
		this.valorAsiento = valorAsiento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	

}
