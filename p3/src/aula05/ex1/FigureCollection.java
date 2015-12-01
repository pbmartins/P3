package aula05.ex1;
import aula01.ex3.Point;

import java.util.ArrayList;

public class FigureCollection {
	private final double maxArea;
	private ArrayList<Figure> collection;
	
	public FigureCollection(double maxArea) {
		if (maxArea <= 0)
			throw new IllegalArgumentException("A área máxima tem de ser superior a 0.");
		this.maxArea = maxArea;
		this.collection = new ArrayList<Figure>();
	}
	
	public boolean addFigure(Figure f) {
		if (f == null)
			throw new IllegalArgumentException("Figura inválida.");
		if (!exists(f) && (f.area() + totalArea() <= maxArea)) {
			collection.add(f);
			assert !collection.isEmpty();
			assert totalArea() > 0;
			return true;
		}
		return false;
	}
	
	public boolean delFigure(Figure f) {
		if (exists(f)) {
			return collection.remove(f);
		}
		return false;
	}
	
	public double totalArea() {
		double to_return = 0;
		for (Figure f : collection)
			to_return += f.area();
		
		return to_return;
	}
	
	public boolean exists(Figure f) {
		assert !collection.isEmpty();
		return collection.contains(f);
	}
	
	public String toString() {
		return "Área máxima: " + this.maxArea + "\nÁrea total: " + totalArea();
	}
	
	public Figure[] getFigures() {
		return collection.toArray(new Figure[collection.size()]);
	}
	
	public Point[] getCentres() {
		Point[] centres = new Point[collection.size()];
		int i = 0;
		
		for (Figure f : collection)
			centres[i++] = f.getCentre();
		
		return centres;
	}
}
