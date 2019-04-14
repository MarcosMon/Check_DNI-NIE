package org.lasencinas.DocsIdentidad;

import org.lasencinas.Interfaces.Calcular;
import org.lasencinas.Interfaces.Verificar;
import org.lasencinas.TablaAsignacion.TablaAsignacion;

public class Dni implements Calcular, Verificar {

	private String dni = null;
	private Character letraCorrecta;

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
	
	public Character getLetraCorrecta() {
		
		return this.letraCorrecta;
	}
	
	public void  setLetraCorrecta(Character letraCorrecta) {
		
		this.letraCorrecta = letraCorrecta;
	}

	public int getDigitosDni() {

		String digitosString = getDni().substring(0, this.getDni().length() - 1);

		int digitos = Integer.parseInt(digitosString);

		return digitos;
	}

	@Override
	public void verificarLetra() {

//		"^\d{8}[^IOUiou]$"
	}

	@Override
	public void calcularLetra() {
		
		int posicionLetra = this.getDigitosDni() % TablaAsignacion.getLongitudTabla();
		
		Character letra = TablaAsignacion.getTablaAsignacion().get(posicionLetra);
		
		this.setLetraCorrecta(letra);

	}

}
