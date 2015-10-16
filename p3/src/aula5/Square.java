package aula5;
import aula1.Point;

public class Square extends Figure {
	private double width;
	private Point centre;
	
	public Square(Point centre, double width) {
		if (centre == null)
			throw new IllegalArgumentException("Centro não válido.");
		if (width <= 0)
			throw new IllegalArgumentException("O lado tem de ser superior a 0");
		this.width = width;
		this.centre = centre;
	}
	
	public Square(double x, double y, double width) {
		this(new Point(x, y), width);
	}
	
	public Square(double width) {
		this(0, 0, width);
	}
	
	public Square(Square s) {
		this(s.getCentre(), s.getWidth());
	}

	public Point getCentre() {
		return this.centre;
	}
	
	public double getWidth() {
		return this.width;
	}
	
	public double area() {
		return Math.pow(this.width, 2);
	}
	
	public double perimeter() {
		return 4 * this.width;
	}
	
	@Override public String toString() {
		return super.toString() + "Lado: " + this.width + "\n";
	}
	
	public boolean equals(Object s) {
		if (s == null)
			return false;
		if (s.getClass() != this.getClass())
			return false;
		return this.getCentre().equals(((Square)s).getCentre()) && this.width == ((Square)s).getWidth();
	}
}
