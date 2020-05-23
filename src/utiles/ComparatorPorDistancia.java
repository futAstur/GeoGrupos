package utiles;

import java.util.Comparator;

import modelos.Equipo;

public class ComparatorPorDistancia implements Comparator<Equipo> {

	@Override
	public int compare(Equipo arg0, Equipo arg1) {
		return arg1.distanciaAGrupo()-arg0.distanciaAGrupo()>0?1:-1;
	}

}
