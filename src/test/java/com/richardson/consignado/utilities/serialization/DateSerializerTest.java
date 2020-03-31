package com.richardson.consignado.utilities.serialization;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.richardson.consignado.mocks.BeneficiarioINSSMock;
import com.richardson.consignado.model.entity.BeneficiarioINSS;

@RunWith(SpringRunner.class)
public class DateSerializerTest {

    private ObjectMapper mapper;
	
    @Before
    public void setUp() {
    	this.mapper = new ObjectMapper();
    }
    
	@Test
	public void deveSerializarUmaData() throws IOException {
		BeneficiarioINSS beneficiarioINSS = BeneficiarioINSSMock.criarBeneficiarioINSS();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String dateString = "1952-10-06";
		beneficiarioINSS.setDataNascimentoCliente(LocalDate.parse(dateString, dtf));
		
		String result = this.mapper.writeValueAsString(beneficiarioINSS);
		assertThat(result, containsString(dateString));
		
	}
}
