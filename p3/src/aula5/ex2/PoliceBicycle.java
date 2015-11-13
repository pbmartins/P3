package aula5.ex2;

public class PoliceBicycle extends Bicycle implements Police {
    private CarType type;
    private int id;

    public PoliceBicycle (int year, String plate, String color, int numPassengers, int weight, CarType type, int id) {
        super(year, plate, color, numPassengers, weight);
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
