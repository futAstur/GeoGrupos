package modelos;

import java.util.Map;

import utiles.LatLng;
import utiles.Util;

public class Equipo {
	public String nombre;
	public double latitud;
	public double longitud;
	public Map<Grupo,Double> distancias;
	public Grupo grupo;
	
	public Equipo(String nombre, double latitud, double longitud) {
		super();
		this.nombre = nombre;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public double distanciaAGrupo() {
		return Util.calcularDistancia(new LatLng(grupo.latitud, grupo.longitud), new LatLng(latitud, longitud));
	}
	
}
