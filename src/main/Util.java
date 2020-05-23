package main;

public class Util {

	public static double calcularDistancia(LatLng uno, LatLng dos) {
		double lats = Math.pow(uno.latitud-dos.latitud,2);
		double longs = Math.pow(uno.longitud-dos.longitud,2);
		
		return Math.sqrt(lats+longs);
	}
	
	
	public class LatLng{
		public double latitud;
		public double longitud;
		public LatLng(double latitud, double longitud) {
			super();
			this.latitud = latitud;
			this.longitud = longitud;
		}
		
		
	}
}
