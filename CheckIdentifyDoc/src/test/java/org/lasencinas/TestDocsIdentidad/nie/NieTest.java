package org.lasencinas.TestDocsIdentidad.nie;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.lasencinas.DocsIdentidad.NIE;

public class NieTest {

	@Test
	public void comprobarGetNie() {

		NIE nie = new NIE("Y9907784L");

		assertEquals(nie.getNie(), "Y9907784L");
	}

	@Test
	public void comprbarLetraControl() {

		NIE nie = new NIE("Y9907784L");

		String letraControl = "" + nie.getLetraControl();

		assertEquals(letraControl, "L");
	}

	@Test
	public void comprbarLetraInicial() {

		NIE nie = new NIE("Y9907784L");

		String letraInicial = "" + nie.getLetraInicial();

		assertEquals(letraInicial, "Y");
	}

	@Test
	public void comprbarLetraControlFail() {

		NIE nie = new NIE("Y9907784L");

		String letraControl = "" + nie.getLetraControl();

		assertNotEquals(letraControl, "S");
	}

	@Test
	public void comprbarLetraInicialFail() {

		NIE nie = new NIE("Y9907784L");

		String letraInicial = "" + nie.getLetraInicial();

		assertNotEquals(letraInicial, "F");
	}

	@Test
	public void comprbarGetDigitos() {

		NIE nie = new NIE("Y9907784L");

		assertEquals(nie.getDigitosNie(), 9907784);
	}

	@Test
	public void comprobarValorLetraInicial() {
		NIE nie = new NIE("X9907784L");
		nie.verificarComposicion();
		nie.calcularLetraInicial();
		assertEquals(nie.getValorLetraInicial(), 0);

		NIE nie1 = new NIE("Y9907784L");
		nie1.verificarComposicion();
		nie1.calcularLetraInicial();
		assertEquals(nie1.getValorLetraInicial(), 1);

		NIE nie2 = new NIE("Z9907784L");
		nie2.verificarComposicion();
		nie2.calcularLetraInicial();
		assertEquals(nie2.getValorLetraInicial(), 2);

	}

	@Test
	public void comprobarGetLetraControlCorrecta() {

		List<String> niesLista = Arrays.asList("Z3149115Y", "X0149115Y", "X3735122Z", "X4821048H", "Y3894320C",
				"X9684113D", "X1134776W", "Z2089626N", "Y4267460P", "Z8920631V");

		for (String nies : niesLista) {

			String letraNiesLista = "" + nies.charAt(nies.length() - 1);

			NIE nie = new NIE(nies);
			nie.verificarComposicion();
			nie.calcularLetraInicial();
			nie.calcularLetraControl();

			String letraCorrecta = "" + nie.getLetraControlCorrecta();

			assertEquals(letraCorrecta, letraNiesLista);
		}
	}

	@Test
	public void comprobarComposicionValida() {

		NIE nie = new NIE("Y2345678T");

		nie.verificarComposicion();

		assertTrue(nie.composicionValida());
	}

	@Test
	public void comprobarComposicionNoValida() {

		NIE nie = new NIE("Z23456T");

		nie.verificarComposicion();

		assertFalse(nie.composicionValida());
	}

	@Test
	public void comprobarNieValido() {

		List<String> niesLista = Arrays.asList("Z3149115Y", "X0149115Y", "X3735122Z", "X4821048H", "Y3894320C",
				"X9684113D", "X1134776W", "Z2089626N", "Y4267460P", "Z8920631V");

		for (String nies : niesLista) {


			NIE nie = new NIE(nies);
			nie.verificarComposicion();
			nie.calcularLetraInicial();
			nie.calcularLetraControl();
			nie.verificarDniValido();

			assertTrue(nie.nieValido() );
		}
	}
	
	@Test
	public void comprobarNieNoValido() {

		List<String> niesLista = Arrays.asList("Z3149115I", "X0149115S", "P3735122Z", "H4821048H", "Y3320C",
				"X9613D", "O1134776W", "Y2089626N", "24267460P", "O8920631V");

		for (String nies : niesLista) {


			NIE nie = new NIE(nies);
			nie.verificarComposicion();
			nie.calcularLetraInicial();
			nie.calcularLetraControl();
			nie.verificarDniValido();

			assertFalse(nie.nieValido() );
		}
	}

}
