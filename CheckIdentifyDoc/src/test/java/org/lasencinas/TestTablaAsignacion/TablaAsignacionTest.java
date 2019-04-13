package org.lasencinas.TestTablaAsignacion;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.lasencinas.TablaAsignacion.TablaAsignacion;

/**
 * Unit test for simple App.
 */
public class TablaAsignacionTest {

	@Test
	public void comprobarLongitudTabla() {

		byte longitudCorrecta = 23;
		
		assertEquals(longitudCorrecta, TablaAsignacion.getLongitudTabla());


	}
	

	
	@Test
	public void comprobarMiTablaAsignacion() {
		int longitudTabla = TablaAsignacion.getLongitudTabla();
		
		for (int i = 0; i < longitudTabla; i++) {
			
		Pattern p = Pattern.compile("[^IOUiou]");
		 Matcher m = p.matcher("" + TablaAsignacion.getTablaAsignacion().get(i));
		 System.out.println(TablaAsignacion.getTablaAsignacion().get(i));
		 boolean b = m.matches();
		 
		 assertEquals(b,true);
		}
		 
	}

}
