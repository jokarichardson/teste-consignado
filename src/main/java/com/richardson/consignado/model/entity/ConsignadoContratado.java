package com.richardson.consignado.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "consignado_contratado")
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ConsignadoContratado implements Serializable {
	
	private static final long serialVersionUID = 3650678017602214312L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "cpf_cliente")
	private Long cpfCliente;
	
	@Column(name = "valor_contratado")
	private BigDecimal valorContratado;
	
	@Column(name = "quantidade_parcelas")
	private Integer quantidadeParcelas;
	
	@Column(name = "data_vencimento_parcela")
	private String dataVencimentoParcela;
	
	@Column(name = "data_inicio_contrato")
	@JsonDeserialize(using = DateDeserializer.class)
	@JsonSerialize(using = DateSerializer.class)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataInicioContrato;
	
	@Column(name = "data_encerramento_contrato")
	@JsonDeserialize(using = DateDeserializer.class)
	@JsonSerialize(using = DateSerializer.class)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataEnceramentoContrato;
	
	@Column(name = "numero_beneficio")
	private Integer numeroBeneficio;
}
