package aula10.ex1;

import java.util.*;

public class GenericVector<T> implements Iterable {
    private T[] array;
    private static final int increment = 3;
    private int size;

    public GenericVector() {
        this.array = (T[])new Object[increment];
    }

    public void addElem(T p) {
        if (p == null)
            throw new IllegalArgumentException("Argumento inválido");

        if (size < array.length)
            array[size++] = p;
        else {
            T[] tmp = (T[])new Object[array.length + increment];
            System.arraycopy(array, 0, tmp, 0, array.length);
            array = tmp;
            array[size++] = p;
        }
    }

    public boolean removeElem(T p) {
        if (p == null)
            throw new IllegalArgumentException("Argumento inválido");

        int i;
        boolean to_return = false;

        for (i = 0; i < size; i++) {
            if (array[i].equals(p)) {
                to_return = true;
                break;
            }
        }

        if (to_return) {
            T[] tmp = (T[])new Object[size - 1];
            System.arraycopy(array, 0, tmp, 0, i);
            System.arraycopy(array, i + 1, tmp, i, size - i);

            array = tmp;
            size--;
        }
        return to_return;
    }

    public int totalElem() {
        return this.size;
    }


    public String toString() {
        if (size == 0)
            throw new AssertionError("Lista está vazia");
        String to_return = "";

        for (int i = 0; i < size; i++)
            to_return += array[i].toString();

        return to_return;
    }

    public BFIterator<T> iterator() {
        return (this).new InternalIterator();
    }

    private class InternalIterator implements Iterator<T>, BFIterator<T> {
        int idx = 0;

        public boolean hasNext() {
            return idx < size;
        }

        public T next() {
            if (hasNext()) {
                return array[idx++];
            } else
                throw new IndexOutOfBoundsException("Já não existem mais elementos na lista");
        }

        public boolean hasPrevious() {
            return idx >= 0;
        }

        public T previous() {
            if (hasPrevious()) {
                return array[idx--];
            } else
                throw new IndexOutOfBoundsException("Já não existem mais elementos na lista");
        }

        public void remove() {
            removeElem(array[idx]);
            idx = 0;
        }
    }

}
