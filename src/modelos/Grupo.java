package modelos;

import java.util.ArrayList;
import java.util.List;

import main.Calculador;

public class Grupo {

	List<Equipo> equipos = new ArrayList<>();
	public double latitud = 0.0;
	public double longitud = 0.0;
	Calculador calculador;

	public Grupo(double init, Calculador calculador) {
		this.calculador = calculador;
		this.latitud = init;
		this.longitud = init;
	}

	public boolean addEquipo(Equipo equipo) {
		if(comprobarExcluyen(equipos,calculador.getExcluyentes(equipo))) {
			return false;
		}
		
		if (equipos.size() == calculador.maximoPorGrupo && calculador.gruposSupernumerarios == 0) {
			return false;
		} else {

			if (equipos.size() == calculador.maximoPorGrupo && calculador.gruposSupernumerarios > 0) {
				equipos.add(equipo);
				equipo.grupo = this;
				calculador.gruposSupernumerarios--;
				return true;
			} else {
				if (equipos.size() < calculador.maximoPorGrupo) {
					equipos.add(equipo);
					equipo.grupo = this;
					return true;
				} else {
					return false;
				}
			}

		}

	}

	private boolean comprobarExcluyen(List<Equipo> eqps, List<Equipo> excl) {
		for (Equipo equipo : excl) {
			if(eqps.contains(equipo))
				return true;
		}
		return false;
	}

	public void calcularCentro() {
		double sumaLats = 0;
		double sumaLongs = 0;

		for (Equipo equipo : equipos) {
			sumaLats = equipo.latitud;
			sumaLongs = equipo.longitud;
		}

		this.latitud = sumaLats / equipos.size();
		this.longitud = sumaLongs / equipos.size();
	}

	public String toString() {

		StringBuffer sb = new StringBuffer();
		for (Equipo equipo : equipos) {
			sb.append(equipo.nombre);
			sb.append("\n");
		}
		return sb.toString();

	}

	public void limpiarGrupo() {
		for (Equipo equipo : equipos) {
			equipo.grupo = null;
		}
		equipos.clear();
	}

}
