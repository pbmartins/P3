package aula3.ex3;

public class LightVehicle extends Vehicle {
	
	public LightVehicle(int engineSize, int power, int numPassengers, int weight) {
		super(engineSize, power, numPassengers, weight);
		if (weight > 3500)
			throw new IllegalArgumentException("Peso bruto inválido.");
		if (numPassengers > 9)
			throw new IllegalArgumentException("Lotação máximo inválida.");
	}
	
}
