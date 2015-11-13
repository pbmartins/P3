package aula1.ex3;

public class Point {
	private double x, y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public double distance(Point p) {
		return Math.sqrt( Math.pow(this.x - p.getX(), 2) + Math.pow(this.y - p.getY(), 2) );
	}
	
	public String toString() {
		return "(" + this.x + "; " + this.y + ")";
	}
	
	public boolean equals(Object p) {
		if (p == null)
			return false;
		if (this.getClass() != p.getClass())
			return false;
		return this.x == ((Point)p).getX() && this.y == ((Point)p).getY();
	}
}
