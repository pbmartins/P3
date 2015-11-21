package aula11.ex3;

public class Fish extends Food {
    private double proteins;
    private double calories;
    private double weight;
    private FishType type;

    public Fish(FishType type, double proteins, double calories, double weight) {
        if (proteins < 0 || calories < 0 || weight <= 0)
            throw new IllegalArgumentException("Valores para proteínas e/ou calorias e/ou peso inválidos.");
        if (type == null)
            throw new IllegalArgumentException("O tipo do peixe só admite FROZEN ou FRESH.");

        this.proteins = proteins;
        this.calories = calories;
        this.weight = weight;
        this.type = type;
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

    public FishType type() {
        return this.type;
    }

    @Override public boolean equals(Object f) {
        return super.equals(f) && this.type == ((Fish)f).type();
    }

    @Override public String toString() {
        return "Tipo: " + this.type + ", " + super.toString();
    }

    @Override public int hashCode() {
        return super.hashCode() + this.type.hashCode();
    }
}
