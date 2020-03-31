package com.richardson.consignado.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.richardson.consignado.mocks.ConsignadoContratadoMock;
import com.richardson.consignado.model.entity.ConsignadoContratado;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ConsignadoContratadoRepositoryTest {
	
	@Autowired
	private ConsignadoContratadoRepository consignadoContratadoRepository;
	
	@Test
	public void deveArmazenarConsignadoContratado() {
		ConsignadoContratado actualConsignadoContratado = this.consignadoContratadoRepository.save(ConsignadoContratadoMock.criarConsignadoContratado());
		
		assertNotNull(actualConsignadoContratado);
	}

}
