package org.lasencinas.DocsIdentidad;

import org.lasencinas.Interfaces.Calcular;
import org.lasencinas.Interfaces.Verificar;

public class Dni implements Calcular, Verificar {

	String dni = null;

	public Dni() {
	}

	public Dni(String dni) {

		setDni(dni);

	}

	public String getDni() {

		return this.dni;
	}

	public void setDni(String dni) {

		this.dni = dni;
	}

	public Character getLetraDni() {

		Character letra = getDni().charAt(getDni().length() - 1);
		Character letraDniMayuscula = Character.toUpperCase(letra);

		return letraDniMayuscula;
	}

	public int getDigitosDni() {

		String digitosString = getDni().substring(0, getLetraDni());

		int digitos = Integer.parseInt(digitosString);

		return digitos;
	}

	@Override
	public void verificarLetra() {

//		"^\d{8}[^IOUiou]$"
	}

	@Override
	public void calcularLetra() {

	}

}
