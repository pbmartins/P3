package aula3;

import aula1.Ponto;

public class Figure {
	private Ponto centre;
	
	public Figure(double x, double y) {
		centre = new Ponto(x, y);
	}
	
	public Figure(Ponto centre) {
		if (centre == null) throw new IllegalArgumentException("O ponto Centro não é válido");
		this.centre = centre;
	}
	
	public Ponto getCentre() {
		return this.centre;
	}
	
	public String toString() {
		return "Centro: " + centre.toString() + "\n";
	}
	
	public boolean equals(Object f) {
		if (f == null)
			return false;
		if (this.getClass() != f.getClass())
			return false;
		return this.centre.equals(((Figure)f).getCentre());
	}
	
}
