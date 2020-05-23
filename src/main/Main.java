package main;

import java.util.ArrayList;
import java.util.List;

import modelos.Equipo;
import utiles.Util;

public class Main {

	public static void main(String[] args) {
		List<Equipo> equipos = Util.cargarEquipos(args[0]);
		
		int grupos = Integer.parseInt(args[1]);
		
		Calculador c = new Calculador(grupos, equipos, new ArrayList<>() );
		c.run(20);
		c.print();
	}
	
	
}
