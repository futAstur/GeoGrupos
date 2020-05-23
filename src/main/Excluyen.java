package main;

public class Excluyen {
	public Equipo e1;
	public Equipo e2;
	public Excluyen(Equipo e1, Equipo e2) {
		super();
		this.e1 = e1;
		this.e2 = e2;
	}
	public boolean contains(Equipo equipo) {
		return e1.equals(equipo) || e2.equals(equipo);
	}
	
	
	
}
