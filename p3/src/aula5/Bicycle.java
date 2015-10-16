package aula5;

import aula1.Person;

import java.util.ArrayList;

public class Bicycle extends Vehicle {
    private static final Category category = Category.B;
    private static final int numWheels = 2;

    private int numPassengers, weight, year;
    private String plate, color;
    private Driver driver;
    private ArrayList<Person> passengers;

    public Bicycle(int year, String plate, String color, int numPassengers, int weight) {
        if (year <= 1900 || plate.length() == 0 || color.length() == 0)
            throw new IllegalArgumentException("Alguns argumentos passados não são válidos.");
        if (weight > 50 || weight <= 0)
            throw new IllegalArgumentException("Peso bruto inválido.");
        if (numPassengers <= 0 || numPassengers > 2)
            throw new IllegalArgumentException("Lotação máximo inválida.");
        this.year = year;
        this.plate = plate;
        this.color = color;
        this.numPassengers = numPassengers;
        this.weight = weight;
        this.driver = null;
        this.passengers = new ArrayList<Person>();
    }

    public int year() {
        return this.year;
    }

    public String plate() {
        return this.plate;
    }

    public String color() {
        return this.color;
    }

    public int numWheels() {
        return numWheels;
    }

    public int numPassengers() {
        return this.numPassengers;
    }

    public int weight() {
        return this.weight;
    }

    public Category category() {
        return null;
    }

    public Driver driver() {
        return this.driver;
    }

    public Person[] passengers() {
        return passengers.toArray(new Person[passengers.size()]);
    }

    public void setDriver(Driver c) {
        if (c == null)
            throw new IllegalArgumentException("Condutor inválido.");
        if (!(c.hasCategory(this.category())))
            throw new AssertionError("O condutor não está habilitado a conduzir este veículo");
        this.driver = c;
    }

    public void addPassenger(Person p) {
        if (p == null)
            throw new IllegalArgumentException("Passageiro inválido.");
        if (passengers.size() == this.numPassengers || ((passengers.size() == this.numPassengers - 1) && this.driver == null))
            throw new AssertionError("Lotação do veículo esgotada.");
        passengers.add(p);
    }

    @Override public String toString() {
        String to_return = super.toString();
        if (this.driver != null)
            to_return += "\nCondutor: " + this.driver.toString();
        if (this.passengers.size() > 0) {
            to_return += "\nPassageiros:\n";
            for (Person p : this.passengers) {
                to_return += p.toString() + "\n";
            }
        }
        return to_return;
    }

    public boolean equals(Object v) {
        return super.equals(v) && this.year == ((Bicycle)v).year() && this.plate.equals(((Bicycle)v).plate()) && this.color.equals(((Bicycle)v).color()) && this.numPassengers == ((Bicycle)v).numPassengers() && this.weight == ((Bicycle)v).weight();
    }
}
