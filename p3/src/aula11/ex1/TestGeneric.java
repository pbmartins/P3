package aula11.ex1;

import aula5.ex1.*;
import java.util.*;

public class TestGeneric {
    public static void main(String[] args) {
        List<Person> vp = new ArrayList<>();

        for (int i=0; i<10; i++)
            vp.add(new aula11.ex1.Person("Bebé no Vector "+i, 1000+i, Date.today()));

        Iterator<Person> vec = vp.iterator();
        printSet(vp.iterator());
        List<Person> lp = new LinkedList<>();

        while ( vec.hasNext() )
            lp.add( vec.next() );

        Iterator<Person> lista = lp.iterator();

        while ( lista.hasNext() )
            System.out.println( lista.next() );

        List<Figure> figList = new LinkedList<>();

        figList.add(new Circle (1,3, 1));
        figList.add(new Square(3,4, 2));
        figList.add(new Rectangle(1,2, 2,5));
        printSet(figList.iterator());

        System.out.println("Soma da Area de Lista de Figuras: " + sumArea(figList));
        // Partindo do principio que Quadrado extends Rectangulo:
        List< Rectangle > quadList = new LinkedList<>();
        quadList.add(new Square(3, 4, 2));
        quadList.add(new Rectangle(1, 2, 2, 5));
        System.out.println("Soma da Area de Lista de Quadrados: " + sumArea(quadList));
    }

    public static double sumArea(List<? extends Figure> list) {
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
