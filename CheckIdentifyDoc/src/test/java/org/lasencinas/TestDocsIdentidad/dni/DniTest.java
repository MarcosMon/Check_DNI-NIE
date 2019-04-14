package org.lasencinas.TestDocsIdentidad.dni;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.lasencinas.DocsIdentidad.Dni;

public class DniTest {

	@Test
	public void comprobarGetDni() {

		Dni dni = new Dni("41232142J");

		assertEquals(dni.getDni(), "41232142J");
		assertNotNull(dni);
	}

	@Test
	public void comprobarGetLetraDni() {

		Dni dni = new Dni("41145321s");

		String letra = "" + dni.getLetraDni();

		assertEquals(letra, "S");
	}

	@Test
	public void comprbarGetLetraDniFail() {

		Dni dni = new Dni("43114312F");

		String letraCorrecta = "" + dni.getLetraDni();

		assertNotEquals(letraCorrecta, "S");

	}

	@Test
	public void comprobarGetDigitosDni() {

		Dni dni = new Dni("41145321s");

		int digitos = dni.getDigitosDni();

		assertEquals(digitos, 41145321);
	}

	@Test
	public void comprobarGetDigitosDniFail() {

		Dni dni = new Dni("41145321s");

		int digitos = dni.getDigitosDni();

		assertNotEquals(digitos, 31114321);

	}

	@Test
	public void comprobarLetraCorrecta() {

		List<String> dnis = Arrays.asList("78484464T", "72376173A", "01817200Q", "95882054E", "63587725Q", "26861694V",
				"21616083Q", "26868974Y", "40135330P", "89044648X");

		for (String dnisLista : dnis) {

			String letraDnisLista = "" + dnisLista.charAt(dnisLista.length() - 1);

			Dni dni = new Dni(dnisLista);

			dni.calcularLetra();

			String letraCorrecta = "" + dni.getLetraCorrecta();

			assertEquals(letraCorrecta, letraDnisLista);
		}
	}

	@Test
	public void comprobarLetraIncorrecta() {

		Dni dni = new Dni("78484464S");

		dni.calcularLetra();

		String letraCorrecta = "" + dni.getLetraCorrecta();

		assertNotEquals(letraCorrecta, "S");
	}
}
