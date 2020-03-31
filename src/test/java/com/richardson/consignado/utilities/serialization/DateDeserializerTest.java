package com.richardson.consignado.utilities.serialization;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.richardson.consignado.model.entity.BeneficiarioINSS;

@RunWith(SpringRunner.class)
public class DateDeserializerTest {
	private ObjectMapper mapper;
	private String dataNascimento = "1952-10-06";

	private SimpleDateFormat sdf;
	private DateTimeFormatter dtf;

	@Before
	public void setUp() {
		this.sdf = new SimpleDateFormat("yyyy-MM-dd");
		this.dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		this.mapper = new ObjectMapper();
		this.mapper.setDateFormat(sdf);
	}

	@Test
	public void deveDesserializarUmaData() throws IOException {
		String beneficiarioINSSJson = "{\"cpfCliente\":18492652756,\"nomeCliente\":\"CLIENTE TESTE\",\"margemDisponivel\":0.32,\"numeroBeneficio\":12332122,\"dataAutorizacaoConsulta\":\"2019-12-27\",\"dataNascimentoCliente\":\"1952-10-06\",\"dataDespachoBeneficio\":\"2019-09-28\"}";

		BeneficiarioINSS actualBeneficiarioINSS = this.mapper.readerFor(BeneficiarioINSS.class)
				.readValue(beneficiarioINSSJson);

		LocalDateTime actualDataNascimento = LocalDateTime.of(
				actualBeneficiarioINSS.getDataNascimentoCliente().getYear(),
				actualBeneficiarioINSS.getDataNascimentoCliente().getMonthValue(),
				actualBeneficiarioINSS.getDataNascimentoCliente().getDayOfMonth(), 0, 0);

		assertEquals(dataNascimento, this.dtf.format(actualDataNascimento));
	}

	@Test
	public void deveRetornarNullAoDesserializarUmaDataInvalida() throws IOException {
		String beneficiarioINSSJsonDataAutorizacaoInvalida = "{\"cpfCliente\":18492652756,\"nomeCliente\":\"CLIENTE TESTE\",\"margemDisponivel\":0.32,\"numeroBeneficio\":12332122,\"dataAutorizacaoConsulta\":\"2019-02-29 00:00:00\",\"dataNascimentoCliente\":\"1952-10-06\",\"dataDespachoBeneficio\":\"2019-09-28\"}";

		BeneficiarioINSS actualBeneficiarioINSS = this.mapper.readerFor(BeneficiarioINSS.class)
				.readValue(beneficiarioINSSJsonDataAutorizacaoInvalida);

		assertNull(actualBeneficiarioINSS.getDataAutorizacaoConsulta());
	}
}