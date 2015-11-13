package aula4.ex2;
import aula1.ex3.Point;
import aula3.ex2.Figure;
import aula3.ex2.Circle;
import aula3.ex2.Square;
import aula3.ex2.Rectangle;

public class Ex2 {

	public static void main(String[] args) {
		Circle c1 = new Circle(2);
		Circle c2 = new Circle(1, 3, 2); 
		Square q1 = new Square(2);
		Square q2 = new Square(3, 4, 2);
		Rectangle r1 = new Rectangle(2, 3); 
		Rectangle r2 = new Rectangle(3, 4, 2, 3);
		
		FigureCollection col = new FigureCollection(42.0);
		
		System.out.println(col.addFigure(c2));
		System.out.println(col.addFigure(r1)); 
		System.out.println(col.addFigure(r1)); 
		System.out.println(col.addFigure(r2)); 
		System.out.println(col.addFigure(c1)); 
		System.out.println(col.addFigure(q2)); 
		System.out.println(col.addFigure(q1)); 
		System.out.println(col.delFigure(r1));
		System.out.println(col.addFigure(q1));
		

		System.out.println("\nÁrea Total da Lista de Figuras: " + col.totalArea());
		
		System.out.println("\nLista de Figuras:");
		for (Figure f: col.getFigures())
			System.out.println(f);
		
		System.out.println("\n\nCirculos na Lista de Figuras:"); 
		for (Figure f: col.getFigures())
			if (f instanceof Circle) 
				System.out.println(f);
		
		System.out.println("\n\nCentro das Figuras:"); 
		for (Point p: col.getCentres())
			System.out.println(p);
	}

}
