package com.richardson.consignado.utilities.converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.StringUtils;

import com.richardson.consignado.model.dto.CreditoContratadoDTO;
import com.richardson.consignado.model.entity.ConsignadoContratado;


public class ConsignadoContratadoConverter {

	public static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	public static CreditoContratadoDTO toCreditoContratadoDTO(ConsignadoContratado consignadoContratado) {
		return CreditoContratadoDTO.builder()
				.id(consignadoContratado.getId())
				.cpfCliente(StringUtils.leftPad(consignadoContratado.getCpfCliente().toString(), 11, "0"))
				.valorContratado(consignadoContratado.getValorContratado())
				.quantidadeParcelas(consignadoContratado.getQuantidadeParcelas())
				.dataVencimentoParcela(consignadoContratado.getDataVencimentoParcela())
				.dataInicioContrato(dtf.format(consignadoContratado.getDataInicioContrato()))
				.dataEnceramentoContrato(dtf.format(consignadoContratado.getDataEnceramentoContrato()))
				.numeroBeneficio(consignadoContratado.getNumeroBeneficio())
				.build();
	}
	
	public static ConsignadoContratado fromCreditoContratadoDTO(CreditoContratadoDTO creditoContratadoDTO) {
		return ConsignadoContratado.builder()
				.id(creditoContratadoDTO.getId())
				.cpfCliente(Long.parseLong(creditoContratadoDTO.getCpfCliente()))
				.valorContratado(creditoContratadoDTO.getValorContratado())
				.quantidadeParcelas(creditoContratadoDTO.getQuantidadeParcelas())
				.dataVencimentoParcela(creditoContratadoDTO.getDataVencimentoParcela())
				.dataInicioContrato(LocalDate.parse(creditoContratadoDTO.getDataInicioContrato(), dtf))
				.dataEnceramentoContrato(LocalDate.parse(creditoContratadoDTO.getDataEnceramentoContrato(), dtf))
				.numeroBeneficio(creditoContratadoDTO.getNumeroBeneficio())
				.build();		
	}
}
