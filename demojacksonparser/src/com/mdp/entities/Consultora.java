package com.mdp.entities;

import com.fasterxml.jackson.annotation.*;

public class Consultora
{
	@JsonProperty("codConsult") private String codigoConsultora;
	@JsonProperty("codPerfil") private String codigoPerfil;
	@JsonProperty("nombres") private String nombre;
	@JsonProperty("apePaterno") private String apellidoPaterno;
	@JsonProperty("apeMaterno") private String apellidoMaterno;
	
	public String getCodigoConsultora() {
		return codigoConsultora;
	}
	public void setCodigoConsultora(String codigoConsultora) {
		this.codigoConsultora = codigoConsultora;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
}
