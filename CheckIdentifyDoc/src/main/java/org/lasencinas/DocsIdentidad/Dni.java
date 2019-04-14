package org.lasencinas.DocsIdentidad;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.lasencinas.Interfaces.Calcular;
import org.lasencinas.Interfaces.Verificar;
import org.lasencinas.TablaAsignacion.TablaAsignacion;

public class Dni implements Calcular, Verificar {

	private String dni = null;
	private Character letraCorrecta;
	private boolean comprobacion;
	private boolean dniValido;

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

	public void setLetraCorrecta(Character letraCorrecta) {

		this.letraCorrecta = letraCorrecta;
	}

	public int getDigitosDni() {

		String digitosString = getDni().substring(0, this.getDni().length() - 1);

		int digitos = Integer.parseInt(digitosString);

		return digitos;
	}

	public boolean dniValido() {

		return this.dniValido;
	}

	public void setDniValido(boolean verificar) {

		this.dniValido = verificar;

	}

	public boolean composicionValida() {

		return this.comprobacion;

	}

	public void setComposicionValida(boolean comprobar) {

		this.comprobacion = comprobar;
	}

	@Override
	public void verificarComposicion() {

		Pattern expresionRegular = Pattern.compile("\\d{8}[A-HJ-NP-TV-Z]");
		Matcher comprobador = expresionRegular.matcher("" + this.getDni());
		boolean emparejados = comprobador.matches();

		setComposicionValida(emparejados);

	}

	@Override
	public void calcularLetraControl() {

		if (!this.composicionValida()) {

			this.setLetraCorrecta('$');

		} else {
			int posicionLetra = this.getDigitosDni() % TablaAsignacion.getLongitudTabla();

			Character letra = TablaAsignacion.getTablaAsignacion().get(posicionLetra);

			this.setLetraCorrecta(letra);
		}

	}

	public void verificarDniValido() {

		if (this.getLetraDni() == this.getLetraCorrecta()) {

			setDniValido(true);
		} else;
			

	}

	public void mensaje() {

		if (dniValido) {
			System.out.println("El DNI -> " + this.getDni() + " Es Correcto.");
		} else {
			System.out.println("El DNI -> " + this.getDni() + " No es Correcto.");
		}
	}

}
