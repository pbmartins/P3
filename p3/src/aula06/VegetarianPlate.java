package aula06;

public class VegetarianPlate extends Plate {

    public VegetarianPlate(String name) {
        super(name);
    }

    @Override public boolean addIngredient(Food f) {
        if (f == null)
            throw new IllegalArgumentException("Ingrediente inválido.");
        if (!(f instanceof Vegetarian))
            return false;
        return super.addIngredient(f);
    }

    @Override public String toString() {
        return "Vegetariano " + super.toString();
    }

    @Override public int hashCode() {
        return super.hashCode() / 31 * 37;
    }
}
