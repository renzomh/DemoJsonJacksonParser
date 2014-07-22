package com.mdp.entities;

import com.fasterxml.jackson.annotation.*;

public class ProductoObligatorio {

	@JsonProperty("codRapProd") private String codRapProd;
	@JsonProperty("cabOferta") private String cabOferta;
	@JsonProperty("descOferta") private String descOferta;
	
	public String getCodRapProd() {
		return codRapProd;
	}
	public void setCodRapProd(String codRapProd) {
		this.codRapProd = codRapProd;
	}
	public String getCabOferta() {
		return cabOferta;
	}
	public void setCabOferta(String cabOferta) {
		this.cabOferta = cabOferta;
	}
	public String getDescOferta() {
		return descOferta;
	}
	public void setDescOferta(String descOferta) {
		this.descOferta = descOferta;
	}
}
