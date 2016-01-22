package aula09.ex3;

import java.util.*;

public class PersonList implements Iterable {
	private Node top;
    private Node end;
    private int size;
	
	public PersonList() {
		top = null;
        end = null;
        size = 0;
	}

    public void add(Person p) {
        if (p == null)
            throw new IllegalArgumentException("Pessoa inválida");
        if (existsCC(p.getCC()))
            throw new AssertionError("Já existe uma pessoa associada a esse CC");

        if (top == null)
            end = top = new Node(p);
        else {
            Node n = new Node(p);
            n.previous = end;
            end.next = n;
            end = n;
        }
        size++;
    }

    public boolean removePerson(Person p) {
        if (p == null)
            throw new IllegalArgumentException("Pessoa inválida");
        if (!existsCC(p.getCC()))
            return false;

        Node n = top;
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

    public int totalPeople() {
        return this.size;
    }
	
	public Person searchPerson(int cc) {
        if (cc <= 0)
            throw new IllegalArgumentException("CC inválido");

		Node n = top;

        while (n != null) {
            if (n.p.getCC() == cc)
                return n.p;
            n = n.next;
        }

        return null;
	}
	
	public String toString() {
		if (size == 0)
            throw new AssertionError("Lista está vazia");
		String to_return = "";

        Node n = top;
        while (n != null) {
            to_return += n.p.toString();
            n = n.next;
        }
		
		return to_return;
	}

    public BFIterator<Person> iterator() {
        return (this).new InternalIterator();
    }

    private boolean existsCC(int cc) {
        return searchPerson(cc) != null;
    }

    private static class Node {
        Person p;
        Node next;
        Node previous;

        public Node(Person p) {
            if (p == null)
                throw new IllegalArgumentException("Pessoa inválida");
            this.p = p;
        }
    }

    private class InternalIterator implements Iterator<Person>, BFIterator<Person> {
        Node n = top;
        Node last = null;

        public boolean hasNext() {
            return n != null;
        }

        public Person next() {
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

        public Person previous() {
            if (hasPrevious()) {
                n = last;
                last = last.previous;
                return n.p;
            } else
                throw new IndexOutOfBoundsException("Já não existem mais elementos na lista");
        }

        public void remove() {
            removePerson(n.p);
            n = top;
        }
    }
    
}
