package aula03.ex2;

import aula01.ex3.Point;

public class Rectangle extends Figure {
	private double width, height;
	
	public Rectangle(Point centre, double width, double height) {
		super(centre);
		if (width <= 0 || height <= 0) throw new IllegalArgumentException("O comprimento e/ou a largura têm de ser superiores a 0");
		this.width = width;
		this.height = height;
	}
	
	public Rectangle(double x, double y, double width, double height) {
		this(new Point(x, y), width, height);
	}
	
	public Rectangle(double width, double height) {
		this(0, 0, width, height);
	}
	
	public Rectangle(Rectangle r) {
		this(r.getCentre(), r.getWidth(), r.getHeight());
	}
	
	public double getWidth() {
		return this.width;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	public double area() {
		return this.width * this.height;
	}
	
	public double perimeter() {
		return 2 * this.width + 2 * this.height;
	}
	
	@Override public String toString() {
		return super.toString() + "Comprimento: " + this.width + "\nLargura: " + this.height + "\n";
	}
	
	public boolean equals(Object r) {
		if (r == null)
			return false;
		if (r.getClass() != this.getClass())
			return false;
		return super.getCentre().equals(((Rectangle)r).getCentre()) && this.width == ((Rectangle)r).getWidth() && this.height == ((Rectangle)r).getHeight();
	}
}
