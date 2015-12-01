package aula03.ex3;
import java.util.*;
import aula01.ex2.Person;

public class Vehicle {
	private int engineSize, power, numPassengers, weight;
	private Driver driver;
	private ArrayList<Person> passengers;
	
	public Vehicle(int engineSize, int power, int numPassengers, int weight) {
		if (engineSize <= 0 || power <= 0 || numPassengers <= 0 || weight <= 0)
			throw new IllegalArgumentException("Nenhum dos valores introduzidos pode ser negativo.");
		this.engineSize = engineSize;
		this.power = power;
		this.numPassengers = numPassengers;
		this.weight = weight;
		this.driver = null;
		this.passengers = new ArrayList<Person>();
	}
	
	public int engineSize() {
		return this.engineSize;
	}
	
	public int power() {
		return this.power;
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
		if (passengers.size() == this.numPassengers)
			throw new AssertionError("Lotação do veículo esgotada.");
		passengers.add(p);
	}
	
	@Override public String toString() {
		String to_return = "Cilindrada: " + this.engineSize + " cm^3\nPotência: " + this.power + " kW\nLotação: " + this.numPassengers + " lugares\nPeso bruto: " + this.weight + " kg\nTipo de carta: " + this.category();
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
		if (v == null)
			return false;
		if (this.getClass() != v.getClass())
			return false;
		return this.engineSize == ((Vehicle)v).engineSize() && this.power == ((Vehicle)v).power() && this.numPassengers == ((Vehicle)v).numPassengers() && this.weight == ((Vehicle)v).weight() && this.category() == ((Vehicle)v).category();
	}
}
