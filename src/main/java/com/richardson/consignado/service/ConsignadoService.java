package com.richardson.consignado.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.richardson.consignado.exception.ConsignadoGenericException;
import com.richardson.consignado.model.dto.BeneficiarioDTO;
import com.richardson.consignado.model.dto.CreditoContratadoDTO;
import com.richardson.consignado.model.entity.BeneficiarioINSS;
import com.richardson.consignado.model.entity.ConsignadoContratado;
import com.richardson.consignado.repository.BeneficiarioINSSRepository;
import com.richardson.consignado.repository.ConsignadoContratadoRepository;
import com.richardson.consignado.utilities.converter.BeneficiarioINSSConverter;
import com.richardson.consignado.utilities.converter.ConsignadoContratadoConverter;

@Service
public class ConsignadoService {
	@Autowired
	private BeneficiarioINSSRepository beneficiarioINSSRepository;
	
	@Autowired
	private ConsignadoContratadoRepository consignadoContratadoRepository;
	
	public List<BeneficiarioDTO> recuperarOfertas() {
		
		try {
			List<BeneficiarioINSS> beneficiariosINSS = this.beneficiarioINSSRepository.getOfertas();
			List<BeneficiarioDTO> beneficiariosDTO = new ArrayList<>();
			
			beneficiariosINSS.forEach(beneficiarioINSS -> beneficiariosDTO.add(BeneficiarioINSSConverter.toBeneficiarioDTO(beneficiarioINSS)));
			
			return beneficiariosDTO;
		} catch (Exception ex) {
			throw new ConsignadoGenericException(ex.getMessage());
		}
	}
	
	public List<BeneficiarioDTO> recuperarOfertasAutorizadas() {
		try {
			List<BeneficiarioINSS> beneficiariosINSS = this.beneficiarioINSSRepository.getOfertasAutorizadas();
			List<BeneficiarioDTO> beneficiariosDTO = new ArrayList<>();
			
			beneficiariosINSS.forEach(beneficiarioINSS -> beneficiariosDTO.add(BeneficiarioINSSConverter.toBeneficiarioDTO(beneficiarioINSS)));
			
			return beneficiariosDTO;
		} catch (Exception ex) {
			throw new ConsignadoGenericException(ex.getMessage());
		}
	}
	
	public CreditoContratadoDTO armazenarConsignado(CreditoContratadoDTO creditoContratadoDTO) {
		try {
			ConsignadoContratado consignadoContratado = ConsignadoContratadoConverter.fromCreditoContratadoDTO(creditoContratadoDTO);
			
			consignadoContratado = this.consignadoContratadoRepository.save(consignadoContratado);
			
			return ConsignadoContratadoConverter.toCreditoContratadoDTO(consignadoContratado);
		} catch (Exception ex) {
			throw new ConsignadoGenericException(ex.getMessage());
		}
	}
}
