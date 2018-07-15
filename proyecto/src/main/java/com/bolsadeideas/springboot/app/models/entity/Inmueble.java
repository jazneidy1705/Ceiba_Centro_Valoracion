package com.bolsadeideas.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.bolsadeideas.springboot.app.enu.TipoInmuebleBDEnum;

@Entity
@Table(name = "inmueble")
public class Inmueble implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String direccion;

	@NotEmpty
	private String metraje;

	@NotEmpty
	private String ciudad;

	@NotEmpty
	private String pais;

	@ManyToOne
	private Cliente cliente;

//	@NotEmpty
//	@
	private double latitud;

//	@NotEmpty
	private double longitud;

	@Enumerated(EnumType.STRING)
	private TipoInmuebleBDEnum tipoInmueble;
	
	@OneToOne(mappedBy="inmueble")
	private Seguro seguro;

	public Seguro getSeguro() {
		return seguro;
	}

	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}

	public TipoInmuebleBDEnum getTipoInmueble() {
		return tipoInmueble;
	}

	public void setTipoInmueble(TipoInmuebleBDEnum tipoInmueble) {
		this.tipoInmueble = tipoInmueble;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getMetraje() {
		return metraje;
	}

	public void setMetraje(String metraje) {
		this.metraje = metraje;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

}
