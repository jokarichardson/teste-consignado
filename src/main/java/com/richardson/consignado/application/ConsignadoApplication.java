package com.richardson.consignado.application;

import java.util.List;

import com.richardson.consignado.model.dto.BeneficiarioDTO;
import com.richardson.consignado.model.dto.CreditoContratadoDTO;

public interface ConsignadoApplication {
	List<BeneficiarioDTO> recuperarOfertas();
	List<BeneficiarioDTO> recuperarOfertasAutorizadas();
	CreditoContratadoDTO armazenarConsignado(CreditoContratadoDTO creditoConsignadoDTO);
	
}
