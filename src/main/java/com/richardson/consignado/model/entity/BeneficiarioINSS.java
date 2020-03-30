package com.richardson.consignado.model.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.richardson.consignado.utilities.serialization.DateDeserializer;
import com.richardson.consignado.utilities.serialization.DateSerializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "beneficiarios_INSS")
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class BeneficiarioINSS implements Serializable {
	private static final long serialVersionUID = 1571081156222164352L;
	
	@Id
	@Column(name = "cpf_cliente")
	private Long cpfCliente;
	
	@Column(name = "nome_cliente")
	private String nomeCliente;
	
	@Column(name = "margem_disponivel_contratacao")
	private Double margemDisponivel;
	
	@Column(name = "numero_beneficio")
	private Integer numeroBeneficio;
	
	@Column(name = "data_autorizacao_consulta")
	@JsonDeserialize(using = DateDeserializer.class)
	@JsonSerialize(using = DateSerializer.class)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataAutorizacaoConsulta;
	
	@Column(name = "data_nascimento_cliente")
	@JsonDeserialize(using = DateDeserializer.class)
	@JsonSerialize(using = DateSerializer.class)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNascimentoCliente;
	
	@Column(name = "data_despacho_beneficio")
	@JsonDeserialize(using = DateDeserializer.class)
	@JsonSerialize(using = DateSerializer.class)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataDespachoBeneficio;
}
