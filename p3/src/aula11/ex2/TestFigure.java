package aula11.ex2;

import java.util.*;

public class TestFigure {
    public static void main(String[] args) {
        Circle c1 = new Circle(2);
        Circle c2 = new Circle(1, 3, 2);
        Square q1 = new Square(2);
        Square q2 = new Square(3, 4, 2);
        Rectangle r1 = new Rectangle(2, 3);
        Rectangle r2 = new Rectangle(3, 4, 2, 3);

        List<Figure> list = new LinkedList<>();

        list.add(q1);
        list.add(q2);
        list.add(r1);
        list.add(r2);
        list.add(c1);
        list.add(c2);

        System.out.println("Maior área: \n" + biggerFigureJ7(list));
        System.out.println("Maior perímetro: \n" + biggerFigureJ7P(list));
        System.out.println("Soma das áreas: " + areaTotalJ8(list, "aula11.ex2.Circle"));

    }

    private static Figure biggerFigureJ7(List<Figure> figs) {
        return figs.stream().reduce(figs.get(0), (bigger, fig) -> {
            if (bigger.compareTo(fig) < 0)
                return fig;
            else
                return bigger;
        });
    }

    private static Figure biggerFigureJ7P(List<Figure> figs) {
        return figs.stream().reduce(figs.get(0), (bigger, fig) -> {
            if (bigger.perimeter() < fig.perimeter())
                return fig;
            else
                return bigger;
        });
    }

    private static double areaTotalJ8(List<Figure> figs, String type) {
        try {
            final Class<?> cl = Class.forName(type);
            return figs.stream().filter(fig -> fig.getClass() == cl).mapToDouble(Figure::area).sum();
        } catch (ClassNotFoundException e) {
            System.err.println("Classe inválida");
            return 0;
        }
        // OU return figs.stream().filter(fig -> fig.getClass() == cl).collect(Collectors.summingDouble(Figure::area));
    }
}
