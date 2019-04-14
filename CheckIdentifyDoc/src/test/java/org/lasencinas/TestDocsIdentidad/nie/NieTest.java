package org.lasencinas.TestDocsIdentidad.nie;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.lasencinas.DocsIdentidad.NIE;

public class NieTest {
	
	@Test
	public void comprobarGetNie() {
		
		NIE nie = new NIE("Y9907784L");
		
		assertEquals(nie.getNie(),"Y9907784L");
	}
	
	@Test
	public void comprbarLetraControl() {
		
		NIE nie = new NIE("Y9907784L");
		
		String letraControl = "" + nie.getLetraControl();
		
		assertEquals(letraControl,"L");
	}
	
	@Test
	public void comprbarLetraInicial() {
		
		NIE nie = new NIE("Y9907784L");
		
		String letraInicial = "" + nie.getLetraInicial();
		
		assertEquals(letraInicial,"Y");
	}
	
	@Test
	public void comprbarLetraControlFail() {
		
		NIE nie = new NIE("Y9907784L");
		
		String letraControl = "" + nie.getLetraControl();
		
		assertNotEquals(letraControl,"S");
	}
	
	@Test
	public void comprbarLetraInicialFail() {
		
		NIE nie = new NIE("Y9907784L");
		
		String letraInicial = "" + nie.getLetraInicial();
		
		assertNotEquals(letraInicial,"F");
	}

}
