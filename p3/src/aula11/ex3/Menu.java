package aula11.ex3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Menu implements Serializable {
    private static final long serialVersionUID = 75264722956L;
    private String name;
    private String local;
    private Map<WeekDay, List<Plate>> menu;
    private static final WeekDay[] days = WeekDay.values();

    public Menu(String name, String local) {
        if (name.length() == 0 || local.length() == 0)
            throw new IllegalArgumentException("Nome do menu e/ou local inválidos.");

        this.name = name;
        this.local = local;
        this.menu = new TreeMap<WeekDay, List<Plate>>();
        for (WeekDay day : days)
            this.menu.put(day, new ArrayList<Plate>());
    }

    public String name() {
        return this.name;
    }

    public String local() {
        return this.local;
    }

    public Map<WeekDay, List<Plate>> menu() {
        return this.menu;
    }

    public List<Plate> dayMenu(WeekDay day) {
        if (day == null)
            throw new IllegalArgumentException("Dia inválido");
        return this.menu.get(day);
    }

    public boolean addPlate(Plate p, WeekDay day) {
        if (plateExistsInDay(p, day))
            throw new AssertionError("O prato que tentou inserir já existe na ementa do dia inserido.");
        return menu.get(day).add(p);
    }

    public boolean removePlate(Plate p, WeekDay day) {
        if (menu.isEmpty())
            throw new AssertionError("A ementa está vazia.");
        return menu.get(day).remove(p);
    }

    public Plate searchPlate(String name) {
        Plate to_return = null;
        for (WeekDay day : days) {
            for (Plate p : menu.get(day)) {
                if (p.name().equals(name))
                    to_return = p;
            }
        }
        return to_return;
    }

    @Override public String toString() {
        String to_return = new String();

        for (WeekDay day : days) {
            for (Plate p : menu.get(day))
                to_return += p.toString() + ", dia " + day + "\n";
        }

        return to_return;
    }

    @Override public boolean equals(Object m) {
        if (m == null)
            return false;
        if (m.getClass() != this.getClass())
            return false;
        return this.name.equals(((Menu)m).name()) && this.local.equals(((Menu)m).local()) && this.menu.equals(((Menu)m).menu());
    }

    private boolean plateExistsInDay(Plate p, WeekDay day) {
        if (p == null)
            throw new IllegalArgumentException("Prato inválido.");
        if (day == null)
            throw new IllegalArgumentException("Dia inválido.");
        return menu.get(day).contains(p);
    }

}
