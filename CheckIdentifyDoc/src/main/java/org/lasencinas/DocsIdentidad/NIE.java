package org.lasencinas.DocsIdentidad;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.lasencinas.TablaAsignacion.TablaAsignacion;
import org.lasencinas.enumNIE.EnumNIE;

public class NIE {

	private String nie = null;
	private Character letraControlCorrecta;
	private int letraInicial;
	private boolean composicionValida;

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

	public Character getLetraControlCorrecta() {

		return this.letraControlCorrecta;
	}

	public void setLetraCorrecta(Character letraControlCorrecta) {

		this.letraControlCorrecta = letraControlCorrecta;
	}
	
	public void verificarComposicion() {

		Pattern expresionRegular = Pattern.compile("^[XxYyZz]{1}[0-9]{7}[A-HJ-NP-TV-Z]{1}$");
		Matcher comprobador = expresionRegular.matcher("" + this.getNie());
		boolean emparejados = comprobador.matches();

		setComposicionValida(emparejados);

	}
	
	public boolean composicionValida() {
		
		return this.composicionValida;
	}

	private void setComposicionValida(boolean emparejados) {
		
		this.composicionValida = emparejados;
		
	}

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
	
	public void calcularLetra() {
		
		String concadenados = Integer.toString(this.getValorLetraInicial()) + Integer.toString(this.getDigitosNie());

		int digitosCalcular = Integer.parseInt(concadenados);
		
		int posicionLetra = digitosCalcular % TablaAsignacion.getLongitudTabla();

		Character letra = TablaAsignacion.getTablaAsignacion().get(posicionLetra);

		this.setLetraCorrecta(letra);
	}

}
