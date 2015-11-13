package aula5.ex1;

import aula5.UtilCompare;

public class Ex1 {
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
        System.out.println(col.addFigure(r1));
        System.out.println(col.addFigure(q1));

        System.out.println("\nÁrea Total da Lista de Figuras: " + col.totalArea());

        Figure[] listaFig = col.getFigures();
        System.out.println("\nLista de Figuras:");
        for (Figure f : listaFig)
            System.out.println(f);

        System.out.println("\nComparacao da area do primeiro elemento com todos");
        for (int i = 0; i < listaFig.length; i++) {
            System.out.printf("%2d %12s de area %6.2f compareTo(listaFig[0]) = %2d\n", i, listaFig[i].getClass().getSimpleName(),
                    listaFig[i].area(), listaFig[i].compareTo(listaFig[0]));
        }

        System.out.println("\nFigura com maior Area: " + UtilCompare.findMax(listaFig));

        // Ordena (crescente) o array de Figuras por areas
        UtilCompare.sortArray(listaFig);

        System.out.println("\nLista de Figuras Ordenadas por Area:");
        for (Figure f : listaFig)
            System.out.println(f + " -> area: " + String.format("%2.2f", f.area()) + " e perimetro: " + String.format("%2.2f", f.perimeter()));
    }
}
