package aula3.ex3;

public class LargeVehicle extends Vehicle {
	
	public LargeVehicle(int engineSize, int power, int numPassengers, int weight) {
		super(engineSize, power, numPassengers, weight);
		if (weight < 3500)
			throw new IllegalArgumentException("Peso bruto inválido.");
		if (numPassengers > 100)
			throw new IllegalArgumentException("Lotação máximo inválida.");
	}
}
