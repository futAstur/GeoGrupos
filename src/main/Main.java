package main;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Equipo> equipos = new ArrayList<>();
		equipos.add(new Equipo("A", 2,2));
		equipos.add(new Equipo("B", 1,-1));
		equipos.add(new Equipo("C", 3,3));
		equipos.add(new Equipo("D", -10,0));
		Equipo f1 = new Equipo("F1", 4,2);
		equipos.add(f1);
		Equipo f2 = new Equipo("F2", 4,2);
		equipos.add(f2);
		equipos.add(new Equipo("E", 5,3));
		equipos.add(new Equipo("H", 1,1));

		List<Excluyen> ex = new ArrayList<>();
		Excluyen ex = new Excluyen(f1,f2);
		
		Calculador c = new Calculador(3, equipos, ex );
		c.run(20);
		c.print();
	}
	
	
}
