package org.lasencinas.TestEnumNIE;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.lasencinas.enumNIE.EnumNIE;

public class enumNIETest {

	@Test
	public void comprobarValoresEnumNie() {

		assertEquals(EnumNIE.valueOf("X").getValorLetra(), 0);
		assertEquals(EnumNIE.valueOf("Y").getValorLetra(), 1);
		assertEquals(EnumNIE.valueOf("Z").getValorLetra(), 2);
	}

	@Test
	public void comprobarLetraEnumNie() {

		EnumNIE letraX = EnumNIE.X;
		EnumNIE letraY = EnumNIE.Y;
		EnumNIE letraZ = EnumNIE.Z;
		assertEquals(letraX.name(), "X");
		assertEquals(letraY.name(), "Y");
		assertEquals(letraZ.name(), "Z");
	}

}
