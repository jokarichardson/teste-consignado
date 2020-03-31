package com.richardson.consignado.application;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.richardson.consignado.application.implementation.ConsignadoApplicationImpl;
import com.richardson.consignado.mocks.BeneficiarioINSSMock;
import com.richardson.consignado.mocks.ConsignadoContratadoMock;
import com.richardson.consignado.model.dto.BeneficiarioDTO;
import com.richardson.consignado.model.dto.CreditoContratadoDTO;
import com.richardson.consignado.service.ConsignadoService;
import com.richardson.consignado.utilities.converter.BeneficiarioINSSConverter;
import com.richardson.consignado.utilities.converter.ConsignadoContratadoConverter;

@RunWith(SpringRunner.class)
public class ConsignadoApplicationTest {

	@InjectMocks
	private ConsignadoApplicationImpl consignadoApplication;

	@Mock
	private ConsignadoService consignadoService;

	@Test
	public void deveRetornarOfertas() {
		List<BeneficiarioDTO> expectedBeneficiarioDTOList = Collections.singletonList(
				BeneficiarioINSSConverter.toBeneficiarioDTO(BeneficiarioINSSMock.criarBeneficiarioINSS()));

		when(this.consignadoService.recuperarOfertas()).thenReturn(expectedBeneficiarioDTOList);
		
		List<BeneficiarioDTO> actualBeneficiarioDTOList = this.consignadoApplication.recuperarOfertas();
		
		assertNotNull(actualBeneficiarioDTOList);
		assertEquals(expectedBeneficiarioDTOList, actualBeneficiarioDTOList);
		verify(this.consignadoService, times(1)).recuperarOfertas();
	}
	
	@Test
	public void deveRetornarOfertasAutorizadas() {
		List<BeneficiarioDTO> expectedBeneficiarioDTOList = Collections.singletonList(
				BeneficiarioINSSConverter.toBeneficiarioDTO(BeneficiarioINSSMock.criarBeneficiarioINSS()));

		when(this.consignadoService.recuperarOfertasAutorizadas()).thenReturn(expectedBeneficiarioDTOList);
		
		List<BeneficiarioDTO> actualBeneficiarioDTOList = this.consignadoApplication.recuperarOfertasAutorizadas();
		
		assertNotNull(actualBeneficiarioDTOList);
		assertEquals(expectedBeneficiarioDTOList, actualBeneficiarioDTOList);
		verify(this.consignadoService, times(1)).recuperarOfertasAutorizadas();
	}
	
	@Test
	public void deveArmazenarConsignadoContratado() {
		CreditoContratadoDTO expectedCreditoContratadoDTO = ConsignadoContratadoConverter.toCreditoContratadoDTO(ConsignadoContratadoMock.criarConsignadoContratado());
		
		when(this.consignadoService.armazenarConsignado(any(CreditoContratadoDTO.class))).thenReturn(expectedCreditoContratadoDTO);
		
		CreditoContratadoDTO actualCreditoContratadoDTO = this.consignadoApplication.armazenarConsignado(expectedCreditoContratadoDTO);
		
		assertNotNull(actualCreditoContratadoDTO);
		assertEquals(expectedCreditoContratadoDTO, actualCreditoContratadoDTO);
		verify(this.consignadoService, times(1)).armazenarConsignado(any(CreditoContratadoDTO.class));
	}
}
