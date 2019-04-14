package org.lasencinas.DocsIdentidad;

public class NIE {

	private String nie = null;

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

}
