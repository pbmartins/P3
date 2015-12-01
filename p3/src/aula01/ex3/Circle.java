package aula01.ex3;

public class Circle {
	private Point centre;
	private double radius;
	
	public Circle(Point centre, double radius) {
		assert centre != null;
		assert radius > 0;
		
		this.centre = centre;
		this.radius = radius;
	}
	
	public Circle(double x, double y, double radius) {
		assert radius > 0;
		
		this.centre = new Point(x, y);
		this.radius = radius;
	}
	
	public Point getCentre() {
		return this.centre;
	}
	
	public double getRadius() {
		return this.radius;
	}
	
	public double area() {
		return Math.PI * Math.pow(this.radius, 2);
	}
	
	public double perimeter() {
		return 2 * Math.PI * this.radius;
	}
	
	public String toString() {
		return "Centro: " + centre.toString() + " | Raio: " + this.radius + " | Área: " + area() + " | Perimetro: " + perimeter();
	}
	
	public boolean equalsTo(Circle c) {
		if (this.radius == c.getRadius()) return true;
		else return false;
	}
	
	public boolean interseta(Circle c) {
		double distanciaCentros = this.centre.distance(c.getCentre());
		double somaRaios = this.radius + c.getRadius();
		if (distanciaCentros > somaRaios) return false;
		else return true;
	}
}
