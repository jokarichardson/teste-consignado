package com.richardson.consignado.mocks;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.richardson.consignado.model.dto.CreditoContratadoDTO;
import com.richardson.consignado.model.entity.ConsignadoContratado;

public class ConsignadoContratadoMock {
	public static ConsignadoContratado criarConsignadoContratado() {
		return ConsignadoContratado.builder()
				.id(1)
				.cpfCliente(Long.parseLong("18492652756"))
				.valorContratado(BigDecimal.valueOf(2000.00))
				.quantidadeParcelas(12)
				.dataVencimentoParcela("10")
				.dataInicioContrato(LocalDate.now().plusDays(10))
				.dataEnceramentoContrato(LocalDate.now().plusMonths(12))
				.numeroBeneficio(6543212)
				.build();
	}
	
	public static CreditoContratadoDTO criarCreditoContratadoDTO() {
		return CreditoContratadoDTO.builder()
				.id(1)
				.cpfCliente("18492652756")
				.valorContratado(BigDecimal.valueOf(2000.00))
				.quantidadeParcelas(12)
				.dataVencimentoParcela("15")
				.dataInicioContrato("2020-04-10")
				.dataEnceramentoContrato("2020-03-10")
				.numeroBeneficio(6543212)
				.build();
	}
}
