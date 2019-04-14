package org.lasencinas.TestDocsIdentidad.nie;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.lasencinas.DocsIdentidad.Dni;
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
	
	@Test
	public void comprbarGetDigitos() {
		
		NIE nie = new NIE("Y9907784L");
		
		assertEquals(nie.getDigitosNie(),9907784);
	}
	
	@Test
	public void comprobarValorLetraInicial() {
		NIE nie = new NIE("X9907784L");
		nie.calcularLetraInicial();
		assertEquals(nie.getValorLetraInicial(),0);
		
		NIE nie1 = new NIE("Y9907784L");
		nie1.calcularLetraInicial();
		assertEquals(nie1.getValorLetraInicial(),1);
		
		NIE nie2 = new NIE("Z9907784L");
		nie2.calcularLetraInicial();
		assertEquals(nie2.getValorLetraInicial(),2);
		
	}
	
	@Test
	public void comprobarGetLetraControlCorrecta() {
		
		List<String> niesLista = Arrays.asList("Z3149115Y", "X0149115Y", "X3735122Z", "X4821048H", "Y3894320C", "X9684113D",
				"X1134776W", "Z2089626N", "Y4267460P", "Z8920631V");

		for (String nies : niesLista) {

			String letraNiesLista = "" + nies.charAt(nies.length() - 1);

			NIE nie = new NIE(nies);
			nie.calcularLetraInicial();
			nie.calcularLetra();
			

			String letraCorrecta = "" + nie.getLetraControlCorrecta();

			assertEquals(letraCorrecta, letraNiesLista);
		}
	}
	
	
}
