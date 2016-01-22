package aula06;

import java.io.Serializable;
import java.util.*;

public class Plate implements Comparable<Plate>, Serializable {
    private String name;
    private List<Food> composition;

    public Plate(String name) {
        if (name.length() == 0)
            throw new IllegalArgumentException("Name do prato inválido.");

        this.name = name;
        composition = new ArrayList<Food>();
    }

    public String name() {
        return this.name;
    }

    public Food[] composition() {
        return this.composition.toArray(new Food[this.composition.size()]);
    }

    public int numIngredients() {
        return this.composition.size();
    }

    public double totalCalories() {
        double total = 0;
        for (Food f : this.composition)
            total += f.calories();
        return total;
    }

    public boolean addIngredient(Food f) {
        if (f == null)
            throw new IllegalArgumentException("Ingrediente inválido.");
        if (this.composition.contains(f))
            return false;
        //  throw new AssertionError("O ingrediente que está a tentar adicionar já está a ser utilizado neste prato.");

        return this.composition.add(f);
    }

    public boolean removeIngredient(Food f) {
        if (f == null)
            throw new IllegalArgumentException("Ingrediente inválido.");
        if (!this.composition.contains(f))
            return false;
        //  throw new AssertionError("O ingrediente que está a tentar adicionar já está a ser utilizado neste prato.");

        return this.composition.remove(f);
    }

    @Override public String toString() {
        return "Prato '" + this.name + ", composto por " + this.composition.size() + " Ingredientes'";
    }

    @Override public boolean equals(Object p) {
        if (p == null)
            return false;
        if (p.getClass() != this.getClass())
            return false;
        return this.name.equals(((Plate)p).name()) && equalsComposition(((Plate)p));
    }

    @Override public int hashCode() {
        int to_return = 37;
        to_return += Double.doubleToLongBits((double)this.composition.hashCode()) + Double.doubleToLongBits((double)this.name.hashCode());
        to_return = (int)(to_return ^ (to_return >>> 32)) * 31;
        return to_return;
    }

    public int compareTo(Plate p) {
        if (p == null)
            throw new IllegalArgumentException("Alimento inválido");

        if (p.totalCalories() > this.totalCalories())
            return -1;
        else if (p.totalCalories() < this.totalCalories())
            return 1;
        return 0;
    }

    private boolean equalsComposition(Plate p) {
        if (p == null)
            throw new IllegalArgumentException("Prato inválido");

        Food[] plateComposition = p.composition();

        if (plateComposition.length != this.composition.size())
            return false;

        for (Food f : plateComposition) {
            if (!this.composition.contains(f))
                return false;
        }
        return true;
    }
}
