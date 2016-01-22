package aula09.ex3;

import java.util.Iterator;

public interface BFIterator<T> extends Iterator<T> {
    boolean hasPrevious();
    T previous();
}