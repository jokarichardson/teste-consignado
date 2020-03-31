package com.richardson.consignado;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ConsignadoStarterApplicationTest {
	
	  @Test
	  public void deveIniciarAAplicacao() {
		  ConsignadoStarterApplication.main(new String[] {});
	  }
}
