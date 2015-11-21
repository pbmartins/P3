package aula11.ex3;

public class Vegetable extends Food implements Vegetarian {
    private double proteins;
    private double calories;
    private double weight;
    private String name;

    public Vegetable(String name, double proteins, double calories, double weight) {
        if (proteins < 0 || calories < 0 || weight <= 0)
            throw new IllegalArgumentException("Valores para proteínas e/ou calorias e/ou peso inválidos.");
        if (name.length() == 0)
            throw new IllegalArgumentException("Nome inválido.");

        this.proteins = proteins;
        this.calories = calories;
        this.weight = weight;
        this.name = name;
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

    public String name() {
        return this.name;
    }

    @Override public boolean equals(Object f) {
        return super.equals(f) && this.name.equals(((Vegetable)f).name());
    }

    @Override public String toString() {
        return "Nome: " + this.name() + ", " + super.toString();
    }

    @Override public int hashCode() {
        return super.hashCode() + this.name.hashCode();
    }
}
