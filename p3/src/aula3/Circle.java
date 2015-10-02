package aula3;

import aula1.Point;

public class Circle extends Figure {
	private double radius;
	
	public Circle(Point centre, double radius) {
		super(centre);
		if (radius <= 0) throw new IllegalArgumentException("O raio tem de ser superior a 0");
		this.radius = radius;
	}
	
	public Circle(double x, double y, double radius) {
		this(new Point(x, y), radius);
	}
	
	public Circle(double radius) {
		this(0, 0, radius);
	}
	
	public Circle(Circle c) {
		this(c.getCentre(), c.getRadius());
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
	
	@Override public String toString() {
		return super.toString() + "Raio: " + this.radius + "\n";
	}
	
	@Override public boolean equals(Object c) {
		if (c == null)
			return false;
		if (this.getClass() != c.getClass())
			return false;
		return super.equals(c) && this.radius == ((Circle)c).getRadius();
	}
	
	public boolean intersects(Circle c) {
		double centresDistance = super.getCentre().distance(c.getCentre());
		double radiusSum = this.radius + c.getRadius();
		if (centresDistance > radiusSum) return false;
		else return true;
	}
}
