package org.lasencinas.enumNIE;

public enum EnumNIE {

	X(0), Y(1), Z(2);

	int letrasNIE = 0;

	private EnumNIE(int letrasNIE) {

		setValorLetra(letrasNIE);
	}

	public int getValorLetra() {

		return letrasNIE;
	}

	public void setValorLetra(int letrasNIE) {

		this.letrasNIE = letrasNIE;

	}

}
