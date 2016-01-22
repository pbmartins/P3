package aula10.ex1;

import java.util.*;

public class GenericList<T> implements Iterable {
	private Node<T> top;
    private Node<T> end;
    private int size;
	
	public GenericList() {
		top = null;
        end = null;
        size = 0;
	}

    public void addElem(T p) {
        if (p == null)
            throw new IllegalArgumentException("Argumento inválido");

        if (top == null)
            end = top = new Node<>(p);
        else {
            Node<T> n = new Node<>(p);
            n.previous = end;
            end.next = n;
            end = n;
        }
        size++;
    }

    public boolean removeElem(T p) {
        if (p == null)
            throw new IllegalArgumentException("Argumento inválido");

        Node<T> n = top;
        if (n.p.equals(p)) {
            top = n.next;
            top.previous = null;
        } else {
            while (!n.next.p.equals(p))
                n = n.next;
            n.next = n.next.next;
            n.next.previous = n;
        }
        return true;
    }

    public int totalElem() {
        return this.size;
    }

	public String toString() {
		if (size == 0)
            throw new AssertionError("Lista está vazia");
		String to_return = "";

        Node<T> n = top;
        while (n != null) {
            to_return += n.p.toString();
            n = n.next;
        }

		return to_return;
	}

    public BFIterator<T> iterator() {
        return (this).new InternalIterator();
    }


    private static class Node<T> {
        T p;
        Node next;
        Node previous;

        public Node(T p) {
            if (p == null)
                throw new IllegalArgumentException("Argumento inválido");
            this.p = p;
        }
    }

    private class InternalIterator implements Iterator<T>, BFIterator<T> {
        Node<T> n = top;
        Node<T> last = null;

        public boolean hasNext() {
            return n != null;
        }

        public T next() {
            if (hasNext()) {
                last = n;
                n = n.next;
                return last.p;
            } else
                throw new IndexOutOfBoundsException("Já não existem mais elementos na lista");
        }

        public boolean hasPrevious() {
            return last != null;
        }

        public T previous() {
            if (hasPrevious()) {
                n = last;
                last = last.previous;
                return n.p;
            } else
                throw new IndexOutOfBoundsException("Já não existem mais elementos na lista");
        }

        public void remove() {
            removeElem(n.p);
            n = top;
        }
    }
    
}
