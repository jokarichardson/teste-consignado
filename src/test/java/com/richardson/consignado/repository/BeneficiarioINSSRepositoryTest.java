package com.richardson.consignado.repository;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.richardson.consignado.model.entity.BeneficiarioINSS;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BeneficiarioINSSRepositoryTest {
	
	@Autowired
	private BeneficiarioINSSRepository beneficiarioINSSRepository;
	
	@Test
	public void deveRetornarOfertas() {
		List<BeneficiarioINSS> actualBeneficiarioINSSList = this.beneficiarioINSSRepository.getOfertas();
		
		assertNotNull(actualBeneficiarioINSSList);
	}

	@Test
	public void deveRetornarOfertasAutorizadas() {
		List<BeneficiarioINSS> actualBeneficiarioINSSList = this.beneficiarioINSSRepository.getOfertasAutorizadas();
		
		assertNotNull(actualBeneficiarioINSSList);
	}
}
