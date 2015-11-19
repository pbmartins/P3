package aula10.ex1;

import java.util.Iterator;

public interface BFIterator<T> extends Iterator<T> {
    boolean hasPrevious();
    T previous();
}