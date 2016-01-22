package aula11.ex3;

import java.io.Serializable;

public abstract class Food implements Comparable<Food>, Serializable {

    public abstract double proteins();

    public abstract double calories();

    public abstract double weight();

    @Override public String toString() {
        return "Proteínas: " + this.proteins() + "/100g, Calorias: " + this.calories() + "/100g, Peso: " + this.weight() + " g";
    }

    @Override public boolean equals(Object f) {
        if (f == null)
            return false;
        if (this.getClass() != f.getClass())
            return false;
        return this.proteins() == ((Food)f).proteins() && this.calories() == ((Food)f).calories() && this.weight() == ((Food)f).weight();
    }

    @Override public int hashCode() {
        final int prime = 31;
        int to_return = 37;
        to_return += Double.doubleToLongBits(this.proteins()) + Double.doubleToLongBits(this.calories()) + Double.doubleToLongBits(this.weight());
        to_return = (int)(to_return ^ (to_return >>> 32));
        return to_return;
    }

    public int compareTo(Food f) {
        if (f == null)
            throw new IllegalArgumentException("Alimento inválido");

        if (f.calories() > this.calories())
            return -1;
        else if (f.calories() < this.calories())
            return 1;
        return 0;
    }
}
