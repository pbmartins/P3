package aula09.ex3;

public class TestIterator {
    public static void main(String[] args) {
        PersonVector vp = new PersonVector();
        for (int i=0; i<10; i++)
            vp.add(new Person("Bebé no Vector "+i, 1000+i, Date.today()));

        BFIterator<Person> vec = vp.iterator();
        while ( vec.hasNext() )
            System.out.println( vec.next() );

        while ( vec.hasPrevious() )
            System.out.println( vec.previous() );

        PersonList lp = new PersonList(); for (int i=0; i<10; i++)
            lp.add(new Person("Bebé na Lista "+i, 2000+i, Date.today()));

        BFIterator<Person> lista = lp.iterator();
        while ( lista.hasNext() )
            System.out.println( lista.next() );

        while ( lista.hasPrevious() )
            System.out.println( lista.previous() );
    }
}
