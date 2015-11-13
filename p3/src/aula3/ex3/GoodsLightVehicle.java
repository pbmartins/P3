package aula3.ex3;

public class GoodsLightVehicle extends LightVehicle {
	private static final Category category = Category.B1;
	
	@Override public Category category() {
		return category;
	}
	
	public GoodsLightVehicle(int engineSize, int power, int numPassengers, int weight) {
		super(engineSize, power, numPassengers, weight);
		if (weight > 3500)
			throw new IllegalArgumentException("Peso bruto inválido.");
		if (numPassengers > 2)
			throw new IllegalArgumentException("Lotação máximo inválida.");
	}
}
