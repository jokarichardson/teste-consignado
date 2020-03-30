package com.richardson.consignado.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.Gson;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@JsonPropertyOrder({ "cpfCliente", "nomeCliente", "margemDisponivel", "numeroBeneficio", "dataAutorizacaoConsulta",
		"dataNascimentoCliente", "dataDespachoBeneficio" })
public class BeneficiarioDTO {

	private String cpfCliente;
	private String nomeCliente;
	private Double margemDisponivel;
	private Integer numeroBeneficio;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private String dataAutorizacaoConsulta;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private String dataNascimentoCliente;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private String dataDespachoBeneficio;
	
	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
}
