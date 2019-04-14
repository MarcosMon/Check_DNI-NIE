package org.lasencinas.TestDocsIdentidad.dni;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.lasencinas.DocsIdentidad.Dni;

public class DniTest {
	
	
	@Test
	public void comprobarGetDni() {
		
		Dni dni = new Dni("41232142J");
		
		
		assertEquals(dni.getDni(),"41232142J");
		assertNotNull(dni);
	}
	
	@Test
	public void comprobarGetLetraDni() {
		
		Dni dni = new Dni("41145321s");
		
		String letra = "" + dni.getLetraDni();
		
		assertEquals(letra,"S");
	}
	
	@Test
	public void comprbarGetLetraDniFail() {
		
		Dni dni = new Dni("43114312F");
		
		String letraCorrecta = "" + dni.getLetraDni();
		
		assertNotEquals(letraCorrecta,"S");
		
	}
	
	
	@Test
	public void comprobarGetDigitosDni() {
		
		Dni dni = new Dni("41145321s");
		
		int digitos = dni.getDigitosDni();
		
		
		assertEquals(digitos,41145321);
	}
	
	@Test
	public void comprobarGetDigitosDniFail() {
		
		Dni dni = new Dni("41145321s");
		
		int digitos = dni.getDigitosDni();
		
		
		assertNotEquals(digitos,31114321);

	}
}
