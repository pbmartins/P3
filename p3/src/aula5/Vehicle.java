package aula5;

import aula1.Person;
import java.util.Comparator;

public abstract class Vehicle implements Comparator<Vehicle>, Comparable<Vehicle> {
	public abstract int numPassengers();
	
	public abstract int weight();

	public abstract String color();

	public abstract int numWheels();

	public abstract int year();

	public abstract String plate();
	
	public abstract Driver driver();
	
	public abstract Person[] passengers();
	
	public abstract void setDriver(Driver c);
	
	public abstract void addPassenger(Person p);
	
	@Override public String toString() {
		String to_return = "Ano: " + this.year() + "\nMatricula: " + this.plate() + "\nLotação: " + this.numPassengers() + " lugares\nPeso bruto: " + this.weight() + " kg\nCor: " + this.color() + "\nNúmero de rodas: " + this.numWheels();
		if (this.driver() != null)
			to_return += "\nCondutor: " + this.driver().toString();
		if (this.passengers().length > 0) {
			to_return += "\nPassageiros:\n";
			for (Person p : this.passengers()) {
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
        return true;
    }

	public int compareTo(Vehicle v) {
		if (v.year() > this.year())
			return -1;
		else if (v.year() < this.year())
			return 1;
		return 0;
	}

	@Override public int compare(Vehicle v1, Vehicle v2) {
		if (v1 == null || v2 == null)
			throw new IllegalArgumentException("Veículos inválidos");
		return v1.compareTo(v2);
	}
}
