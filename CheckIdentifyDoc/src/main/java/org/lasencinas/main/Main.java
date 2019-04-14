package org.lasencinas.main;

import org.lasencinas.DocsIdentidad.Dni;
import org.lasencinas.TablaAsignacion.TablaAsignacion;

public class Main {

	public static void main(String[] args) {
		
		System.out.println(TablaAsignacion.getLongitudTabla());
		
		Dni dni = new Dni("325515F");
		System.out.println(dni.getLetraDni());
		System.out.println(dni.getDni().substring(0, dni.getDni().length()-1));

	}

}
