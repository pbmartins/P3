package aula5;

/**
 * Created by pedromartins on 10/10/15.
 */
public class PoliceMotorcycle extends Motorcycle implements Police {
    private CarType type;
    private int id;

    public PoliceMotorcycle (int year, String plate, String color, int engineSize, int power, int consumption, int fuel, int maxSpeed, int numPassengers, int weight, CarType type, int id) {
        super(year, plate, color, engineSize, power, consumption, fuel, maxSpeed, numPassengers, weight);
        if (id <= 0)
            throw new IllegalArgumentException("ID não válido!");
        this.type = type;
        this.id = id;
    }

    public CarType type() {
        return this.type;
    }

    public int id() {
        return this.id;
    }
}
