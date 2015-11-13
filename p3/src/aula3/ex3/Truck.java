package aula3.ex3;

public class Truck extends LargeVehicle {
	private static final Category category = Category.C;
	
	@Override public Category category() {
		return category;
	}
	
	public Truck(int engineSize, int power, int numPassengers, int weight) {
		super(engineSize, power, numPassengers, weight);
		if (weight < 3500)
			throw new IllegalArgumentException("Peso bruto inválido.");
		if (numPassengers > 2)
			throw new IllegalArgumentException("Lotação máximo inválida.");
	}
}
