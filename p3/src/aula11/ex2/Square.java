package aula11.ex2;
import aula1.ex3.Point;

public class Square extends Rectangle {
	
	public Square(Point centre, double width) {
		super(centre, width, width);
	}
	
	public Square(double x, double y, double width) {
		super(new Point(x, y), width, width);
	}
	
	public Square(double width) {
		super(0, 0, width, width);
	}
	
	public Square(Square s) {
		this(s.getCentre(), s.getWidth());
	}

    @Override public double area() {
		return Math.pow(super.getWidth(), 2);
	}

    @Override public double perimeter() {
		return 4 * super.getWidth();
	}
	
	@Override public String toString() {
		return super.toString() + "Lado: " + super.getWidth() + "\n";
	}

	public boolean equals(Object s) {
		if (s == null)
			return false;
		if (s.getClass() != this.getClass())
			return false;
		return super.getCentre().equals(((Square)s).getCentre()) && super.getWidth() == ((Square)s).getWidth();
	}
}
