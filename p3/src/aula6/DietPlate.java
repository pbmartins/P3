package aula6;

public class DietPlate extends Plate {
    private final double MAX_CALORIES;

    public DietPlate(String name, double maxCalories) {
        super(name);
        this.MAX_CALORIES = maxCalories;
    }

    @Override public boolean addIngredient(Food f) {
        if (f == null)
            throw new IllegalArgumentException("Ingrediente inválido.");
        if (f.calories() + super.totalCalories() > this.MAX_CALORIES)
            return false;
        return super.addIngredient(f);
    }

    @Override public String toString() {
        return "Dieta (" + super.totalCalories() + " Calorias) " + super.toString();
    }

    @Override public int hashCode() {
        return super.hashCode() * 7 + 31;
    }
}
