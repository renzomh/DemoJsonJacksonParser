package com.mdp.entities;

import com.fasterxml.jackson.annotation.*;

public class InformacionFinanciera
{
	@JsonProperty("codConsult") private String codigoConsultora;
	@JsonProperty("codPais") private int codigoPais;
	@JsonProperty("credDipnbl") private double creditoDisponible;
	@JsonProperty("desCSTTCRD") private String descripcionCSTTCRD;
	@JsonProperty("descStCred") private String descStCred;
	@JsonProperty("detCredDsp") private double detCredDsp;
	@JsonProperty("vtaCmGrpPr") private double vtaCmGrpPr;
	@JsonProperty("detPgEfctv") private double detPgEfctv;
	@JsonProperty("detSaldFvr") private double detSaldFvr;
	@JsonProperty("deudaAcum") private double deudaAcum;
	@JsonProperty("indDeudAnt") private double indDeudAnt;
	@JsonProperty("indSttsCrd") private double indSttsCrd;
	@JsonProperty("limCredito") private double limCredito;
	@JsonProperty("vtaCampana") private double vtaCampana;
	
	public String getCodigoConsultora() {
		return codigoConsultora;
	}
	public void setCodigoConsultora(String codigoConsultora) {
		this.codigoConsultora = codigoConsultora;
	}
	public int getCodigoPais() {
		return codigoPais;
	}
	public void setCodigoPais(int codigoPais) {
		this.codigoPais = codigoPais;
	}
	public double getCreditoDisponible() {
		return creditoDisponible;
	}
	public void setCreditoDisponible(double creditoDisponible) {
		this.creditoDisponible = creditoDisponible;
	}
	public String getDescripcionCSTTCRD() {
		return descripcionCSTTCRD;
	}
	public void setDescripcionCSTTCRD(String descripcionCSTTCRD) {
		this.descripcionCSTTCRD = descripcionCSTTCRD;
	}
	public String getDescStCred() {
		return descStCred;
	}
	public void setDescStCred(String descStCred) {
		this.descStCred = descStCred;
	}
	public double getDetCredDsp() {
		return detCredDsp;
	}
	public void setDetCredDsp(double detCredDsp) {
		this.detCredDsp = detCredDsp;
	}
	public double getVtaCmGrpPr() {
		return vtaCmGrpPr;
	}
	public void setVtaCmGrpPr(double vtaCmGrpPr) {
		this.vtaCmGrpPr = vtaCmGrpPr;
	}
	public double getDetPgEfctv() {
		return detPgEfctv;
	}
	public void setDetPgEfctv(double detPgEfctv) {
		this.detPgEfctv = detPgEfctv;
	}
	public double getDetSaldFvr() {
		return detSaldFvr;
	}
	public void setDetSaldFvr(double detSaldFvr) {
		this.detSaldFvr = detSaldFvr;
	}
	public double getDeudaAcum() {
		return deudaAcum;
	}
	public void setDeudaAcum(double deudaAcum) {
		this.deudaAcum = deudaAcum;
	}
	public double getIndDeudAnt() {
		return indDeudAnt;
	}
	public void setIndDeudAnt(double indDeudAnt) {
		this.indDeudAnt = indDeudAnt;
	}
	public double getIndSttsCrd() {
		return indSttsCrd;
	}
	public void setIndSttsCrd(double indSttsCrd) {
		this.indSttsCrd = indSttsCrd;
	}
	public double getLimCredito() {
		return limCredito;
	}
	public void setLimCredito(double limCredito) {
		this.limCredito = limCredito;
	}
	public double getVtaCampana() {
		return vtaCampana;
	}
	public void setVtaCampana(double vtaCampana) {
		this.vtaCampana = vtaCampana;
	}
}
