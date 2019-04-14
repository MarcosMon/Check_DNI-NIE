package org.lasencinas.TestDocsIdentidad.nie;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.lasencinas.DocsIdentidad.NIE;

public class NieTest {
	
	@Test
	public void comprobarGetNie() {
		
		NIE nie = new NIE("Y9907784L");
		
		assertEquals(nie.getNie(),"Y9907784L");
	}

}
