package org.lasencinas.main;

import java.util.Arrays;
import java.util.List;

import org.lasencinas.DocsIdentidad.Dni;
import org.lasencinas.TablaAsignacion.TablaAsignacion;

public class Main {

	public static void main(String[] args) {

		List<String> dnis = Arrays.asList("78484464T", "72376173A", "01817200Q", "95882054E", "63587725Q", "26861694V",
				"21616083Q", "26868974Y", "40135330P", "89044648X");

		System.out.println("\n" + "-------------------DNI VALIDOS-------------------------------" + "\n");
		
		for (String dnisLista : dnis) {

			Dni dni = new Dni(dnisLista);

			dni.verificarComposicion();
			dni.calcularLetra();
			dni.verificarDniValido();
			dni.mensaje();

		}
		
		System.out.println("\n" + "-------------------DNI NO VALIDOS-------------------------------" + "\n");

		
		List<String> dnisNoValidos = Arrays.asList("7848446224T", "7231176173A", "018200Q", "9588222054E", "63587725QS", "26861694U",
				"213Q", "12345678", "40135330I", "890648X");
		
		for (String dnisLista : dnisNoValidos) {

			Dni dni = new Dni(dnisLista);

			dni.verificarComposicion();
			dni.calcularLetra();
			dni.verificarDniValido();
			dni.mensaje();

		}
		
	}

}
