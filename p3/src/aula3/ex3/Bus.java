package aula3.ex3;

import aula3.ex3.Category;
import aula3.ex3.LargeVehicle;

public class Bus extends LargeVehicle {
	private static final Category category = Category.D;
	
	@Override public Category category() {
		return category;
	}
	
	public Bus(int engineSize, int power, int numPassengers, int weight) {
		super(engineSize, power, numPassengers, weight);
		if (weight > 30000)
			throw new IllegalArgumentException("Peso bruto inválido.");
		if (numPassengers > 100)
			throw new IllegalArgumentException("Lotação máximo inválida.");
	}
}
