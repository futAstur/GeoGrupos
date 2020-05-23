package utiles;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import modelos.Equipo;

public class Util {

	public static double calcularDistancia(LatLng uno, LatLng dos) {
		double lats = Math.pow(uno.latitud - dos.latitud, 2);
		double longs = Math.pow(uno.longitud - dos.longitud, 2);

		return Math.sqrt(lats + longs);
	}

	public static List<Equipo> cargarEquipos(String filename) {
		List<Equipo> eqps = new ArrayList<>();
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"));
			
			String line;
			while((line=br.readLine())!=null) {
				String[] fields = line.split("\t");
				
				double lat = Double.parseDouble(fields[1]);
				double lng = Double.parseDouble(fields[2]);
				
				Equipo eq = new Equipo(fields[0], lat, lng);
				eqps.add(eq);
			}
			
			br.close();
		} catch (IOException ex) {
			System.err.println(ex);
		}
		
		return eqps;
	}

}
