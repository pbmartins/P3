package aula1.ex3;

public class Square {
	private Point centre;
	private double width;
	
	public Square(Point centre, double width) {
		assert centre != null;
		assert width > 0;
		
		this.centre = centre;
		this.width = width;
	}
	
	public Square(double x, double y, double width) {
		assert width > 0;
		
		this.centre = new Point(x, y);
		this.width = width;
	}
	
	public Point getCentre() {
		return this.centre;
	}
	
	public double getWidth() {
		return this.width;
	}
	
	public double area() {
		return Math.pow(width, 2);
	}
	
	public double perimeter() {
		return 4 * width;
	}
	
	public String toString() {
		return "Centro: " + centre.toString() + " | Lado: " + this.width + " | Área: " + area() + " | Perimetro: " + perimeter();
	}
}
