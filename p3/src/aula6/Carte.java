package aula6;

import java.util.*;

public class Carte {
    private Map<Integer, Food> ingredients;
    private Map<String, Plate> plates;
    private Menu menu;
    private int ingredientsCounter;


    public Carte(String name, String local) {
        this.ingredients = new TreeMap<Integer, Food>();
        this.ingredientsCounter = 0;
        this.plates = new TreeMap<String, Plate>();
        this.menu = new Menu(name, local);
    }

    // Ingredients
    public void addMeat(MeatVariety variety, double proteins, double calories, double weight) {
        this.ingredients.put(ingredientsCounter++, new Meat(variety, proteins, calories, weight));
    }

    public void addFish(FishType type, double proteins, double calories, double weight) {
        this.ingredients.put(ingredientsCounter++, new Fish(type, proteins, calories, weight));
    }

    public void addCereal(String name, double proteins, double calories, double weight) {
        this.ingredients.put(ingredientsCounter++, new Cereal(name, proteins, calories, weight));
    }

    public void addVegetable(String name, double proteins, double calories, double weight) {
        this.ingredients.put(ingredientsCounter++, new Vegetable(name, proteins, calories, weight));
    }

    // Dishes
    public void newPlate(String name) {
        if (this.plates.containsKey(name))
            throw new AssertionError("O prato que está a tentar inserir já existe.");
        this.plates.put(name, new Plate(name));
        assert this.plates.containsKey(name);
    }

    public void removePlate(String name) {
        if (!this.plates.containsKey(name))
            throw new AssertionError("Não existe nenhum prato associado ao nome inserido.");
        this.plates.remove(name);
        assert !this.plates.containsKey(name);
    }

    public Plate selectPlate(String name) {
        if (!this.plates.containsKey(name))
            throw new AssertionError("Não existe nenhum prato associado ao nome inserido.");
        return this.plates.get(name);
    }

    public boolean addIngredientToPlate(String name, Food f) {
        return this.plates.get(name).addIngredient(f);
    }

    public boolean addIngredientFromPlate(String name, Food f) {
        return this.plates.get(name).removeIngredient(f);
    }

    // Menu
    public boolean addPlateToMenu(Plate p, WeekDay day) {
        return this.menu.addPlate(p, day);
    }

    public boolean removePlateFromMenu(Plate p, WeekDay day) {
        return this.menu.removePlate(p, day);
    }

    public String toString() {
        return this.menu.toString();
    }
}
