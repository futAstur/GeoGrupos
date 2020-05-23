package main;

import java.util.Comparator;

public class ComparatorPorDistancia implements Comparator<Equipo> {

	@Override
	public int compare(Equipo arg0, Equipo arg1) {
		return arg1.distanciaAGrupo()-arg0.distanciaAGrupo();
	}

}
