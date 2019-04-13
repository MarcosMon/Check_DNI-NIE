package org.lasencinas.TablaAsignacion;

import java.util.HashMap;

public class TablaAsignacion {

	private static HashMap<Integer, Character> tabla = new HashMap<Integer, Character>();
	private static Character[] letrasDocumento = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J',
			'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E' };

	private TablaAsignacion() {
	}

	public static HashMap<Integer, Character> getTablaAsignacion() {

		for (int posicion = 0; posicion < letrasDocumento.length; posicion++) {
			tabla.put(posicion, letrasDocumento[posicion]);// Se crea un diccionario con clave valor

		}
		return tabla;

	}

	public static int getLongitudTabla() {

		return getTablaAsignacion().size();
	}

}