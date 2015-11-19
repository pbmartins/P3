package aula10.ex1;
import aula5.ex1.*;

public class TestGeneric {
    public static void main(String[] args) {
        GenericVector<Person> vp = new GenericVector<>();

        for (int i=0; i<10; i++)
            vp.addElem(new Person("Bebé no Vector "+i, 1000+i, Date.today()));

        BFIterator<Person> vec = vp.iterator();
        printSet(vp.iterator());
        GenericList<Person> lp = new GenericList<>();

        while ( vec.hasNext() )
            lp.addElem( vec.next() );

        BFIterator<Person> lista = lp.iterator();

        while ( lista.hasNext() )
            System.out.println( lista.next() );

        GenericList<Figure> figList = new GenericList<>();

        figList.addElem(new Circle (1,3, 1));
        figList.addElem(new Square(3,4, 2));
        figList.addElem(new Rectangle(1,2, 2,5));
        printSet(figList.iterator());

        System.out.println("Soma da Area de Lista de Figuras: " + sumArea(figList));
        // Partindo do principio que Quadrado extends Rectangulo:
        GenericList< Rectangle > quadList = new GenericList<>();
        quadList.addElem(new Square(3, 4, 2));
        quadList.addElem(new Rectangle(1, 2, 2, 5));
        System.out.println("Soma da Area de Lista de Quadrados: " + sumArea(quadList));
    }

    public static double sumArea(GenericList<? extends Figure> list) {
        double to_return = 0;

        BFIterator<? extends Figure> iterator = list.iterator();
        while(iterator.hasNext())
            to_return += iterator.next().area();

        return to_return;
    }

    public static <T> void printSet(BFIterator<T> iterator) {
        while(iterator.hasNext())
            System.out.println(iterator.next().toString());
    }

}
