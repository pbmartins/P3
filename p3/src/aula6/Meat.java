package aula6;

public class Meat extends Food {
    private double proteins;
    private double calories;
    private double weight;
    private MeatVariety variety;

    public Meat(MeatVariety variety, double proteins, double calories, double weight) {
        if (proteins < 0 || calories < 0 || weight <= 0)
            throw new IllegalArgumentException("Valores para proteínas e/ou calorias e/ou peso inválidos.");
        if (variety == null)
            throw new IllegalArgumentException("A variedade de carne é inválida.");

        this.proteins = proteins;
        this.calories = calories;
        this.weight = weight;
        this.variety = variety;
    }

    public double proteins() {
        return this.proteins;
    };

    public double calories() {
        return this.calories;
    };

    public double weight() {
        return this.weight;
    };

    public MeatVariety variety() {
        return this.variety;
    }

    @Override public boolean equals(Object f) {
        return super.equals(f) && this.variety == ((Meat)f).variety();
    }

    @Override public String toString() {
        return "Variedade: " + this.variety + ", " + super.toString();
    }

    @Override public int hashCode() {
        return super.hashCode() + this.variety.hashCode();
    }
}
