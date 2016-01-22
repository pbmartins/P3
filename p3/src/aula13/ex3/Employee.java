package aula13.ex3;

import java.util.*;
import java.util.stream.Collectors;

public class Employee implements Comparable<Employee> {
    private String name;
    private List<String> toys;

    public Employee(String name) {
        if (name == null || name.length() == 0)
            throw new IllegalArgumentException("Nome inválido!");
        this.name = name;
        this.toys = new LinkedList<>();
    }

    public String getName() {
        return this.name;
    }

    public String getFirstName() {
        return this.name.split(" ")[0];
    }

    public String[] toysReceived() {
        return this.toys.toArray(new String[this.toys.size()]);
    }

    public void addToy(String toy) {
        this.toys.add(toy);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (o.getClass() != this.getClass())
            return false;
        return ((Employee)o).getName().equals(this.name) && Arrays.equals(((Employee)o).toysReceived(), this.toysReceived());
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (toys != null ? toys.hashCode() : 0);
        return result;
    }

    public String toString() {
        return "Nome: " + this.name + " / Brinquedos recebidos: " + this.toys.stream().collect(Collectors.joining(", "));
    }

    public int compareTo(Employee e) {
        if (e == null)
            throw new IllegalArgumentException("Funcionário inválido!");
        if (this.name.compareTo(e.getName()) < 0)
            return -1;
        else if (this.name.compareTo(e.getName()) > 0)
            return 1;
        return 0;
    }
}
