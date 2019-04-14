package org.lasencinas.DocsIdentidad;

import org.lasencinas.TablaAsignacion.TablaAsignacion;
import org.lasencinas.enumNIE.EnumNIE;

public class NIE {

	private String nie = null;
	private Character letraControlCorrecta;
	private int letraInicial;

	public NIE() {
	}

	public NIE(String nie) {

		setNie(nie);

	}

	public String getNie() {

		return this.nie;
	}

	public void setNie(String nie) {

		this.nie = nie;
	}

	public Character getLetraControl() {

		Character letra = getNie().charAt(getNie().length() - 1);
		Character letraControlMayuscula = Character.toUpperCase(letra);

		return letraControlMayuscula;
	}

	public Character getLetraInicial() {

		Character letra = getNie().charAt(0);
		Character letraInicialMayuscula = Character.toUpperCase(letra);

		return letraInicialMayuscula;
	}

	public int getDigitosNie() {

		String digitosString = getNie().substring(1, this.getNie().length() - 1);

		int digitos = Integer.parseInt(digitosString);

		return digitos;
	}

	public int getValorLetraInicial() {

		return this.letraInicial;
	}

	public void setValorLetraInicial(int letraInicial) {

		this.letraInicial = letraInicial;

	}

//	public Character getLetraControlCorrecta() {
//
//		return this.letraControlCorrecta;
//	}
//
//	public void setLetraCorrecta(Character letraControlCorrecta) {
//
//		this.letraControlCorrecta = letraControlCorrecta;
//	}

	public void calcularLetraInicial() {

		String letraInicial = "" + this.getLetraInicial();

		switch (letraInicial) {
		case "X":
			setValorLetraInicial(EnumNIE.valueOf("X").getValorLetra());
			break;
		case "Y":

			setValorLetraInicial(EnumNIE.valueOf("Y").getValorLetra());
			break;

		case "Z":

			setValorLetraInicial(EnumNIE.valueOf("Z").getValorLetra());
			break;
		default:
			break;
		}
	}

}
