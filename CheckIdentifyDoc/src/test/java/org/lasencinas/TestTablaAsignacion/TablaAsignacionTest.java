package org.lasencinas.TestTablaAsignacion;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.lasencinas.TablaAsignacion.TablaAsignacion;

public class TablaAsignacionTest {

	@Test
	public void comprobarLongitudTabla() {

		byte longitudCorrecta = 23;

		assertEquals(longitudCorrecta, TablaAsignacion.getLongitudTabla());

	}

	@Test
	public void comprobarTablaAsignacionNoValidaMayuscula() {
		HashMap<Integer, Character> tabla = new HashMap<Integer, Character>();
		Character[] letrasDocumento = { 'T', 'R', 'W', 'A', 'G', 'M', 'U', 'I', 'P', 'O', 'X', 'B', 'N', 'J', 'Z', 'S',
				'Q', 'V', 'H', 'L', 'C', 'K', 'E' };
		Pattern expresionRegular = null;
		Matcher comprobador = null;
		boolean emparejados = false;
		String letrasCorrectas = "";
		String letrasIncorrectas = "";

		for (int posicion = 0; posicion < letrasDocumento.length; posicion++) {
			tabla.put(posicion, letrasDocumento[posicion]);// Se crea un diccionario con clave valor

		}

		for (int letra = 0; letra < tabla.size(); letra++) {

			expresionRegular = Pattern.compile("[^IOUiou]");
			comprobador = expresionRegular.matcher("" + tabla.get(letra));
			emparejados = comprobador.matches();

			if (emparejados) {

				letrasCorrectas += tabla.get(letra);
			} else {
				letrasIncorrectas += tabla.get(letra);

			}
		}
		assertEquals(letrasIncorrectas, "UIO");
		assertEquals(letrasIncorrectas.length(), 3);
		assertEquals(letrasCorrectas, "TRWAGMPXBNJZSQVHLCKE");
		assertEquals(letrasCorrectas.length(), 20);

	}
	
	@Test
	public void comprobarTablaAsignacionNoValidaMinuscula() {
		HashMap<Integer, Character> tabla = new HashMap<Integer, Character>();
		Character[] letrasDocumento = { 'T', 'R', 'W', 'A', 'G', 'M', 'u', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S',
				'Q', 'V', 'H', 'L', 'C', 'K', 'E' };
		Pattern expresionRegular = null;
		Matcher comprobador = null;
		boolean emparejados = false;
		String letrasCorrectas = "";
		String letrasIncorrectas = "";

		for (int posicion = 0; posicion < letrasDocumento.length; posicion++) {
			tabla.put(posicion, letrasDocumento[posicion]);// Se crea un diccionario con clave valor

		}

		for (int letra = 0; letra < tabla.size(); letra++) {

			expresionRegular = Pattern.compile("[^IOUiou]");
			comprobador = expresionRegular.matcher("" + tabla.get(letra));
			emparejados = comprobador.matches();

			if (emparejados) {

				letrasCorrectas += tabla.get(letra);
			} else {
				letrasIncorrectas += tabla.get(letra);

			}
		}
		assertEquals(letrasIncorrectas, "u");
		assertEquals(letrasIncorrectas.length(), 1);
		assertEquals(letrasCorrectas, "TRWAGMFPDXBNJZSQVHLCKE");
		assertEquals(letrasCorrectas.length(), 22);

	}


	@Test
	public void comprobarMiTablaAsignacion() {
		int longitudTabla = TablaAsignacion.getLongitudTabla();

		for (int i = 0; i < longitudTabla; i++) {

			Pattern p = Pattern.compile("[^IOUiou]");
			Matcher m = p.matcher("" + TablaAsignacion.getTablaAsignacion().get(i));
			boolean b = m.matches();

			assertEquals(b, true);
		}

	}

}
