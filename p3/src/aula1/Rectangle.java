package aula1;

public class Rectangle {
	private Point centre;
	private double width, height;
	
	public Rectangle(Point centre, double width, double height) {
		assert centre != null;
		assert width > 0 && height > 0 && width != height;
		
		this.centre = centre;
		this.width = width;
		this.height = height;
	}
	
	public Rectangle(double x, double y, double width, double height) {
		assert width > 0 && height > 0;
		
		this.centre = new Point(x, y);
		this.width = width;
		this.height = height;
	}
	
	public Point getCentre() {
		return this.centre;
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
	
	public String toString() {
		return "Centro: " + centre.toString() + " | Comprimento: " + this.width + " | Largura: " + this.height + " | Área: " + area() + " | Perimetro: " + perimeter();
	}
}
