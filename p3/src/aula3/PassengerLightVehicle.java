package aula3;

public class PassengerLightVehicle extends LightVehicle {
	private static final Category category = Category.B;
	
	@Override public Category category() {
		return category;
	}
	
	public PassengerLightVehicle(int engineSize, int power, int numPassengers, int weight) {
		super(engineSize, power, numPassengers, weight);
		if (weight > 3500)
			throw new IllegalArgumentException("Peso bruto inválido.");
		if (numPassengers > 9)
			throw new IllegalArgumentException("Lotação máximo inválida.");
	}
}
