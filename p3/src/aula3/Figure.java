package aula3;

import aula1.Point;

public class Figure {
	private Point centre;
	
	public Figure(double x, double y) {
		centre = new Point(x, y);
	}
	
	public Figure(Point centre) {
		if (centre == null) throw new IllegalArgumentException("O ponto Centro não é válido");
		this.centre = centre;
	}
	
	public Point getCentre() {
		return this.centre;
	}
	
	public String toString() {
		return "Centro: " + centre.toString() + "\n";
	}
	
	public double area() {
		return 0;
	}
	
	public boolean equals(Object f) {
		if (f == null)
			return false;
		if (this.getClass() != f.getClass())
			return false;
		return this.centre.equals(((Figure)f).getCentre());
	}
	
}
