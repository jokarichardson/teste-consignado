package com.richardson.consignado.service;

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

import com.richardson.consignado.exception.ConsignadoGenericException;
import com.richardson.consignado.mocks.BeneficiarioINSSMock;
import com.richardson.consignado.mocks.ConsignadoContratadoMock;
import com.richardson.consignado.model.dto.BeneficiarioDTO;
import com.richardson.consignado.model.dto.CreditoContratadoDTO;
import com.richardson.consignado.model.entity.BeneficiarioINSS;
import com.richardson.consignado.model.entity.ConsignadoContratado;
import com.richardson.consignado.repository.BeneficiarioINSSRepository;
import com.richardson.consignado.repository.ConsignadoContratadoRepository;
import com.richardson.consignado.utilities.converter.BeneficiarioINSSConverter;
import com.richardson.consignado.utilities.converter.ConsignadoContratadoConverter;

@RunWith(SpringRunner.class)
public class ConsignadoServiceTest {

	@InjectMocks
	private ConsignadoService consignadoService;

	@Mock
	private BeneficiarioINSSRepository beneficiarioINSSRepository;

	@Mock
	private ConsignadoContratadoRepository consignadoContratadoRepository;

	@Test
	public void deveRetornarOfertas() {
		List<BeneficiarioINSS> repositoryBeneficiarioINSSList = Collections
				.singletonList(BeneficiarioINSSMock.criarBeneficiarioINSS());

		List<BeneficiarioDTO> expectedBeneficiarioDTOList = Collections.singletonList(
				BeneficiarioINSSConverter.toBeneficiarioDTO(BeneficiarioINSSMock.criarBeneficiarioINSS()));

		when(this.beneficiarioINSSRepository.getOfertas()).thenReturn(repositoryBeneficiarioINSSList);

		List<BeneficiarioDTO> actualBeneficiarioDTOList = this.consignadoService.recuperarOfertas();

		assertNotNull(actualBeneficiarioDTOList);
		assertEquals(expectedBeneficiarioDTOList, actualBeneficiarioDTOList);
		verify(this.beneficiarioINSSRepository, times(1)).getOfertas();
	}
	
	@Test(expected = ConsignadoGenericException.class)
	public void deveLancarConsignadoGenericExceptionAoRetornarOfertas() {
		when(this.beneficiarioINSSRepository.getOfertas()).thenThrow(ConsignadoGenericException.class);

		this.consignadoService.recuperarOfertas();
	}
	
	@Test
	public void deveRetornarOfertasAutorizadas() {
		List<BeneficiarioINSS> repositoryBeneficiarioINSSList = Collections
				.singletonList(BeneficiarioINSSMock.criarBeneficiarioINSS());

		List<BeneficiarioDTO> expectedBeneficiarioDTOList = Collections.singletonList(
				BeneficiarioINSSConverter.toBeneficiarioDTO(BeneficiarioINSSMock.criarBeneficiarioINSS()));

		when(this.beneficiarioINSSRepository.getOfertasAutorizadas()).thenReturn(repositoryBeneficiarioINSSList);

		List<BeneficiarioDTO> actualBeneficiarioDTOList = this.consignadoService.recuperarOfertasAutorizadas();

		assertNotNull(actualBeneficiarioDTOList);
		assertEquals(expectedBeneficiarioDTOList, actualBeneficiarioDTOList);
		verify(this.beneficiarioINSSRepository, times(1)).getOfertasAutorizadas();
	}
	
	@Test(expected = ConsignadoGenericException.class)
	public void deveLancarConsignadoGenericExceptionAoRetornarOfertasAutorizadas() {
		when(this.beneficiarioINSSRepository.getOfertasAutorizadas()).thenThrow(ConsignadoGenericException.class);

		this.consignadoService.recuperarOfertasAutorizadas();
	}

	@Test
	public void deveArmazenarConsignadoContratado() {
		ConsignadoContratado persistedConsignadoContratado = ConsignadoContratadoMock.criarConsignadoContratado();
		CreditoContratadoDTO expectedCreditoContratadoDTO = ConsignadoContratadoConverter.toCreditoContratadoDTO(ConsignadoContratadoMock.criarConsignadoContratado());
		
		when(this.consignadoContratadoRepository.save(any(ConsignadoContratado.class))).thenReturn(persistedConsignadoContratado);
		
		CreditoContratadoDTO actualCreditoContratadoDTO = this.consignadoService.armazenarConsignado(expectedCreditoContratadoDTO);
		
		assertNotNull(actualCreditoContratadoDTO);
		assertEquals(expectedCreditoContratadoDTO, actualCreditoContratadoDTO);
		verify(this.consignadoContratadoRepository, times(1)).save(any(ConsignadoContratado.class));
	}
	
	@Test(expected = ConsignadoGenericException.class)
	public void deveLancarConsignadoGenericExceptionAoArmazenarConsignadoContratado() {
		CreditoContratadoDTO expectedCreditoContratadoDTO = ConsignadoContratadoConverter.toCreditoContratadoDTO(ConsignadoContratadoMock.criarConsignadoContratado());
		
		when(this.consignadoContratadoRepository.save(any(ConsignadoContratado.class))).thenThrow(ConsignadoGenericException.class);
		
		this.consignadoService.armazenarConsignado(expectedCreditoContratadoDTO);
	}
}
