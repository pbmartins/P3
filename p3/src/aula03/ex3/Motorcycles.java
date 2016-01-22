package aula03.ex3;

public class Motorcycles extends Vehicle {
	private static final Category category = Category.A;
	
	@Override public Category category() {
		return category;
	}
	
	public Motorcycles(int engineSize, int power, int numPassengers, int weight) {
		super(engineSize, power, numPassengers, weight);
		if (weight > 750)
			throw new IllegalArgumentException("Peso bruto inválido.");
		if (numPassengers > 2)
			throw new IllegalArgumentException("Lotação máximo inválida.");
	}
}
