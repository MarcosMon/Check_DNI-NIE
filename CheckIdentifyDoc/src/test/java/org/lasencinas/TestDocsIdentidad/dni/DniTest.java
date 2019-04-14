package org.lasencinas.TestDocsIdentidad.dni;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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

}
