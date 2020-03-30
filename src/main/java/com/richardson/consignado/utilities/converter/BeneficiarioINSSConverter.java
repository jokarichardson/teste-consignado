package com.richardson.consignado.utilities.converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

import com.richardson.consignado.model.dto.BeneficiarioDTO;
import com.richardson.consignado.model.entity.BeneficiarioINSS;


public class BeneficiarioINSSConverter {

	public static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	public static BeneficiarioDTO toBeneficiarioDTO(BeneficiarioINSS beneficiarioINSS) {
		
		BeneficiarioDTO beneficiarioDTO = BeneficiarioDTO.builder()
				.cpfCliente(StringUtils.leftPad(beneficiarioINSS.getCpfCliente().toString(), 12, "0"))
				.nomeCliente(beneficiarioINSS.getNomeCliente())
				.margemDisponivel(beneficiarioINSS.getMargemDisponivel())
				.numeroBeneficio(beneficiarioINSS.getNumeroBeneficio())
				.build();
		
		if (Objects.nonNull(beneficiarioINSS.getDataAutorizacaoConsulta()))
			beneficiarioDTO.setDataAutorizacaoConsulta(dtf.format(beneficiarioINSS.getDataAutorizacaoConsulta()));
		
		beneficiarioDTO.setDataNascimentoCliente(dtf.format(beneficiarioINSS.getDataNascimentoCliente()));
		
		if (Objects.nonNull(beneficiarioINSS.getDataDespachoBeneficio()))
			beneficiarioDTO.setDataDespachoBeneficio(dtf.format(beneficiarioINSS.getDataDespachoBeneficio()));
		
		return beneficiarioDTO;
	}
	
	public static BeneficiarioINSS fromBeneficiarioDTO(BeneficiarioDTO beneficiarioDTO) {
		return BeneficiarioINSS.builder()
				.cpfCliente(Long.parseLong(beneficiarioDTO.getCpfCliente()))
				.nomeCliente(beneficiarioDTO.getNomeCliente())
				.margemDisponivel(beneficiarioDTO.getMargemDisponivel())
				.numeroBeneficio(beneficiarioDTO.getNumeroBeneficio())
				.dataAutorizacaoConsulta(LocalDate.parse(beneficiarioDTO.getDataAutorizacaoConsulta(), dtf))
				.dataNascimentoCliente(LocalDate.parse(beneficiarioDTO.getDataNascimentoCliente(), dtf))
				.dataDespachoBeneficio(LocalDate.parse(beneficiarioDTO.getDataDespachoBeneficio(), dtf))
				.build();		
	}
}
