package com.richardson.consignado.utilities.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.richardson.consignado.mocks.BeneficiarioINSSMock;
import com.richardson.consignado.model.dto.BeneficiarioDTO;
import com.richardson.consignado.model.entity.BeneficiarioINSS;

@RunWith(SpringRunner.class)
public class BeneficiarioINSSConverterTest {
	
	@Test
	public void deveConverterBeneficiarioINSSParaBeneficiarioDTO() {
		BeneficiarioINSS beneficiarioINSS = BeneficiarioINSSMock.criarBeneficiarioINSS();
		BeneficiarioDTO beneficiarioDTO  = BeneficiarioINSSConverter.toBeneficiarioDTO(beneficiarioINSS);
		
		assertNotNull(beneficiarioDTO);
		assertEquals(beneficiarioINSS.getNomeCliente(), beneficiarioDTO.getNomeCliente());
		
		Long cpfCliente = Long.parseLong(beneficiarioDTO.getCpfCliente());
		assertEquals(beneficiarioINSS.getCpfCliente(), cpfCliente);
	}
	
	@Test
	public void deveConverterBeneficiarioDTOParaBeneficiarioINSS() {
		BeneficiarioDTO beneficiarioDTO  = BeneficiarioINSSMock.criarBeneficiarioDTO();
		BeneficiarioINSS beneficiarioINSS = BeneficiarioINSSConverter.fromBeneficiarioDTO(beneficiarioDTO);
		
		assertNotNull(beneficiarioINSS);
		assertEquals(beneficiarioDTO.getNomeCliente(), beneficiarioINSS.getNomeCliente());
		
		String cpfCliente = StringUtils.leftPad(beneficiarioINSS.getCpfCliente().toString(), 11, "0");
		assertEquals(beneficiarioDTO.getCpfCliente(), cpfCliente);		
	}

}
