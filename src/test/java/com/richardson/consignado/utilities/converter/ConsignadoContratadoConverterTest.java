package com.richardson.consignado.utilities.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.richardson.consignado.mocks.ConsignadoContratadoMock;
import com.richardson.consignado.model.dto.CreditoContratadoDTO;
import com.richardson.consignado.model.entity.ConsignadoContratado;

@RunWith(SpringRunner.class)
public class ConsignadoContratadoConverterTest {
	
	@Test
	public void deveConverterConsignadoContratadoParaCreditoContratadoDTO() {
		ConsignadoContratado consignadoContratado = ConsignadoContratadoMock.criarConsignadoContratado();
		CreditoContratadoDTO creditoContratadoDTO = ConsignadoContratadoConverter.toCreditoContratadoDTO(consignadoContratado);
		
		assertNotNull(creditoContratadoDTO);
		assertEquals(consignadoContratado.getNumeroBeneficio(), creditoContratadoDTO.getNumeroBeneficio());
	}
	
	@Test
	public void deveConverterCreditoContratadoDTOParaConsignadoContratado() {
		CreditoContratadoDTO creditoContratadoDTO = ConsignadoContratadoMock.criarCreditoContratadoDTO();
		ConsignadoContratado consignadoContratado = ConsignadoContratadoConverter.fromCreditoContratadoDTO(creditoContratadoDTO);
		
		assertNotNull(consignadoContratado);
		assertEquals(creditoContratadoDTO.getNumeroBeneficio(), consignadoContratado.getNumeroBeneficio());
	}
}
