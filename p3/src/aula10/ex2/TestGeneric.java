package aula10.ex2;

import aula05.ex1.Circle;
import aula05.ex1.Figure;
import aula05.ex1.Rectangle;
import aula05.ex1.Square;

import java.util.Iterator;

public class TestGeneric {
    public static void main(String[] args) {
        BinarySearchTree<Figure> figList = new BinarySearchTree<>();

        figList.insert(new Circle (1,3, 1));
        figList.insert(new Square(3,4, 2));
        figList.insert(new Rectangle(1,2, 2,5));
        printSet(figList.iterator());

        System.out.println("Soma da Area de Lista de Figuras: " + sumArea(figList));
        // Partindo do principio que Quadrado extends Rectangulo:
        BinarySearchTree< Rectangle > quadList = new BinarySearchTree<>();
        quadList.insert(new Square(3, 4, 2));
        quadList.insert(new Rectangle(1, 2, 2, 5));
        System.out.println("Soma da Area de Lista de Quadrados: " + sumArea(quadList));
    }

    public static double sumArea(BinarySearchTree<? extends Figure> list) {
        double to_return = 0;

        Iterator<? extends Figure> iterator = list.iterator();
        while(iterator.hasNext())
            to_return += iterator.next().area();

        return to_return;
    }

    public static <T> void printSet(Iterator<T> iterator) {
        while(iterator.hasNext())
            System.out.println(iterator.next().toString());
    }

}
