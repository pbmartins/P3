package aula6;

import java.util.*;
import java.nio.file.*;
import java.io.*;

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

    public String ingredientsToString() {
        String to_return = "";
        for (int key : this.ingredients.keySet())
            to_return += "ID: " + key + ", " + this.ingredients.get(key).toString() + "\n";
        return to_return;
    }

    public Food getIngredient(int key) {
        if (!this.ingredients.containsKey(key))
            throw new AssertionError("Não existe nenhum ingrediente com esse identificador.");
        return this.ingredients.get(key);
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

    public boolean removeIngredientFromPlate(String name, Food f) {
        return this.plates.get(name).removeIngredient(f);
    }

    public String platesToString() {
        String to_return = "";
        for (String key : this.plates.keySet())
            to_return += this.plates.get(key).toString() + "\n";
        return to_return;
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

    public void saveOnFile(String path) throws IOException {
        String[] extension = path.split("\\.");
        if (!extension[extension.length - 1].equals("ser"))
            throw new IllegalArgumentException("Extensão inválida");
        Path p = Paths.get(System.getProperty("user.home"), path);
        ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(p.toString()));
        objectOut.writeObject(this.menu);
        objectOut.close();
    }

    public void readFromFile(String path) throws IOException {
        String[] extension = path.split("\\.");
        if (!extension[extension.length - 1].equals("ser"))
            throw new IllegalArgumentException("Extensão inválida");
        Path p = Paths.get(System.getProperty("user.home"), path);
        ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(p.toString()));
        try {
            this.menu = (Menu)objectIn.readObject();
            objectIn.close();
        } catch(ClassNotFoundException e) {
            System.err.println("Classe não encontrada");
        }
    }
}
