package com.richardson.consignado.mocks;

import java.time.LocalDate;

import com.richardson.consignado.model.dto.BeneficiarioDTO;
import com.richardson.consignado.model.entity.BeneficiarioINSS;

public class BeneficiarioINSSMock {

	public static BeneficiarioINSS criarBeneficiarioINSS() {
		return BeneficiarioINSS.builder().cpfCliente(Long.parseLong("18492652756"))
				.nomeCliente("CLIENTE TESTE")
				.margemDisponivel(0.32)
				.numeroBeneficio(12332122)
				.dataAutorizacaoConsulta(LocalDate.now().minusDays(95))
				.dataNascimentoCliente(LocalDate.now().minusYears(65))
				.dataDespachoBeneficio(LocalDate.now().minusDays(185))
				.build();
	}

	public static BeneficiarioDTO criarBeneficiarioDTO() {
		return BeneficiarioDTO.builder().cpfCliente("18492652756")
				.nomeCliente("CLIENTE TESTE")
				.margemDisponivel(0.32)
				.numeroBeneficio(12332122)
				.dataAutorizacaoConsulta("2019-11-01")
				.dataNascimentoCliente("1952-10-06")
				.dataDespachoBeneficio("2019-07-20")
				.build();
	}
}
