package aula5;

import aula1.Point;

import java.util.Comparator;

public abstract class Figure implements Comparator<Figure>, Comparable<Figure> {
	
	public abstract Point getCentre();
	
	public abstract double area();

	public abstract double perimeter();
	
	public abstract boolean equals(Object f);

	public String toString() {
		return "Centro: " + this.getCentre() + "\n";
	}

	public int compareTo(Figure f) {
		if (f.area() > this.area())
			return -1;
		else if (f.area() < this.area())
			return 1;
		return 0;
	}

	@Override public int compare(Figure f1, Figure f2) {
		if (f1 == null || f2 == null)
			throw new IllegalArgumentException("Figuras inválidas");
		return f1.compareTo(f2);
	}
}
