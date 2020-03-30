package com.richardson.consignado.application.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.richardson.consignado.application.ConsignadoApplication;
import com.richardson.consignado.model.dto.BeneficiarioDTO;
import com.richardson.consignado.model.dto.CreditoContratadoDTO;
import com.richardson.consignado.service.ConsignadoService;

@Component
public class ConsignadoApplicationImpl implements ConsignadoApplication {

	@Autowired
	private ConsignadoService consignadoService;

	@Override
	public List<BeneficiarioDTO> recuperarOfertas() {
		return this.consignadoService.recuperarOfertas();
	}

	@Override
	public List<BeneficiarioDTO> recuperarOfertasAutorizadas() {
		return this.consignadoService.recuperarOfertasAutorizadas();
	}

	@Override
	public CreditoContratadoDTO armazenarConsignado(CreditoContratadoDTO creditoContratadoDTO) {
		return this.consignadoService.armazenarConsignado(creditoContratadoDTO);
	}
	
	
}
