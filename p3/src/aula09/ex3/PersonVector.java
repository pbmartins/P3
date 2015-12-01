package aula09.ex3;

import java.util.*;

public class PersonVector implements Iterable {
    private Person[] array;
    private static final int increment = 3;
    private int size;

    public PersonVector() {
        this.array = new Person[increment];
    }

    public void add(Person p) {
        if (p == null)
            throw new IllegalArgumentException("Pessoa inválida");
        if (existsCC(p.getCC()))
            throw new AssertionError("Já existe uma pessoa associada a esse CC");

        if (size < array.length)
            array[size++] = p;
        else {
            Person[] tmp = new Person[array.length + increment];
            System.arraycopy(array, 0, tmp, 0, array.length);
            array = tmp;
            array[size++] = p;
        }
    }

    public boolean removePerson(Person p) {
        if (p == null)
            throw new IllegalArgumentException("Pessoa inválida");
        if (!existsCC(p.getCC()))
            return false;

        int i;
        Person[] tmp = new Person[size - 1];

        for (i = 0; i < size; i++) {
            if (array[i].equals(p))
                break;
        }

        System.arraycopy(array, 0, tmp, 0, i);
        System.arraycopy(array, i + 1, tmp, i, size - i);

        array = tmp;
        size--;
        return true;
    }

    public int totalPeople() {
        return this.size;
    }

    public Person searchPerson(int cc) {
        if (cc <= 0)
            throw new IllegalArgumentException("CC inválido");

        for (int i = 0; i < size; i++) {
            if (array[i].getCC() == cc)
                return array[i];
        }

        return null;
    }

    public String toString() {
        if (size == 0)
            throw new AssertionError("Lista está vazia");
        String to_return = "";

        for (int i = 0; i < size; i++)
            to_return += array[i].toString();

        return to_return;
    }

    public BFIterator<Person> iterator() {
        return (this).new InternalIterator();
    }

    private boolean existsCC(int cc) {
        return searchPerson(cc) != null;
    }

    private class InternalIterator implements Iterator<Person>, BFIterator<Person> {
        int idx = 0;

        public boolean hasNext() {
            return idx < size;
        }

        public Person next() {
            if (hasNext()) {
                return array[idx++];
            } else
                throw new IndexOutOfBoundsException("Já não existem mais elementos na lista");
        }

        public boolean hasPrevious() {
            return idx >= 0;
        }

        public Person previous() {
            if (hasPrevious()) {
                return array[idx--];
            } else
                throw new IndexOutOfBoundsException("Já não existem mais elementos na lista");
        }

        public void remove() {
            removePerson(array[idx]);
            idx = 0;
        }
    }

}
