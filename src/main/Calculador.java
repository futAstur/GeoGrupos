package main;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import modelos.Equipo;
import modelos.Grupo;
import utiles.ComparatorPorDistancia;
import utiles.Excluyen;
import utiles.LatLng;
import utiles.Util;


public class Calculador {

	private List<Grupo> grupos = new ArrayList<>();
	private List<Equipo> equipos = new ArrayList<>();
	private List<Excluyen> excluyentes;

	public int maximoPorGrupo;
	public int gruposSupernumerarios;
	
	public Calculador(int grupos, List<Equipo> equipos, List<Excluyen> ex) {
		int numeroEquipos = equipos.size();
		maximoPorGrupo = numeroEquipos / grupos;

		gruposSupernumerarios = numeroEquipos % grupos;

		for (int i = 0; i < grupos; i++) {
			this.grupos.add(new Grupo(i,this));
		}
		
		this.equipos=equipos;
		this.excluyentes=ex;

	}

	public void run(int it) {
		for (int i = 0; i < it; i++) {
			asignarEquipos();
			calcularCentro();
		}
	}
	
	
	private void calcularCentro() {
		for (Grupo grupo : grupos) {
			grupo.calcularCentro();
		}
		
	}

	private void asignarEquipos() {

		if(equipos.get(0).grupo!=null)
			equipos.sort(new ComparatorPorDistancia());

		limpiarGrupos();
		
		
		for (Equipo equipo : equipos) {
			PriorityQueue<Distancia> distancias = new PriorityQueue<Distancia>();
			for (Grupo grupo : grupos) {
				double distanciaThis = Util.calcularDistancia(new LatLng(grupo.latitud,grupo.longitud),new LatLng(equipo.latitud,equipo.longitud));
				distancias.add(new Distancia(distanciaThis, grupo));
			}
			boolean added=false;
			while(!added) {
				added = distancias.poll().grupo.addEquipo(equipo);
			}
		}
	}

	private class Distancia implements Comparable<Distancia>{
		
		public double distancia;
		public Grupo grupo;
		public Distancia(double distancia, Grupo grupo) {
			this.distancia = distancia;
			this.grupo = grupo;
		}
		@Override
		public int compareTo(Distancia arg0) {
			return distancia>=arg0.distancia?1:-1;
		}
		
		
		
	}
	
	private void limpiarGrupos() {
		gruposSupernumerarios = equipos.size() % grupos.size();

		for (Grupo grupo : grupos) {
			grupo.limpiarGrupo();
		}
		
	}

	public void print() {
		int i=1;
		for (Grupo grupo : grupos) {
			System.out.println("GRUPO "+i);
			System.out.println(grupo.toString());
			System.out.println("-----------------------------");
			i++;
			
		}
	}

	public List<Equipo> getExcluyentes(Equipo equipo) {
		List<Equipo> ret = new ArrayList<>();
		for (Excluyen excluyen : excluyentes) {
			if(excluyen.contains(equipo)) {
				ret.add(excluyen.getOtro(equipo));
			}
		}
		return ret;
	}
}
