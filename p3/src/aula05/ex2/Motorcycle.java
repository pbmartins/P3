package aula05.ex2;

import aula01.ex2.Person;

import java.util.ArrayList;

public class Motorcycle extends Vehicle implements Motorized {
    private static final Category category = Category.A;
    private static final int numWheels = 2;

    private int engineSize, power, numPassengers, weight, year, maxSpeed, consumption;
    private String plate, color;
    private Driver driver;
    private Fuel fuel;
    private ArrayList<Person> passengers;

    public Motorcycle(int year, String plate, String color, int engineSize, int power, int consumption, Fuel fuel, int maxSpeed, int numPassengers, int weight) {
        if (year <= 1900 || plate.length() == 0 || color.length() == 0 || engineSize <= 0 || power <= 0 || consumption <= 0 || fuel == null || maxSpeed <= 0)
            throw new IllegalArgumentException("Alguns argumentos passados não são válidos.");
        if (weight > 750 || weight <= 0)
            throw new IllegalArgumentException("Peso bruto inválido.");
        if (numPassengers <= 0 || numPassengers > 2)
            throw new IllegalArgumentException("Lotação máximo inválida.");
        this.year = year;
        this.plate = plate;
        this.color = color;
        this.engineSize = engineSize;
        this.power = power;
        this.consumption = consumption;
        this.fuel = fuel;
        this.maxSpeed = maxSpeed;
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

    public int engineSize() {
        return this.engineSize;
    }

    public int power() {
        return this.power;
    }

    public int consumption() {
        return this.consumption;
    }

    public Fuel fuel() {
        return this.fuel;
    }

    public int maxSpeed() {
        return this.maxSpeed;
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
        String to_return = super.toString() + "\nCilindrada: " + this.engineSize + " cm^3\nPotência: " + this.power + " kW\nTipo de carta: " + category + "\nConsumo: " + this.consumption + "/100km\nTipo de combustível: " + this.fuel;
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
        return super.equals(v) && this.year == ((Motorcycle)v).year() && this.plate.equals(((Motorcycle)v).plate()) && this.color.equals(((Motorcycle)v).color()) && this.engineSize == ((Motorcycle)v).engineSize() && this.power == ((Motorcycle)v).power() && this.numPassengers == ((Motorcycle)v).numPassengers() && this.weight == ((Motorcycle)v).weight() && this.category() == ((Motorcycle)v).category() && this.consumption == ((Motorcycle)v).consumption() && this.fuel == ((Motorcycle)v).fuel();
    }
}

